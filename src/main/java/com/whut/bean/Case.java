package com.whut.bean;

import javax.xml.soap.Text;
import java.math.BigDecimal;
import java.util.Date;

public class Case {
    private int c_id;
    private char d_id;
    private char p_id;
    private Text c_description;
    private BigDecimal c_fee;
    private int c_status;
    private Date c_date;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public char getD_id() {
        return d_id;
    }

    public void setD_id(char d_id) {
        this.d_id = d_id;
    }

    public char getP_id() {
        return p_id;
    }

    public void setP_id(char p_id) {
        this.p_id = p_id;
    }

    public Text getC_description() {
        return c_description;
    }

    public void setC_description(Text c_description) {
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
                '}';
    }
}
