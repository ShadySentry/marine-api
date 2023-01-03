package net.sf.marineapi.nmea.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinsNavigationTaskStatusTest {

    BinsNavigationTaskStatus status;

    @BeforeEach
    void setUp() {
        status = BinsNavigationTaskStatus.RESOLVED;
    }

    @Test
    void toStringRaw() {
        assertEquals("RESOLVED",status.toString());

    }

    @Test
    void fromStringRaw() {
        status = BinsNavigationTaskStatus.fromStringRaw("0");
        assertEquals(BinsNavigationTaskStatus.NOT_RESOLVED, status);
    }

    @Test
    void isValidRaw() {
        assertTrue(BinsNavigationTaskStatus.isValidRaw("0"));
        assertTrue(BinsNavigationTaskStatus.isValidRaw("1"));
        assertTrue(BinsNavigationTaskStatus.isValidRaw("2"));
        assertTrue(BinsNavigationTaskStatus.isValidRaw("3"));
    }

    @Test
    void isNotValidRaw() {
        assertFalse(BinsNavigationTaskStatus.isValidRaw("K"));
        assertFalse(BinsNavigationTaskStatus.isValidRaw(""));
        assertFalse(BinsNavigationTaskStatus.isValidRaw("33"));
    }

    @Test
    void values() {
        assertEquals(4, BinsNavigationTaskStatus.values().length);
    }

    @Test
    void valueOf() {
        assertEquals("RESOLVED", BinsNavigationTaskStatus.valueOf(status.toString()).toString());
    }
}