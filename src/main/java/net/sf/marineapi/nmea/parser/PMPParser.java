package net.sf.marineapi.nmea.parser;

import lombok.extern.slf4j.Slf4j;
import net.sf.marineapi.nmea.sentence.PMPSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.BinsGpsStatus;
import net.sf.marineapi.nmea.util.BinsNavigationTaskStatus;

/**
 * BINS POPMP sentence parser
 */
@Slf4j
public class PMPParser extends SentenceParser implements PMPSentence {

    public static final int LATITUDE_PRECISION = 0;
    public static final int LONGITUDE_PRECISION = 1;
    public static final int ALTITUDE_PRECISION = 2;
    public static final int BINS_NAVIGATION_RESOLVE_STATUS = 3;
    public static final int BINS_GPS_STATUS = 4;

    public PMPParser(String nmea) {
        super(nmea,SentenceId.PMP);
    }

    public PMPParser(TalkerId talker) {
        super(talker, SentenceId.PMP, 5);
    }

    public PMPParser() {
        super(TalkerId.PO,SentenceId.PMP,5);
    }


    @Override
    public double getLatitudePrecision() {
        return getDoubleValue(LATITUDE_PRECISION);
    }

    @Override
    public double getLongitudePrecision() {
        return getDoubleValue(LONGITUDE_PRECISION);
    }

    @Override
    public double getAltitudePrecision() {
        return getDoubleValue(ALTITUDE_PRECISION);
    }

    @Override
    public BinsNavigationTaskStatus getNavigationTaskStatus() {
        String value = getStringValue(BINS_NAVIGATION_RESOLVE_STATUS);
        if (!BinsNavigationTaskStatus.isValidRaw(value)) {
            log.error("BinsNavigationTaskStatus format mismatch in POPMP sentence. value -\""
                    + value + "\" in class" + this.getClass().getName(),this);
            throw new DataNotAvailableException("BinsNavigationTaskStatus format mismatch in POPMP sentence. value -\""
                    + value + "\" in class" + this.getClass().getName());
        }
        return BinsNavigationTaskStatus.fromStringRaw(value);
    }

    @Override
    public BinsGpsStatus getBinsGPSStatus() {

        String value=getStringValue(BINS_GPS_STATUS);
        if (!BinsGpsStatus.isValidRaw(value)) {
            log.error("BinsGpsStatus format mismatch in POPMP sentence. value -\""
                    + value + "\" in class" + this.getClass().getName(), this);
            throw new DataNotAvailableException("BinsGpsStatus format mismatch in POPMP sentence. value -\""
                    + value + "\" in class" + this.getClass().getName());
        }
        return BinsGpsStatus.fromStringRaw(value);
    }

    @Override
    public void setLatitudePrecision(double latitudePrecision) {
        setDoubleValue(LATITUDE_PRECISION, latitudePrecision);
    }

    @Override
    public void setLongitudePrecision(double longitudePrecision) {
        setDoubleValue(LONGITUDE_PRECISION, longitudePrecision);
    }

    @Override
    public void setAltitudePrecision(double altitudePrecision) {
        setDoubleValue(ALTITUDE_PRECISION, altitudePrecision);
    }

    @Override
    public void setNavigationTaskStatus(BinsNavigationTaskStatus navigationTaskStatus) {
        String value = BinsNavigationTaskStatus.toStringRaw(navigationTaskStatus);
        setStringValue(BINS_NAVIGATION_RESOLVE_STATUS, value);
    }

    @Override
    public void setBinsGpsStatus(BinsGpsStatus binsGpsStatus) {
        String value = BinsGpsStatus.toStringRaw(binsGpsStatus);
        setStringValue(BINS_GPS_STATUS, value);
    }
}
