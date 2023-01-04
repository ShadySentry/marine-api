package net.sf.marineapi.nmea.util;

import lombok.NonNull;

/**
 * • А – данные достоверны;
 * • В – есть решение, достоверность не подтверждена;
 * • V – решение не получено;
 * • K – идет процесс автоматической калибровки.
 */
public enum BinsCalibrationStatus {
    /**
     * A
     */
        RELIABLE('A'),
    /**
     * B
     */
        RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE('B'),
    /**
     * V
     */
        RESOLVE_NOT_CALCULATED('V'),

    /**
     * K
     */
    AUTOMATIC_CALIBRATION_IN_PROGRESS('K');

    private char ch;
    BinsCalibrationStatus(char ch) {
        this.ch=ch;
    }

    public static String toStringRAW(@NonNull BinsCalibrationStatus status) {

            String converted;
            if (status == BinsCalibrationStatus.RELIABLE) {
                converted = "A";
            } else if (status == RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE) {
                converted = "B";
            } else if (status == AUTOMATIC_CALIBRATION_IN_PROGRESS) {
                converted = "K";
            } else {
                converted = "V";
            }
            return converted;
        }

    /**
     * @param stringValue
     * • А – данные достоверны;
     * • В – есть решение, достоверность не подтверждена;
     * • V – решение не получено;
     * • K – идет процесс автоматической калибровки.
     * @return
     */
        public static BinsCalibrationStatus fromStringRAW(@NonNull String stringValue) {
            BinsCalibrationStatus converted;
            if (stringValue.equals("A")) {
                converted = RELIABLE;
            } else if (stringValue.equals("B")) {
                converted = RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE;
            } else if (stringValue.equals("K")) {
                converted = AUTOMATIC_CALIBRATION_IN_PROGRESS;
            } else {
                converted= BinsCalibrationStatus.RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE;
            }
            return converted;
        }

    public static boolean isValidRaw(String rawValue) {
        boolean valid = rawValue.length() == 1;

        if(! (rawValue.equals("A")
                || rawValue.equals("B")
                || rawValue.equals("K")
                || rawValue.equals("V"))){
            valid=false;
        }

        return valid;
    }

    public char toChar() {
        return ch;
    }

    /**
     * Get the enum corresponding to specified char.
     *
     * @param ch Char indicator for unit
     * @return Units enum
     */
    public static BinsCalibrationStatus valueOf(char ch) {
        for (BinsCalibrationStatus status : values()) {
            if (status.toChar() == ch) {
                return status;
            }
        }
        return valueOf(String.valueOf(ch));
    }
}