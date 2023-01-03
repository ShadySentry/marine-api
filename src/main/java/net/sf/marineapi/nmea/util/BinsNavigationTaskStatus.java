package net.sf.marineapi.nmea.util;

import lombok.NonNull;
import net.sf.marineapi.nmea.sentence.PMPSentence;

/**
 * Bins navigation resolving status
 * user in POPMP
 * @see  PMPSentence
 *      • 0 – навигационная задача не решена;
 *      • 1 – навигационная задача решена;
 *      • 2 – идет решение навигационной задачи;
 *      • 3 – выполнение калибровки;
 */
public enum BinsNavigationTaskStatus {
    /**
     * 0 – навигационная задача не решена
     */
    NOT_RESOLVED,
    /**
     * 1 – навигационная задача решена
     */
    RESOLVED,
    /**
     * 2 – идет решение навигационной задачи
     */
    RESOLVING_IN_PROGRESS,
    /**
     * 3 – выполнение калибровки
     */
    AUTOMATIC_CALIBRATION_IN_PROGRESS;

    public static String toStringRaw(@NonNull BinsNavigationTaskStatus status){
        int converted;
        if(status==NOT_RESOLVED){
            converted=0;
        } else if (status==RESOLVED) {
            converted=1;
        }else if(status==RESOLVING_IN_PROGRESS){
            converted=2;
        }else {
            converted=3;
        }

        return String.valueOf(converted);
    }

    public static BinsNavigationTaskStatus fromStringRaw(String stringRawValue){
        BinsNavigationTaskStatus converted;

        if (stringRawValue.equals("0")){
            converted=NOT_RESOLVED;
        }else if(stringRawValue.equals("1")){
            converted=RESOLVED;
        } else if (stringRawValue.equals("2")) {
            converted=RESOLVING_IN_PROGRESS;
        } else {
            converted=AUTOMATIC_CALIBRATION_IN_PROGRESS;
        }

        return converted;
    }

    public static boolean isValidRaw(String rawValue){

        boolean valid = true;
        if(rawValue==null &&  rawValue.length() != 1){
            valid=false;
        };

        if(! (rawValue.equals("0")
                || rawValue.equals("1")
                || rawValue.equals("2")
                || rawValue.equals("3"))){
            valid=false;
        }

        return valid;
    }


}
