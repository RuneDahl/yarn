/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Minute">minutes</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianMinute
        extends Gregorian {
    /**
     * Create a period of minutes in the Gregorian calendar.
     * @param count Number of minutes.
     */
    public GregorianMinute(final int count) {
        super(count, GregorianCalendar.MINUTE);
    }
}