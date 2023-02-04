package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>режим работы МС-Ю:
 * <p>  •	0 – ждущий режим;
 * <p>  •	1 – готова к работе;
 */
public enum MsuOperatingMode {
    PENDING(0),
    READY_FOR_OPERATION(1);


    private int value;

    MsuOperatingMode(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "ждущий режим";
        }
        return "готова к работе";
    }

    public static MsuOperatingMode valueOf(int val) {
        for (MsuOperatingMode posture : values()) {
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