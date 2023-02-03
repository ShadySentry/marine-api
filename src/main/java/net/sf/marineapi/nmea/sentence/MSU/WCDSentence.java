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
package net.sf.marineapi.nmea.sentence.MSU;


import net.sf.marineapi.nmea.sentence.Sentence;
import net.sf.marineapi.nmea.util.BinsCalibrationStatus;
import net.sf.marineapi.nmea.util.Time;

/**
 * $PMWCD,yyy.y,xx.x,xxx.x*hh
 * 	yyy.y - направление ветра (0...359.9)
 * 	xx.x - скорость ветра (0...30.0)
 * 	xxx.x – температура воздуха (-40.0…+55.0)
 * 	hh – байт контрольной суммы рассчитывается путем поразрядного су-ммирования по модулю 2 (исполнение операции «Исключающее ИЛИ») всех байтов сообщения между символами «$» и «*».
 * &#064;example $PMWCD,013.5,05.4,-10.3*66
 */
public interface WCDSentence extends Sentence {

    double getWindDirection();
    double setWindDirection();

    double getWindSpeed();
    double setWindSpeed();

    double getAirTemperature();
    double setAirTemperature();

}
