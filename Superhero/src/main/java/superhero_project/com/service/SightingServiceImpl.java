package superhero_project.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superhero_project.com.dao.SightingDao;
import superhero_project.com.model.SightingDto;

import java.util.List;
@Service
public class SightingServiceImpl implements SightingService{

    SightingDao sightingDao;

    @Autowired
    public SightingServiceImpl(SightingDao sightingDao) {
        this.sightingDao = sightingDao;
    }

    @Override
    public List<SightingDto> fetchAllSightings() {
        return null;
    }

    @Override
    public SightingDto fetchASighting(int sightingId) {
        return null;
    }

    @Override
    public SightingDto addSighting(SightingDto newSighting) {
        return null;
    }

    @Override
    public SightingDto updateSighting(SightingDto updateSighting) {
        return null;
    }

    @Override
    public void removeSighting(int sightingId) {

    }
}
