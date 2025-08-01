package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    // Validate that string is not null or empty
    public static boolean validString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Validate email using Apache Commons EmailValidator
    public static boolean validEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }

    // Validate password strength (min 6 characters)
    public static boolean validPassword(String password) {
        return validString(password) && password.length() >= 6;
    }

    // Trim and return a cleaned-up version of a string
    public static String sanitize(String str) {
        return str == null ? null : str.trim();
    }
}
