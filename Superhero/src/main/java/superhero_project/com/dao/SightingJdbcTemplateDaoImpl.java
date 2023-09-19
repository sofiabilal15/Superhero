package superhero_project.com.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import superhero_project.com.dao.mapper.SightingMapper;
import superhero_project.com.exception.ApplicationException;
import superhero_project.com.model.SightingDto;
import java.util.List;
@Repository
public class SightingJdbcTemplateDaoImpl implements SightingDao{

    private JdbcTemplate jdbcTemplate;

    private RowMapper<SightingDto> rowMapper = new SightingMapper();

    @Autowired
    public SightingJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<SightingDto> fetchAllSightings() {

        String query = "SELECT * FROM sightings";
        List<SightingDto> allSightings = jdbcTemplate.query(query, rowMapper);
        return allSightings;

    }

    @Override
    public SightingDto fetchASighting(int sightingId) {

        String query = "SELECT * FROM sightings WHERE sighting_id="+sightingId;

        SightingDto fetchedSighting = null;
        try {
            fetchedSighting = jdbcTemplate.queryForObject(query, rowMapper);
        } catch(DataAccessException dae) {

            throw new ApplicationException();
        }

        return fetchedSighting;
    }

    @Override
    public SightingDto addSighting(SightingDto newSighting) {
        String query1 = "INSERT INTO sightings(hero_id,location_id,sighting_date ) VALUE ('"+newSighting.getHeroId()+"', '"+newSighting.getLocationId()+"' , '"+newSighting.getSightDate()+"');";
        int rowsAffected = jdbcTemplate.update(query1);

        String query2 = "SELECT last_insert_id();";
        int generateSightingId = jdbcTemplate.queryForObject(query2, (rs, rowNum)->{
            return rs.getInt(1);
        });
        newSighting.setSightId(generateSightingId);



        return newSighting;
    }

    @Override
    public SightingDto updateSighting(SightingDto updateSighting) {


        String query = "UPDATE sightings SET hero_id=?, location_id=?, sighting_date=? WHERE sighting_id=?";
        int rowsAffected = jdbcTemplate.update(query, updateSighting.getHeroId(), updateSighting.getLocationId(), updateSighting.getSightDate(), updateSighting.getSightId());
        return updateSighting;
    }

    @Override
    public void removeSighting(int sightingId) {
        String query = "DELETE FROM sightings WHERE sighting_id="+sightingId;
        jdbcTemplate.update(query,sightingId);

    }
}
