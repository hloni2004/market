package za.ac.cput.factory;

import za.ac.cput.domain.Transaction;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Student;

import java.time.LocalDateTime;

public class TransactionFactory {

    public static Transaction createTransaction(
            String imageOfProduct,
            String productLabel,
            String productDescription,
            String productCondition,
            LocalDateTime transactionDate,
            double price,
            Product product,
            Student buyer) {

        if (imageOfProduct == null || productLabel == null || productDescription == null || productCondition == null
                || transactionDate == null || price <= 0 || product == null || buyer == null) {
            return null;
        }

        return new Transaction.Builder()
                .setImageOfProduct(imageOfProduct)
                .setProductLabel(productLabel)
                .setProductDescription(productDescription)
                .setProductCondition(productCondition)
                .setTransactionDate(transactionDate)
                .setPrice(price)
                .setProduct(product)
                .setBuyer(buyer)
                .build();
    }
}
