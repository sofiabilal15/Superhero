package superhero_project.com.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import superhero_project.com.dao.mapper.OrganizationMapper;
import superhero_project.com.exception.ApplicationException;
import superhero_project.com.model.OrganizationDto;

import java.util.List;
@Repository
public class OrganizationJdbcTemplateDaoImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<OrganizationDto> rowMapper = new OrganizationMapper();

    @Autowired
    public OrganizationJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<OrganizationDto> fetchAllOrganizations() {

        String query = "SELECT * FROM organizations";
        List<OrganizationDto> allOrganizations = jdbcTemplate.query(query,rowMapper);
        return allOrganizations;
    }

    @Override
    public OrganizationDto fetchAOrganization(int organizationId) {

        String query = "SELECT * FROM organizations WHERE organization_id="+organizationId;
        OrganizationDto fetchedOrganization = null;
        try {
            fetchedOrganization = jdbcTemplate.queryForObject(query, rowMapper);
        } catch(DataAccessException dae) {

            throw new ApplicationException();
        }

        return fetchedOrganization;
    }

    @Override
    public OrganizationDto addOrganization(OrganizationDto newOrganization) {
        String query1 = "INSERT INTO organizations(name, description,address) VALUE ('"+newOrganization.getName()+"', '"+newOrganization.getDescription()+"' , '"+newOrganization.getAddress()+"');";

        String query2 = "SELECT last_insert_id();";
        int generateOrganizationId = jdbcTemplate.queryForObject(query2, (rs, rowNum)->{
            return rs.getInt(1);
        });
        newOrganization.setOrgId(generateOrganizationId);

        return newOrganization;
    }

    @Override
    public OrganizationDto updateOrganization(OrganizationDto updateOrganization) {
        String query = "UPDATE organizations SET name=?, description=?, address=?";
        int rowsAffected = jdbcTemplate.update(query, updateOrganization.getName(), updateOrganization.getDescription(), updateOrganization.getAddress(), updateOrganization.getOrgId());
        return updateOrganization;
    }

    @Override
    public void removeOrganization(int organizationId) {
        String query = "DELETE FROM organizations WHERE organization_id="+organizationId;
        jdbcTemplate.update(query,organizationId);
    }

    }
