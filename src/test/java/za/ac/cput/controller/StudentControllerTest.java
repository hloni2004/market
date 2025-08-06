package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Residence;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ResidenceFactory;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentControllerTest {

    private static Student student;
    private static Residence residence;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/market/student";

    @BeforeAll
    static void setUp() {
        Address address = AddressFactory.createAddress(
                "456",
                "Oak Avenue",
                "Riverview",
                "Durban",
                "KwaZulu-Natal",
                4001
        );

        residence = ResidenceFactory.createResidence(
                "Riverside Lodge",
                "Room 202",
                2,
                "Riverside Building",
                address
        );

        student = StudentFactory.createStudent(
                "Jane",
                "Smith",
                "jane.smith@example.com",
                "SecurePass456!",
                residence
        );
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Student> response = this.restTemplate.postForEntity(url, student, Student.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        student = response.getBody(); // save returned object with ID
        System.out.println("Created: " + response.getBody());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + student.getStudentId();
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Student updatedStudent = new Student.Builder()
                .copy(student)
                .setFirstName("Janet")
                .build();

        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedStudent);

        String readUrl = BASE_URL + "/read/" + updatedStudent.getStudentId();
        ResponseEntity<Student> response = restTemplate.getForEntity(readUrl, Student.class);

        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());

        student = updatedStudent; // update reference for future tests
    }

    @Test
    void d_delete() {
//        String url = BASE_URL + "/delete/" + student.getStudentId();
//        restTemplate.delete(url);
//
//        String readUrl = BASE_URL + "/read/" + student.getStudentId();
//        ResponseEntity<Student> response = restTemplate.getForEntity(readUrl, Student.class);
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        System.out.println("Deleted student with ID: " + student.getStudentId());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
        System.out.println("All Students: " + response.getBody());
    }
}
