package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {

    private static Student student;
    private static Product product;

    @Autowired
    private IProductService productService;

    @Autowired
    private IStudentService studentService;

    @BeforeAll
    static void setupData() {
        System.out.println("==> Starting ProductService Tests...");
    }

    @BeforeEach
    void setUp() {
        if (student == null) {
            Address address = AddressFactory.createAddress(
                    "221", "Long Street", "CBD", "Cape Town", "Western Cape", 8000
            );

            Residence residence = ResidenceFactory.createResidence(
                    "Central Residence", "Room 20", 2, "Block B", address
            );

            student = StudentFactory.createStudent(
                    "John", "Doe", "john.doe@example.com", "password123", residence
            );

            studentService.create(student); // Persist student once
        }

        product = ProductFactory.createProduct(
                "Laptop",
                "High-end gaming laptop",
                "New",
                1500.00,
                "Electronics",
                true,
                "imageUrlHere",
                student // associate existing student
        );
    }

    @Test
    @Order(1)
    void create() {
        product = productService.create(product); // Save and assign to get ID
        assertNotNull(product);
        assertNotNull(product.getProductId()); // This should now pass
        System.out.println("Created: " + product);
    }


    @Test
    @Order(2)
    void read() {
        Product saved = productService.read(product.getProductId());
        assertNotNull(saved);
        System.out.println("Read: " + saved);
    }

    @Test
    @Order(3)
    void update() {
        Product updated = new Product.Builder()
                .copy(product)
                .setPrice(2000.99)
                .build();
        Product result = productService.update(updated);
        assertNotNull(result);
        assertEquals(2000.99, result.getPrice());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = productService.delete(product.getProductId());
        assertTrue(deleted);
        System.out.println("Deleted product with ID: " + product.getProductId());
    }

    @Test
    @Order(5)
    void getAll() {
        List<Product> products = productService.getAll();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println("All Products: " + products);
    }
}
