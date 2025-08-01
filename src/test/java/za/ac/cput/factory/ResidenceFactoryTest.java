package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Residence;

import static org.junit.jupiter.api.Assertions.*;

class ResidenceFactoryTest {

    @Test
    void createResidence_success() {
        Address address = new Address.Builder()
                .setStreetNumber("123")
                .setStreetName("Main Street")
                .setSuburb("Central")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setPostalCode(8001)
                .build();

        Residence residence = ResidenceFactory.createResidence(
                "Rosewood Heights", "G21", 2, "Block C", address);

        assertNotNull(residence);
       System.out.println(residence);
    }

}