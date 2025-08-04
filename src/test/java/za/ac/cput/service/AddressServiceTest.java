package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {

    @Autowired
    private IAddressService service;

    private  static Address address;

    @BeforeAll
    static void setup() {
        address = AddressFactory.createAddress(
                "123", "Main St", "Central", "Cape Town", "Western Cape", 8000
        );
    }

    @Test
    @Order(1)
    void create() {
        assertNotNull(address);
        address = service.create(address); // This line attempts to save the address
        System.out.println(address);
    }

    @Test
    @Order(2)
    void read() {
        Address read = service.read(address.getAddressId());
    }

    @Test
    @Order(3)
    void update() {
        Address updatedAddress = new Address.Builder().copy(address).setCity("Gauteng").build();
       address = service.update(updatedAddress);
    }

    @Test
    @Order(4)
    void delete() {
       boolean respo =  service.delete(address.getAddressId());
    }

    @Test
    @Order(5)
    void getAll() {
        List<Address> all = service.getAll();
    }
}
