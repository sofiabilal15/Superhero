package superhero_project.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superhero_project.com.dao.OrganizationDao;
import superhero_project.com.model.OrganizationDto;

import java.util.List;
@Service
public class OrganizationServiceImpl implements OrganizationService{

    OrganizationDao organizationDao;
    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationDto> fetchAllOrganizations() {
        return organizationDao.fetchAllOrganizations();
    }

    @Override
    public OrganizationDto fetchAOrganization(int organizationId) {
        return organizationDao.fetchAOrganization(organizationId);
    }

    @Override
    public OrganizationDto addOrganization(OrganizationDto newOrganization) {
        return organizationDao.addOrganization(newOrganization);
    }

    @Override
    public OrganizationDto updateOrganization(OrganizationDto updateOrganization) {
        return organizationDao.updateOrganization(updateOrganization);
    }

    @Override
    public void removeOrganization(int organizationId) {

        organizationDao.removeOrganization(organizationId);
    }
}
