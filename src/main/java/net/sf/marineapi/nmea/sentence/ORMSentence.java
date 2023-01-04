package net.sf.marineapi.nmea.sentence;

import net.sf.marineapi.nmea.util.Units;

/**
 * $СOORM,llll.ll,a,yyyyy.yy,a,x.x,M,*hh
 * Полями данного предложения являются:
 * – llll.ll,a – широта, N/S;
 *  – yyyyy.yy,a – долгота, E/W;
 *  – x.x – высота (WGS-84);
 *  – M – единицы измерения высоты, имеют значение"M" – метры;
 *  – hh – байт контрольной суммы рассчитывается путем поразрядного суммирования по модулю 2
 *        (исполнение операции «Исключающее ИЛИ») всех байтов сообщения между символами «$» и «*».
 */
public interface ORMSentence extends PositionSentence, BinsServiceSentence{
    /**
     * Altitude presented in meters.
     */
    char ALT_UNIT_METERS = 'M';

    /**
     * Altitude presented in feet.
     */
    char ALT_UNIT_FEET = 'f';

    /**
     * Get antenna altitude above mean sea level.
     *
     * @return Altitude value
     * @throws net.sf.marineapi.nmea.parser.DataNotAvailableException If the data is
     *             not available.
     * @throws net.sf.marineapi.nmea.parser.ParseException If the field contains
     *             unexpected or illegal value.
     */
    double getAltitude();

    /**
     * Gets the altitude units, meters or feet.
     *
     * @return Units enum
     * @throws net.sf.marineapi.nmea.parser.DataNotAvailableException If the data is
     *             not available.
     * @throws net.sf.marineapi.nmea.parser.ParseException If the field contains
     *             unexpected or illegal value.
     */
    Units getAltitudeUnits();

    /**
     * Set the antenna altitude.
     *
     * @param alt Altitude to set
     */
    void setAltitude(double alt);

    /**
     * Sets the unit of altitude.
     *
     * @param unit Units to set
     */
    void setAltitudeUnits(Units unit);




}
