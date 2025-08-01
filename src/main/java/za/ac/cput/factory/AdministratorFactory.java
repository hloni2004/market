package za.ac.cput.factory;

import za.ac.cput.domain.Administrator;
import za.ac.cput.util.Helper;

public class AdministratorFactory {

    public static Administrator createAdministrator(String username, String email, String password) {
        if (!Helper.validString(username) || !Helper.validEmail(email) || !Helper.validPassword(password)) {
           return null;
        }

        return new Administrator.Builder()
                .setUsername(Helper.sanitize(username))
                .setEmail(Helper.sanitize(email))
                .setPassword(password)
                .build();
    }
}
