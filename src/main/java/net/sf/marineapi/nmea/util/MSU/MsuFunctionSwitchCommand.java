package net.sf.marineapi.nmea.util.MSU;

/**
 * <p>запрос переключения функций МС-Ю:
 * <p>  •	0 – нет запроса;
 * <p>  •	1 – есть запрос;
 */
public enum MsuFunctionSwitchCommand {
    NO_REQUEST(0),
    REQUEST_IS_PRESENT(1);


    private int value;

    MsuFunctionSwitchCommand(int value) {
        this.value = value;
    }

    public String getStringValue() {
        if (value == 0) {
            return "запит відстній";
        }
        return "запит присутній";
    }

    public static MsuFunctionSwitchCommand valueOf(int val) {
        for (MsuFunctionSwitchCommand function : values()) {
            if (function.toInt() == val) {
                return function;
            }
        }
        return valueOf(String.valueOf(val));
    }

    public int toInt() {
        return value;
    }
}
