package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean validString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean validEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }

    public static boolean validPassword(String password) {
        return validString(password) && password.length() >= 6;
    }

    public static String sanitize(String str) {
        return str == null ? null : str.trim();
    }
}
