package superhero_project.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superhero_project.com.dao.LocationDao;
import superhero_project.com.model.LocationDto;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService{

    LocationDao locationDao;
    @Autowired
    public LocationServiceImpl(LocationDao locationDao) {
        super();
        this.locationDao = locationDao;
    }



    @Override
    public List<LocationDto> fetchAllLocations() {
        return locationDao.fetchAllLocations();
    }

    @Override
    public LocationDto fetchALocation(int locationId) {
        return fetchALocation(locationId);
    }

    @Override
    public LocationDto addLocation(LocationDto newLocation) {
        return locationDao.addLocation(newLocation);
    }

    @Override
    public LocationDto updateLocation(LocationDto updateLocation) {
        return locationDao.updateLocation(updateLocation);
    }

    @Override
    public void removeLocation(int locationId) {

        locationDao.removeLocation(locationId);
    }
}
