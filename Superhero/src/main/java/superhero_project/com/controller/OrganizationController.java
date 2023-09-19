package superhero_project.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import superhero_project.com.model.OrganizationDto;
import superhero_project.com.service.OrganizationService;

import java.util.List;

@CrossOrigin
@RestController
public class OrganizationController {
    OrganizationService organizationService;
    @Autowired

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    public List<OrganizationDto> fetchAllOrganizations() {
        return organizationService.fetchAllOrganizations();
    }
    @GetMapping("/organizations/{oid}")
    public OrganizationDto fetchAOrganization(@PathVariable("lid") int organizationId) {
        return organizationService.fetchAOrganization(organizationId);
    }
    @PostMapping("/organizations")
    public OrganizationDto addOrganization(@RequestBody OrganizationDto newOrganization) {
        return organizationService.addOrganization(newOrganization);
    }

    @PutMapping("/organizations")
    public OrganizationDto updateOrganization(@RequestBody OrganizationDto updateLocation) {
        return organizationService.updateOrganization(updateLocation);
    }

    @DeleteMapping("/organizations/{oid}")
    public void removeOrganization(@PathVariable("hid") int organizationId) {
        organizationService.removeOrganization(organizationId);
    }
}
