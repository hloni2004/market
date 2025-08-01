package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Residence;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ResidenceFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ResidenceServiceTest {

    @Autowired
    private IResidenceService service;

    private static final Address address = AddressFactory.createAddress(
            "10", "Loop Street", "CBD", "Cape Town", "Western Cape", 8001);

    private static final Residence residence = ResidenceFactory.createResidence(
            "Varsity Residence", "102", 2, "Block B", address);

    @Test
    @Order(1)
    void a_create() {
        Residence created = service.create(residence);

    }

    @Test
    @Order(2)
    void b_read() {
       service.read(residence.getResidenceId());
    }

    @Test
    @Order(3)
    void c_update() {
        Residence updated = new Residence.Builder()
                .copy(residence)
                .setRoomNumber("103")
                .build();
        Residence result = service.update(updated);

    }

    @Test
    @Order(4)
    void d_getAll() {
        List<Residence> residences = service.getAll();

    }
}
