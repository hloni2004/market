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
    private static Long savedProductId; // Store the ID separately

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

            Address address = AddressFactory.createAddress(
                    "221", "Long Street", "CBD", "Cape Town", "Western Cape", 8000
            );

            Residence residence = ResidenceFactory.createResidence(
                    "Central Residence", "Room 20", 2, "Block B", address
            );

            student = StudentFactory.createStudent(
                    "John", "Doe", "john.doe@example.com", "password123", residence
            );

            student = studentService.create(student); // Persist student and get the saved version
            System.out.println("Student created with ID: " + student.getStudentId());


        // Only create product if we haven't already created it

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
        assertNotNull(product, "Product should not be null before creation");

        Product savedProduct = productService.create(product);

        assertNotNull(savedProduct, "Saved product should not be null");
        assertNotNull(savedProduct.getProductId(), "Saved product should have an ID");

        // Store the ID for use in other tests
        savedProductId = savedProduct.getProductId();

        // Update our product reference to the saved version
        product = savedProduct;

        System.out.println("Created product with ID: " + savedProductId);
        System.out.println("Created: " + product);
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(savedProductId, "Product ID should be available from create test");

        Product readProduct = productService.read(savedProductId);

        assertNotNull(readProduct, "Read product should not be null");
        assertEquals(savedProductId, readProduct.getProductId(), "Product IDs should match");
        assertEquals("Laptop", readProduct.getProductName(), "Product name should match");

        System.out.println("Read product: " + readProduct);
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(savedProductId, "Product ID should be available from create test");

        Product updated = new Product.Builder()
                .copy(product)
                .setPrice(2000.99)
                .setProductDescription("Updated gaming laptop")
                .build();

        Product result = productService.update(updated);

        assertNotNull(result, "Updated product should not be null");
        assertEquals(savedProductId, result.getProductId(), "Product ID should remain the same");
        assertEquals(2000.99, result.getPrice(), "Price should be updated");
        assertEquals("Updated gaming laptop", result.getProductDescription(), "Description should be updated");

        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        List<Product> products = productService.getAll();

        assertNotNull(products, "Products list should not be null");
        assertFalse(products.isEmpty(), "Products list should not be empty");

        // Check if our product is in the list
        boolean found = products.stream()
                .anyMatch(p -> savedProductId.equals(p.getProductId()));
        assertTrue(found, "Our created product should be in the list");

        System.out.println("Found " + products.size() + " products");
        products.forEach(p -> System.out.println(" - " + p.getProductName() + " (ID: " + p.getProductId() + ")"));
    }

    @Test
    @Order(5)
    void delete() {
        assertNotNull(savedProductId, "Product ID should be available from create test");

        // Verify product exists before deletion
        Product existingProduct = productService.read(savedProductId);
        assertNotNull(existingProduct, "Product should exist before deletion");

        boolean deleted = productService.delete(savedProductId);
        assertTrue(deleted, "Delete operation should return true");

        // Verify product no longer exists
        Product deletedProduct = productService.read(savedProductId);
        assertNull(deletedProduct, "Product should be null after deletion");

        System.out.println("Successfully deleted product with ID: " + savedProductId);
    }
}