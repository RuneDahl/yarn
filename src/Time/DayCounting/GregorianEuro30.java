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
 * moving any date on the 31st to the 30th before measuring the difference.
 * <br>See for instance: <a href="http://en.wikipedia.org/wiki/Day_count_convention#30E.2F360">
 * ISDA 30E/360 on Wikipedia</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianEuro30 extends Gregorian {
    /**
     * Returns the length in days of the specified month of the specified year.
     * @param year  Year.
     * @param month Month.
     * @return      The length in days of the specified month of the specified year.
     */
    @Override
    public double month(final int year, final int month) {
        return 30.0;
    }

    /**
     * Returns the length in days of the specified year.
     * @param year Year.
     * @return     The length in days of the specified year.
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
        return "30E";
    }

    /**
     * Returns the adjusted date/time according to the GregorianEuro30 daycountrule.
     * @param date Date/time.
     * @return     The adjusted date/time according to the GregorianEuro30 daycountrule.
     */
    @Override
    protected GregorianCalendar _Adjust(final GregorianCalendar date)
    {
        GregorianCalendar adjusted = (GregorianCalendar)date.clone();
        if (adjusted.get(GregorianCalendar.DAY_OF_MONTH) == 31) {
            adjusted.set(GregorianCalendar.DAY_OF_MONTH, 30);
        }
        return adjusted;
    }
}