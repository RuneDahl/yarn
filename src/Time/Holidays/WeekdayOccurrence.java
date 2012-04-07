/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.Holidays;

/**
 * Abstract implementation of a {@see Holiday holiday} based on a specified
 * weekday and a number of occurrences.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public abstract class WeekdayOccurrence<TypeOfCalendar>
    implements Holiday<TypeOfCalendar> {
    private static final Validation.Validator<Integer> __occurrenceValidator =
            Validation.Factory.BoundedInteger(1, 5);
    private static final Validation.Validator<Integer> __weekdayValidator =
            Validation.Factory.BoundedInteger(1, 7);

    private int _occurrence;
    private int _weekday;
    
    /**
     * Creates an instance with the specified occurrences and weekday.
     * @param occurrence The occurrence of weekdays.
     * @param weekday    Weekday. An integer in the range 1 through 7.
     */
    protected WeekdayOccurrence(final int occurrence, final int weekday) {
        this.setOccurrence(occurrence);
        this.setWeekday(weekday);
    }

    /**
     * Returns the occurrence of weekdays.
     * @return The occurrence of weekdays.
     */
    public final int getOccurrence() {
        return this._occurrence;
    }
    
    /**
     * Sets the occurrence of weekdays.
     * @param occurrence The occurrence of weekdays.
     */
    public final void setOccurrence(final int occurrence) {
        if (!__occurrenceValidator.isValid(occurrence))
            throw new IllegalArgumentException(
                    __occurrenceValidator.message(occurrence, "Occurrence"));
        this._occurrence = occurrence;
    }

    /**
     * Returns the day of week of this holiday.
     * @return The day of week of this holiday.
     */
    public final int getWeekday() {
        return this._weekday;
    }

    /**
     * Sets the day of week of this holiday.
     * @param weekday The day of week of this holiday.
     */
    public final void setWeekday(final int weekday) {
        if (!__weekdayValidator.isValid(weekday))
            throw new IllegalArgumentException(
                    __weekdayValidator.message(weekday, "Weekday"));
        this._weekday = weekday;
    }
}
