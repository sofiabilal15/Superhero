package superhero_project.com.dao.mapper;
import org.springframework.jdbc.core.RowMapper;
import superhero_project.com.model.HeroDto;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HeroMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        HeroDto hero = new HeroDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        return hero;
    }
}

