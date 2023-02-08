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


import net.sf.marineapi.nmea.sentence.Sentence;
import net.sf.marineapi.nmea.util.MSU.*;

/**
 * $PMFSD,xx.x,yyy.y,a,b,c,d,e*hh
 * 	xx.x - напряжение питания,В (0...40.0)
 * 	yyy.y - температура МС-Ю, С (-40.0…+55.0)
 * 	а – положение МС-Ю:
 * •	0 – транспортное;
 * •	1 – рабочее;
 * •	2 – мачта раскладывается;
 * •	3 – мачта складывается
 * 	b – режим работы МС-Ю:
 * •	0 – ждущий режим;
 * •	1 – готова к работе;
 * 	c – подогрев МС-Ю:
 * •	0 –отключен;
 * •	1 – включен;
 * 	d – разрешение подогрева МС-Ю:
 * •	0 – запрещен;
 * •	1 – разрешен;
 * 	e – обдув датчика температуры включён:
 * •	0 – отключен;
 * •	1 – включен;
 * 	hh – байт контрольной суммы рассчитывается
 * путем поразрядного су-ммирования по модулю 2 (исполнение операции «Исключающее ИЛИ»)
 * всех байтов сообщения между символами «$» и «*».
 * &#064;example $PMFSD,12.5,-03.6,1,1,0,0,0*7E
 */
public interface FSDSentence extends Sentence {
    double getVoltage();
    void setVoltage(double value);

    double getTemperature();
    void setTemperature(double value);

    MsuPosture getPosture();
    void setPosture(MsuPosture value);

    MsuOperatingMode getOperatingMode();
    void setOperatingMode(MsuOperatingMode value);

    MsuHeatingMode getHeatingMode();
    void setHeatingMode(MsuHeatingMode value);

    MsuHeatingModePermission getHeatingModePermission();
    void setHeatingModePermission (MsuHeatingModePermission  value);

    MsuTemperatureSensorBlowing getTemperatureSensorBlowing();
    void setTemperatureSensorBlowing(MsuTemperatureSensorBlowing value);
}
