/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Hour">hours</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianHour
        extends Gregorian {
    /**
     * Create a period of hours in the Gregorian calendar.
     * @param count Number of hours.
     */
    public GregorianHour(final int count) {
        super(count, GregorianCalendar.HOUR);
    }
}