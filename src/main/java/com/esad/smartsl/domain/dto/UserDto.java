package com.esad.smartsl.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = -3258638684981965008L;

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String password;
    private UserRoleDto userRole;
    private Integer isForeigner;
    private String nic;
    private Integer passportNumber;
    private String accessToken;
    private Timestamp tokenExpiredAt;
    private String address;
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleDto getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDto userRole) {
        this.userRole = userRole;
    }

    public Integer getIsForeigner() {
        return isForeigner;
    }

    public void setIsForeigner(Integer isForeigner) {
        this.isForeigner = isForeigner;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Timestamp getTokenExpiredAt() {
        return tokenExpiredAt;
    }

    public void setTokenExpiredAt(Timestamp tokenExpiredAt) {
        this.tokenExpiredAt = tokenExpiredAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
