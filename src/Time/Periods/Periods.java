/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A collection of {@see Period periods}.
 * @param <TypeOfCalendar> Type of calendar.
 * @author Rune Dahl Iversen
 */
public final class Periods<TypeOfCalendar>
        extends ArrayList<Period<TypeOfCalendar>>
        implements Mathematics.Count, Period<TypeOfCalendar> {
    private int _count;

    /**
     * Create an empty collection of periods.
     * @param count Number of times to apply the periods.
     */
    public Periods(final int count) {
        super();
        this.setCount(count);
    }

    /**
     * Create a collection of periods of the specified periods
     * and number of times.
     * @param count   Number of times to apply the periods.
     * @param periods Periods.
     */
    public Periods(final int count,
            final Period<TypeOfCalendar>... periods) {
        this(count);
        if (periods != null)
            for (Period<TypeOfCalendar> p : periods)
                this.add(p);
    }

    /**
     * Create a collection of periods of the specified periods
     * and number of times.
     * @param count   Number of times to apply the periods.
     * @param periods Periods.
     */
    public Periods(final int count,
            final Collection<? extends Period<TypeOfCalendar>> periods) {
        super(periods);
        this.setCount(count);
    }

    @Override
    public int getCount() {
        return this._count;
    }

    @Override
    public void setCount(final int count) {
        this._count = count;
    }

    @Override
    public TypeOfCalendar shift(TypeOfCalendar date, final int count) {
        if (date == null)
            throw new NullPointerException("date");
        TypeOfCalendar shifted = date;
        int totalCount = count * this.getCount();
        int direction = (int)Math.signum(totalCount);
        for (int i = 0; i < Math.abs(totalCount); i++)
            for (Period<TypeOfCalendar> period : this)
                shifted = period.shift(shifted, direction);
        return shifted;
    }
}