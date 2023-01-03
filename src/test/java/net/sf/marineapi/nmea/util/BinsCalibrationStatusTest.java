package net.sf.marineapi.nmea.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinsCalibrationStatusTest {
    BinsCalibrationStatus status;

    @BeforeEach
    void setUp() {
        status= BinsCalibrationStatus.RELIABLE;
    }

    @Test
    void fromStringRAW() {
        status= BinsCalibrationStatus.fromStringRAW("B");
        assertEquals("RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE",status.toString());
    }

    @Test
    void testToStringRAW() {
        assertEquals("A", BinsCalibrationStatus.toStringRAW(status));

    }

    @Test
    void values() {
        assertEquals(4, BinsCalibrationStatus.values().length);
    }

    @Test
    void valueOf() {
        assertEquals("RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE", BinsCalibrationStatus.RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE.toString());
    }
}