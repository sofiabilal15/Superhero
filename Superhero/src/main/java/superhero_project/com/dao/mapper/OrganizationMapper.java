package superhero_project.com.dao.mapper;
import org.springframework.jdbc.core.RowMapper;
import superhero_project.com.model.OrganizationDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrganizationDto organization = new OrganizationDto(rs.getInt(1), rs. getString(2), rs.getString(3),rs.getString(4));
        return organization;
    }
}
