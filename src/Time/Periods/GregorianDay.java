/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Day">days</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianDay
        extends Gregorian {
    /**
     * Create a period of days in the Gregorian calendar.
     * @param count Number of days.
     */
    public GregorianDay(final int count) {
        super(count, GregorianCalendar.DATE);
    }
}