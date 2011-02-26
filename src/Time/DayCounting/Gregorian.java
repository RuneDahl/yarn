/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

import java.util.GregorianCalendar;

/**
 * An abstract {@see DayCount day count convention} in the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian calendar</a>.
 * <br>This abstract day count convention is based on the assumption that
 * whether or not to adjust a date/time is determined entirely by the date/time
 * and the day count convention.
 * @author Rune Dahl Iversen
 */
public abstract class Gregorian implements DayCount<GregorianCalendar> {
    @Override
    public final double days(final GregorianCalendar from, final GregorianCalendar to) {
        if (0 < from.compareTo(to))
            return -this.days(to, from);

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
                difference -= this.month(fromYear, month);
            if (month < toMonth)
                difference += this.month(toYear, month);
        }
        for (int year = fromYear; year < toYear; year++)
            difference += this.year(year);
        return difference;
    }

    /**
     * Returns the adjusted date/time according to this daycount rule.
     * @param date Date/time.
     * @return     The adjusted date/time according to this daycount rule.
     */
    protected abstract GregorianCalendar _Adjust(final GregorianCalendar date);
}