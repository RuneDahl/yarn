/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.Holidays.UnitedStates;

import Time.Holidays.AnnuallyRecurring;
import java.util.GregorianCalendar;

/**
 * {@see Holiday} implementing the
 * <a href="http://en.wikipedia.org/wiki/New_Year%27s_Day">New Year's Day</a>
 * as observed in the
 * <a href="http://en.wikipedia.org/wiki/USA">United States of America</a>.<br>
 * This holiday shifts to January 2nd should January 1st be a Sunday.
 * @author Rune Dahl Iversen
 */
public final class NewYearsDay
    implements AnnuallyRecurring<GregorianCalendar> {

    @Override
    public GregorianCalendar getHoliday(final int year) {
        GregorianCalendar holiday = new GregorianCalendar(year, 0, 1);
        if (holiday.get(GregorianCalendar.DAY_OF_WEEK) ==
                GregorianCalendar.SUNDAY)
            holiday.add(GregorianCalendar.DATE, 1);
        return holiday;
    }

    @Override
    public boolean occurs(final int year) {
        return true;
    }

    @Override
    public boolean isHoliday(final GregorianCalendar dateTime) {
        int day = dateTime.get(GregorianCalendar.DAY_OF_MONTH);
        int month = dateTime.get(GregorianCalendar.MONTH);
        int year = dateTime.get(GregorianCalendar.YEAR);
        return (month == 0 &&
                day == this.getHoliday(year).get(GregorianCalendar.DAY_OF_MONTH));
    }
}
