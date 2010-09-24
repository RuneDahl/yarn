/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Millisecond">milliseconds</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianMilliSecond
        extends Gregorian {
    /**
     * Create a period of milliseconds in the Gregorian calendar.
     * @param count Number of milliseconds.
     */
    public GregorianMilliSecond(final int count) {
        super(count, GregorianCalendar.MILLISECOND);
    }
}