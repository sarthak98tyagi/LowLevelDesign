package VehicleRental;

import java.util.UUID;

public class User {

    private String userId;
    private String userName;
    private int age;
    private String email;
    private String contactNumber;
    private String licenseId;

    public User(String userName, int age, String email, String contactNumber, String licenseId) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.contactNumber = contactNumber;
        this.licenseId = licenseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

}
