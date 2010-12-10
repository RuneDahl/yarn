/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;

/**
 * Implementation of a number of basic periods in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public abstract class Gregorian
        extends Count<GregorianCalendar> {
    private final int _basicPeriod;

    /**
     * Create a basic period in the Gregorian calendar.
     * @param count       Number of periods.
     * @param basicPeriod Integer representing the basic period of this period.
     *                    <br>This value must be from the period constants
     *                    defined for the {@see GregorianCalendar}.
     */
    protected Gregorian(final int count, final int basicPeriod) {
        super(count);
        this._basicPeriod = basicPeriod;
    }

    public GregorianCalendar shift(final GregorianCalendar date, final int count) {
        GregorianCalendar shifted = (GregorianCalendar) date.clone();
        shifted.add(this._basicPeriod, count * this.getCount());
        return shifted;
    }
}