package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>обмен с потребителем МС-Ю:
 * <p>  •	0 – норма;
 * <p>  •	1 – ошибка приема;
 */
public enum MsuDataExchangeMalfunction implements MsuMalfunction{
    NORMAL(0),
    MALFUNCTION(1);


    private int value;

    MsuDataExchangeMalfunction(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "норма";
        }
        return "помилка прийому";
    }

    public static MsuDataExchangeMalfunction valueOf(int val) {
        for (MsuDataExchangeMalfunction posture : values()) {
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