package com.whut.bean;

import java.util.Date;

//wirte by sunfahu
public class Patient {
    private char p_id;
    private String p_name;
    private int p_gender;
    private Date p_birthday;
    private String p_password;

    public char getP_id() {
        return p_id;
    }

    public void setP_id(char p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_gender() {
        return p_gender;
    }

    public void setP_gender(int p_gender) {
        this.p_gender = p_gender;
    }

    public Date getP_birthday() {
        return p_birthday;
    }

    public void setP_birthday(Date p_birthday) {
        this.p_birthday = p_birthday;
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_gender=" + p_gender +
                ", p_birthday=" + p_birthday +
                ", p_password='" + p_password + '\'' +
                '}';
    }
}

