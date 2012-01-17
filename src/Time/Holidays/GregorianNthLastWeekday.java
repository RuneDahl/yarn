/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.Holidays;

import Time.Gregorian;
import java.util.GregorianCalendar;

/**
 * Implementation of a {@see Holiday holiday} that occurs on a set count of the
 * specified weekday every month.
 * @author Rune Dahl Iversen
 */
public final class GregorianNthLastWeekday
    extends WeekdayOccurrence<GregorianCalendar>
    implements MonthlyRecurring<GregorianCalendar> {

    /**
     * Create a monthly recurring holiday in the Gregorian calendar on the 
     * specified day of the week.
     * @param weekday Day of the week.
     * @param count   Number of occurrence.
     */
    public GregorianNthLastWeekday(final int weekday, final int count) {
        super(count, weekday);
    }
    
    @Override
    public GregorianCalendar getHoliday(final int year, final int month) {
        if (this.occurs(year, month))
            return new GregorianCalendar(year, month,
                    Gregorian.dateOfNthWeekdayFromEndOfMonth(
                    this.getOccurrence(), this.getWeekday(), year, month));
        throw new NullPointerException("This holiday does not occur in " +
                "the specified year and month: " + Integer.toString(year) +
                " " + Integer.toString(month) + ".");
    }

    @Override
    public boolean occurs(final int year, final int month) {
        return Gregorian.nthWeekdayOfMonthOccurs(
                this.getOccurrence(), this.getWeekday(), year, month);
    }

    @Override
    public boolean isHoliday(final GregorianCalendar dateTime) {
        int year = dateTime.get(GregorianCalendar.YEAR);
        int month = dateTime.get(GregorianCalendar.MONTH);
        return Gregorian.dateOfNthWeekdayFromEndOfMonth(
                this.getOccurrence(), this.getWeekday(), year, month) ==
                dateTime.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
