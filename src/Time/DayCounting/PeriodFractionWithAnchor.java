/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.DayCounting;

import Time.Periods.Period;
import java.util.Calendar;

/**
 * Abstract implementation of a {@see Fraction daycounting fraction} based on
 * a {@see Period date/time period}, {@see Calendar anchor date/time} and
 * two {@see DayCount day count conventions}.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public abstract class PeriodFractionWithAnchor<TypeOfCalendar>
        implements Fraction<TypeOfCalendar> {
    private TypeOfCalendar _anchor;
    private DayCount<TypeOfCalendar> _denominator;
    private DayCount<TypeOfCalendar> _numerator;
    private Period<TypeOfCalendar> _period;
    
    /**
     * Creates an instance with the specified values.
     * @param numerator   Numerator day count convention.
     * @param denominator Denominator day count convention.
     * @param period      Date/time period.
     * @param anchor      Anchor date/time.
     */
    protected PeriodFractionWithAnchor(
            final DayCount<TypeOfCalendar> numerator,
            final DayCount<TypeOfCalendar> denominator,
            final Period<TypeOfCalendar> period,
            final TypeOfCalendar anchor) {
        this.setAnchor(anchor);
        this.setDenominator(denominator);
        this.setNumerator(numerator);
        this.setPeriod(period);
    }
    
    /**
     * Gets the anchor date/time.
     * @return The anchor date/time.
     */
    public final TypeOfCalendar getAnchor() {
        return this._anchor;
    }
    
    /**
     * Sets the anchor date/time.
     * @param anchor The anchor date/time.
     */
    public final void setAnchor(final TypeOfCalendar anchor) {
        if (anchor == null)
            throw new NullPointerException(
                    "Anchor not properly specified.");
        this._anchor = anchor;
    }
    
    /**
     * Gets the denominator.
     * @return The denominator.
     */
    public final DayCount<TypeOfCalendar> getDenominator() {
        return this._denominator;
    }
    
    /**
     * Sets the denominator day count convention.
     * @param denominator The denominator day count convention.
     */
    public final void setDenominator(
            final DayCount<TypeOfCalendar> denominator) {
        if (denominator == null)
            throw new NullPointerException(
                    "Denominator not properly specified.");
        this._denominator = denominator;
    }

    @Override
    public String getName() {
        return this._numerator.getNumerator() + "/" +
                this._denominator.getDenominator();
    }

    /**
     * Gets the numerator day count convention.
     * @return The numerator day count convention.
     */
    public final DayCount<TypeOfCalendar> getNumerator() {
        return this._numerator;
    }
    
    /**
     * Sets the numerator day count convention.
     * @param numerator The numerator day count convention.
     */
    public final void setNumerator(
            final DayCount<TypeOfCalendar> numerator) {
        if (numerator == null)
            throw new NullPointerException(
                    "Numerator not properly specified.");
        this._numerator = numerator;
    }

    /**
     * Gets the date/time period.
     * @return The date/time period.
     */
    public final Period<TypeOfCalendar> getPeriod() {
        return this._period;
    }
    
    /**
     * Sets the date/time period.
     * @param period The date/time period.
     */
    public final void setPeriod(final Period<TypeOfCalendar> period) {
        if (period == null)
            throw new NullPointerException(
                    "Period not properly specified.");
        this._period = period;
    }
}
