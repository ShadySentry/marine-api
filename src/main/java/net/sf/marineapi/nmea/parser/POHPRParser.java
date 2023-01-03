/*
 * BODParser.java
 * Copyright (C) 2010 Kimmo Tuukkanen
 *
 * This file is part of Java Marine API.
 * <http://ktuukkan.github.io/marine-api/>
 *
 * Java Marine API is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Java Marine API is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java Marine API. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.marineapi.nmea.parser;

import lombok.extern.slf4j.Slf4j;
import net.sf.marineapi.nmea.sentence.POHPRSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.BINSCalibrationStatus;
import net.sf.marineapi.nmea.util.Time;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * HPR sentence parser.
 *
 * @author ShadySentry
 * @see POHPRSentence
 */
@Slf4j
class POHPRParser extends SentenceParser implements POHPRSentence {
    //    private static double HEADING_AZIMUTH;
//    private static double TILT_TO_STARBOARD;
//    private static double TRIM_HEAD_IS_BOTTOM;
//    private static double RESOLVE_STATUS;
    private static final int OBSERVATION_TIME_UTC = 0;
    private static final int HEADING_AZIMUTH = 1;
    private static final int TILT_TO_STARBOARD = 2;
    private static final int TRIM_HEAD_IS_BOTTOM = 3;
    private static final int RESOLVE_STATUS = 4;
//"$POHPR,163828.715,10.05,179.17,-10.01,B*1E"

    /**
     * Creates a new instance of BOD parser.
     *
     * @param nmea POHPR sentence String
     * @throws IllegalArgumentException If specified String is invalid or does
     *                                  not contain a POHPR sentence.
     */
    public POHPRParser(String nmea) {
        super(nmea, SentenceId.HPR);
    }

    /**
     * Creates POHPR parser with empty sentence.
     *
     * @param talker TalkerId to set (PO)
     */
    public POHPRParser(TalkerId talker) {
        super(talker, SentenceId.HPR, 5);
    }

    /**
     * Creates POHPR parser with empty sentence
     */
    public POHPRParser() {
        super(TalkerId.PO, SentenceId.HPR, 5);
    }


    @Override
    public Time getObservationTime() {
        String str = getStringValue(OBSERVATION_TIME_UTC);
        return new Time(str);
    }

    @Override
    public double getHeadingAzimuth() {
        return getDoubleValue(HEADING_AZIMUTH);
    }

    @Override
    public double getTiltToStarboard() {
        return getDoubleValue(TILT_TO_STARBOARD);
    }

    @Override
    public double getTrimHeadIsBottom() {
        return getDoubleValue(TRIM_HEAD_IS_BOTTOM);
    }

    @Override
    public String getResolveStatusRaw() {
        return getStringValue(RESOLVE_STATUS);
    }

    @Override
    public BINSCalibrationStatus getResolveStatus() {
        return BINSCalibrationStatus.fromStringRAW(getStringValue(RESOLVE_STATUS));
    }

    @Override
    public void setHeadingAzimuth(double headingAzimuth) {
        setDoubleValue(HEADING_AZIMUTH, headingAzimuth);
    }

    @Override
    public void setTiltToStarboard(double tiltToStarboard) {
        if (tiltToStarboard >= -180.00 && tiltToStarboard <= 180.00) {
            setDoubleValue(TILT_TO_STARBOARD, tiltToStarboard);
        }
    }

    @Override
    public void setTrimHeadIsBottom(double trimHeadIsBottom) {
        if (trimHeadIsBottom >= -90.00 && trimHeadIsBottom <= 90.00) {
            setDoubleValue(TRIM_HEAD_IS_BOTTOM, trimHeadIsBottom);
        }
    }

    @Override
    public void setResolveStatusFromRaw(String resolveStatus) {
        if (resolveStatus.length() > 1) {
            log.error("ResolveStatus was - " + resolveStatus + ". Allowed max length is 1 and values [A,B,V,K]");
            setStringValue(RESOLVE_STATUS, "");
        }else{
        setStringValue(RESOLVE_STATUS, resolveStatus);}
    }

    @Override
    public void setResolveStatus(BINSCalibrationStatus resolveStatus) {
        setStringValue(RESOLVE_STATUS, BINSCalibrationStatus.toStringRAW(resolveStatus));
    }

    @Override
    public void setObservationTime(Time t) {
        setStringValue(OBSERVATION_TIME_UTC, t.toString());
    }

//    public enum BINSCalibrationStatus {
//        RELIABLE,
//        RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE,
//        RESOLVE_NOT_CALCULATED,
//        AUTOMATIC_CALIBRATION_IN_PROGRESS;
//
//        public String toString(@NonNull BINSCalibrationStatus status) {
//
//            String converted;
//            if (status == BINSCalibrationStatus.RELIABLE) {
//                converted = "A";
//            } else if (status == RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE) {
//                converted = "B";
//            } else if (status == AUTOMATIC_CALIBRATION_IN_PROGRESS) {
//                converted = "K";
//            } else {
//                converted = "V";
//            }
//            return converted;
//        }
//        public BINSCalibrationStatus fromString(@NonNull String stringValue) {
//            BINSCalibrationStatus converted;
//            if (stringValue.equals("A")) {
//                converted = RELIABLE;
//            } else if (stringValue.equals("B")) {
//                converted = RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE;
//            } else if (stringValue.equals("K")) {
//                converted = AUTOMATIC_CALIBRATION_IN_PROGRESS;
//            } else {
//                converted=BINSCalibrationStatus.RESOLVE_IS_CALCULATED_WITHOUT_PROOF_OF_RELIABLE;
//            }
//            return converted;
//        }
//
//    }

}
