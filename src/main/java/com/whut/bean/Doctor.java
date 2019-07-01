package com.whut.bean;

import java.util.Date;

public class Doctor {
    private char d_id;
    private char t_id;
    private String d_title;
    private int d_gender;
    private Date d_birthday;
    private char dp_id;
    private String d_password;
    private String d_name;

    public char getD_id() {
        return d_id;
    }

    public void setD_id(char d_id) {
        this.d_id = d_id;
    }

    public char getT_id() {
        return t_id;
    }

    public void setT_id(char t_id) {
        this.t_id = t_id;
    }

    public String getD_title() {
        return d_title;
    }

    public void setD_title(String d_title) {
        this.d_title = d_title;
    }

    public int getD_gender() {
        return d_gender;
    }

    public void setD_gender(int d_gender) {
        this.d_gender = d_gender;
    }

    public Date getD_birthday() {
        return d_birthday;
    }

    public void setD_birthday(Date d_birthday) {
        this.d_birthday = d_birthday;
    }

    public char getDp_id() {
        return dp_id;
    }

    public void setDp_id(char dp_id) {
        this.dp_id = dp_id;
    }

    public String getD_password() {
        return d_password;
    }

    public void setD_password(String d_password) {
        this.d_password = d_password;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "d_id=" + d_id +
                ", t_id=" + t_id +
                ", d_title='" + d_title + '\'' +
                ", d_gender=" + d_gender +
                ", d_birthday=" + d_birthday +
                ", dp_id=" + dp_id +
                ", d_password='" + d_password + '\'' +
                ", d_name='" + d_name + '\'' +
                '}';
    }
}
