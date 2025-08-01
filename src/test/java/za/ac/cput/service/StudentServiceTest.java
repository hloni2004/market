package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Residence;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ResidenceFactory;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceTest {
    private static Student student ;

    @Autowired
    private IStudentService studentService;

    @BeforeAll
    static void init() {
        Address address = AddressFactory.createAddress(
                "123",
                "Main Street",
                "Greenwood",
                "Cape Town",
                "Western Cape",
                8001
        );
        Residence residence = ResidenceFactory.createResidence(
                "Sunset Residence",
                "Room 101",
                1,
                "Sunset Building",
                address
        );

         student = StudentFactory.createStudent(
                "John",
                "Doe",
                "john.doe@example.com",
                "Password123!",
                residence
        );



    }
    @Test
    @Order(1)
    void create() {
        studentService.create(student);
    }

    @Test
    @Order(2)
    void read() {
        Student found = studentService.read(student.getStudentId());

    }

    @Test
    @Order(3)
    void update() {
        Student newStudent = new Student.Builder().copy(student).setFirstName("hloni").build();
        studentService.update(newStudent);
    }

    @Test
    @Order(4)
    void findByEmail() {
       Student found =  studentService.findByEmail(student.getEmail());
    }

    @Test
    @Order(5)
    void getAll() {
        studentService.getAll();
    }
}