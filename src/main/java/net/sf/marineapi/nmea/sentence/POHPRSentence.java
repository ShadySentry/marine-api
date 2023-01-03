/* 
 * BODSentence.java
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
package net.sf.marineapi.nmea.sentence;


import net.sf.marineapi.nmea.util.BINSCalibrationStatus;
import net.sf.marineapi.nmea.util.Time;

/**
 * $POHPR,hhmmss.ss,x.x,x.x,x.x,a*hh
 *  Полями данного предложения являются:
 *  – hhmmss.ss – время обсервации (UTC);
 *  – x.x – курс (азимут) в градусах;
 *  – x.x – крен в градусах (±1800,  «–» – на правый борт);
 *  – x.x – дифферент в градусах (±900,  «–» – нос внизу);
 *  – а – статус:
 *  • А – данные достоверны;
 *  • В – есть решение, достоверность не подтверждена;
 *  • V – решение не получено;
 *  • K – идет процесс автоматической калибровки.
 *  – hh – байт контрольной суммы рассчитывается путем поразрядного суммирования по модулю 2 (исполнение операции «Исключающее ИЛИ») всех байтов сообщения между символами «$» и «*».
 */
public interface POHPRSentence extends Sentence {

    Time getObservationTime();
    double getHeadingAzimuth();

    double getTiltToStarboard();

    double getTrimHeadIsBottom();

    String getResolveStatusRaw();

    BINSCalibrationStatus getResolveStatus();

    void setHeadingAzimuth(double headingAzimuth);

    void setTiltToStarboard(double tiltToStarboard);

    void setTrimHeadIsBottom(double trimHeadIsBottom);

    void setResolveStatusFromRaw(String resolveStatusRaw);

    void setResolveStatus(BINSCalibrationStatus resolveStatus);


    void setObservationTime(Time t);
}
