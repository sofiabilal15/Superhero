package superhero_project.com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import superhero_project.com.model.LocationDto;
import superhero_project.com.service.LocationService;

import java.util.List;

@CrossOrigin
@RestController
public class LocationController {
    LocationService locationService;

    @Autowired

    public LocationController(LocationService locationService) {
        super();
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<LocationDto> fetchAllLocations() {
        return locationService.fetchAllLocations();
    }
    @GetMapping("/locations/{lid}")
    public LocationDto fetchALocation(@PathVariable("lid") int locationId) {
        return locationService.fetchALocation(locationId);
    }
    @PostMapping("/locations")
    public LocationDto addLocation(@RequestBody LocationDto newLocation) {
        return locationService.addLocation(newLocation);
    }

    @PutMapping("/locations")
    public LocationDto updateLocation(@RequestBody LocationDto updateLocation) {
        return locationService.updateLocation(updateLocation);
    }

    @DeleteMapping("/locations/{lid}")
    public void removeLocation(@PathVariable("hid") int locationId) {
        locationService.removeLocation(locationId);
    }
}
