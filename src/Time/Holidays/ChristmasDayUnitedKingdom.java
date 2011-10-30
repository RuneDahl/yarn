/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of <a href="http://en.wikipedia.org/wiki/Christmas_Day">
 * Christmas day</a> as a {@see Holiday holiday}.
 * This implementation of Christmas day is in use in the financial industry of the
 * <a href="http://en.wikipedia.org/wiki/UK">United Kingdom</a> and parts of the
 * <a href="http://en.wikipedia.org/wiki/Commonwealth_of_Nations">Commonwealth
 * of Nations</a>.<br>
 * It allows for the moving of the holiday, should December 25th be a saturday.
 * @author Rune Dahl Iversen
 */
public final class ChristmasDayUnitedKingdom
        implements AnnuallyRecurring<GregorianCalendar> {
    /**
     * Create a holiday consisting of Christmas day.
     * As commonly used by the financial industry in the UK.
     */
    public ChristmasDayUnitedKingdom() { // Intentional
    }

    @Override
    public GregorianCalendar getHoliday(final int year) {
        GregorianCalendar holiday = new GregorianCalendar(year, 11, 25);
        int dayOfWeek = holiday.get(GregorianCalendar.DAY_OF_WEEK);
        if (dayOfWeek == GregorianCalendar.SATURDAY)
            holiday.add(GregorianCalendar.DATE, 2);
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
        return christmas.get(GregorianCalendar.YEAR) == dateTime.get(GregorianCalendar.YEAR) &&
                christmas.get(GregorianCalendar.MONTH) == dateTime.get(GregorianCalendar.MONTH) &&
                christmas.get(GregorianCalendar.DATE) == dateTime.get(GregorianCalendar.DATE);
    }
}
