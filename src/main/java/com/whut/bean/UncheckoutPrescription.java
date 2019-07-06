package com.whut.bean;

import javax.xml.registry.infomodel.User;

public class UncheckoutPrescription
{
    private String date;
    private String p_id;
    private String c_id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "UncheckoutPrescription{" +
                "date='" + date + '\'' +
                ", p_id='" + p_id + '\'' +
                ", c_id='" + c_id + '\'' +
                '}';
    }
}
