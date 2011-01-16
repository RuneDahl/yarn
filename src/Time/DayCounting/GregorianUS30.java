/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

import java.util.GregorianCalendar;

/**
 * The {@see DayCount day count convention} counting every
 * <a href="http://en.wikipedia.org/wiki/Month">month</a> as 30 days and
 * <a href="http://en.wikipedia.org/wiki/Year">years</a> as 360 days as well as
 * adjusting the dates according to a complicated rule.<br>
 * See for instance: <a href="http://en.wikipedia.org/wiki/Day_count_convention#30.2F360_US">
 * ISDA 30U/360 on Wikipedia</a>.<br>
 * (This implementation does not consider the two "investment is EOM" rules when
 * adjusting the date/times, since no specific investment is considered here.)
 * @author Rune Dahl Iversen
 */
public final class GregorianUS30 implements DayCount<GregorianCalendar> {
    /**
     * Returns the length of the period between the 2 specified date/times.
     * @param from From date/time.
     * @param to   To date/time.
     * @return     The length of the period between the 2 specified date/times.
     */
    @Override
    public double days(final GregorianCalendar from, final GregorianCalendar to) {
        if (0 < from.compareTo(to))
            return -this.days(to, from);
        GregorianCalendar f = _AdjustFrom(from);
        GregorianCalendar t = _AdjustTo(from, to);
        double difference = Time.Gregorian.belowDateDifference(f, t);

        difference += t.get(GregorianCalendar.DATE) - f.get(GregorianCalendar.DATE);
        difference += 30.0 * (t.get(GregorianCalendar.MONTH) - f.get(GregorianCalendar.MONTH));
        difference += 360.0 * (t.get(GregorianCalendar.YEAR) - f.get(GregorianCalendar.YEAR));
        return difference;
    }

    /**
     * Returns the length in days of the specified month of the specified year.
     * @param year  Year.
     * @param month Month.
     * @return      The length in days of the specified month of the specified year.
     */
    @Override
    public double month(final int year, final int month) {
        if (month < 0 || 11 < month)
            throw new IllegalArgumentException("Month out of range.");
        return 30.0;
    }

    /**
     * Returns the length in days of the specified year.
     * @param year  Year.
     * @return      The length in days of the specified year.
     */
    @Override
    public double year(final int year) {
        return 360.0;
    }

    /**
     * Gets a string representation of this daycount when acting as a denominator.
     * @return String representation of this daycount when acting as a denominator.
     */
    @Override
    public String getDenominator() {
        return "360";
    }

    /**
     * Gets a string representation of this daycount when acting as a numerator.
     * @return String representation of this daycount when acting as a numerator.
     */
    @Override
    public String getNumerator() {
        return "30U";
    }

    private GregorianCalendar _AdjustFrom(final GregorianCalendar from) {
        GregorianCalendar adjusted = (GregorianCalendar)from.clone();
        if (adjusted.get(GregorianCalendar.DAY_OF_MONTH) == 31)
            adjusted.set(GregorianCalendar.DAY_OF_MONTH, 30);
        return adjusted;
    }

    private GregorianCalendar _AdjustTo(final GregorianCalendar from,
            final GregorianCalendar to) {
        GregorianCalendar adjusted = (GregorianCalendar)to.clone();
        if (adjusted.get(GregorianCalendar.DAY_OF_MONTH) == 31 &&
                30 <= from.get(GregorianCalendar.DAY_OF_MONTH))
            adjusted.set(GregorianCalendar.DAY_OF_MONTH, 30);
        return adjusted;
    }
}