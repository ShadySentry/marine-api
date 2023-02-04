package net.sf.marineapi.nmea.parser.MSU;

import net.sf.marineapi.nmea.sentence.MSU.FSDSentence;
import net.sf.marineapi.nmea.util.MSU.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FSDParserTest {

    private FSDParser empty;
    private FSDSentence parser;
    private static final String EXAMPLE= "$PMFSD,12.5,-03.6,1,1,0,0,0*7E";

    @Before
    public void setUp() {
        empty = new FSDParser();
        parser = new FSDParser(EXAMPLE);
    }

    @Test
    public void fieldCountTest(){
        assertEquals(7,parser.getFieldCount());
    }

    @Test
    public void getVoltage() {
        double expectedValue = 12.5;
        assertEquals(expectedValue,parser.getVoltage());
    }

    @Test
    public void setVoltage() {
        double expectedValue = 10.5;
        parser.setVoltage(expectedValue);
        assertEquals(expectedValue,parser.getVoltage());
    }

    @Test
    public void getTemperature() {
        double expectedValue = -3.6;
        assertEquals(expectedValue,parser.getTemperature());
    }

    @Test
    public void setTemperature() {
        double expectedValue = 55.0;
        parser.setTemperature(expectedValue);
        assertEquals(expectedValue,parser.getTemperature());
    }

    @Test
    public void getPosture() {
        MsuPosture expectedValue = MsuPosture.OPERATING;
        assertEquals(expectedValue,parser.getPosture());
    }

    @Test
    public void setPosture() {
        MsuPosture expectedValue = MsuPosture.ANTENNA_ROD_PULLING_OUT;
        parser.setPosture(expectedValue);
        assertEquals(expectedValue,parser.getPosture());
    }

    @Test
    public void getOperatingMode() {
        MsuOperatingMode expectedValue = MsuOperatingMode.READY_FOR_OPERATION;
        assertEquals(expectedValue,parser.getOperatingMode());
    }

    @Test
    public void setOperatingMode() {
        MsuOperatingMode expectedValue = MsuOperatingMode.PENDING;
        parser.setOperatingMode(expectedValue);
        assertEquals(expectedValue,parser.getOperatingMode());
    }

    @Test
    public void getHeatingMode() {
        MsuHeatingMode expectedValue = MsuHeatingMode.OFF;
        assertEquals(expectedValue,parser.getHeatingMode());
    }

    @Test
    public void setHeatingMode() {
        MsuHeatingMode expectedValue = MsuHeatingMode.ON;
        parser.setHeatingMode(expectedValue);
        assertEquals(expectedValue,parser.getHeatingMode());

    }

    @Test
    public void getHeatingModePermission() {
        MsuHeatingModePermission expectedValue = MsuHeatingModePermission.DISABLED;
        assertEquals(expectedValue,parser.getHeatingModePermission());

    }

    @Test
    public void setHeatingModePermission() {
        MsuHeatingModePermission expectedValue = MsuHeatingModePermission.ENABLED;
        parser.setHeatingModePermission(expectedValue);
        assertEquals(expectedValue,parser.getHeatingModePermission());
    }

    @Test
    public void getTemperatureSensorBlowing() {
        MsuTemperatureSensorBlowing expectedValue = MsuTemperatureSensorBlowing.OFF;
        assertEquals(expectedValue,parser.getTemperatureSensorBlowing());
    }

    @Test
    public void setTemperatureSensorBlowing() {
        MsuTemperatureSensorBlowing expectedValue = MsuTemperatureSensorBlowing.ON;
        parser.setTemperatureSensorBlowing(expectedValue);
        assertEquals(expectedValue,parser.getTemperatureSensorBlowing());
    }
}