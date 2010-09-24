/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

/**
 * Interface for a <a href="http://en.wikipedia.org/wiki/Holiday">holiday</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public interface Holiday<TypeOfCalendar> {
    /**
     * Returns whether the specified date/time is a holiday.
     * @param dateTime Date/time.
     * @return         Whether the specified date/time is a holiday.
     */
    public boolean isHoliday(final TypeOfCalendar dateTime);
}