package com.whut.bean;

public class Administrators {
    // 编号
    private String ad_id;
    // 密码
    private String ad_password;

    @Override
    public String toString() {
        return "Administrators{" +
                "ad_id='" + ad_id + '\'' +
                ", ad_password='" + ad_password + '\'' +
                ", ad_name='" + ad_name + '\'' +
                '}';
    }

    // 姓名
    private String ad_name;


    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_password() {
        return ad_password;
    }

    public void setAd_password(String ad_password) {
        this.ad_password = ad_password;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }



}
