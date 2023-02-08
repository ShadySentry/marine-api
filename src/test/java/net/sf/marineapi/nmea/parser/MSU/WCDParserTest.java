package net.sf.marineapi.nmea.parser.MSU;

import net.sf.marineapi.nmea.parser.WCDParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WCDParserTest {
    public static final String EXAMPLE = "$PMWCD,013.5,05.4,-10.3*66";

    private WCDParser empty;
    private WCDParser parser;

    @Before
    public void setUp() {
        empty = new WCDParser();
        parser  =new WCDParser(EXAMPLE);
    }

    @Test
    public void getWindDirection() {
        assertEquals(13.5, parser.getWindDirection(),0.001);
    }

    @Test
    public void setWindDirection() {
        double direction=356.9;
        parser.setWindDirection(direction);
        assertEquals(direction,parser.getWindDirection(),0.001);
    }

    @Test
    public void getWindSpeed() {
        assertEquals(5.4, parser.getWindSpeed(),0.001);
    }

    @Test
    public  void setWindSpeed() {double direction=356.9;
        double windSpeed=17.5;
        assertEquals(windSpeed,parser.getWindSpeed(),0.001);
    }

    @Test
    public void getAirTemperature() {
        assertEquals(-10.3,parser.getAirTemperature(),0.001);
    }

    @Test
    public void setAirTemperature() {
        double airTemperature=-36.6;
        parser.setAirTemperature(airTemperature);
        assertEquals(airTemperature,parser.getAirTemperature(),0.001);
    }
}