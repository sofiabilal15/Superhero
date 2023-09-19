package superhero_project.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import superhero_project.com.model.SightingDto;
import superhero_project.com.service.SightingService;

import java.util.List;

@CrossOrigin
@RestController
public class SightingController {

    SightingService sightingService;
    @Autowired
    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping("/sightings")
    public List<SightingDto> fetchAllSightings() {
        return sightingService.fetchAllSightings();
    }
    @GetMapping("/sightings/{sid}")
    public SightingDto fetchASighting(@PathVariable("sid") int sightingId) {
        return sightingService.fetchASighting(sightingId);
    }
    @PostMapping("/sightings")
    public SightingDto addSighting(@RequestBody SightingDto newSighting) {
        return sightingService.addSighting(newSighting);
    }

    @PutMapping("/sightings")
    public SightingDto updateSighting(@RequestBody SightingDto updateSighting) {
        return sightingService.updateSighting(updateSighting);
    }

    @DeleteMapping("/sightings/{sid}")
    public void removeSighting(@PathVariable("sid") int sightingId) {
        sightingService.removeSighting(sightingId);
    }
}
