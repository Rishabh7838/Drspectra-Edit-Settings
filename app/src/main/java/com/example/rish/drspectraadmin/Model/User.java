package com.example.rish.drspectraadmin.Model;

public class User {
    String Age;
    String Gender;
    String Name;
    String Phone;

    public User(String name, String gender, String age, String phone) {
        this.Name = name;
        this.Gender = gender;
        this.Age = age;
        this.Phone = phone;
    }

    public String getUserName() {
        return this.Name;
    }

    public void setUserName(String name) {
        this.Name = name;
    }

    public String getUserGender() {
        return this.Gender;
    }

    public void setUserGender(String gender) {
        this.Gender = gender;
    }

    public String getUserAge() {
        return this.Age;
    }

    public void setUserAge(String age) {
        this.Age = age;
    }

    public String getUserPhone() {
        return this.Phone;
    }

    public void setUserPhone(String phone) {
        this.Phone = phone;
    }
}

