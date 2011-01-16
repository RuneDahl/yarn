/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of a
 * <a href="http://en.wikipedia.org/wiki/Week">weekly</a>
 * recurring {@see Holiday holiday} in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianWeekday implements Holiday<GregorianCalendar> {
    private int _weekday;

    /**
     * Create a weekly recurring holiday in the Gregorian calendar on the
     * specified day of the week.
     * @param weekday Day of the week.
     */
    public GregorianWeekday(final int weekday) {
        this.setWeekday(weekday);
    }

    /**
     * Returns the day of week of this holiday.
     * @return The day of week of this holiday.
     */
    public int getWeekday() {
        return this._weekday;
    }

    /**
     * Sets the day of week of this holiday.
     * @param weekday The day of week of this holiday.
     */
    public void setWeekday(final int weekday) {
        if (weekday < 1 || 7 < weekday)
            throw new IllegalArgumentException("The weekday must be specified " +
                    "within the range 1 through 7. Both inclusive.");
        this._weekday = weekday;
    }

    /**
     * Returns whether the specified date/time falls within this holiday.
     * @param date Date/time.
     * @return     Whether the specified date/time falls within this holiday.
     */
    @Override
    public boolean isHoliday(final GregorianCalendar date) {
        return this._weekday == date.get(GregorianCalendar.DAY_OF_WEEK);
    }
}