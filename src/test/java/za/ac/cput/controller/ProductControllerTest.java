package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductControllerTest {

    private static Product product;
    private static Student seller;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/market/product";

    @BeforeAll
    static void setUp() {
        Address address = AddressFactory.createAddress(
                "789",
                "Pine Street",
                "Hillview",
                "Johannesburg",
                "Gauteng",
                2001
        );

        Residence residence = ResidenceFactory.createResidence(
                "Hilltop Residence",
                "Room 303",
                3,
                "Hilltop Building",
                address
        );

        seller = StudentFactory.createStudent(
                "Alice",
                "Brown",
                "alice.brown@example.com",
                "StrongPass789!",
                residence
        );

        product = ProductFactory.createProduct(
                "Gaming Laptop",
                "High-performance gaming laptop with RTX graphics",
                "New",
                2500.00,
                "Electronics",
                true,
                "https://example.com/laptop.jpg",
                seller
        );
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Product> response = this.restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        product = response.getBody();  // save returned object with ID
        System.out.println("Created: " + product);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + product.getProductId();
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Product updatedProduct = new Product.Builder()
                .copy(product)
                .setPrice(2700.00)
                .build();

        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedProduct);

        String readUrl = BASE_URL + "/read/" + updatedProduct.getProductId();
        ResponseEntity<Product> response = restTemplate.getForEntity(readUrl, Product.class);

        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());

        product = updatedProduct;  // update reference for future tests
    }

    @Test
    void d_delete() {
        // Uncomment below if delete functionality is implemented
        // String url = BASE_URL + "/delete/" + product.getProductId();
        // restTemplate.delete(url);
        //
        // String readUrl = BASE_URL + "/read/" + product.getProductId();
        // ResponseEntity<Product> response = restTemplate.getForEntity(readUrl, Product.class);
        // assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        // System.out.println("Deleted product with ID: " + product.getProductId());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
        System.out.println("All Products: " + response.getBody());
    }
}
