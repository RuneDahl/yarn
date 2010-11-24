/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

/**
 * Interface for a period of time relative to a calendar.
 * Periods may add and subtract to specified calendars/dates.
 * @param <TypeOfCalendar> Type of calendar.
 * Allows construction of periods for different calendars.
 * @author Rune Dahl Iversen
 */
public interface Period<TypeOfCalendar> {
    /**
     * Returns the specified date/time shifted by this period the specified
     * number of times.
     * @param date  Date/time.
     * @param count Number of times to apply this period.
     * @return      The date/time shifted by this period
     * the specified number of of times.
     */
    public TypeOfCalendar shift(final TypeOfCalendar date, final int count);
}