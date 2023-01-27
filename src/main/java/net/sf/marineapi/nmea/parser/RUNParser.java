package net.sf.marineapi.nmea.parser;

import lombok.extern.slf4j.Slf4j;
import net.sf.marineapi.nmea.sentence.PMPSentence;
import net.sf.marineapi.nmea.sentence.RUNSentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.sentence.TalkerId;
import net.sf.marineapi.nmea.util.BinsGpsStatus;
import net.sf.marineapi.nmea.util.BinsNavigationTaskStatus;

/**
 * BINS PORUN sentence parser
 */
@Slf4j
public class RUNParser extends SentenceParser implements RUNSentence {

    public RUNParser(String nmea) {
        super(nmea,SentenceId.RUN);
    }

    public RUNParser(TalkerId talker) {
        super(talker, SentenceId.RUN, 0);
    }

    public RUNParser() {
        super(TalkerId.PO,SentenceId.RUN,0);
    }

    @Override
    public boolean isProprietary() {
        return true;
    }
}
