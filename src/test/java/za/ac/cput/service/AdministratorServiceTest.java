package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Administrator;
import za.ac.cput.factory.AdministratorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdministratorServiceTest {

    @Autowired
    private IAdministratorService administratorService;

    private static Administrator admin;

    @BeforeAll
    static void beforeAll() {
        admin = AdministratorFactory.createAdministrator("admin_user", "admin@example.com", "P@ssword123");
    }

    @Test
    @Order(1)
    void create() {
        administratorService.create(admin);
    }

    @Test
    @Order(2)
    void read() {
        administratorService.read(admin.getAdminId());
    }

    @Test
    @Order(3)
    void update() {
        Administrator newAdmin = new Administrator.Builder().copy(admin).setUsername("hloni").build();
        administratorService.update(newAdmin);
    }

    @Test
    @Order(4)
    void getAll() {
        List<Administrator> all = administratorService.getAll();
    }
}