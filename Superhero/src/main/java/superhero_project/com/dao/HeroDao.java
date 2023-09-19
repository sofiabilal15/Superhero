package superhero_project.com.dao;

import superhero_project.com.model.HeroDto;

import java.util.List;

public interface HeroDao {
    public List<HeroDto> fetchAllHeroes();
    public HeroDto fetchAHero(int heroId);
    public HeroDto addHero(HeroDto newHero);
    public HeroDto updateHero(HeroDto updateHero);
    public void removeHero(int heroId);


}
