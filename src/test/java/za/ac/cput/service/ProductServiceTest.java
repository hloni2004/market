package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Residence;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.ResidenceFactory;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ProductServiceTest {

    private static Product product;
    private static Student student;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProductService productService;

    @BeforeAll
    static void beforeAll() {
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




        product = ProductFactory.createProduct(
                "Laptop",
                "High-end gaming laptop",
                "New",
                1500.00,
                "Electronics",
                true,
                "imageUrlHere",
                student
        );

    }


    @Test
    @Order(1)
    void create() {
        student = studentService.create(student);
        assertNotNull(student);
        product = productService.create(product);

    }

    @Test
    @Order(2)
    void read() {
        product = productService.read(product.getProductId());
        System.out.println(product);
    }

    @Test
    @Order(3)
    void update() {
        Product updatedProduct = new Product.Builder().copy(product).setPrice(578990363014.23).build();
        product = productService.update(updatedProduct);
    }

    @Test
    @Order(4)
    void delete() {
        productService.delete(product.getProductId());
    }

    @Test
    @Order(5)
    void getAll() {
        productService.getAll();
    }
}