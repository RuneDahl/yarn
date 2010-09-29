/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of a {@see GregorianCalendar Gregorian} {@see Holiday holiday}
 * delimited by a start date/time.<br>
 * So any date/time before the start date/time is not counted as a holiday,
 * despite the implementation of the holiday that is wrapped.
 * @author Rune Dahl Iversen
 */
public class GregorianStartDate implements Holiday<GregorianCalendar> {
    private Holiday<GregorianCalendar> _holiday;
    private GregorianCalendar _start;

    /**
     * Creates a new instance of the specified holiday
     * delimited by the start date/time
     * @param holiday Holiday.
     * @param start   Start date/time.
     * @throws NullPointerException Holiday not properly specified.
     * @throws NullPointerException Start date/time not properly specified.
     */
    public GregorianStartDate(
            final Holiday<GregorianCalendar> holiday,
            final GregorianCalendar start) {
        this.setHoliday(holiday);
        this.setStart(start);
    }

    /**
     * Gets the holiday delimited by the start date/time.
     * @return The holiday.
     */
    public Holiday<GregorianCalendar> getHoliday() {
        return _holiday;
    }

    /**
     * Gets the start date/time delimiting the holiday.
     * @return The start date/time.
     */
    public GregorianCalendar getStart() {
        return _start;
    }

    /**
     * Sets the holiday delimited by the start date/time.
     * @param holiday The holiday.
     * @throws NullPointerException Holiday not properly specified.
     */
    public void setHoliday(final Holiday<GregorianCalendar> holiday) {
        if (holiday == null)
            throw new NullPointerException("Holiday not properly specified.");
        this._holiday = holiday;
    }

    /**
     * Sets the start date/time delimiting the holiday.
     * @param start The start date/time.
     * @throws NullPointerException Start date/time not properly specified.
     */
    public void setStart(final GregorianCalendar start) {
        if (start == null)
            throw new NullPointerException(
                    "Start date/time not properly specified.");
        this._start = start;
    }

    public boolean isHoliday(final GregorianCalendar dateTime) {
        return (this._start.compareTo(dateTime) <= 0 &&
                this._holiday.isHoliday(dateTime));
    }
}