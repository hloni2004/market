package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.Address;

@Entity
@Table(name = "residence")
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long residenceId;

    @Column(name = "residence_name")
    protected String residenceName;

    @Column(name = "room_number")
    protected String roomNumber;

    @Column(name = "floor_number")
    protected int floorNumber;

    @Column(name = "building")
    protected String buildingName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    protected Address address;

    protected Residence() {}

    protected Residence(Builder builder) {
        this.residenceId = builder.residenceId;
        this.residenceName = builder.residenceName;
        this.roomNumber = builder.roomNumber;
        this.floorNumber = builder.floorNumber;
        this.buildingName = builder.buildingName;
        this.address = builder.address;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Residence{" +
                "residenceId=" + residenceId +
                ", residenceName='" + residenceName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", floorNumber=" + floorNumber +
                ", buildingName='" + buildingName + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder {
        private Long residenceId;
        private String residenceName;
        private String roomNumber;
        private int floorNumber;
        private String buildingName;
        private Address address;

//        public Builder setResidenceId(Long residenceId) {
//            this.residenceId = residenceId;
//            return this;
//        }

        public Builder setResidenceName(String residenceName) {
            this.residenceName = residenceName;
            return this;
        }

        public Builder setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setFloorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        public Builder setBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(Residence residence) {
            this.residenceId = residence.getResidenceId();
            this.residenceName = residence.getResidenceName();
            this.roomNumber = residence.getRoomNumber();
            this.floorNumber = residence.getFloorNumber();
            this.buildingName = residence.getBuildingName();
            this.address = residence.getAddress();
            return this;
        }

        public Residence build() {
            return new Residence(this);
        }
    }
}
