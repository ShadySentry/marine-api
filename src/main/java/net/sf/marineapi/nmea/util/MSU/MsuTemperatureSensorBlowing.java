package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>обдув датчика температуры  МС-Ю:
 * <p>  •	0 – отключен;
 * <p>  •	1 – включен;
 */
public enum MsuTemperatureSensorBlowing {
    OFF(0),
    ON(1);


    private int value;

    MsuTemperatureSensorBlowing(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "вимкнен";
        }
        return "увімкнен";
    }

    public static MsuTemperatureSensorBlowing valueOf(int val) {
        for (MsuTemperatureSensorBlowing posture : values()) {
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