package net.sf.marineapi.nmea.util;

import org.junit.jupiter.api.Test;

import static net.sf.marineapi.nmea.util.PositionConverter.GpsToDecimalDegrees;
import static org.junit.jupiter.api.Assertions.*;

class PositionConverterTest {

    private final double lat=48+(25.618128/60);
    private final double lon=35+(0.251609/60);
    @Test
    void convertNmeaLatitudeWithNorthWillReturnPositive() {
        assertEquals(lat, GpsToDecimalDegrees("4825.618128","N"),0.000001);
    }

    @Test
    void convertNmeaLatitudeWithSouthWillReturnNegative() {
        assertEquals(-lat, GpsToDecimalDegrees("4825.618128","S"),0.000001);
    }

    @Test
    void convertNameLongitudeWithEastWillReturnPositive() {
        assertEquals(lon, GpsToDecimalDegrees("03500.251609","E"),0.000001);
    }

    @Test
    void convertNameLongitudeWithWestWillReturnNegative() {
        assertEquals(-lon, GpsToDecimalDegrees("03500.251609","W"),0.000001);
    }


}