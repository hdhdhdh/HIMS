package com.whut.bean;

import java.util.Date;
import java.util.List;

// 药方类

public class Prescription {

    private Integer c_id;// 药方编号

    private String m_id;// 病例编号
    private String m_name;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "c_id=" + c_id +
                ", m_id='" + m_id + '\'' +
                ", m_name='" + m_name + '\'' +
                '}';
    }
}
