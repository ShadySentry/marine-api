package net.sf.marineapi.nmea.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class RunParserTest {

    public static final String EXAMPLE = "$PORUN*56";

    private RUNParser porun;
    private RUNParser empty;

    @BeforeEach
    void setUp() {
        try {
            empty = new RUNParser();
            porun = new RUNParser(EXAMPLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConstructor() {
        assertEquals(0, empty.getFieldCount());
    }

    @Test
    public void isValid(){

        assertTrue(porun.isValid());
    }

}