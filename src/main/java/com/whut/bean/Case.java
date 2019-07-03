package com.whut.bean;

import javax.xml.soap.Text;
import java.math.BigDecimal;
import java.util.Date;

public class Case {
    private Integer c_id;//病例编号
    private String d_id;//医生编号
    private String p_id;//病人编号
    private String c_description;//病例描述
    private BigDecimal c_fee;//费用
    private int c_status;//病例状态
    private Date c_date;//病例生成日期
    private String pr_description;//药物清单

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

    public BigDecimal getC_fee() {
        return c_fee;
    }

    public void setC_fee(BigDecimal c_fee) {
        this.c_fee = c_fee;
    }

    public int getC_status() {
        return c_status;
    }

    public void setC_status(int c_status) {
        this.c_status = c_status;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public String getPr_description() {
        return pr_description;
    }

    public void setPr_description(String pr_description) {
        this.pr_description = pr_description;
    }

    @Override
    public String toString() {
        return "Case{" +
                "c_id=" + c_id +
                ", d_id=" + d_id +
                ", p_id=" + p_id +
                ", c_description=" + c_description +
                ", c_fee=" + c_fee +
                ", c_status=" + c_status +
                ", c_date=" + c_date +
                ", pr_description=" + pr_description +
                '}';
    }
}
