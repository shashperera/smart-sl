package com.esad.smartsl.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "USER")
public class User extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -4346634251382564016L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE_NO")
    private String mobileNo;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ROLE_ID", nullable = false)
    private UserRole userRole;

    @Column(name = "IS_FOREIGNER")
    private Integer isForeigner;

    @Column(name = "NIC")
    private String nic;

    @Column(name = "PASSPORT_NUMBER")
    private Integer passportNumber;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "TOKEN_EXPIRED_AT")
    private Timestamp tokenExpiredAt;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
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
