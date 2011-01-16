/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;
import java.util.Hashtable;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian</a>
 * Eastern <a href="http://en.wikipedia.org/wiki/Easter">Easter</a>.<br>
 * The heart of the algorithm is here is due to Ron Mallen and was found on
 * <a href="http://www.gmarts.org/index.php?go=415">GM Arts - Easter Date Algorithms</a>.
 * (It is a cut-out from the "Function EasterMallen".)<br>
 * This Easter only applies to the
 * <a href="http://en.wikipedia.org/wiki/Eastern_Christianity">Eastern Christianity</a>
 * Easter within the Gregorian calendar. That is not to Easter in the
 * <a href="http://en.wikipedia.org/wiki/Julian_calendar">Julian calendar</a>
 * nor to the Easter celebrated by the
 * <a href="http://en.wikipedia.org/wiki/Western_Christianity">Western Christianity</a>.<br>
 * This implementation is limited in validity to the years 1583 through 4099
 * (both included).
 * @author Rune Dahl Iversen
 */
public final class GregorianEasternEaster
        implements AnnuallyRecurring<GregorianCalendar> {
    // A cache of computed easter dates. This should speed up results.
    private static final Hashtable<Integer, GregorianCalendar> __easters =
            new Hashtable<Integer, GregorianCalendar>();

    /**
     * Create a Gregorian Eastern Easter.
     */
    public GregorianEasternEaster() { // Intentional
    }

    /**
     * Returns the Easter Sunday in the Gregorian Calendar occuring in the specified year.
     * @param year Year.
     * @return     The Easter Sunday in the Gregorian Calendar occuring in the specified year.
     * @exception  NullPointerException Gregorian Easter does not occur/
     *             cannot be computed for the specified year.
     */
    @Override
    public GregorianCalendar getHoliday(final int year) {
        if (!this.occurs(year))
            throw new NullPointerException("Gregorian Easter does not occur/" +
                    "cannot be computed for the specified year " +
                    Integer.toString(year) + ".");
        if (__easters.containsKey(year))
            return __easters.get(year);

        int d, m, centuryDigits, remainder19, yearDigits;
        int tA, tB, tC, tD, tE;

        centuryDigits = year / 100;
        yearDigits = year % 100;
        remainder19 = year % 19;

        tA = ((225 - 11*remainder19) % 30) + 21;
        tB = (tA - 19) % 7;
        tC = (40 - centuryDigits) % 7;
        tD = (yearDigits + yearDigits / 4) % 7;
        tE =((20 - tB - tC - tD) % 7) + 1;

        d = tA + tE;
        d += Time.Gregorian.correctionInDaysFromJulianToGregorian(year);

        if (61 < d) {
            d -= 61;
            m = 5;
        } else if (31 < d) {
            d -= 31;
            m = 4;
        } else
            m = 3;

        GregorianCalendar easter = new GregorianCalendar(year, m - 1, d);
        __easters.put(year, easter);
        return easter;
    }

    /**
     * Returns whether the Gregorian Easter occurs/can be computed for the
     * specified year.
     * @param year Year.
     * @return     Whether the Gregorian Easter occurs/can be computed for the
     *             specified year.
     */
    @Override
    public boolean occurs(final int year) {
        return 1582 < year && year < 4100;
    }

    /**
     * Returns whether the specified date/time is on Easter Sunday.
     * @param date Date/time.
     * @return     Whether the specified date/time is on Easter Sunday.
     */
    @Override
    public boolean isHoliday(final GregorianCalendar date) {
        int year = date.get(GregorianCalendar.YEAR);
        if (!this.occurs(year))
            return false;
        GregorianCalendar easter = this.getHoliday(year);
        return date.get(GregorianCalendar.DATE) == easter.get(GregorianCalendar.DATE) &&
                date.get(GregorianCalendar.MONTH) == easter.get(GregorianCalendar.MONTH);
    }
}