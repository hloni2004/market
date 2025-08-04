package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void createProduct() {

        Student seller = new Student.Builder()

                .setFirstName("John")
                .setLastName("Doe")
                .build();

        Product product = ProductFactory.createProduct(
                "Laptop",
                "High-end gaming laptop",
                "New",
                1500.00,
                "Electronics",
                true,
                "imageUrlHere",
                seller
        );

        assertNotNull(product);
        System.out.print(product);

    }
}
