/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Month">months</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianMonth
        extends Gregorian {
    /**
     * Create a period of months in the Gregorian calendar.
     * @param count Number of months.
     */
    public GregorianMonth(final int count) {
        super(count, GregorianCalendar.MONTH);
    }
}