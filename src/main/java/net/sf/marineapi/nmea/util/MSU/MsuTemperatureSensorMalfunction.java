package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>датчик температуры МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – отказ;
 */
public enum MsuTemperatureSensorMalfunction implements MsuMalfunction{
    NORMAL(0),
    MALFUNCTION(1);


    private int value;

    MsuTemperatureSensorMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        return "несправність";
    }

    public static MsuTemperatureSensorMalfunction valueOf(int val) {
        for (MsuTemperatureSensorMalfunction posture : values()) {
            if (posture.toInt() == val) {
                return posture;
            }
        }
        return valueOf(String.valueOf(val));
    }

    public int toInt() {
        return value;
    }

    @Override
    public boolean isNormal() {
        return this==NORMAL;
    }
}