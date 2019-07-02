package com.whut.enums;

public enum GenderEnum
{
    MEAL(1, "男"), FEMEAL(2, "女"),;

    private int gender;

    private String genderDesc;

    private GenderEnum(int gender, String genderDesc) {
        this.gender = gender;
        this.genderDesc = genderDesc;
    }

    public int getGender() {
        return gender;
    }

    public String getDesc() {
        return genderDesc;
    }
}
