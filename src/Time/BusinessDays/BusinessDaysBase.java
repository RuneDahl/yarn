/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.BusinessDays;

import Time.Holidays.Holiday;
import Time.Periods.Period;

/**
 * Abstract implementation of the {@see BusinessDays business days} interface
 * containing the holidays and period.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public abstract class BusinessDaysBase<TypeOfCalendar>
        implements BusinessDays<TypeOfCalendar> {
    private Period<TypeOfCalendar> _period;
    private Holiday<TypeOfCalendar> _holidays;

    /**
     * Creates an instance of business days using the specified holidays
     * and period.
     * @param holidays Holidays.
     * @param period   Period used to adjust and shift date/times.
     * @throws NullPointerException Holidays not properly specified.
     * @throws NullPointerException Period not properly specified.
     */
    protected BusinessDaysBase(final Holiday<TypeOfCalendar> holidays,
            final Period<TypeOfCalendar> period) {
        this.setHolidays(holidays);
        this.setPeriod(period);
    }
    
    public final  Holiday<TypeOfCalendar> getHolidays() {
        return this._holidays;
    }

    public final Period<TypeOfCalendar> getPeriod() {
        return this._period;
    }

    /**
     * Sets the holidays of this business days.
     * @param holidays Holidays.
     * @throws NullPointerException Holidays not properly specified.
     */
    public final void setHolidays(final Holiday<TypeOfCalendar> holidays) {
        if (holidays == null)
            throw new NullPointerException("Holidays not properly specified.");
        this._holidays = holidays;
    }

    /**
     * Sets the period used to adjust and shift date/times.
     * @param period Period used to adjust and shift date/times.
     * @throws NullPointerException Period not properly specified.
     */
    public final void setPeriod(final Period<TypeOfCalendar> period) {
        if (period == null)
            throw new NullPointerException("Period not properly specified.");
        this._period = period;
    }
}