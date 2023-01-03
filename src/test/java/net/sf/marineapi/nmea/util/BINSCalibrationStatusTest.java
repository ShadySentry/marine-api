package net.sf.marineapi.nmea.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BINSCalibrationStatusTest {
    BINSCalibrationStatus status;

    @BeforeEach
    void setUp() {
        status= BINSCalibrationStatus.RELIABLE;
    }

    @Test
    void fromStringRAW() {
        status=BINSCalibrationStatus.fromStringRAW("B");
        assertEquals("RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE",status.toString());
    }

    @Test
    void testToStringRAW() {
        assertEquals("A", BINSCalibrationStatus.toStringRAW(status));

    }

    @Test
    void values() {
        assertEquals(4,BINSCalibrationStatus.values().length);
    }

    @Test
    void valueOf() {
        assertEquals("RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE", BINSCalibrationStatus.RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE.toString());
    }
}