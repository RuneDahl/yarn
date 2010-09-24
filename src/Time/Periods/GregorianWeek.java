/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of
 * <a href="http://en.wikipedia.org/wiki/Week">weeks</a> in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianWeek
        extends Gregorian {
    /**
     * Create a period of weeks in the Gregorian calendar.
     * @param count Number of weeks.
     */
    public GregorianWeek(final int count) {
        super(count, GregorianCalendar.WEEK_OF_YEAR);
    }
}