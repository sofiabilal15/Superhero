package superhero_project.com.dao;

import superhero_project.com.model.OrganizationDto;

import java.util.List;

public interface OrganizationDao {
    public List<OrganizationDto> fetchAllOrganizations();
    public OrganizationDto fetchAOrganization(int organizationId);
    public OrganizationDto addOrganization(OrganizationDto newOrganization);
    public OrganizationDto updateOrganization(OrganizationDto updateOrganization);
    public void removeOrganization(int organizationId);
}
