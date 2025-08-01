package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // Required no-arg constructor for JPA
    protected Administrator() {
    }

    // Builder constructor
    protected Administrator(Builder builder) {
        this.adminId = builder.adminId;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    // Getters
    public Long getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private Long adminId;
        private String username;
        private String email;
        private String password;

//        public Builder setAdminId(Long adminId) {
//            this.adminId = adminId;
//            return this;
//        }

        public Builder setUsername(String username) {
            this.username = username;
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

        public Builder copy(Administrator administrator) {
            this.adminId = administrator.adminId;
            this.username = administrator.username;
            this.email = administrator.email;
            this.password = administrator.password;
            return this;
        }

        public Administrator build() {
            return new Administrator(this);
        }
    }
}
