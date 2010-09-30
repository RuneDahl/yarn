/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import Time.BusinessDays.*;
import Time.Holidays.Holiday;
import java.util.GregorianCalendar;

/**
 * Implementation of a number of {@see BusinessDays business days} in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianBusinessDay extends Count<GregorianCalendar> {
    private HolidaysBased<GregorianCalendar> _businessDays;

    /**
     * Create a period of business days in the Gregorian calendar using the
     * specified holidays.
     * @param count    Number of business days.
     * @param holidays Holidays.
     * @throws NullPointerException Holidays are not properly specified.
     */
    public GregorianBusinessDay(final int count,
            final Holiday<GregorianCalendar> holidays) {
        super(count);
        this.setHolidays(holidays);
    }

    /**
     * Gets the holidays determining what days are businessdays.
     * @return Holidays.
     */
    public Holiday<GregorianCalendar> getHolidays() {
        return this._businessDays.getHolidays();
    }

    /**
     * Sets the holidays used to determine what days are businessdays.
     * @param holidays Holidays.
     * @throws NullPointerException Holidays are not properly specified.
     */
    public void setHolidays(final Holiday<GregorianCalendar> holidays) {
        if (holidays == null)
            throw new NullPointerException("Holidays not properly specified.");
        if (this._businessDays == null)
            this._businessDays = new Following<GregorianCalendar>(
                    holidays, new GregorianDay(1));
        else
            this._businessDays.setHolidays(holidays);
    }

    public GregorianCalendar Shift(GregorianCalendar date, int count) {
        return this._businessDays.Shift(date, count);
    }
}