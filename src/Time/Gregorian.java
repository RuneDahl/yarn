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
     * Returns the difference between the two specified Gregorian date/times
     * that stem from the differences in Hours, Minutes, Seconds and
     * Milli-seconds measured in days.
     * @param from From date/time.
     * @param to   To date/time.
     * @return     The difference measured in days stemming from Hours, Minutes,
     *             Seconds and Milli-seconds.
     */
    public static double belowDateDifference(
            final GregorianCalendar from,
            final GregorianCalendar to) {
        double difference = (to.get(GregorianCalendar.MILLISECOND) - from.get(GregorianCalendar.MILLISECOND)) / 1000.0;
        difference += (to.get(GregorianCalendar.SECOND) - from.get(GregorianCalendar.SECOND));
        difference /= 60.0;
        difference += (to.get(GregorianCalendar.MINUTE) - from.get(GregorianCalendar.MINUTE));
        difference /= 60.0;
        difference += (to.get(GregorianCalendar.HOUR_OF_DAY) - from.get(GregorianCalendar.HOUR_OF_DAY));
        difference /= 24.0;
        return difference;
    }

    /**
     * Computes whether the specified year is a leap-year in the Gregorian calendar.
     * @param year Year.
     * @return     True if year is a leap-year, otherwise false.
     */
    public static boolean isLeapYear(final int year) {
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
    public static boolean isLeapYear(final GregorianCalendar date) {
        return isLeapYear(date.get(GregorianCalendar.YEAR));
    }

    /**
     * Returns the actual length of a month in a year from the Gregorian calendar in days.
     * @param year  Year.
     * @param month Month.
     * @return Length of the month in days.
     */
    public static double lengthOfMonth(final int year, final int month) {
        double length = 0.0;
        switch (month)
        {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                length = 31.0;
                break;
            case 1:
                length = 28.0;
                break;
            case 3:
            case 5:
            case 8:
            case 10:
                length = 30.0;
                break;
            default:
                throw new IllegalArgumentException("The month must be an " +
                        "integer in the range 0 to 11 (both included).");
        }
        if (month == 1 && isLeapYear(year))
            length = 29.0;
        return length;
    }

    /**
     * Returns the actual length of a year in the Gregorian calendar in days.
     * @param year Year.
     * @return Length of the year in days.
     */
    public static double lengthOfYear(final int year) {
        return 365.0 + (isLeapYear(year) ? 1.0 : 0.0);
    }

    /**
     * Returns the latest of the 2 specified Gregorian date/times.
     * @param date1 Date/time.
     * @param date2 Date/time.
     * @return      The latest of the 2 specified Gregorian date/times.
     */
    public static GregorianCalendar max(
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
    public static GregorianCalendar min(
            final GregorianCalendar date1, final GregorianCalendar date2) {
        if (0 < date2.compareTo(date1))
            return (GregorianCalendar)date1.clone();
        else
            return (GregorianCalendar)date2.clone();
    }
}