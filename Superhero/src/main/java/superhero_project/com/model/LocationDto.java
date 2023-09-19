package superhero_project.com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {

    private int locationId;
    private String name;
    private String description;
    private String address;
    private double latitude;
    private double longitude;

    public LocationDto(int locationId, String name, String description, String address, double latitude, double longitude) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
