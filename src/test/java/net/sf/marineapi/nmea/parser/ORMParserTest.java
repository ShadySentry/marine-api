package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.CompassPoint;
import net.sf.marineapi.nmea.util.Position;
import net.sf.marineapi.nmea.util.Units;
import org.junit.jupiter.api.Test;

import static net.sf.marineapi.nmea.util.PositionConverter.GpsToDecimalDegrees;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class ORMParserTest {

//public static final String EXAMPLE = "$COORM,6011.552,N,02501.941,E,2048.0,M*34";
    public static final String EXAMPLE = "$COORM,4825.618128,N,03500.251609,E,2048.0,M";
    private ORMParser empty = new ORMParser(TalkerId.CO);
    private ORMParser orm=new ORMParser(EXAMPLE);
    private final double lat= GpsToDecimalDegrees("4825.618128","N");
    private final double lon=GpsToDecimalDegrees("03500.251609","E");
    private final double alt=2048.0;

    @Test
    void getAltitude() {
        assertEquals(alt,orm.getAltitude(),0.001);
    }

    @Test
    void getAltitudeUnits() {
        assertEquals(Units.METER,orm.getAltitudeUnits());
    }

    @Test
    void getPosition() {
        Position position = orm.getPosition();

        assertEquals(lat,position.getLatitude(),0.0000001);
        assertEquals(CompassPoint.NORTH,position.getLatitudeHemisphere());
        assertEquals(lon,position.getLongitude(),0.0000001);
        assertEquals(CompassPoint.EAST,position.getLongitudeHemisphere());
        assertEquals(alt,position.getAltitude(),0.01);
    }

    @Test
    void setAltitude() {
        double newAlt = 11.460;
        orm.setAltitude(newAlt);
        assertEquals(newAlt,orm.getPosition().getAltitude(),0.1 );
    }

    @Test
    void setAltitudeUnits() {
        empty.setAltitudeUnits(Units.METER);
        assertEquals(Units.METER,orm.getAltitudeUnits());
    }

    @Test
    void setAltitudeUnitsWrong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->
                        orm.setAltitudeUnits(Units.FEET));
    }

    @Test
    void setPosition() {
        final double lat = 61 + (1.111 / 60);
        final double lon = 27 + (7.777 / 60);
        final double alt = 11.1;
        Position p = new Position(lat, lon);
        p.setAltitude(alt);
        orm.setPosition(p);

        Position wp = orm.getPosition();
        assertNotNull(wp);
        assertEquals(lat, wp.getLatitude(), 0.0000001);
        assertEquals(lon, wp.getLongitude(), 0.0000001);
        assertEquals(CompassPoint.NORTH, wp.getLatitudeHemisphere());
        assertEquals(CompassPoint.EAST, wp.getLongitudeHemisphere());
        assertEquals(alt, wp.getAltitude(), 0.01);
    }

    @Test
    void isProprietary() {
        assertTrue(orm.isProprietary());
    }
}