package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

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

        // Validate required fields only (productName, price, condition, seller)
        if (!Helper.validString(productName) || price == null || price <= 0 || !Helper.validString(condition) || seller == null) {
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
