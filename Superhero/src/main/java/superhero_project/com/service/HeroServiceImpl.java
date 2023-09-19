package superhero_project.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superhero_project.com.dao.HeroDao;
import superhero_project.com.model.HeroDto;

import java.util.List;
@Service
public class HeroServiceImpl implements HeroService{

    HeroDao heroDao;

    @Autowired
    public HeroServiceImpl(HeroDao heroDao) {
        this.heroDao = heroDao;
    }
    @Override
    public List<HeroDto> fetchAllHeroes() {
        return heroDao.fetchAllHeroes();
    }

    @Override
    public HeroDto fetchAHero(int heroId) {
        return heroDao.fetchAHero(heroId);
    }

    @Override
    public HeroDto addHero(HeroDto newHero) {
        return heroDao.addHero(newHero);
    }

    @Override
    public HeroDto updateHero(HeroDto updateHero) {
        return heroDao.updateHero(updateHero);
    }

    @Override
    public void removeHero(int heroId) {

        heroDao.removeHero(heroId);
    }
}
