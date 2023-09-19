package superhero_project.com;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;
import superhero_project.com.dao.OrganizationDao;
import superhero_project.com.model.OrganizationDto;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrganizationJdbcTemplateDaoImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrganizationDao organizationDao;

    @BeforeEach
    public void setUp() {
        // Clean up the organizations table before each test
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "organizations");
    }

    @Test
    public void testFetchAllOrganizations() {
        // Add some sample organizations to the database for testing
        jdbcTemplate.execute("INSERT INTO organizations (name, description, address) VALUES " +
                "('Org1', 'Description1', 'Address1'), " +
                "('Org2', 'Description2', 'Address2')");

        List<OrganizationDto> organizations = organizationDao.fetchAllOrganizations();

        assertNotNull(organizations);
        assertEquals(2, organizations.size());
    }

    @Test
    public void testFetchAOrganization() {
        // Add a sample organization to the database for testing
        jdbcTemplate.execute("INSERT INTO organizations (name, description, address) VALUES " +
                "('Org1', 'Description1', 'Address1')");

        OrganizationDto organization = organizationDao.fetchAOrganization(1);

        assertNotNull(organization);
        assertEquals("Org1", organization.getName());
        assertEquals("Description1", organization.getDescription());
        assertEquals("Address1", organization.getAddress());
    }

    @Test
    public void testAddOrganization() {
        OrganizationDto newOrganization = new OrganizationDto(1, "NewName", "NewDescription","NewAddress");
        newOrganization.setName("NewOrg");
        newOrganization.setDescription("NewDescription");
        newOrganization.setAddress("NewAddress");

        OrganizationDto addedOrganization = organizationDao.addOrganization(newOrganization);

        assertNotNull(addedOrganization);
        assertEquals("NewOrg", addedOrganization.getName());
        assertEquals("NewDescription", addedOrganization.getDescription());
        assertEquals("NewAddress", addedOrganization.getAddress());
        assertNotNull(addedOrganization.getOrgId());
    }

    @Test
    public void testUpdateOrganization() {
        // Add a sample organization to the database for testing
        jdbcTemplate.execute("INSERT INTO organizations (organization_id, name, description, address) VALUES " +
                "(1, 'Org1', 'Description1', 'Address1')");

        OrganizationDto updatedOrganization = new OrganizationDto(1,"UpdatedOrg","UpdatedDescription","UpdatedAddress");
        updatedOrganization.setOrgId(1);
        updatedOrganization.setName("UpdatedOrg");
        updatedOrganization.setDescription("UpdatedDescription");
        updatedOrganization.setAddress("UpdatedAddress");

        OrganizationDto result = organizationDao.updateOrganization(updatedOrganization);

        assertNotNull(result);
        assertEquals("UpdatedOrg", result.getName());
        assertEquals("UpdatedDescription", result.getDescription());
        assertEquals("UpdatedAddress", result.getAddress());
        assertEquals(1, result.getOrgId());
    }

    @Test
    public void testRemoveOrganization() {
        // Add a sample organization to the database for testing
        jdbcTemplate.execute("INSERT INTO organizations (organization_id, name, description, address) VALUES " +
                "(1, 'Org1', 'Description1', 'Address1')");

        organizationDao.removeOrganization(1);

        OrganizationDto organization = organizationDao.fetchAOrganization(1);
        assertNull(organization);
    }
}

