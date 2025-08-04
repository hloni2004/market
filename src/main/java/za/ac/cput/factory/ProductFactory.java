package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

/**
 * ProductFactory is responsible for creating valid Product instances
 * using the Builder pattern.
 */
public class ProductFactory {

    public static Product createProduct(
            String productName,
            String productDescription,
            String condition,
            Double price,
            String productCategory,
            boolean availabilityStatus,
            String productImageUrl,
            Student seller) {

        if (!Helper.validString(productName)
                || !Helper.validString(productDescription)
                || !Helper.validString(condition)
                || price == null || price <= 0
                || !Helper.validString(productCategory)
                || !Helper.validString(productImageUrl)
                || seller == null) {
            System.out.println(" ProductFactory validation failed.");
            return null;
        }

        return new Product.Builder()
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setCondition(condition)
                .setPrice(price)
                .setProductCategory(productCategory)
                .setAvailabilityStatus(availabilityStatus)
                .setProductImageUrl(productImageUrl)
                .setSeller(seller)
                .build();
    }
}
