package com.whut.bean;
//code by sunfahu
public class Type {
    private char t_id;
    private String t_name;

    public char getT_id() {
        return t_id;
    }

    public void setT_id(char t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                '}';
    }
}
