package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>измеритель скорости и направления ветра МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – отказ;
 */
public enum MsuWindSpeedSensorMalfunction implements MsuMalfunction{
    NORMAL(0),
    MALFUNCTION(1);


    private int value;

    MsuWindSpeedSensorMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        return "несправність";
    }

    public static MsuWindSpeedSensorMalfunction valueOf(int val) {
        for (MsuWindSpeedSensorMalfunction posture : values()) {
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