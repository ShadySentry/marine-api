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
import net.sf.marineapi.nmea.util.MSU.*;


/**
 * MSU ESD sentence.
 * Provides and information on  malfunctions
 */
public interface ESDSentence extends Sentence {

    MsuTemperatureSensorMalfunction getTemperatureSensorMalfunction();
    void setTemperatureSensorMalfunction(MsuTemperatureSensorMalfunction value);

    MsuWindSpeedSensorMalfunction getWindSpeedSensorMalfunction();
    void setWindSpeedSensorMalfunction(MsuWindSpeedSensorMalfunction value);

    MsuElectricalDriveMalfunction getElectricalDriveMalfunction();
    void setElectricalDriveMalfunction(MsuElectricalDriveMalfunction value);

    MsuEndSwitchesMalfunction getEndSwitchesMalfunction();
    void setEndSwitchesMalfunction(MsuEndSwitchesMalfunction value);

    MsuVoltageMalfunction getVoltageMalfunction();
    void setVoltageMalfunction(MsuVoltageMalfunction value);

    MsuPostureSwitchMalfunction getPostureSwitchMalfunction();
    void setPostureSwitchMalfunction (MsuPostureSwitchMalfunction value);

    MsuDataExchangeMalfunction getDataExchangeMalfunction();
    void setDataExchangeMalfunction(MsuDataExchangeMalfunction value);
}
