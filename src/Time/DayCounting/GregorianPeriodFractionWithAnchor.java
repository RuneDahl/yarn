/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.DayCounting;

import Time.Gregorian;
import Time.Periods.Period;
import java.util.GregorianCalendar;

/**
 * Implementation of a {@see Fraction day counting fraction} using 2
 * {@see DayCount day count conventions}, an {@see GregorianCalendar anchor}
 * and a {@see Period period}, all using the {@see GregorianCalendar Gregorian
 * calendar}.
 * @author Rune Dahl Iversen
 */
public final class GregorianPeriodFractionWithAnchor
        extends PeriodFractionWithAnchor<GregorianCalendar> {
    /**
     * Create a new instance of the period and anchor based day counting fraction.
     * @param numerator   Numerator day count convention.
     * @param denominator Denominator day count convention.
     * @param period      Date/time period.
     * @param anchor      Anchor date/time.
     */
    public GregorianPeriodFractionWithAnchor(
            final DayCount<GregorianCalendar> numerator,
            final DayCount<GregorianCalendar> denominator,
            final Period<GregorianCalendar> period,
            final GregorianCalendar anchor) {
        super(numerator, denominator, period, anchor);
    }

    @Override
    public double getTime(final GregorianCalendar start, final GregorianCalendar end) {
        Period<GregorianCalendar> unit = this.getPeriod();
        DayCount<GregorianCalendar> numerator = this.getNumerator();
        DayCount<GregorianCalendar> denominator = this.getDenominator();
        if (0 < start.compareTo(end))
            return -this.getTime(end, start); // This implies a reflexive behaviour.
        GregorianCalendar temp = this.firstAcross(start, this.getAnchor(), unit, +1);
        temp = this.firstAcross(start, temp, unit, -1);
        GregorianCalendar t = temp;
        double period = 0.0;
        while (0 < end.compareTo(temp)) // Go forwards until the regular date/time is past end.
        {
            temp = unit.shift(temp, +1); // Shift regular date/time forwards.
            period += this.timeFraction(numerator, denominator, start, t, temp, end);
            t = temp; // Store the regular date/time, since it's the needed in the next loop.
        }
        return period;
    }
    
    /**
     * Returns the day counting fraction for the part of the regular period
     * that falls within the full period.
     * @param numerator    Numerator day count convention.
     * @param denominator  Denominator day count convention.
     * @param periodStart  Starting date/time for the full period.
     * @param regularStart Starting date/time for the regular period.
     * @param regularEnd   Ending date/time for the regular period.
     * @param periodEnd    Ending date/time for the full period.
     * @return             Day counting fraction.
     */
    private double timeFraction(
            final DayCount<GregorianCalendar> numerator,
            final DayCount<GregorianCalendar> denominator,
            final GregorianCalendar periodStart,
            final GregorianCalendar regularStart,
            final GregorianCalendar regularEnd,
            final GregorianCalendar periodEnd) {
        GregorianCalendar start = Gregorian.max(periodStart, regularStart);
        GregorianCalendar end = Gregorian.min(regularEnd, periodEnd);
        return numerator.days(start, end) /
                denominator.days(regularStart, regularEnd);
    }
    
    /**
     * Returns a date/time shifted using the specified period in the direction
     * from start until it has crossed the boundary. If the start is on the
     * side of the the boundary, where shifting the date/time moves it away
     * from the boundary, the starting date/time will be returned.
     * boundary, then 
     * @param boundary  Boundary date/time.
     * @param start     Starting date/time.
     * @param period    Period.
     * @param direction Direction.
     * @return          Shifted date/time.
     */
    private GregorianCalendar firstAcross(
            final GregorianCalendar boundary,
            final GregorianCalendar start,
            final Period<GregorianCalendar> period,
            final int direction) {
        GregorianCalendar temp = start;
        while (0 < boundary.compareTo(temp) * direction)
            temp = period.shift(temp, direction);
        return temp;
    }
}
