/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

import java.util.GregorianCalendar;

/**
 * An abstract
 * <a href="http://en.wikipedia.org/wiki/Day_count_convention">day count convention</a>
 * in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * <br>This abstract day count convention is based on the assumption that whether
 * or not to adjust a date/time is determined entirely by the date/time
 * and the day count convention.
 * @author Rune Dahl Iversen
 */
public abstract class Gregorian implements DayCount<GregorianCalendar> {
    /**
     * Returns the length of the period between the 2 specified date/times.
     * @param from From date/time.
     * @param to   To date/time.
     * @return     The length of the period between the 2 specified date/times.
     */
    public final double Days(final GregorianCalendar from, final GregorianCalendar to) {
        if (0 < from.compareTo(to))
            return -Days(to, from);

        final GregorianCalendar f = this._Adjust(from);
        final GregorianCalendar t = this._Adjust(to);

        double difference = Time.Gregorian.belowDateDifference(from, to);
        difference += t.get(GregorianCalendar.DATE) - f.get(GregorianCalendar.DATE);

        final int fromMonth = f.get(GregorianCalendar.MONTH);
        final int fromYear = f.get(GregorianCalendar.YEAR);
        final int toMonth = t.get(GregorianCalendar.MONTH);
        final int toYear = t.get(GregorianCalendar.YEAR);

        for (int month = 0; month < 12; month++)
        {
            if (month < fromMonth)
                difference -= this.Month(fromYear, month);
            if (month < toMonth)
                difference += this.Month(toYear, month);
        }
        for (int year = fromYear; year < toYear; year++)
            difference += this.Year(year);
        return difference;
    }

    /**
     * Returns the adjusted date/time according to this daycount rule.
     * @param date Date/time.
     * @return     The adjusted date/time according to this daycount rule.
     */
    protected abstract GregorianCalendar _Adjust(final GregorianCalendar date);
}