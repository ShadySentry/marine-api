/*
 * SerialPortExample.java
 * Copyright (C) 2011 Kimmo Tuukkanen
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
package net.sf.marineapi.example;


import net.sf.marineapi.nmea.event.SentenceEvent;
import net.sf.marineapi.nmea.event.SentenceListener;
import net.sf.marineapi.nmea.io.SentenceReader;
import net.sf.marineapi.nmea.parser.ORMParser;
import net.sf.marineapi.nmea.parser.PMPParser;
import net.sf.marineapi.nmea.parser.HPRParser;
import net.sf.marineapi.nmea.sentence.SentenceValidator;
import purejavacomm.*;

import java.io.*;
import java.util.*;

/**
 * Serial port example using GNU/RXTX libraries (see readme.txt). Scans through
 * all COM ports and seeks for NMEA 0183 data with default settings (4800
 * baud, 8 data bits, 1 stop bit and no parity). If NMEA data is found, starts
 * printing out all sentences the device is broadcasting.
 * <p>
 * Notice that on Linux you may need to set read/write privileges on correct
 * port (e.g. {@code sudo chmod 666 /dev/ttyUSB0}) or add your user in
 * dialout group before running this example.
 *
 * @author Kimmo Tuukkanen
 */
public class SerialPortWithOutExample implements SentenceListener {
    private static String[] ARGS;

    /**
     * Constructor
     */
    public SerialPortWithOutExample() {
        init();
    }

    /*
     * (non-Javadoc)
     * @see net.sf.marineapi.nmea.event.SentenceListener#readingPaused()
     */
    public void readingPaused() {
        System.out.println("-- Paused --");
    }

    /*
     * (non-Javadoc)
     * @see net.sf.marineapi.nmea.event.SentenceListener#readingStarted()
     */
    public void readingStarted() {
        System.out.println("-- Started --");
    }

    /*
     * (non-Javadoc)
     * @see net.sf.marineapi.nmea.event.SentenceListener#readingStopped()
     */
    public void readingStopped() {
        System.out.println("-- Stopped --");
    }

    /*
     * (non-Javadoc)
     * @see
     * net.sf.marineapi.nmea.event.SentenceListener#sentenceRead(net.sf.marineapi
     * .nmea.event.SentenceEvent)
     */
    public void sentenceRead(SentenceEvent event) {
        // here we receive each sentence read from the port
        System.out.println(event.getSentence());
    }

    /**
     * Scan serial ports for NMEA data.
     *
     * @return SerialPort from which NMEA data was found, or null if data was
     * not found in any of the ports.
     */
    private SerialPort getSerialPort() {
        if (ARGS.length > 0) {
            CommPortIdentifier id;
            String m_TestPortName;
            SerialPort sp = null;
            try {
                m_TestPortName = ARGS[0];
                id = CommPortIdentifier.getPortIdentifier(m_TestPortName);
                sp = (SerialPort) id.open("SerialExample", 30);
                sp.notifyOnDataAvailable(true);
                sp.notifyOnOutputEmpty(true);
                sp.setSerialPortParams(115200, SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                sp.enableReceiveTimeout(1000);
                sp.enableReceiveThreshold(0);

                System.out.println("loaded COM port from config ARGS with name " + ARGS[0]);
                return sp;
            } catch (Exception e) {
                id = null;
                if (sp != null) {
                    sp.close();
                    sp = null;
                }
                e.printStackTrace();
            }

        }
        System.out.println("Trying to find COM port automatically ...");
        try {
            Enumeration<?> e = CommPortIdentifier.getPortIdentifiers();

            while (e.hasMoreElements()) {
                CommPortIdentifier id = (CommPortIdentifier) e.nextElement();

                if (id.getPortType() == CommPortIdentifier.PORT_SERIAL) {

                    SerialPort sp = (SerialPort) id.open("SerialExample", 30);

                    sp.setSerialPortParams(115200, SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    sp.enableReceiveTimeout(1000);
                    sp.enableReceiveThreshold(0);

                    InputStream is = sp.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader buf = new BufferedReader(isr);

                    System.out.println("Scanning port " + sp.getName());

                    // try each port few times before giving up
                    for (int i = 0; i < 5; i++) {
                        try {
                            String data = buf.readLine();
                            if (SentenceValidator.isValid(data)) {
                                System.out.println("NMEA data found!");
                                return sp;
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    is.close();
                    isr.close();
                    buf.close();
                }
            }
            System.out.println("NMEA data was not found..");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    SerialPort sp;
    InputStream is;
    SentenceReader sr;

    OutputStream m_Out;

    /**
     * Init serial port and reader.
     */
    private void init() {
        try {
            sp = getSerialPort();
            assert sp != null;
            m_Out = sp.getOutputStream();
            byte[] buffer = new String("Hello from ACMS").getBytes();
            try {
                m_Out.write(buffer, 0, buffer.length);
                System.out.println("Printing message " + new String(buffer) + "----- " +buffer);

                sp.addEventListener(event -> {
                    if (event.getEventType() == SerialPortEvent.OUTPUT_BUFFER_EMPTY) {

                        for (int i = 0; i < 3; i++) {
                            byte[] buffer1 = generateTestMessage();
                            try {
                                System.out.println("Printing message " + new String(buffer1));
                                m_Out.write(buffer1, 0, buffer1.length);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        try {
                            m_Out.flush();
                            m_Out.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (sp != null) {
                is = sp.getInputStream();
                sr = new SentenceReader(is);
                sr.addSentenceListener(this);
                sr.start();


            }

        } catch (Exception e) {
            try {
                if (m_Out != null) {
                    m_Out.flush();
                    m_Out.close();

                    if (sr != null) {
                        sr.stop();
                    }

                    if (is != null) {
                        is.close();
                    }

                    if (sp != null) {
                        sp.close();
                        sp = null;
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    private byte[] generateTestMessage() {
        List<String> messages = List.of(
                new String("$POHPR,163828.715,10.05,179.17,-10.01,B*1E"),
                new String("$POPMP,1.1,2.2,3.3,2,0*52"),
                new String("$COORM,4825.618128,N,03500.251609,E,2048.0,M"),
                new String("$COORM,4825.618128,S,03500.251609,E,10.0,M"),
                new String("$COORM,4825.618128,N,03500.251609,W,-550.0,M"));

        Random random = new Random();
        String example = messages.get(random.nextInt(4));

        String msgType = example.substring(1, 6);
        String response;
        if (msgType.equals("COORM")) {
            response = new ORMParser(example).toString();
        } else if (msgType.equals("POPMP")) {
            response = new PMPParser(example).toString();
        } else {
            response = new HPRParser(example).toString();
        }
        response=new String(response+"\r\n");

        return response.getBytes();
    }

    /**
     * Startup method, no arguments required.
     *
     * @param args None
     */
    public static void main(String[] args) {
        ARGS = args;

        new SerialPortWithOutExample();
    }
}