package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.ESDSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.MSU.*;

/**
 * 2.1.3.	Информация об отказах устройства
 * $PMESD,a,b,c,d,e,f,g*hh
 * Полями данного предложения являются:
 * 	a - датчик температуры:
 * •	0 – норма
 * •	1 - отказ
 * 	b - измеритель скорости и направления ветра:
 * •	0 – норма
 * •	1 - отказ
 * 	c – электропривод:
 * •	0 – норма
 * •	1 - отказ
 * 	d – концевики:
 * •	0 – норма
 * •	1 - отказ
 * 	e – напряжение:
 * •	0 – норма
 * •	1 – повышенное
 * •	2 - пониженное
 * 	f – смена положения:
 * •	0 – норма
 * •	1 – ошибка перехода в рабочее положение
 * •	2 - ошибка перехода в транспортное положение
 * 	g - обмен
 * •	0 – норма
 * •	1 – ошибка приема
 * 	hh – байт контрольной суммы рассчитывается путем
 * поразрядного су-ммирования по модулю 2 (исполнение операции «Исключающее ИЛИ»)
 * всех байтов сообщения между символами «$» и «*».
 * &#064;example $PMESD,0,0,0,1,2,2,0*52
 */
public class ESDParser extends SentenceParser implements ESDSentence {

    private static final int TEMPERATURE = 0;
    private static final int WIND_SPEED = 1;
    private static final int ELECTRICAL_DRIVE = 2;
    private static final int END_SWITCHES = 3;
    private static final int VOLTAGE = 4;
    private static final int POSTURE_SWITCHING = 5;
    private static final int DATA_EXCHANGE = 6;


    public ESDParser(String nmea) {
        super(nmea, SentenceId.ESD);
    }

    public ESDParser(String nmea, String type) {
        super(nmea, type);
    }

    public ESDParser(TalkerId talker) {
        super(talker, SentenceId.ESD, 7);
    }

    public ESDParser() {
        super(TalkerId.PM, SentenceId.ESD, 7);
    }

    @Override
    public MsuTemperatureSensorMalfunction getTemperatureSensorMalfunction() {
        return MsuTemperatureSensorMalfunction.valueOf(getIntValue(TEMPERATURE));
    }

    @Override
    public void setTemperatureSensorMalfunction(MsuTemperatureSensorMalfunction value) {
        setIntValue(TEMPERATURE,value.toInt());
    }

    @Override
    public MsuWindSpeedSensorMalfunction getWindSpeedSensorMalfunction() {
        return MsuWindSpeedSensorMalfunction.valueOf(getIntValue(WIND_SPEED));
    }

    @Override
    public void setWindSpeedSensorMalfunction(MsuWindSpeedSensorMalfunction value) {
        setIntValue(WIND_SPEED,value.toInt() );
    }

    @Override
    public MsuElectricalDriveMalfunction getElectricalDriveMalfunction() {
        return MsuElectricalDriveMalfunction.valueOf(getIntValue(ELECTRICAL_DRIVE));
    }

    @Override
    public void setElectricalDriveMalfunction(MsuElectricalDriveMalfunction value) {
        setIntValue(ELECTRICAL_DRIVE,value.toInt());
    }

    @Override
    public MsuEndSwitchesMalfunction getEndSwitchesMalfunction() {
        return MsuEndSwitchesMalfunction.valueOf(getIntValue(END_SWITCHES));
    }

    @Override
    public void setEndSwitchesMalfunction(MsuEndSwitchesMalfunction value) {
        setIntValue(END_SWITCHES,value.toInt());
    }

    @Override
    public MsuVoltageMalfunction getVoltageMalfunction() {
        return MsuVoltageMalfunction.valueOf(getIntValue(VOLTAGE));
    }

    @Override
    public void setVoltageMalfunction(MsuVoltageMalfunction value) {
        setIntValue(VOLTAGE,value.toInt());
    }

    @Override
    public MsuPostureSwitchMalfunction getPostureSwitchMalfunction() {
        return MsuPostureSwitchMalfunction.valueOf(getIntValue(POSTURE_SWITCHING));
    }

    @Override
    public void setPostureSwitchMalfunction(MsuPostureSwitchMalfunction value) {
        setIntValue(POSTURE_SWITCHING,value.toInt());
    }

    @Override
    public MsuDataExchangeMalfunction getDataExchangeMalfunction() {
        return MsuDataExchangeMalfunction.valueOf(getIntValue(DATA_EXCHANGE));
    }

    @Override
    public void setDataExchangeMalfunction(MsuDataExchangeMalfunction value) {
        setIntValue(DATA_EXCHANGE,value.toInt());
    }
}
