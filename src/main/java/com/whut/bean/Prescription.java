package com.whut.bean;

import java.util.Date;

// 药方类

public class Prescription {
    // 药方编号
    private int pr_id;
    // 病例编号
    private int c_id;
    // 药品编码（国药）
    private String m_id;
    // 药方的时间
    private Date pr_date;


    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public Date getPr_date() {
        return pr_date;
    }

    public void setPr_date(Date pr_date) {
        this.pr_date = pr_date;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "pr_id=" + pr_id +
                ", c_id=" + c_id +
                ", m_id='" + m_id + '\'' +
                ", pr_date=" + pr_date +
                '}';
    }
}
