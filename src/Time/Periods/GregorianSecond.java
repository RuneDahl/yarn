/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Second">seconds</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianSecond
        extends Gregorian {
    /**
     * Create a period of seconds in the Gregorian calendar.
     * @param count Number of seconds.
     */
    public GregorianSecond(final int count) {
        super(count, GregorianCalendar.SECOND);
    }
}