package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>концевики МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – отказ;
 */
public enum MsuEndSwitchesMalfunction {
    NORMAL(0),
    MALFUNCTION(1);


    private int value;

    MsuEndSwitchesMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        return "несправність";
    }

    public static MsuEndSwitchesMalfunction valueOf(int val) {
        for (MsuEndSwitchesMalfunction posture : values()) {
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