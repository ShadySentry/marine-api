package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>смена положения МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – ошибка перехода в рабочее положение;
 * <p>  •	1 – ошибка перехода в транспортное положение;
 */
public enum MsuPostureSwitchMalfunction implements MsuMalfunction{
    NORMAL(0),
    OPERATING_MODE_SWITCH_MALFUNCTION(1),
    TRANSPORT_MODE_SWITCH_MALFUNCTION(2);


    private int value;

    MsuPostureSwitchMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        if(value==1) {
            return  "помилка переходу в робоче положення";
        }
        return "помилка переходу в транспортне положення";
    }

    public static MsuPostureSwitchMalfunction valueOf(int val) {
        for (MsuPostureSwitchMalfunction posture : values()) {
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