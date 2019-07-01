package com.whut.bean;

import java.util.Date;

//wirte by sunfahu
public class Patient {
    private String p_id;//病人编号
    private String p_name;//病人姓名
    private int p_gender;//病人性别
    private Date p_birthday;//病人出生日期
    private String p_password;//病人密码

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
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
                ",p_password='" + p_password + '\'' +
                '}';
    }
}

