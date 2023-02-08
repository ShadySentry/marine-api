package net.sf.marineapi.nmea.parser.MSU;


import net.sf.marineapi.nmea.parser.ESDParser;
import net.sf.marineapi.nmea.util.MSU.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ESDParserTest {

    private static final String EXAMPLE = "$PMESD,0,0,0,1,2,2,0*52";
    private ESDParser empty;
    private ESDParser parser;

    @Before
    public void setUp() throws Exception {
        empty = new ESDParser();
        parser = new ESDParser(EXAMPLE);
    }

    @Test
    public void fieldCountTest() {
        assertEquals(7, empty.getFieldCount());
    }

    @Test
    public void getTemperatureSensorMalfunctionTest() {
        MsuTemperatureSensorMalfunction expectedValue = MsuTemperatureSensorMalfunction.NORMAL;
        assertEquals(expectedValue, parser.getTemperatureSensorMalfunction());

    }

    @Test
    public void setTemperatureSensorMalfunctionTest() {
        MsuTemperatureSensorMalfunction expectedValue = MsuTemperatureSensorMalfunction.MALFUNCTION;
        parser.setTemperatureSensorMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getTemperatureSensorMalfunction());
    }

    @Test
    public void getWindSpeedSensorMalfunctionTest() {
        MsuWindSpeedSensorMalfunction expectedValue = MsuWindSpeedSensorMalfunction.NORMAL;
        assertEquals(expectedValue, parser.getWindSpeedSensorMalfunction());
    }

    @Test
    public void setWindSpeedSensorMalfunctionTest() {
        MsuWindSpeedSensorMalfunction expectedValue = MsuWindSpeedSensorMalfunction.MALFUNCTION;
        parser.setWindSpeedSensorMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getWindSpeedSensorMalfunction());
    }

    @Test
    public void getElectricalDriveMalfunctionTest() {
        MsuElectricalDriveMalfunction expectedValue = MsuElectricalDriveMalfunction.NORMAL;
        assertEquals(expectedValue, parser.getElectricalDriveMalfunction());
    }

    @Test
    public void setElectricalDriveMalfunctionTest() {
        MsuElectricalDriveMalfunction expectedValue = MsuElectricalDriveMalfunction.MALFUNCTION;
        parser.setElectricalDriveMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getElectricalDriveMalfunction());
    }

    @Test
    public void getEndSwitchesMalfunctionTest() {
        MsuEndSwitchesMalfunction expectedValue = MsuEndSwitchesMalfunction.MALFUNCTION;
        assertEquals(expectedValue, parser.getEndSwitchesMalfunction());
    }

    @Test
    public void setEndSwitchesMalfunctionTest() {
        MsuEndSwitchesMalfunction expectedValue = MsuEndSwitchesMalfunction.NORMAL;
        parser.setEndSwitchesMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getEndSwitchesMalfunction());
    }

    @Test
    public void getVoltageMalfunctionTest() {
        MsuVoltageMalfunction expectedValue = MsuVoltageMalfunction.LOW;
        assertEquals(expectedValue, parser.getVoltageMalfunction());
    }

    @Test
    public void setVoltageMalfunctionTest() {
        MsuVoltageMalfunction expectedValue = MsuVoltageMalfunction.NORMAL;
        parser.setVoltageMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getVoltageMalfunction());
    }

    @Test
    public void getPostureSwitchMalfunctionTest() {
        MsuPostureSwitchMalfunction expectedValue = MsuPostureSwitchMalfunction.TRANSPORT_MODE_SWITCH_MALFUNCTION;
        assertEquals(expectedValue, parser.getPostureSwitchMalfunction());
    }

    @Test
    public void setPostureSwitchMalfunctionTest() {
        MsuPostureSwitchMalfunction expectedValue = MsuPostureSwitchMalfunction.OPERATING_MODE_SWITCH_MALFUNCTION;
        parser.setPostureSwitchMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getPostureSwitchMalfunction());
    }

    @Test
    public void getDataExchangeMalfunctionTest() {
        MsuDataExchangeMalfunction expectedValue = MsuDataExchangeMalfunction.NORMAL;
        assertEquals(expectedValue, parser.getDataExchangeMalfunction());
    }

    @Test
    public void setDataExchangeMalfunctionTest() {
        MsuDataExchangeMalfunction expectedValue = MsuDataExchangeMalfunction.MALFUNCTION;
        parser.setDataExchangeMalfunction(expectedValue);
        assertEquals(expectedValue, parser.getDataExchangeMalfunction());
    }
}