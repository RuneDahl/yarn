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
     * Returns the adjusted date/time from the specified date/time using the
     * rules and values of this business days.
     * @param dateTime Date/time.
     * @return The adjusted date/time.
     */
    public TypeOfCalendar adjust(final TypeOfCalendar dateTime);

    /**
     * Returns the specified date/time shifted the number of times using the
     * period of this business days while not counting the holidays.<br>
     * The shifted date/time will be a business day according to this instance.
     * @param dateTime Date/time.
     * @param count    Number of shifts to apply.
     * @return The shifted date/time.
     */
    public TypeOfCalendar shift(final TypeOfCalendar dateTime,
            final int count);
}