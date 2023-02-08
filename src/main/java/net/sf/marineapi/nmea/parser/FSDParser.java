package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.FSDSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.MSU.*;

public class FSDParser extends SentenceParser implements FSDSentence {

    private static final int VOLTAGE = 0;
    private static final int TEMPERATURE = 1;
    private static final int POSTURE = 2;
    private static final int OPERATING_MODE = 3;
    private static final int HEATING_MODE = 4;
    private static final int HEATING_MODE_PERMISSION = 5;
    private static final int TEMPERATURE_SENSOR_BLOWING = 6;


    public FSDParser(String nmea) {
        super(nmea, SentenceId.FSD);
    }

    public FSDParser(String nmea, String type) {
        super(nmea, type);
    }

    public FSDParser(TalkerId talker) {
        super(talker, SentenceId.FSD, 7);
    }

    public FSDParser() {
        super(TalkerId.PM, SentenceId.FSD, 7);
    }


    @Override
    public double getVoltage() {
        return getDoubleValue(VOLTAGE);
    }

    @Override
    public void setVoltage(double value) {
        setDoubleValue(VOLTAGE, value);
    }

    @Override
    public double getTemperature() {
        return getDoubleValue(TEMPERATURE);
    }

    @Override
    public void setTemperature(double value) {
        setDoubleValue(TEMPERATURE, value);
    }

    @Override
    public MsuPosture getPosture() {
        return MsuPosture.valueOf(getIntValue(POSTURE));
    }

    @Override
    public void setPosture(MsuPosture value) {
        setIntValue(POSTURE, value.toInt());
    }

    @Override
    public MsuOperatingMode getOperatingMode() {
        return MsuOperatingMode.valueOf(getIntValue(OPERATING_MODE));
    }

    @Override
    public void setOperatingMode(MsuOperatingMode value) {
        setIntValue(OPERATING_MODE, value.toInt());
    }

    @Override
    public MsuHeatingMode getHeatingMode() {
        return MsuHeatingMode.valueOf(getIntValue(HEATING_MODE));
    }

    @Override
    public void setHeatingMode(MsuHeatingMode value) {
        setIntValue(HEATING_MODE, value.toInt());
    }

    @Override
    public MsuHeatingModePermission getHeatingModePermission() {
        return MsuHeatingModePermission.valueOf(getIntValue(HEATING_MODE_PERMISSION));
    }

    @Override
    public void setHeatingModePermission(MsuHeatingModePermission value) {
        setIntValue(HEATING_MODE_PERMISSION, value.toInt());
    }

    @Override
    public MsuTemperatureSensorBlowing getTemperatureSensorBlowing() {
        return MsuTemperatureSensorBlowing.valueOf(getIntValue(TEMPERATURE_SENSOR_BLOWING));
    }

    @Override
    public void setTemperatureSensorBlowing(MsuTemperatureSensorBlowing value) {
        setIntValue(TEMPERATURE_SENSOR_BLOWING, value.toInt());
    }
}
