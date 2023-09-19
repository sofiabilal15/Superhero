package superhero_project.com.dao;


import superhero_project.com.model.SightingDto;

import java.util.List;

public interface SightingDao {
    public List<SightingDto> fetchAllSightings();
    public SightingDto fetchASighting(int sightingId);
    public SightingDto addSighting(SightingDto newSighting);
    public SightingDto updateSighting(SightingDto updateSighting);
    public void removeSighting(int sightingId);
}
