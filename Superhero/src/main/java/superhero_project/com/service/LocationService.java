package superhero_project.com.service;

import superhero_project.com.model.LocationDto;

import java.util.List;

public interface LocationService {
    public List<LocationDto> fetchAllLocations();
    public LocationDto fetchALocation(int locationId);
    public LocationDto addLocation(LocationDto newLocation);
    public LocationDto updateLocation(LocationDto updateLocation);
    public void removeLocation(int locationId);
}
