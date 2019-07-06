package com.whut.enums;

public enum CaseStatusEnum
{
    UNPRESCRIBED(1, "待开药"),UNPADE(3, "待支付"), UNCHECKOUT(5, "待出库"),CHECKOUT(6, "已出库");

    private int status;

    private String statusInfo;

    private CaseStatusEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }
}
