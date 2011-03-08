/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time;

import java.util.GregorianCalendar;

/**
 * Utility class containing methods for date/times in the
 * <a href="http://en.wikipedia.org/wiki/Julian_calendar">Julian calendar</a>.<br>
 * Since the Julian and Gregorian calendars are implemented jointly by the class
 * {@see java.util.GregorianCalendar java.util.GregorianCalendar} this
 * implementation of utility methods for the Julian calendar use date/times
 * specified by the class java.util.GregorianCalendar. And such methods as
 * would be identical are found in the class {@see Gregorian Time.Gregorian}.<br>
 * This implementation use the correctly specified leap year, not the
 * <a href="http://en.wikipedia.org/wiki/Julian_calendar#Leap_year_error">
 * wrongly implemented</a> leap years in the period 45 B.C. to 8 A.D.<br>
 * The implementation allows the calculation of
 * <a href="http://en.wikipedia.org/wiki/Proleptic_Julian_calendar">
 * proleptic and postleptic</a> leap years, that is it allows calculation of
 * whether a year before 45 B.C. or after 1582 A.D. would have been a leap year
 * under the Julian calendar.
 * @author Rune Dahl Iversen
 */
public final class Julian {
    private Julian()
    { /* Intentional */ }

    /**
     * Computes whether the specified year is a leap year in the Julian calendar.
     * @param year Year.
     * @return     True if year is a leap year, otherwise false.
     */
    public static boolean isLeapYear(final int year) {
        return (year % 4 == 0);
    }

    /**
     * Computes whether the specified date/time falls within a leap year
     * in the Gregorian calendar.
     * @param date date/time.
     * @return     True if the date is within a leap year, otherwise false.
     */
    public static boolean isLeapYear(final GregorianCalendar date) {
        return isLeapYear(date.get(GregorianCalendar.YEAR));
    }

    /**
     * Returns the actual length of a month in a year from the Julian calendar in days.
     * @param year  Year.
     * @param month Month.
     * @return Length of the month in days.
     */
    public static double lengthOfMonth(final int year, final int month) {
        double length = 0.0;
        switch (month)
        {
            case 0:
                length = 31.0;
                break;
            case 1:
                length = 28.0 + (isLeapYear(year) ? 1.0 : 0.0);
                break;
            case 2:
                length = 31.0;
                break;
            case 3:
                length = 30.0;
                break;
            case 4:
                length = 31.0;
                break;
            case 5:
                length = 30.0;
                break;
            case 6:
                length = 31.0;
                break;
            case 7:
                length = 31.0;
                break;
            case 8:
                length = 30.0;
                break;
            case 9:
                length = 31.0;
                break;
            case 10:
                length = 30.0;
                break;
            case 11:
                length = 31.0;
                break;
            default:
                throw new IllegalArgumentException("The month must be an " +
                        "integer in the range 0 to 11 (both included).");
        }
        return length;
    }

    /**
     * Returns the actual length of a year in the Julian calendar in days.
     * @param year Year.
     * @return Length of the year in days.
     */
    public static double lengthOfYear(final int year) {
        return 365.0 + (isLeapYear(year) ? 1.0 : 0.0);
    }
}
