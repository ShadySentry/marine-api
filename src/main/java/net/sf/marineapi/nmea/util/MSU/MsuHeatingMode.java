package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>подогрев МС-Ю:
 * <p>  •	0 – отключен;
 * <p>  •	1 – включен;
 */
public enum MsuHeatingMode {
    OFF(0),
    ON(1);


    private int value;

    MsuHeatingMode(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "вимкнен";
        }
        return "увімкнен";
    }

    public static MsuHeatingMode valueOf(int val) {
        for (MsuHeatingMode posture : values()) {
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