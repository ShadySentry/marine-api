package net.sf.marineapi.nmea.util.MSU;

/**
 * •	0 – транспортное;
 * •	1 – рабочее;
 * •	2 – мачта раскладывается;
 * •	3 – мачта складывается
 */
public enum MsuPosture {
    TRANSPORT(0),
    OPERATING(1),
    ANTENNA_ROD_PULLING_OUT(2),
    ANTENNA_ROD_PULLING_IN(3);


    private int value;

    MsuPosture(int value) {
        this.value = value;
    }

    public String getStringValue() {
        switch (value) {
            case 0:
                return "транспортне";
            case 1:
                return "робоче";
            case 2:
                return "мачта розкладається";
            default:
                return "мачта складається";
        }
    }

    public static MsuPosture valueOf(int val) {
        for (MsuPosture posture : values()) {
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