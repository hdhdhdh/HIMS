package com.whut.enums;

public enum CaseStatusEnum
{
    UNPADE(1, "未处理"), PADE(2, "已处理");

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
