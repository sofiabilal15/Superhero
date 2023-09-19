package superhero_project.com.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import superhero_project.com.dao.mapper.HeroMapper;
import superhero_project.com.exception.ApplicationException;
import superhero_project.com.model.HeroDto;
import java.util.List;
@Repository
public class HeroJdbcTemplateDaoImpl implements HeroDao {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<HeroDto> rowMapper = new HeroMapper();

    @Autowired
    public HeroJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HeroDto> fetchAllHeroes() {

        String query = "SELECT * FROM heroes";

        List<HeroDto> allHeroes = jdbcTemplate.query(query, rowMapper);
        return allHeroes;

    }

    @Override
    public HeroDto fetchAHero(int heroId) {
        String query = "SELECT * FROM heroes WHERE hero_id="+heroId;

        HeroDto fetchedHero = null;
        try {
            fetchedHero = jdbcTemplate.queryForObject(query, rowMapper);
        } catch(DataAccessException dae) {

            throw new ApplicationException();
        }

        return fetchedHero;
    }

    @Override
    public HeroDto addHero(HeroDto newHero) {
        String query1 = "INSERT INTO heroes(name, description,superpower,hero_type) VALUE ('"+newHero.getName()+"', '"+newHero.getDescription()+"' , '"+newHero.getSuperpower()+"', '"+newHero.getHeroType()+"');";
        int rowsAffected = jdbcTemplate.update(query1);

        String query2 = "SELECT last_insert_id();";
        int generateHeroId = jdbcTemplate.queryForObject(query2, (rs, rowNum)->{
            return rs.getInt(1);
        });
        newHero.setHeroId(generateHeroId);

        return newHero;
    }

    @Override
    public HeroDto updateHero(HeroDto updateHero) {

        String query = "UPDATE heroes SET name=?, description=?, superpower=?, hero_type=? WHERE hero_id=?";
        int rowsAffected = jdbcTemplate.update(query, updateHero.getName(), updateHero.getDescription(), updateHero.getSuperpower(), updateHero.getHeroType(), updateHero.getHeroId());
        return updateHero;
    }


    @Override
    public void removeHero(int heroId) {

        String query = "DELETE FROM heroes WHERE hero_id="+heroId;
        jdbcTemplate.update(query,heroId);
    }
}
