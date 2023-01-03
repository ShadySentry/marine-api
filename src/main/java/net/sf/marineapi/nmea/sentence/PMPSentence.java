package net.sf.marineapi.nmea.sentence;

import net.sf.marineapi.nmea.util.BinsGpsStatus;
import net.sf.marineapi.nmea.util.BinsNavigationTaskStatus;

/**
 * $POPMP,x.x,x.x,x.x,a,b*hh,
 * Полями данного предложения являются:
 *
 * – x.x – точность определения позиции по широте;
 * – x.x – точность определения позиции по долготе;
 * – x.x – точность определения позиции по высотке;
 * – a – статус:
 *      • 0 – навигационная задача не решена;
 *      • 1 – навигационная задача решена;
 *      • 2 – идет решение навигационной задачи;
 *      • 3 – выполнение калибровки;
 * – b — статус GPS:
 *      • 0 –данные GPS недостоверны;
 *      • 1 –данные GPS достоверны;
 *      • 2 – данные получены в ручном режиме (без использования GPS);
 * – hh – байт контрольной суммы рассчитывается путем поразрядного суммирования по модулю 2
 *        (исполнение операции «Исключающее ИЛИ») всех байтов сообщения между символами «$» и «*».
 */
public interface PMPSentence extends Sentence{
    double getLatitudePrecision();
    double getLongitudePrecision();
    double getAltitudePrecision();
    BinsNavigationTaskStatus getNavigationTaskStatus();
    BinsGpsStatus getBinsGPSStatus();


    void setLatitudePrecision(double latitudePrecision);
    void setLongitudePrecision(double longitudePrecision);
    void setAltitudePrecision(double altitudePrecision);
    void setNavigationTaskStatus(BinsNavigationTaskStatus navigationTaskStatus);
    void setBinsGpsStatus(BinsGpsStatus binsGpsStatus);
}
