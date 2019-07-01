package com.whut.bean;

import java.util.Date;

public class Appointment {
    private int a_id;//挂号单编号
    private String dp_id;//预约部门编号
    private Date a_date;//预约日期
    private String p_id;//病人id
    private int a_status;//挂号单状态

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getDp_id() {
        return dp_id;
    }

    public void setDp_id(String dp_id) {
        this.dp_id = dp_id;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public int getA_status() {
        return a_status;
    }

    public void setA_status(int a_status) {
        this.a_status = a_status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "a_id=" + a_id +
                ", dp_id='" + dp_id + '\'' +
                ", a_date=" + a_date +
                ", p_id='" + p_id + '\'' +
                ", a_status=" + a_status +
                '}';
    }
}
