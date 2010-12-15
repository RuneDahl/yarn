/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import Time.BusinessDays.*;
import java.util.GregorianCalendar;

/**
 * Implementation of a number of {@see BusinessDays business days} in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianBusinessDay extends Count<GregorianCalendar> {
    private BusinessDays<GregorianCalendar> _businessDays;

    /**
     * Create a period of a number of business days in the Gregorian calendar
     * using the specified businessdays.
     * @param count        Number of business days.
     * @param businessDays Business days.
     * @throws NullPointerException Business days are not properly specified.
     */
    public GregorianBusinessDay(final int count,
            final BusinessDays<GregorianCalendar> businessDays) {
        super(count);
        this.setBusinessDays(businessDays);
    }

    /**
     * Gets the business days of this period.
     * @return Holidays.
     */
    public BusinessDays<GregorianCalendar> getBusinessDays() {
        return this._businessDays;
    }

    /**
     * Sets the business days of this period.
     * @param businessDays Business days.
     * @throws NullPointerException Business days are not properly specified.
     */
    public void setBusinessDays(final BusinessDays<GregorianCalendar> businessDays) {
        if (businessDays == null)
            throw new NullPointerException("Business days not properly specified.");
        this._businessDays = businessDays;
    }

    public GregorianCalendar shift(GregorianCalendar date, int count) {
        return this._businessDays.shift(date, count);
    }
}