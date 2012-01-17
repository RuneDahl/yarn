/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays.UnitedStates;

import Time.Holidays.AnnuallyRecurring;
import java.util.GregorianCalendar;

/**
 * Implementation of <a href="http://en.wikipedia.org/wiki/Christmas_Day">
 * Christmas day</a> as a {@see Holiday holiday}.
 * This implementation of Christmas day is commonly observed in the
 * <a href="http://en.wikipedia.org/wiki/USA">United States of America</a>.<br>
 * It allows for the moving of the holiday, should December 25th be a Sunday.
 * @author Rune Dahl Iversen
 */
public final class ChristmasDay
        implements AnnuallyRecurring<GregorianCalendar> {
    /**
     * Create a holiday consisting of Christmas day.
     * As commonly observed in the United States of America.
     */
    public ChristmasDay() { // Intentional
    }

    @Override
    public GregorianCalendar getHoliday(final int year) {
        GregorianCalendar holiday = new GregorianCalendar(year, 11, 25);
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
        GregorianCalendar christmas =
                this.getHoliday(dateTime.get(GregorianCalendar.YEAR));
        return 11 == dateTime.get(GregorianCalendar.MONTH) &&
                christmas.get(GregorianCalendar.DATE) ==
                dateTime.get(GregorianCalendar.DATE);
    }
}
