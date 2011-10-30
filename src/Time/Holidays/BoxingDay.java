/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of the <a href="http://en.wikipedia.org/wiki/Boxing_Day">
 * Boxing Day</a> as a {@see Holiday holiday}.
 * The Boxing Day is in use in the <a href="http://en.wikipedia.org/wiki/UK">
 * United Kingdom</a> and parts of the
 * <a href="http://en.wikipedia.org/wiki/Commonwealth_of_Nations">Commonwealth
 * of Nations</a>.
 * @author Rune Dahl Iversen
 */
public final class BoxingDay
        implements AnnuallyRecurring<GregorianCalendar> {
    /**
     * Create a holiday consisting of the Boxing Day.
     */
    public BoxingDay() { // Intentional
    }

    @Override
    public GregorianCalendar getHoliday(final int year) {
        GregorianCalendar holiday = new GregorianCalendar(year, 11, 26);
        int dayOfWeek = holiday.get(GregorianCalendar.DAY_OF_WEEK);
        if (dayOfWeek == GregorianCalendar.SATURDAY ||
                dayOfWeek == GregorianCalendar.SUNDAY)
            holiday.add(GregorianCalendar.DATE, 2);
        return holiday;
    }

    @Override
    public boolean occurs(final int year) {
        return true;
    }

    @Override
    public boolean isHoliday(final GregorianCalendar dateTime) {
        GregorianCalendar boxingDay =
                this.getHoliday(dateTime.get(GregorianCalendar.YEAR));
        return boxingDay.get(GregorianCalendar.YEAR) == dateTime.get(GregorianCalendar.YEAR) &&
                boxingDay.get(GregorianCalendar.MONTH) == dateTime.get(GregorianCalendar.MONTH) &&
                boxingDay.get(GregorianCalendar.DATE) == dateTime.get(GregorianCalendar.DATE);
    }
}
