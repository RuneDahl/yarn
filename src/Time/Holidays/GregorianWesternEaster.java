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
 * Western <a href="http://en.wikipedia.org/wiki/Easter">Easter</a>.<br>
 * The algorithm is here is due to David Hodges and was found on
 * <a href="http://www.gmarts.org/index.php?go=415">GM Arts -
 * Easter Date Algorithms</a>. (It is a wrapping of the "Function EasterHodges".)<br>
 * The algorithm is a refinement of
 * <a href="http://calendars.wikia.com/wiki/Computus#Meeus.2FJones.2FButcher_Gregorian_algorithm">
 * Butcher's Ecclesiastical Calendar (1876)</a>.<br>
 * This Easter only applies to the
 * <a href="http://en.wikipedia.org/wiki/Western_Christianity">Western Christianity</a>
 * Easter within the
 * Gregorian calendar. That is not to Easter in the
 * <a href="http://en.wikipedia.org/wiki/Julian_calendar">Julian calendar</a>
 * nor to the Easter celebrated by the
 * <a href="http://en.wikipedia.org/wiki/Eastern_Christianity">Eastern Christianity</a>.
 * @author Rune Dahl Iversen
 */
public final class GregorianWesternEaster
        implements AnnuallyRecurring<GregorianCalendar> {
    private Hashtable<Integer, GregorianCalendar> _easters =
            new Hashtable<Integer, GregorianCalendar>();

    /**
     * Create a Gregorian Easter.
     */
    public GregorianWesternEaster() {
    }

    /**
     * Returns the Easter Sunday in the Gregorian Calendar occuring in the specified year.
     * @param year Year.
     * @return     The Easter Sunday in the Gregorian Calendar occuring in the specified year.
     * @exception  NullPointerException Gregorian Easter does not occur/
     *             cannot be computed for the specified year.
     */
    public GregorianCalendar getHoliday(final int year) {
        if (!this.Occurs(year))
            throw new NullPointerException("Gregorian Easter does not occur/" +
                    "cannot be computed for the specified year " +
                    Integer.toString(year) + ".");
        if (this._easters.containsKey(year))
            return this._easters.get(year);

        int a, b, c, d, e, f, g, h, j, k, m, n, p;

        a = year / 100;
        b = year % 100;
        c = (3 * (a + 25)) / 4;
        d = (3 * (a + 25)) % 4;
        e = (8 * (a + 11)) / 25;
        f = ((5 * a) + b) % 19;
        g = ((19 * f) + c - e) % 30;
        h = (f + (11 * g)) / 319;
        j = ((60 * (5 - d)) + b) / 4;
        k = ((60 * (5 - d)) + b) % 4;
        m = ((2 * j) - k - g + h) % 7;
        n = (g - h + m + 114) / 31;
        p = (g - h + m + 114) % 31;

        GregorianCalendar easter = new GregorianCalendar(year, n - 1, p + 1);
        this._easters.put(year, easter);
        return easter;
    }

    /**
     * Returns whether the Gregorian Easter occurs/can be computed for the
     * specified year.
     * @param year Year.
     * @return     Whether the Gregorian Easter occurs/can be computed for the
     *             specified year.
     */
    public boolean Occurs(final int year) {
        return 1582 < year && year < 4100;
    }

    /**
     * Returns whether the specified date/time is on Easter Sunday.
     * @param date Date/time.
     * @return     Whether the specified date/time is on Easter Sunday.
     */
    public boolean isHoliday(final GregorianCalendar date) {
        int year = date.get(GregorianCalendar.YEAR);
        if (!this.Occurs(year))
            return false;
        GregorianCalendar easter = this.getHoliday(year);
        return date.get(GregorianCalendar.DATE) == easter.get(GregorianCalendar.DATE) &&
                date.get(GregorianCalendar.MONTH) == easter.get(GregorianCalendar.MONTH) &&
                date.get(GregorianCalendar.YEAR) == easter.get(GregorianCalendar.YEAR);
    }
}