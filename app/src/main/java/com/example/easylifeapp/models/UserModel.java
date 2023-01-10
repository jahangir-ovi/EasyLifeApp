package com.example.easylifeapp.models;

public class UserModel {
    String name;
    String emailid;
    String pass;

    public UserModel() {
    }

    public UserModel(String name, String emailid, String pass) {
        this.name = name;
        this.emailid = emailid;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
