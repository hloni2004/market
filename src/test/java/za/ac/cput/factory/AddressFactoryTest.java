package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddress_success() {
        Address address = AddressFactory.createAddress(
                "123", "Main Street", "Central", "Cape Town", "Western Cape", 8001);

        assertNotNull(address);
        System.out.println(address);

    }
}