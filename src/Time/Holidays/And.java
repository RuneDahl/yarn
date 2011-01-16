/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A collection of {@see Holiday holidays} using 'logical and' to compose the holidays.
 * @param <TypeOfCalendar> Type of calendar of the holidays.
 * @author Rune Dahl Iversen
 */
public final class And<TypeOfCalendar>
        extends ArrayList<Holiday<TypeOfCalendar>>
        implements Holiday<TypeOfCalendar> {
    /**
     * Create an empty collection of holidays.
     */
    public And() {
        super();
    }

    /**
     * Create a collection of holidays containing the specified holidays.
     * @param holidays Holidays.
     */
    public And(final Holiday<TypeOfCalendar>... holidays) {
        this();
        for (Holiday<TypeOfCalendar> h : holidays)
            this.add(h);
    }

    /**
     * Create a collection of holidays containing the specified holidays.
     * @param holidays Holidays.
     */
    public And(final Collection<? extends Holiday<TypeOfCalendar>> holidays) {
        super(holidays);
    }

    /**
     * Returns whether the specified date/time is a holiday
     * to all of the holidays in this collection.
     * @param date Date/time.
     * @return     Whether the specified date/time is a holiday
     *             to all of the holidays in this collection.
     */
    @Override
    public boolean isHoliday(final TypeOfCalendar date) {
        for (Holiday<TypeOfCalendar> holiday : this)
            if (!holiday.isHoliday(date))
                return false;
        return true;
    }
}