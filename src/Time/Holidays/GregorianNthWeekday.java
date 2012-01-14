/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.Holidays;

import Time.Gregorian;
import java.util.GregorianCalendar;

/**
 *
 * @author Rune Dahl Iversen
 */
public final class GregorianNthWeekday
    implements MonthlyRecurring<GregorianCalendar> {
    private static final Validation.Validator<Integer> __countValidator =
            Validation.Factory.BoundedInteger(1, 5);
    private static final Validation.Validator<Integer> __weekdayValidator =
            Validation.Factory.BoundedInteger(1, 7);
    
    private int _weekday;
    private int _count;

    /**
     * Create a monthly recurring holiday in the Gregorian calendar on the 
     * specified day of the week.
     * @param weekday Day of the week.
     * @param count   Number of occurrence.
     */
    public GregorianNthWeekday(final int weekday, final int count) {
        this.setCount(count);
        this.setWeekday(weekday);
    }
    
    public int getCount() {
        return this._count;
    }
    
    public void setCount(final int count) {
        Integer c = count;
        if (!__countValidator.isValid(c))
            throw new IllegalArgumentException(
                    __countValidator.message(c, "Count"));
        this._count = count;
    }

    /**
     * Returns the day of week of this holiday.
     * @return The day of week of this holiday.
     */
    public int getWeekday() {
        return this._weekday;
    }

    /**
     * Sets the day of week of this holiday.
     * @param weekday The day of week of this holiday.
     */
    public void setWeekday(final int weekday) {
        if (!__weekdayValidator.isValid(weekday))
            throw new IllegalArgumentException(
                    __weekdayValidator.message(weekday, "Weekday"));
        this._weekday = weekday;
    }

    @Override
    public GregorianCalendar getHoliday(final int year, final int month) {
        if (this.occurs(year, month))
            return new GregorianCalendar(year, month,
                    Gregorian.daysToNthWeekdayFromStartOfMonth(
                    this._count, this._weekday, year, month));
        throw new NullPointerException("This holiday does not occur in " +
                "the specified year and month: " + Integer.toString(year) +
                " " + Integer.toString(month) + ".");
    }

    @Override
    public boolean occurs(final int year, final int month) {
        return Gregorian.nthWeekdayOfMonthOccurs(
                this._count, this._weekday, year, month);
    }

    @Override
    public boolean isHoliday(GregorianCalendar dateTime) {
        int year = dateTime.get(GregorianCalendar.YEAR);
        int month = dateTime.get(GregorianCalendar.MONTH);
        return Gregorian.daysToNthWeekdayFromStartOfMonth(
                this._count, this._weekday, year, month) ==
                dateTime.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
