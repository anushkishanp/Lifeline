package com.example.ghana.lifeline;

/**
 * Created by Ghana on 27-03-2017.
 */

public class details {
    public String username;
    public String age;
    public String sex;
    public String blood;
    public String dob;
    public String email;
    public String contact;
    public String password;
    public String address;
    public String pincode;
    public String city;

    public details() {
    }

    public details(String username, String age, String sex, String blood, String dob, String email, String contact, String password, String address, String pincode, String city) {
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.blood = blood;
        this.dob = dob;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getBlood() {
        return blood;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }
}
