package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.ORMSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.Position;
import net.sf.marineapi.nmea.util.Units;

public class ORMParser extends PositionParser implements ORMSentence {
    private static final int LATITUDE = 0;
    public static final int LAT_HEMISPHERE = 1;
    private static final int LONGITUDE = 2;
    public static final int LON_HEMISPHERE = 3;
    private static final int ALTITUDE = 4;
    private static final int ALTITUDE_UNITS = 5;


    public ORMParser() {
        super(TalkerId.CO, SentenceId.ORM, 6);
    }

    public ORMParser(String nmea) {
        super(nmea, SentenceId.ORM);
    }

    public ORMParser(TalkerId talker) {
        super(talker, SentenceId.ORM, 6);
    }

    @Override
    public double getAltitude() {
        return getDoubleValue(ALTITUDE);
    }

    public Units getAltitudeUnits() {
        char ch = getCharValue(ALTITUDE_UNITS);
        if (ch != ALT_UNIT_METERS) {
            String msg = "Invalid altitude unit indicator: %s";
            throw new ParseException(String.format(msg, ch));
        }
        return Units.valueOf(ch);
    }

    @Override
    public Position getPosition() {
        Position pos = parsePosition(
                LATITUDE, LAT_HEMISPHERE, LONGITUDE, LON_HEMISPHERE);

        if (hasValue(ALTITUDE) && hasValue(ALTITUDE_UNITS)) {
            double alt = getAltitude();
            if (getAltitudeUnits().equals(Units.FEET)) {
                alt = (alt / 0.3048);
            }
            pos.setAltitude(alt);
        }

        return pos;
    }

    @Override
    public void setAltitude(double alt) {
        setDoubleValue(ALTITUDE, alt, 1, 1);
    }

    public void setAltitudeUnits(Units unit) {
        if (unit != Units.METER) {
            throw new IllegalArgumentException(String.format("Only {%s} are allowed", Units.METER));
        }
        setCharValue(ALTITUDE_UNITS, unit.toChar());
    }

    @Override
    public void setPosition(Position pos) {
        setPositionValues(
                pos, LATITUDE, LAT_HEMISPHERE, LONGITUDE, LON_HEMISPHERE);

        setAltitude(pos.getAltitude());
        setAltitudeUnits(Units.METER);
    }

    @Override
    public boolean isProprietary() {
        return true;
    }
}
