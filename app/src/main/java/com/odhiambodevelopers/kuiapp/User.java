package com.odhiambodevelopers.kuiapp;

public class User {
    private String username;
    private String regNo;
    private String phoneNumber;
    private String email;

    public  User(){

    }

    public User(String username, String regNo, String phoneNumber, String email) {
        this.username = username;
        this.regNo = regNo;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
