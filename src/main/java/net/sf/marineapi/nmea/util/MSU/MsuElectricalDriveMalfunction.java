package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>электропривод МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – отказ;
 */
public enum MsuElectricalDriveMalfunction {
    NORMAL(0),
    MALFUNCTION(1);


    private int value;

    MsuElectricalDriveMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        return "несправність";
    }

    public static MsuElectricalDriveMalfunction valueOf(int val) {
        for (MsuElectricalDriveMalfunction posture : values()) {
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