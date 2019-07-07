package com.whut.enums;

public enum CaseStatusEnum
{
    UNPRESCRIBED(1, "待开药"),UNPADE(2, "待支付"), UNCHECKOUT(3, "待出库"),CHECKOUT(4, "已出库");

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
