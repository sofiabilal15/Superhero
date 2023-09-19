package superhero_project.com.dao.mapper;
import org.springframework.jdbc.core.RowMapper;
import superhero_project.com.model.SightingDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        SightingDto sighting = new SightingDto(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getDate(4));
       return sighting;
    }
}
