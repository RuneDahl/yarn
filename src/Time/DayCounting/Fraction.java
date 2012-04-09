/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.DayCounting;

/**
 * Interface for a <a href="http://en.wikipedia.org/wiki/Daycount_Convention">
 * day counting fraction</a> used for converting the span of time between two
 * date/times into a number representing the amount of time
 * between the specified date/times.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public interface Fraction<TypeOfCalendar> {
    /**
     * Gets a string representation of this day counting fraction.
     * @return The name.
     */
    public String getName();

    /**
     * Gets the time measured in periods from the specified start date/time to the end.
     * @param start Start date/time.
     * @param end   End date/time.
     * @return      The time from the start to the end date/time measured as periods.
     */
    public double getTime(TypeOfCalendar start, TypeOfCalendar end);
}
