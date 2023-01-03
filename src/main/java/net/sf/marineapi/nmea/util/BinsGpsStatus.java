package net.sf.marineapi.nmea.util;

import lombok.NonNull;
import net.sf.marineapi.nmea.sentence.PMPSentence;

/**
 * Bins GPS status
 * user in POPMP
 *
 * @see PMPSentence
 * • 0 – данные GPS недостоверны;
 * • 1 – данные GPS достоверны;
 * • 2 – данные получены в ручном режиме (без использования GPS);
 */
public enum BinsGpsStatus {
    /**
     * 0 – данные GPS недостоверны
     */
    NON_RELIABLE,
    /**
     * 1 – данные GPS достоверны
     */
    RELIABLE,
    /**
     * 2 – данные получены в ручном режиме (без использования GPS)
     */
    PROVIDED_MANUALLY;

    /**
     * @param status RELIABLE, NON_RELIABLE, PROVIDED_MANUALLY
     * @return • 0 – данные GPS недостоверны;
     * • 1 – данные GPS достоверны;
     * • 2 – данные получены в ручном режиме (без использования GPS);
     */
    public static String toStringRaw(@NonNull BinsGpsStatus status) {
        int converted;
        if (status == NON_RELIABLE) {
            converted = 0;
        } else if (status == RELIABLE) {
            converted = 1;
        } else {
            converted = 2;
        }

        return String.valueOf(converted);
    }

    public static BinsGpsStatus fromStringRaw(String stringRawValue) {
        BinsGpsStatus converted;

        if (stringRawValue.equals("0")) {
            converted = NON_RELIABLE;
        } else if (stringRawValue.equals("1")) {
            converted = RELIABLE;
        } else {
            converted = PROVIDED_MANUALLY;
        }

        return converted;
    }

    public static boolean isValidRaw(String rawValue) {
        boolean valid = true;
        if(rawValue!=null &&  rawValue.length() != 1){
            valid=false;
        };

        if (!(rawValue.equals("0")
                || rawValue.equals("1")
                || rawValue.equals("2"))) {
            valid = false;
        }

        return valid;
    }
}
