/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.BusinessDays;

import Time.Holidays.*;
import Time.Periods.*;

/**
 * Interface defining
 * <a href="http://en.wikipedia.org/wiki/Business_day">business days</a>
 * from a corresponding set of {@see Time.Holidays.Holiday holidays}
 * implementing a method of adjustment and shifting relative to a
 * {@see Time.Periods.Period period}.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public interface BusinessDays<TypeOfCalendar> {
    /**
     * Gets the holidays from this business days.
     * @return The holidays.
     */
    public Holiday<TypeOfCalendar> getHolidays();

    /**
     * Gets the period used to adjust and shift date/times.
     * @return The period used to adjust and shift date/times.
     */
    public Period<TypeOfCalendar> getPeriod();

    /**
     * Sets the holidays of this business days.
     * @param holidays Holidays.
     */
    public void setHolidays(final Holiday<TypeOfCalendar> holidays);

    /**
     * Sets the period used to adjust and shift date/times.
     * @param period Period used to adjust and shift date/times.
     */
    public void setPeriod(final Period<TypeOfCalendar> period);

    /**
     * Returns the adjusted date/time from the specified date/time using the
     * rules and values of this business days.
     * @param dateTime Date/time.
     * @return The adjusted date/time.
     */
    public TypeOfCalendar Adjust(final TypeOfCalendar dateTime);

    /**
     * Returns the specified date/time shifted the number of times using the
     * period of this business days while not counting the holidays.<br>
     * The shifted date/time will be a business day according to this instance.
     * @param dateTime Date/time.
     * @param count    Number of shifts to apply.
     * @return The shifted date/time.
     */
    public TypeOfCalendar Shift(final TypeOfCalendar dateTime,
            final int count);
}