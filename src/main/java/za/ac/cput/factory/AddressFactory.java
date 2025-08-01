package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {

    public static Address createAddress(String streetNumber, String streetName, String suburb,
                                        String city, String province, int postalCode) {

        if (!Helper.validString(streetNumber) || !Helper.validString(streetName) ||
                !Helper.validString(suburb) || !Helper.validString(city) ||
                !Helper.validString(province) || postalCode <= 0) {
          return null;
        }

        return new Address.Builder()
                .setStreetNumber(Helper.sanitize(streetNumber))
                .setStreetName(Helper.sanitize(streetName))
                .setSuburb(Helper.sanitize(suburb))
                .setCity(Helper.sanitize(city))
                .setProvince(Helper.sanitize(province))
                .setPostalCode(postalCode)
                .build();
    }
}
