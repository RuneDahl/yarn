/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

import java.util.GregorianCalendar;

/**
 * Implementation of the {@see DayCount day count convention}
 * counting the actual number of days under the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * <br>See for instance:
 * <a href="http://en.wikipedia.org/wiki/Day_count_convention#Actual.2FActual_ISDA">
 * ISDA Actual/Actual on Wikipedia</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianActual extends Gregorian {

    /**
     * Returns the length in days of the specified month of the specified year.
     * @param year  Year.
     * @param month Month.
     * @return      The length in days of the specified month of the specified year.
     */
    public double Month(final int year, final int month) {
        return Time.Gregorian.lengthOfMonth(year, month);
    }

    /**
     * Returns the length in days of the specified year.
     * @param year  Year.
     * @return      The length in days of the specified year.
     */
    public double Year(final int year) {
        return Time.Gregorian.lengthOfYear(year);
    }

    /**
     * Gets a string representation of this daycount when acting as a denominator.
     * @return String representation of this daycount when acting as a denominator.
     */
    public String getDenominator() {
        return "Act";
    }

    /**
     * Gets a string representation of this daycount when acting as a numerator.
     * @return String representation of this daycount when acting as a numerator.
     */
    public String getNumerator() {
        return "Act";
    }

    /**
     * Adjust the adjusted date/time according to the GregorianActual daycount rule. That is no adjustment.
     * @param date Date/time to adjust.
     * @return     The date/time.
     */
    @Override
    protected GregorianCalendar _Adjust(final GregorianCalendar date) {
        return (GregorianCalendar)date.clone();
    }
}