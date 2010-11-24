/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of an
 * <a href="http://en.wikipedia.org/wiki/Anniversary">anniversary</a>
 * {@see Holiday holiday} in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public class GregorianAnniversary
        implements AnnuallyRecurring<GregorianCalendar> {
    private int _date;
    private int _month;

    /**
     * Create a Gregorian anniversary with the specified month and date.
     * @param month Month.
     * @param date  Date.
     */
    public GregorianAnniversary(final int month, final int date) {
        this.setMonth(month);
        this.setDate(date);
    }

    /**
     * Gets the date/day of month of this Gregorian anniversary.
     * @return The date/day of month of this Gregorian anniversary.
     */
    public int getDate() {
        return this._date;
    }

    /**
     * Gets the month of this Gregorian anniversary.
     * @return The month of this Gregorian anniversary.
     */
    public int getMonth() {
        return this._month;
    }

    /**
     * Sets the day/date of month os this Gregorian anniversary.
     * @param date Day/date of month.
     * @exception IllegalArgumentException Date must be a value in the
     *            range 1 through 31. (Both included)
     */
    public void setDate(final int date) {
        if (date < 1 || 31 < date)
            throw new IllegalArgumentException("Date must be a value in the " +
                    "range 1 through 31. (Both included)");
        this._date = date;
    }

    /**
     * Sets the month of this Gregorian anniversary.
     * @param month Month.
     * @exception IllegalArgumentException Month must be a value in the
     *            range 1 through 11. (Both included)
     */
    public void setMonth(final int month) {
        if (month < 0 || 11 < month)
            throw new IllegalArgumentException("Month must be a value in the " +
                    "range 0 through 11. (Both included)");
        this._month = month;
    }

    /**
     * Returns this Gregorian anniversary of the specified year - if it occurs.
     * @param year Year.
     * @return     This Gregorian anniversary of the specified year.
     * @throws NullPointerException
     *         This anniversary does not occur in the specified year.
     */
    public GregorianCalendar getHoliday(final int year) {
        if (this.occurs(year))
            return new GregorianCalendar(year, this._month, this._date);
        throw new NullPointerException("This anniversay does not occur in the " +
                "specified year: " + Integer.toString(year));
    }

    /**
     * Returns whether this Gregorian anniversary happens in the specified year.
     * @param year Year.
     * @return     Whether this Gregorian anniversary happens in the specified year.
     */
    public boolean occurs(final int year) {
        return this._date <= Time.Gregorian.lengthOfMonth(year, this._month);
    }

    /**
     * Returns whether the specified date/time is this Gregorian anniversary.
     * @param date Date/time.
     * @return     Whether the specified date/time is this Gregorian anniversary.
     */
    public boolean isHoliday(final GregorianCalendar date) {
        return date.get(GregorianCalendar.DATE) == this._date &&
                date.get(GregorianCalendar.MONTH) == this._month;
    }

}