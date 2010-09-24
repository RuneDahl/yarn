/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

import java.util.GregorianCalendar;

/**
 * The {@see DayCount day count convention} counting number of days in a
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calender</a>
 * but not counting
 * <a href="http://en.wikipedia.org/wiki/Leap_year#Leap_day">leap days</a>.
 * This makes all years of equal length - 365 days.
 * <br>See for instance:
 * <a href="http://en.wikipedia.org/wiki/Day_count_convention#Actual.2F365_Fixed">
 * ISDA Actual/356 on Wikipedia</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianNoLeap extends Gregorian {
    /**
     * Returns the length in days of the specified month of the specified year.
     * @param year  Year.
     * @param month Month.
     * @return      The length in days of the specified month of the specified year.
     */
    public double Month(final int year, final int month) {
        if (month == 1)
            return 28.0;
        return Time.Gregorian.lengthOfMonth(year, month);
    }

    /**
     * Returns the length in days of the specified year.
     * @param year  Year.
     * @return      The length in days of the specified year.
     */
    public double Year(final int year) {
        return 365.0;
    }

    /**
     * Gets a string representation of this daycount when acting as a denominator.
     * @return String representation of this daycount when acting as a denominator.
     */
    public String getDenominator() {
        return "365";
    }

    /**
     * Gets a string representation of this daycount when acting as a numerator.
     * @return String representation of this daycount when acting as a numerator.
     */
    public String getNumerator() {
        return "NLp";
    }

    /**
     * Returns the adjusted date/time according to the GregorianNoLeap daycount rule.
     * @param date Date/time.
     * @return     The adjusted date/time according to the GregorianNoLeap daycount rule.
     */
    @Override
    protected GregorianCalendar _Adjust(final GregorianCalendar date) {
        GregorianCalendar adjusted = (GregorianCalendar)date.clone();
        if (adjusted.get(GregorianCalendar.MONTH) == 1 &&
                adjusted.get(GregorianCalendar.DAY_OF_MONTH) == 29)
            adjusted.set(GregorianCalendar.DAY_OF_MONTH, 28);
        return adjusted;
    }
}