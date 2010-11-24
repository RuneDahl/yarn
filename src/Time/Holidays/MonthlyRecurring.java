/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

/**
 * Interface for {@see Holiday holiday} that occurs no more than once per
 * <<a href="http://en.wikipedia.org/wiki/Month">month</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public interface MonthlyRecurring<TypeOfCalendar>
        extends Holiday<TypeOfCalendar> {
    /**
     * Returns the holiday for the specified year and month - if it exists.
     * @param year  Year.
     * @param month Month.
     * @return      The holiday for the specified year and month.
     */
    public TypeOfCalendar getHoliday(final int year, final int month);

    /**
     * Returns whether the holiday occurs/exists for the specified year and month.
     * @param year  Year.
     * @param month Month.
     * @return      Whether the holiday occurs/exists for the specified year and month.
     */
    public boolean occurs(final int year, final int month);
}