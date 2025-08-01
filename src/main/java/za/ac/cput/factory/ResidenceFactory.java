package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Residence;
import za.ac.cput.util.Helper;

public class ResidenceFactory {

    public static Residence createResidence(String residenceName, String roomNumber, int floorNumber,
                                            String buildingName, Address address) {

        if (!Helper.validString(residenceName) ||
                !Helper.validString(roomNumber) ||
                floorNumber <= 0 ||
                !Helper.validString(buildingName) ||
                address == null) {
            return null;
        }

        return new Residence.Builder()
                .setResidenceName(Helper.sanitize(residenceName))
                .setRoomNumber(Helper.sanitize(roomNumber))
                .setFloorNumber(floorNumber)
                .setBuildingName(Helper.sanitize(buildingName))
                .setAddress(address)
                .build();
    }
}
