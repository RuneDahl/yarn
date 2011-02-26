/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

/**
 * Interface for a <a href="http://en.wikipedia.org/wiki/Day_count_convention">
 * day count convention</a>.<br>
 * A day count convention is a method to translate the time between
 * two date/times (within a calendar) into a number of days.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public interface DayCount<TypeOfCalendar>
{
    /**
     * Returns the length in days of the period between the 2 specified date/times.
     * @param from From date/time.
     * @param to   To date/time.
     * @return     The length of the period between the 2 specified date/times.
     */
    public double days(final TypeOfCalendar from, final TypeOfCalendar to);

    /**
     * Returns the length in days of the specified month of the specified year.
     * @param year  Year.
     * @param month Month.
     * @return      The length in days of the specified month of the specified year.
     */
    public double month(final int year, final int month);

    /**
     * Returns the length in days of the specified year.
     * @param year  Year.
     * @return      The length in days of the specified year.
     */
    public double year(final int year);

    /**
     * Gets a string representation of this daycount when acting as a denominator.
     * @return String representation of this daycount when acting as a denominator.
     */
    public String getDenominator();

    /**
     * Gets a string representation of this daycount when acting as a numerator.
     * @return String representation of this daycount when acting as a numerator.
     */
    public String getNumerator();
}