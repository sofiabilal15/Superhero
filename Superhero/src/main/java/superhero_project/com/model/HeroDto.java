package superhero_project.com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroDto {
    private int heroId;
    private String name;
    private String description;
    private String superpower;
    private String heroType;

    public HeroDto(int heroId, String name, String description, String superpower, String heroType) {
        this.heroId = heroId;
        this.name = name;
        this.description = description;
        this.superpower = superpower;
        this.heroType = heroType;
    }

}
