package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Residence;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {



        @Test
        void createStudent_ShouldCreateStudentWithNullLists() {
            Address address = new Address.Builder()
                    .setStreetNumber("123")
                    .setStreetName("Main Street")
                    .setSuburb("Central")
                    .setCity("Cape Town")
                    .setProvince("Western Cape")
                    .setPostalCode(8001)
                    .build();

            Residence residence = new Residence.Builder()
                    .setResidenceName("Test Residence")
                    .setRoomNumber("101")
                    .setFloorNumber(1)
                    .setBuildingName("Building A")
                    .setAddress(address)
                    .build();

            Student student = StudentFactory.createStudent(
                    "John",
                    "Doe",
                    "john.doe@example.com",
                    "password123",
                    residence
            );


            assertNotNull(student);
            System.out.println(student);

        }
    }
