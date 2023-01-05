package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.SETSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

public class SETParser extends SentenceParser implements SETSentence {
    // TODO: 05.01.2023 implement
    public SETParser() {
        super(TalkerId.CA, SentenceId.LIB, 0);
    }

    public SETParser(String nmea) {
        super(nmea, SentenceId.LIB);
    }

    public SETParser(TalkerId talker) {
        super(talker, SentenceId.LIB, 0);
    }

    @Override
    public boolean isProprietary() {
        return true;
    }
}
