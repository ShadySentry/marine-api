package net.sf.marineapi.nmea.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinsGpsStatusTest {

    BinsGpsStatus status;

    @BeforeEach
    void setUp() {
        status=BinsGpsStatus.NON_RELIABLE;
    }

    @Test
    void toStringRaw() {
        assertEquals("0",BinsGpsStatus.toStringRaw(status).toString());
    }

    @Test
    void fromStringRaw() {
        status=BinsGpsStatus.fromStringRaw("2");
        assertEquals(BinsGpsStatus.PROVIDED_MANUALLY,status);

    }

    @Test
    void isValidRaw() {
        assertTrue(BinsGpsStatus.isValidRaw("0"));
        assertTrue(BinsGpsStatus.isValidRaw("1"));
        assertTrue(BinsGpsStatus.isValidRaw("2"));
    }

    @Test
    void isNotValidRaw() {
        assertFalse(BinsGpsStatus.isValidRaw(""));
        assertFalse(BinsGpsStatus.isValidRaw("11"));
        assertFalse(BinsGpsStatus.isValidRaw("4"));
        assertFalse(BinsGpsStatus.isValidRaw("-1"));
        assertFalse(BinsGpsStatus.isValidRaw("k"));
    }

    @Test
    void values() {
        assertEquals(3,BinsGpsStatus.values().length);
    }

    @Test
    void valueOf() {
        assertEquals(BinsGpsStatus.RELIABLE,BinsGpsStatus.valueOf("RELIABLE"));
    }
}