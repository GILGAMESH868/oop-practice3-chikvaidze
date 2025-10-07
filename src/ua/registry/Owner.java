package ua.registry;

import java.time.LocalDate;

public class Owner extends BaseEntity {
    private String firstName;
    private String lastName;
    private String driverLicenseNumber;
    private LocalDate birthDate;
    private String address;
    private boolean licenseSuspended;

    public Owner(String id, String firstName, String lastName, String driverLicenseNumber,
                 LocalDate birthDate, String address) {
        this.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverLicenseNumber = driverLicenseNumber;
        this.birthDate = birthDate;
        this.address = address;
    }

    public void updateAddress(String newAddress) {
        if (newAddress == null || newAddress.isBlank()) return;
        this.address = newAddress.trim();
    }

    public void suspendLicense() { this.licenseSuspended = true; }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDriverLicenseNumber() { return driverLicenseNumber; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public boolean isLicenseSuspended() { return licenseSuspended; }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", licenseSuspended=" + licenseSuspended +
                '}';
    }
}
