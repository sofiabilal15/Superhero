package superhero_project.com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import superhero_project.com.model.HeroDto;
import superhero_project.com.service.HeroService;

import java.util.List;

@CrossOrigin
@RestController
public class HeroController {
    HeroService heroService;

    @Autowired

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/heroes")
    public List<HeroDto> fetchAllHeroes() {
        return heroService.fetchAllHeroes();
    }
    @GetMapping("/heroes/{hid}")
    public HeroDto fetchAAuthor(@PathVariable("hid") int heroId) {
        return heroService.fetchAHero(heroId);
    }
    @PostMapping("/heroes")
    public HeroDto addHero(@RequestBody HeroDto newHero) {
        return heroService.addHero(newHero);
    }

    @PutMapping("/heroes")
    public HeroDto updateHero(@RequestBody HeroDto updateHero) {
        return heroService.updateHero(updateHero);
    }

    @DeleteMapping("/heroes/{hid}")
    public void removeHero(@PathVariable("hid") int heroId) {
        heroService.removeHero(heroId);
    }
}
