package superhero_project.com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationDto {
    private int orgId ;
    private String name;
    private String description;
    private String address;

    public OrganizationDto(int orgId, String name, String description, String address) {
        this.orgId = orgId;
        this.name = name;
        this.description = description;
        this.address = address;
    }
}
