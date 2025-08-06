package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long studentId;

    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Column(name = "email", nullable = false, unique = false)
    protected String email;

    @Column(name = "password", nullable = false)
    protected String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "residence_id")
    protected Residence residence;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference("student-products")
    protected List<Product> productForSale;

    @OneToMany(mappedBy = "buyer")
    @JsonManagedReference("student-transactions")
    protected List<Transaction> purchases;

    public Student() {}

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.residence = builder.residence;
        this.productForSale = builder.productForSale;
        this.purchases = builder.purchases;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Residence getResidence() {
        return residence;
    }

    public List<Product> getProductForSale() {
        return productForSale;
    }

    public List<Transaction> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", residence=" + residence +
                ", productForSale=" + productForSale +
                ", purchases=" + purchases +
                '}';
    }

    public static class Builder {
        private Long studentId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Residence residence;
        private List<Product> productForSale;
        private List<Transaction> purchases;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setResidence(Residence residence) {
            this.residence = residence;
            return this;
        }

        public Builder setProductForSale(List<Product> productForSale) {
            this.productForSale = productForSale;
            return this;
        }

        public Builder setPurchases(List<Transaction> purchases) {
            this.purchases = purchases;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.email = student.email;
            this.password = student.password;
            this.residence = student.residence;
            this.productForSale = student.productForSale;
            this.purchases = student.purchases;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}