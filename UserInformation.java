package com.example.ghana.lifeline;


import com.google.firebase.database.DatabaseReference;

/**
 * Created by Ghana on 18-03-2017.
 */

public class UserInformation {
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

    public UserInformation() {
    }

    public UserInformation(String username, String age, String sex, String blood, String dob, String email, String contact, String password, String address, String pincode, String city) {
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
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getBlood(){
        return blood;
    }
    public void setBlood(String blood){
        this.blood=blood;
    }
    public String getDob(){
        return dob;
    }
    public void setDob(String dob){
        this.dob=dob;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;

    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getPincode(){
        return pincode;
    }
    public void setPincode(String pincode){
        this.pincode=pincode;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }
}
