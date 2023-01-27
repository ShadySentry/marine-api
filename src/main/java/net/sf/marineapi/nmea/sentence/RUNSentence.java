package net.sf.marineapi.nmea.sentence;

import net.sf.marineapi.nmea.util.BinsGpsStatus;
import net.sf.marineapi.nmea.util.BinsNavigationTaskStatus;

/**
 * $PORUN*hh,
 * Полями данного предложения являются:
 *
 * – hh – байт контрольной суммы рассчитывается путем поразрядного суммирования по модулю 2
 *        (исполнение операции «Исключающее ИЛИ») всех байтов сообщения между символами «$» и «*».
 */
public interface RUNSentence extends Sentence{

}
