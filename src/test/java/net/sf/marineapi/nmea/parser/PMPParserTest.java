package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.util.BinsGpsStatus;
import net.sf.marineapi.nmea.util.BinsNavigationTaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PMPParserTest {

    public static final String EXAMPLE = "$POPMP,1.1,2.2,3.3,2,0*52";

    private PMPParser popmp;
    private PMPParser empty;

    @BeforeEach
    void setUp() {
        try {
            empty = new PMPParser();
            popmp = new PMPParser(EXAMPLE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testConstructor() {
        assertEquals(5, empty.getFieldCount());
    }

    @Test
    void getLatitudePrecision() {
        assertEquals(1.1,popmp.getLatitudePrecision(),0.001);
    }

    @Test
    void getLongitudePrecision() {
        assertEquals(2.2,popmp.getLongitudePrecision(),0.001);
    }

    @Test
    void getAltitudePrecision() {
        assertEquals(3.3,popmp.getAltitudePrecision(),0.001);
    }

    @Test
    void getNavigationTaskStatus() {
        assertEquals(BinsNavigationTaskStatus.RESOLVING_IN_PROGRESS,popmp.getNavigationTaskStatus());
    }

    @Test
    void getNavigationTaskStatusEmpty() {
        DataNotAvailableException exception = assertThrows(DataNotAvailableException.class, ()->{
            empty.getNavigationTaskStatus();
        });
    }

    @Test
    void getBinsGPSStatus() {
        assertEquals(BinsGpsStatus.NON_RELIABLE,popmp.getBinsGPSStatus());
    }
    @Test
    void getBinsGpsStatusEmpty() {
        DataNotAvailableException exception = assertThrows(DataNotAvailableException.class, ()->{
            empty.getBinsGPSStatus();
        });
    }


    @Test
    void setLatitudePrecision() {
        double newValue = 10.10;
        popmp.setLatitudePrecision(newValue);
        assertEquals(newValue,popmp.getLatitudePrecision(),0.001);
    }

    @Test
    void setLongitudePrecision() {
        double newValue = 20.22;
        popmp.setLongitudePrecision(newValue);
        assertEquals(newValue,popmp.getLongitudePrecision(),0.001);
    }

    @Test
    void setAltitudePrecision() {
        double newValue = -30.30;
        popmp.setAltitudePrecision(newValue);
        assertEquals(newValue,popmp.getAltitudePrecision(),0.001);
    }

    @Test
    void setNavigationTaskStatus() {
        BinsNavigationTaskStatus status = BinsNavigationTaskStatus.RESOLVED;
        popmp.setNavigationTaskStatus(status);
        assertEquals(status,popmp.getNavigationTaskStatus());
    }

    @Test
    void setBinsGpsStatus() {
        BinsGpsStatus status = BinsGpsStatus.RELIABLE;
        popmp.setBinsGpsStatus(status);
        assertEquals(status,popmp.getBinsGPSStatus());
    }
}