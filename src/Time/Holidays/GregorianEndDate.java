/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;

/**
 * Implementation of a {@see GregorianCalendar Gregorian} {@see Holiday holiday}
 * delimited by an end date/time.<br>
 * So any date/time after the end date/time is not counted as a holiday,
 * despite the implementation of the holiday that is wrapped.
 * @author Rune Dahl Iversen
 */
public final class GregorianEndDate implements Holiday<GregorianCalendar> {
    private Holiday<GregorianCalendar> _holiday;
    private GregorianCalendar _end;

    /**
     * Creates a new instance of the specified holiday
     * delimited by the end date/time
     * @param holiday Holiday.
     * @param end     End date/time.
     * @throws NullPointerException Holiday not properly specified.
     * @throws NullPointerException End date/time not properly specified.
     */
    public GregorianEndDate(final Holiday<GregorianCalendar> holiday,
            final GregorianCalendar end) {
        this.setHoliday(holiday);
        this.setEnd(end);
    }

    /**
     * Gets the holiday delimited by the end date/time.
     * @return The holiday.
     */
    public Holiday<GregorianCalendar> getHoliday() {
        return _holiday;
    }

    /**
     * Gets the end date/time delimiting the holiday.
     * @return The end date/time.
     */
    public GregorianCalendar getEnd() {
        return _end;
    }

    /**
     * Sets the holiday delimited by the end date/time.
     * @param holiday The holiday.
     * @throws NullPointerException Holiday not properly specified.
     */
    public void setHoliday(final Holiday<GregorianCalendar> holiday) {
        if (holiday == null)
            throw new NullPointerException("Holiday not properly specified.");
        this._holiday = holiday;
    }

    /**
     * Sets the end date/time delimiting the holiday.
     * @param end The end date/time.
     * @throws NullPointerException End date/time not properly specified.
     */
    public void setEnd(final GregorianCalendar end) {
        if (end == null)
            throw new NullPointerException(
                    "End date/time not properly specified.");
        this._end = end;
    }

    @Override
    public boolean isHoliday(final GregorianCalendar dateTime) {
        return (0 <= this._end.compareTo(dateTime) &&
                this._holiday.isHoliday(dateTime));
    }
}