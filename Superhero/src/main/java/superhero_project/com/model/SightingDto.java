package superhero_project.com.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class SightingDto {
    private int sightId;
    private int heroId;
    private int locationId;
    private Date sightDate;

    public SightingDto(int sightId, int heroId, int locationId, Date sightDate) {
        this.sightId = sightId;
        this.heroId = heroId;
        this.locationId = locationId;
        this.sightDate = sightDate;
    }
}
