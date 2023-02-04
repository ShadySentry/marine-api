package net.sf.marineapi.nmea.parser.MSU;

import net.sf.marineapi.nmea.parser.SentenceParser;
import net.sf.marineapi.nmea.sentence.MSU.WCDSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

public class WCDParser extends SentenceParser implements WCDSentence {
    private static final int WIND_DIRECTION = 0;
    private static final int WIND_SPEED = 1;
    private static final int AIR_TEMPERATURE = 2;

    public WCDParser(String nmea) {
        super(nmea, SentenceId.WCD.toString());
    }

    /**
     * Creates WCD parser with empty sentence.
     *
     * @param talker TalkerId to set (PM)
     */
    public WCDParser(TalkerId talker) {
        super(talker, SentenceId.WCD.toString(), 3);
    }

    /**
     * Creates PMWCD parser with empty sentence
     */
    public WCDParser() {
        super(TalkerId.PM, SentenceId.WCD.toString(), 3);
    }

    @Override
    public double getWindDirection() {
        return getDoubleValue(WIND_DIRECTION);
    }

    @Override
    public void setWindDirection(double windDirection) {
        if (windDirection >= 0.0 && windDirection <= 360.0) {
            setDoubleValue(WIND_DIRECTION, windDirection);
        }
    }

    @Override
    public double getWindSpeed() {
        return getDoubleValue(WIND_SPEED);
    }

    @Override
    public void setWindSpeed(double windSpeed) {
        if (windSpeed >= 0) {
            setDoubleValue(WIND_SPEED, windSpeed);
        }

    }

    @Override
    public double getAirTemperature() {
        return getDoubleValue(AIR_TEMPERATURE);
    }

    @Override
    public void setAirTemperature(double airTemperature) {
        if (airTemperature >= -40.0 && airTemperature <= 55.0) {
            setDoubleValue(AIR_TEMPERATURE, airTemperature);
        }
    }
}
