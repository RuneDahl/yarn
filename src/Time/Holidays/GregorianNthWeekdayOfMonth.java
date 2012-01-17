/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.Holidays;

import Time.Gregorian;
import java.util.GregorianCalendar;

/**
 * Implementation of a {@see Holiday holiday} on the specified occurrence of
 * the day of the week in the specified month.
 * @author Rune Dahl Iversen
 */
public final class GregorianNthWeekdayOfMonth
    extends WeekdayOccurrence<GregorianCalendar>
    implements AnnuallyRecurring<GregorianCalendar> {
    private static final Validation.Validator<Integer> __monthValidator =
            Validation.Factory.BoundedInteger(0, 11);
    
    private int _month;

    /**
     * Create a annually recurring holiday in the Gregorian calendar on the 
     * specified occurrence of the day of the week in the specified month.
     * @param month   Month.
     * @param weekday Day of the week.
     * @param occurrence   Number of occurrence.
     */
    public GregorianNthWeekdayOfMonth(
            final int month, final int weekday, final int occurrence) {
        super(occurrence, weekday);
        this.setMonth(month);
    }
    
    /**
     * Returns the month of this holiday.
     * @return The month of this holiday.
     */
    public int getMonth() {
        return this._month;
    }
    
    /**
     * Sets the month of this holiday.
     * @param month Month.
     */
    public void setMonth(final int month) {
        if (!__monthValidator.isValid(month))
            throw new IllegalArgumentException(
                    __monthValidator.message(month, "Month"));
        this._month = month;
    }

    @Override
    public GregorianCalendar getHoliday(final int year) {
        if (this.occurs(year))
            return new GregorianCalendar(year, this._month,
                    Gregorian.dateOfNthWeekdayFromStartOfMonth(
                    this.getOccurrence(), this.getWeekday(), year, this._month));
        throw new NullPointerException("This holiday does not occur in " +
                "the specified year: " + Integer.toString(year) + ".");
    }

    @Override
    public boolean occurs(final int year) {
        return Gregorian.nthWeekdayOfMonthOccurs(
                this.getOccurrence(), this.getWeekday(), year, this._month);
    }

    @Override
    public boolean isHoliday(final GregorianCalendar dateTime) {
        int year = dateTime.get(GregorianCalendar.YEAR);
        int month = dateTime.get(GregorianCalendar.MONTH);
        return month == this._month &&
                Gregorian.dateOfNthWeekdayFromStartOfMonth(
                this.getOccurrence(), this.getWeekday(), year, this._month) ==
                dateTime.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
