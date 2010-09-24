/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import Time.Periods.Period;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of a set of {@see Holiday holidays} that occur relative
 * to a specific/central holiday.
 * <br>The relative positions of the related holidays are specified using
 * {@see Period periods} The periods are individually subtracted from the
 * date/time being tested and these shifted date/times are then tested using
 * the central holiday.<br>
 * So specifying a holiday 40 days after the central holiday would use a period
 * of +40 days. And a holiday 3 weeks prior to the central holiday would use a
 * period of -3 weeks.
 * @param <TypeOfCalendar> Type of calendar.
 * @author Rune Dahl Iversen
 */
public final class Relatives<TypeOfCalendar>
        extends ArrayList<Period<TypeOfCalendar>>
        implements Holiday<TypeOfCalendar>{
    private Holiday<TypeOfCalendar> _centralHoliday;

    /**
     * Creates a collection of holidays relative to the specified
     * central holiday using the specified list of periods.
     * @param centralHoliday Central holiday.
     * @param periods        List of periods.
     */
    protected Relatives(final Holiday<TypeOfCalendar> centralHoliday,
            final Collection<? extends Period<TypeOfCalendar>> periods) {
        super(periods);
        this.setCentralHoliday(centralHoliday);
    }

    /**
     * Returns the central holiday.
     * @return Holiday.
     */
    public Holiday<TypeOfCalendar> getCentralHoliday() {
        return this._centralHoliday;
    }

    /**
     * Sets the central holiday.
     * @param centralHoliday Holiday.
     * @exception NullPointerException Central holiday not properly specified.
     */
    public void setCentralHoliday(final Holiday<TypeOfCalendar> centralHoliday) {
        if (centralHoliday == null)
            throw new NullPointerException("Central holiday not properly specified.");
        this._centralHoliday = centralHoliday;
    }

    /**
     * Returns whether the specified date, shifted by one of the periods
     * is a holiday to the central holiday.
     * @param date Date/time.
     * @return     Whether the specified date, shifted by one of the periods
     *             is a holiday to the central holiday.
     */
    public boolean isHoliday(final TypeOfCalendar date) {
        for (Period<TypeOfCalendar> p : this) {
            TypeOfCalendar d = p.Shift(date, -1);
            if (this._centralHoliday.isHoliday(d))
                return true;
        }
        return false;
    }
}