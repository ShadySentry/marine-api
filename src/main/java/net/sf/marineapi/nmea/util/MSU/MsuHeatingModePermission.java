package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>разрешение подогрева МС-Ю:
 * <p>  •	0 – запрещен;
 * <p>  •	1 – разрешен;
 */
public enum MsuHeatingModePermission {
    DISABLED(0),
    ENABLED(1);


    private int value;

    MsuHeatingModePermission(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "заборонен";
        }
        return "дозволен";
    }

    public static MsuHeatingModePermission valueOf(int val) {
        for (MsuHeatingModePermission posture : values()) {
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