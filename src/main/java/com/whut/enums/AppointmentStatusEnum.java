package com.whut.enums;

public enum AppointmentStatusEnum
{
    UNPROCESSED(0, "未处理"), PROCESSED(1, "已处理"),;

    private int status;

    private String statusInfo;

    private AppointmentStatusEnum(int status, String statusInfo) {
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

