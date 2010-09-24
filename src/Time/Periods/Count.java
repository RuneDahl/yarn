/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

/**
 * Abstract implementation of a {@see Period period} for a type of calendar
 * with a {@see Mathematics.Count count}.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public abstract class Count<TypeOfCalendar>
        implements Period<TypeOfCalendar>, Mathematics.Count {
    private int _count;

    /**
     * Initializes a new instance of a {@see Mathematics.Count counted}
     * {@see Period period} with the specified count.
     * @param count Count to be set.
     */
    protected Count(final int count){
        this.setCount(count);
    }

    public final int getCount() {
        return this._count;
    }

    public final void setCount(final int count) {
        this._count = count;
    }
}