package com.epam.projects.kidsshop.entity;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private long iin;
    private long phone;
    private String email;
    private String address;
    private String details;
    private String status;
    private String password;
    private boolean adminPermission;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getIin() {
        return iin;
    }

    public void setIin(long iin) {
        this.iin = iin;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(boolean adminPermission) {
        this.adminPermission = adminPermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                iin == user.iin &&
                phone == user.phone &&
                adminPermission == user.adminPermission &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(email, user.email) &&
                Objects.equals(address, user.address) &&
                Objects.equals(details, user.details) &&
                Objects.equals(status, user.status) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, iin, phone, email, address, details, status, password, adminPermission);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", iin=" + iin +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", adminPermission=" + adminPermission +
                '}';
    }
}