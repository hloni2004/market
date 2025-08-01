package za.ac.cput.factory;

import za.ac.cput.domain.Residence;
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

import java.util.ArrayList;

public class StudentFactory {

    public static Student createStudent(String firstName, String lastName, String email,
                                        String password, Residence residence) {

        if (!Helper.validString(firstName) ||
                !Helper.validString(lastName) ||
                !Helper.validEmail(email) ||
                !Helper.validPassword(password) ||
                residence == null) {
            return null;
        }

        return new Student.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setResidence(residence)
                .setProductForSale(new ArrayList<>())  // Prevent LazyInitializationException
                .setPurchases(new ArrayList<>())       // Prevent LazyInitializationException
                .build();
    }
}
