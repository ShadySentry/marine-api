package net.sf.marineapi.nmea.parser.MSU;

import net.sf.marineapi.nmea.parser.SentenceParser;
import net.sf.marineapi.nmea.sentence.MSU.ESDSentence;
import net.sf.marineapi.nmea.sentence.MSU.SDSSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.MSU.*;

/**
 * $PMSDS,a,b,c,d*hh
 * 	a – рабочее положение:
 * •	0 нет запроса
 * •	1 запрос на перевод МС-Ю в рабочее положение
 * 	b – транспортное положение:
 * •	0 нет запроса
 * •	1 запрос на перевод МС-Ю в транспортное положение
 * 	c – включить обогрев:
 * •	0 нет запрос
 * •	1 запрос на включение
 * 	d – выключить обогрев
 * •	0 нет запроса
 * •	1 запрос на выключение
 * 	hh – байт контрольной суммы рассчитывается
 * путем поразрядного су-ммирования по модулю 2 (исполнение операции «Исключающее ИЛИ»)
 * всех байтов сообщения между символами «$» и «*».
 * &#064;example $PMSDS,1,0,1,0*59
 */
public class SDSParser extends SentenceParser implements SDSSentence {

    private static final int OPERATING_POSTURE = 0;
    private static final int TRANSPORTING_POSTURE = 1;
    private static final int HEATING_ON = 2;
    private static final int HEATING_OFF = 3;;


    public SDSParser(String nmea) {
        super(nmea, SentenceId.SDS.toString());
    }

    protected SDSParser(String nmea, String type) {
        super(nmea, type);
    }

    protected SDSParser(TalkerId talker) {
        super(talker, SentenceId.SDS.toString(), 4);
    }

    public SDSParser() {
        super(TalkerId.PM, SentenceId.SDS.toString(), 4);
    }


    @Override
    public MsuFunctionSwitchCommand getOperatingPostureCommandState() {
        return MsuFunctionSwitchCommand.valueOf(getIntValue(OPERATING_POSTURE));
    }

    @Override
    public void setOperatingPostureCommandState(MsuFunctionSwitchCommand value) {
        setIntValue(OPERATING_POSTURE,value.toInt());
    }

    @Override
    public MsuFunctionSwitchCommand getTransportingPostureCommandState() {
        return MsuFunctionSwitchCommand.valueOf(getIntValue(TRANSPORTING_POSTURE));
    }

    @Override
    public void setTransportingPostureCommandState(MsuFunctionSwitchCommand value) {
        setIntValue(TRANSPORTING_POSTURE,value.toInt());
    }

    @Override
    public MsuFunctionSwitchCommand getHeatingOnCommandState() {
        return MsuFunctionSwitchCommand.valueOf(getIntValue(HEATING_ON));
    }

    @Override
    public void setHeatingOnCommandState(MsuFunctionSwitchCommand value) {
        setIntValue(HEATING_ON,value.toInt());
    }

    @Override
    public MsuFunctionSwitchCommand getHeatingOffCommandState() {
        return MsuFunctionSwitchCommand.valueOf(getIntValue(HEATING_OFF));
    }

    @Override
    public void setHeatingOffCommandState(MsuFunctionSwitchCommand value) {
        setIntValue(HEATING_OFF,value.toInt());
    }
}
