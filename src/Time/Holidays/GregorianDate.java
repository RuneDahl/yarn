/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of a single
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian</a>
 * <a href="http://en.wikipedia.org/wiki/Calendar_date">date</a>
 * as a {@see Holiday holiday}.
 * @author Rune Dahl Iversen
 */
public final class GregorianDate implements Holiday<GregorianCalendar>{
    private int _date;
    private int _month;
    private int _year;

    /**
     * Create a holiday consisting of a single Gregorian date.
     * @param date Date/time.
     */
    public GregorianDate(final GregorianCalendar date) {
        this.setDate(date);
    }

    /**
     * Gets this holidays Gregorian date.
     * @return This holidays Gregorian date.
     */
    public GregorianCalendar getDate() {
        return new GregorianCalendar(_year, _month, _date);
    }

    /**
     * Sets this calendars Gregorian date.
     * @param date Date/time.
     */
    public void setDate(final GregorianCalendar date) {
        this._date = date.get(GregorianCalendar.DATE);
        this._month = date.get(GregorianCalendar.MONTH);
        this._year = date.get(GregorianCalendar.YEAR);
    }

    /**
     * Returns whether the specified date/time falls within this holiday.
     * @param date Date/time.
     * @return     Whether the specified date/time falls within this holiday.
     */
    @Override
    public boolean isHoliday(final GregorianCalendar date) {
        return this._date == date.get(GregorianCalendar.DATE) &&
                this._month == date.get(GregorianCalendar.MONTH) &&
                this._year == date.get(GregorianCalendar.YEAR);
    }
}