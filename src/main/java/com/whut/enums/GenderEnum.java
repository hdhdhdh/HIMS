package com.whut.enums;

public enum GenderEnum
{
    MEAL(1, "男"), FEMEAL(2, "女"),;

    private int state;

    private String values;

    private GenderEnum(int state, String values) {
        this.state = state;
        this.values = values;
    }

    public int getState()
    {
        return state;
    }
    public static GenderEnum getGenderEnum(int index)
    {
        for (GenderEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
    public String getValues()
    {
        return values;
    }


}
