package net.sf.marineapi.nmea.util;


/**
 * longitude and  latitude converters
 * user in
 * @see net.sf.marineapi.nmea.parser.ORMParser
 */
public class PositionConverter {
    public static final char DELIMITER='.';

    /**
     * Convert NMEA absolute position to decimal degrees
     * "ddmm.mmmm" or "dddmm.mmmm" really is (d)dd+mm.mmmm/60,
     * then negated if quadrant is 'W' or 'S'
     */
    public static double GpsToDecimalDegrees(String nmeaLatitude, String hemisphere){
//        https://stackoverflow.com/questions/36254363/how-to-convert-latitude-and-longitude-of-nmea-format-data-to-decimal
        if(nmeaLatitude==null || nmeaLatitude.isEmpty()){
            throw new IllegalArgumentException("argument is too short. Acceptable only nmea string {ddmm.mmmm}");
        }

        int delimiterIndex = nmeaLatitude.indexOf(DELIMITER);
        if(delimiterIndex==-1 || delimiterIndex ==0 || delimiterIndex==nmeaLatitude.length()){
            throw new IllegalArgumentException("wrong format for latitude Acceptable only nmea %s {ddmm.mmmm}");
        }


        double degrees = Double.parseDouble(nmeaLatitude.substring(0,delimiterIndex-2));
        double minutes = Double.parseDouble(nmeaLatitude.substring(delimiterIndex-2,nmeaLatitude.length()));

        double result = degrees+minutes/60;

        if(hemisphere.equals("W") || hemisphere.equals("S")){
            result=-result;
        }

        return result;
    }
}
