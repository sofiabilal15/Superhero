package superhero_project.com.dao;

import superhero_project.com.model.LocationDto;

import java.util.List;

public interface LocationDao {
    public List<LocationDto> fetchAllLocations();
    public LocationDto fetchALocation(int locationId);
    public LocationDto addLocation(LocationDto newLocation);
    public LocationDto updateLocation(LocationDto updateLocation);
    public void removeLocation(int locationId);


}
