package net.sf.marineapi.nmea.parser.MSU;

import net.sf.marineapi.nmea.util.MSU.MsuFunctionSwitchCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SDSParserTest {
    private SDSParser empty;
    private SDSParser parser;
    private static final String EXAMPLE= "$PMSDS,1,0,1,0*59";

    @Before
    public void setUp() {
        empty = new SDSParser();
        parser = new SDSParser(EXAMPLE);
    }

    @Test
    public void fieldCountTest(){
        assertEquals(4,parser.getFieldCount());
    }

    // TODO: 04.02.2023 implement all
    @Test
    public void getOperatingPostureCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.REQUEST_IS_PRESENT;
        assertEquals(expected,parser.getOperatingPostureCommandState());
    }

    @Test
    public void testGetOperatingPostureCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.NO_REQUEST;
        parser.setOperatingPostureCommandState(expected);
        assertEquals(expected,parser.getOperatingPostureCommandState());
    }

    @Test
    public void getTransportingPostureCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.NO_REQUEST;
        assertEquals(expected,parser.getTransportingPostureCommandState());
    }

    @Test
    public void setTransportingPostureCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.REQUEST_IS_PRESENT;
        parser.setTransportingPostureCommandState(expected);
        assertEquals(expected,parser.getTransportingPostureCommandState());
    }

    @Test
    public void getHeatingOnCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.REQUEST_IS_PRESENT;
        assertEquals(expected,parser.getHeatingOnCommandState());
    }

    @Test
    public void setHeatingOnCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.NO_REQUEST;
        parser.setHeatingOnCommandState(expected);
        assertEquals(expected,parser.getHeatingOnCommandState());
    }

    @Test
    public void getHeatingOffCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.NO_REQUEST;
        assertEquals(expected,parser.getHeatingOffCommandState());
    }

    @Test
    public void setHeatingOffCommandState() {
        MsuFunctionSwitchCommand expected = MsuFunctionSwitchCommand.REQUEST_IS_PRESENT;
        parser.setHeatingOffCommandState(expected);
        assertEquals(expected,parser.getHeatingOffCommandState());
    }
}