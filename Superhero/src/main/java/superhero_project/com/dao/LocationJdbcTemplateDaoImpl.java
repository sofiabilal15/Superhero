package superhero_project.com.dao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import superhero_project.com.dao.mapper.LocationMapper;
import superhero_project.com.exception.ApplicationException;
import superhero_project.com.model.LocationDto;
import java.util.List;
@Repository
public class LocationJdbcTemplateDaoImpl implements LocationDao {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<LocationDto> rowMapper = new LocationMapper();

    public LocationJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<LocationDto> fetchAllLocations() {

        String query = "SELECT * FROM locations";
        List<LocationDto> allLocations = jdbcTemplate.query(query, rowMapper);
        return allLocations;
    }

    @Override
    public LocationDto fetchALocation(int locationId) {

        String query = "SELECT * FROM locations WHERE location_id=" + locationId;
        LocationDto fetchedLocation = null;
        try {
            fetchedLocation = jdbcTemplate.queryForObject(query, rowMapper);
        } catch(DataAccessException dae) {

            throw new ApplicationException();
        }


        return fetchedLocation;
    }

    @Override
    public LocationDto addLocation(LocationDto newLocation) {
        String query1 = "INSERT INTO locations(name, description, address,latitude,longitude) VALUE ('"+newLocation.getName()+"', '"+newLocation.getDescription()+"' , '"+newLocation.getAddress()+"', '"+newLocation.getLatitude()+"', '"+newLocation.getLatitude()+"');";
        int rowsAffected = jdbcTemplate.update(query1);
        String query2 = "SELECT last_insert_id();";
        int generateLocationId = jdbcTemplate.queryForObject(query2, (rs, rowNum)->{
            return rs.getInt(1);
        });
        newLocation.setLocationId(generateLocationId);

        return newLocation;
    }

    @Override
    public LocationDto updateLocation(LocationDto updateLocation) {
        String query = "UPDATE locations SET name=?, description=?, address=?, latitude=? ,longitude=? WHERE location_id=?";
        int rowsAffected = jdbcTemplate.update(query, updateLocation.getName(), updateLocation.getDescription(), updateLocation.getAddress(), updateLocation.getLatitude(),updateLocation.getLongitude() ,updateLocation.getLocationId());

        return updateLocation;
    }


    @Override
    public void removeLocation(int locationId) {
        String query = "DELETE FROM locations WHERE locations_id=" + locationId;
        jdbcTemplate.update(query,locationId);
    }
}

