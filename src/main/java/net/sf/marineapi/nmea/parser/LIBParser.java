package net.sf.marineapi.nmea.parser;

import net.sf.marineapi.nmea.sentence.LIBSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;

public class LIBParser extends SentenceParser implements LIBSentence {
    // TODO: 05.01.2023 implement

    public LIBParser() {
        super(TalkerId.CA, SentenceId.LIB,0);
    }

    public LIBParser(String nmea) {
        super(nmea,SentenceId.LIB);
    }

    public LIBParser(TalkerId talker) {
        super(talker,SentenceId.LIB,0);
    }

    @Override
    public boolean isProprietary() {
        return true;
    }
}
