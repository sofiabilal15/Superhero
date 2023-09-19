package superhero_project.com.dao.mapper;
import org.springframework.jdbc.core.RowMapper;
import superhero_project.com.model.LocationDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocationDto location = new LocationDto(rs.getInt(1), rs. getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6));
        return location;
    }
}
