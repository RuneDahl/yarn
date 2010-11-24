/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of a
 * <a href="http://en.wikipedia.org/wiki/Month">monthly</a>
 * recurring {@see Holiday holiday} in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianMonthly
        implements MonthlyRecurring<GregorianCalendar> {
    private int _date;

    /**
     * Create a monthly recurring holiday in the Gregorian calendar on the
     * specified date of the month.
     * @param date Date of month.
     */
    public GregorianMonthly(final int date) {
        this.setDate(date);
    }

    /**
     * Get the date of month for this holiday.
     * @return The date of month for this holiday.
     */
    public int getDate() {
        return this._date;
    }

    /**
     * Set the date of month for this holiday.
     * @param date The date of month for this holiday.
     */
    public void setDate(final int date) {
        if (date < 1 || 31 < date)
            throw new IllegalArgumentException("Date must be a value " +
                    "in the range 1 through 31. (Both included)");
        this._date = date;
    }

    /**
     * Returns this holiday as occuring in the specified year and month.
     * @param year  Year.
     * @param month Month.
     * @return      This holiday as occuring in the specified year and month.
     */
    public GregorianCalendar getHoliday(final int year, final int month) {
        if (this.occurs(year, month))
            return new GregorianCalendar(year, month, this._date);
        throw new NullPointerException("This monthly holiday does not occur in " +
                "the specified yead and month: " + Integer.toString(year) +
                " " + Integer.toString(month) + ".");
    }

    /**
     * Returns whether this holiday occurs in the specified year and month.
     * @param year  Year.
     * @param month Month.
     * @return      Whether this holiday occurs in the specified year and month.
     */
    public boolean occurs(final int year, final int month) {
        return this._date <= Time.Gregorian.lengthOfMonth(year, month);
    }

    /**
     * Returns whether the specified date/time falls within this holiday.
     * @param date Date/time.
     * @return     Whether the specified date/time falls within this holiday.
     */
    public boolean isHoliday(final GregorianCalendar date) {
        return date.get(GregorianCalendar.DATE) == this._date;
    }
}