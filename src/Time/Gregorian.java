/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time;

import java.util.GregorianCalendar;

/**
 * Utility class containing methods for date/times in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public final class Gregorian {
    private Gregorian() {
    }

    /**
     * Computes whether the specified year is a leap-year in the Gregorian calendar.
     * @param year Year.
     * @return     True if year is a leap-year, otherwise false.
     */
    public final static boolean isLeapYear(final int year) {
        boolean isLeapYear = (year % 4 == 0);
        if (isLeapYear)
        {
            isLeapYear = (year % 100 != 0);
            if (!isLeapYear)
                isLeapYear = (year % 400 == 0);
        }
        return isLeapYear;
    }

    /**
     * Computes whether the specified date/time falls within a leap-year
     * in the Gregorian calendar.
     * @param date Date/time.
     * @return     True if the date is within a leap-year, otherwise false.
     */
    public final static boolean isLeapYear(final GregorianCalendar date) {
        return isLeapYear(date.get(GregorianCalendar.YEAR));
    }

        /**
     * Returns the latest of the 2 specified Gregorian date/times.
     * @param date1 Date/time.
     * @param date2 Date/time.
     * @return      The latest of the 2 specified Gregorian date/times.
     */
    public final static GregorianCalendar max(
            final GregorianCalendar date1, final GregorianCalendar date2) {
        if (0 < date2.compareTo(date1))
            return (GregorianCalendar)date2.clone();
        else
            return (GregorianCalendar)date1.clone();
    }

    /**
     * Returns the earliest of the 2 specified Gregorian date/times.
     * @param date1 Date/time.
     * @param date2 Date/time.
     * @return      The earliest of the 2 specified Gregorian date/times.
     */
    public final static GregorianCalendar min(
            final GregorianCalendar date1, final GregorianCalendar date2) {
        if (0 < date2.compareTo(date1))
            return (GregorianCalendar)date1.clone();
        else
            return (GregorianCalendar)date2.clone();
    }
}