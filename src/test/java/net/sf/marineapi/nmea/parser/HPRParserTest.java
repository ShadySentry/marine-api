package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.util.BinsCalibrationStatus;
import net.sf.marineapi.nmea.util.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HPRParserTest {

    public static final String EXAMPLE = "$POHPR,163828.715,10.05,179.17,-10.01,B*1E";

    private HPRParser pohpr;
    private HPRParser empty;


    @Before
    public void setUp() throws Exception {
        try {
            empty = new HPRParser();
            pohpr = new HPRParser(EXAMPLE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testConstructor() {
        assertEquals(5, empty.getFieldCount());
    }

    @Test
    public void testGetObservationTime() {
        Time t = pohpr.getObservationTime();
        assertNotNull(t);
        assertEquals(16, t.getHour());
        assertEquals(38, t.getMinutes());
        assertEquals(28.715, t.getSeconds(), 0.001);
    }

    @Test
    public void testGetHeadingAzimuth() {
        assertEquals(10.05, pohpr.getHeadingAzimuth(), 0.001);
    }

    @Test
    public void testGetTiltToStarboard() {
        assertEquals(179.17, pohpr.getTiltToStarboard(), 0.001);
    }

    @Test
    public void testGetTrimHeadIsBottom() {
        assertEquals(-10.01, pohpr.getTrimHeadIsBottom(), 0.001);
    }

    @Test
    public void testGetResolveStatusRaw() {
        assertEquals("B", pohpr.getResolveStatusRaw());
    }

    @Test
    public void testGetResolveStatus() {
        assertEquals(BinsCalibrationStatus.RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE,
                pohpr.getResolveStatus());
    }

    @Test
    public void testSetHeadingAzimuth() {
        double azimuth = 111.11;
        pohpr.setHeadingAzimuth(azimuth);
        assertEquals(azimuth, pohpr.getHeadingAzimuth(), 0.001);

    }

    @Test
    public void testSetTiltToStarboard() {
        double tilt = -180.00;
        pohpr.setTiltToStarboard(tilt);
        assertEquals(tilt, pohpr.getTiltToStarboard(), 0.001);
    }

    @Test
    public void testSetTiltToStarboardGreater() {
        double tilt = 180.01;
        pohpr.setTiltToStarboard(tilt);
        assertNotEquals(tilt, pohpr.getTiltToStarboard(), 0.001);
    }

    @Test
    public void testSetTiltToStarboardLess() {
        double tilt = -180.01;
        pohpr.setTiltToStarboard(tilt);
        assertNotEquals(tilt, pohpr.getTiltToStarboard(), 0.001);
    }

    @Test
    public void testSetTrimHeadIsBottom() {
        double trim = 90.00;
        pohpr.setTrimHeadIsBottom(trim);
        assertEquals(trim, pohpr.getTrimHeadIsBottom(), 0.001);

        trim = -90.00;
        pohpr.setTrimHeadIsBottom(trim);
        assertEquals(trim, pohpr.getTrimHeadIsBottom(), 0.001);
    }

    @Test
    public void testSetTrimHeadIsBottomGreater() {
        double trim = 90.01;
        pohpr.setTrimHeadIsBottom(trim);
        assertNotEquals(trim, pohpr.getTrimHeadIsBottom(), 0.001);
    }

    @Test
    public void testSetTrimHeadIsBottomLess() {
        double trim = -90.01;
        pohpr.setTiltToStarboard(trim);
        assertNotEquals(trim, pohpr.getTrimHeadIsBottom(), 0.001);
    }

    @Test
    public void testSetResolveStatusFromRaw() {
        BinsCalibrationStatus status = BinsCalibrationStatus.AUTOMATIC_CALIBRATION_IN_PROGRESS;
        String statusRaw = "K";
        pohpr.setResolveStatusFromRaw(statusRaw);
        assertEquals(statusRaw, pohpr.getResolveStatusRaw().toString());
    }

    @Test
    public void setResolveStatusFromRawWrongLength() {
        String statusRaw = BinsCalibrationStatus.RESOLVE_NOT_CALCULATED.toString();
        pohpr.setResolveStatusFromRaw(statusRaw);
        DataNotAvailableException exception = assertThrows(DataNotAvailableException.class, () -> {
                    pohpr.getResolveStatusRaw();
                }
        );
    }

    @Test
    public void testSetResolveStatus() {
        BinsCalibrationStatus status = BinsCalibrationStatus.AUTOMATIC_CALIBRATION_IN_PROGRESS;
        pohpr.setResolveStatus(status);
        assertEquals(status, pohpr.getResolveStatus());
    }

    @Test
    public void testSetObservationTime() {
        String azimuth = String.valueOf(pohpr.getHeadingAzimuth());
        Time t = new Time(1, 2, 3.456);
        pohpr.setObservationTime(t);
        assertTrue(pohpr.toString().contains("POHPR,010203.456,"+azimuth));
    }
}