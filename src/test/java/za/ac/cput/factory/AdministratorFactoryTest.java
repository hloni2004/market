package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Administrator;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorFactoryTest {


    @Test
    void createAdministrator_success() {
        Administrator admin = AdministratorFactory.createAdministrator(
                "adminUser", "admin@example.com", "securePass123");

        assertNotNull(admin);
        System.out.println(admin);

    }

}