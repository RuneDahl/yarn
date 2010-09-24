/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

/**
 * Interface for {@see Holiday holiday} that occurs no more than once per
 * <a href="http://en.wikipedia.org/wiki/Year">year</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public interface AnnuallyRecurring<TypeOfCalendar>
        extends Holiday<TypeOfCalendar> {
    /**
     * Returns the holiday for the specified year - if it exists.
     * @param year  Year.
     * @return      The holiday for the specified year.
     */
    public TypeOfCalendar getHoliday(final int year);

    /**
     * Returns whether the holiday occurs/exists for the specified year.
     * @param year  Year.
     * @return      Whether the holiday occurs/exists for the specified year.
     */
    public boolean Occurs(final int year);
}