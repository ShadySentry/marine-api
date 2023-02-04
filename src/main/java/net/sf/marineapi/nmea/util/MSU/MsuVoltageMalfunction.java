package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>напряжение МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – повышенное;
 * <p>  •	1 – пониженное;
 */
public enum MsuVoltageMalfunction {
    NORMAL(0),
    HIGH(1),
    LOW(2);


    private int value;

    MsuVoltageMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        if(value==1) {
            return  "висока";
        }
        return "низька";
    }

    public static MsuVoltageMalfunction valueOf(int val) {
        for (MsuVoltageMalfunction posture : values()) {
            if (posture.toInt() == val) {
                return posture;
            }
        }
        return valueOf(String.valueOf(val));
    }

    public int toInt() {
        return value;
    }
}