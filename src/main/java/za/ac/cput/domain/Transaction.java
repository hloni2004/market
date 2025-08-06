package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import za.ac.cput.domain.Student;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long transactionId;

    @Column(name = "transaction_date")
    protected LocalDateTime transactionDate;

    @Column(name = "image_of_product")
    protected String imageOfProduct;

    @Column(name = "product_label")
    protected String productLabel;

    @Column(name = "description")
    protected String productDescription;

    @Column(name = "product_condition")
    protected String productCondition;

    @Column(name = "price")
    protected double price;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    protected Product product;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @JsonBackReference("student-transactions")
    protected Student buyer;

    protected Transaction() {}

    protected Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.imageOfProduct = builder.imageOfProduct;
        this.productLabel = builder.productLabel;
        this.productDescription = builder.productDescription;
        this.productCondition = builder.productCondition;
        this.transactionDate = builder.transactionDate;
        this.price = builder.price;
        this.product = builder.product;
        this.buyer = builder.buyer;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public String getImageOfProduct() {
        return imageOfProduct;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public Student getBuyer() {
        return buyer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionDate=" + transactionDate +
                ", price=" + price +
                ", product=" + product +
                ", buyer=" + buyer +
                '}';
    }

    public static class Builder {
        protected Long transactionId;
        protected String imageOfProduct;
        protected String productLabel;
        protected String productDescription;
        protected String productCondition;
        protected LocalDateTime transactionDate;
        protected double price;
        protected Product product;
        protected Student buyer;

        public Builder setImageOfProduct(String imageOfProduct) {
            this.imageOfProduct = imageOfProduct;
            return this;
        }

        public Builder setProductLabel(String productLabel) {
            this.productLabel = productLabel;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder setProductCondition(String productCondition) {
            this.productCondition = productCondition;
            return this;
        }

        public Builder setTransactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setBuyer(Student buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder copy(Transaction transaction) {
            this.transactionId = transaction.transactionId;
            this.imageOfProduct = transaction.imageOfProduct;
            this.productLabel = transaction.productLabel;
            this.productDescription = transaction.productDescription;
            this.productCondition = transaction.productCondition;
            this.transactionDate = transaction.transactionDate;
            this.price = transaction.price;
            this.product = transaction.product;
            this.buyer = transaction.buyer;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}