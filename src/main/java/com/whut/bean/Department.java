package com.whut.bean;

import javax.xml.soap.Text;
import java.util.Date;

public class Department {
    private String dp_id;//部门编号
    private String dp_name;//部门名称
    private String dp_description;//部门简介

    public String getDp_id() {
        return dp_id;
    }

    public void setDp_id(String dp_id) {
        this.dp_id = dp_id;
    }

    public String getDp_name() {
        return dp_name;
    }

    public void setDp_name(String dp_name) {
        this.dp_name = dp_name;
    }

    public String getDp_description() {
        return dp_description;
    }

    public void setDp_description(String dp_description) {
        this.dp_description = dp_description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dp_id='" + dp_id + '\'' +
                ", dp_name='" + dp_name + '\'' +
                ", dp_description=" + dp_description +
                '}';
    }
}
