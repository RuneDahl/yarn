/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import Time.Periods.Period;
import java.util.*;
import java.util.GregorianCalendar;

/**
 * Factory class for {@see Holiday holidays}.
 * @author Rune Dahl Iversen
 */
public final class Factory {
    private Factory()
    { }

    /**
     * {@see Holiday Holidays} as used by the majority of danish financial
     * institutions.<br>
     * This set of holidays is not applicable backwards in time beyond 2009.
     * @return Danish financial holidays.
     */
    public static Holiday<GregorianCalendar> DanishFinancialHolidays() {
        And<GregorianCalendar> holidays = new And<GregorianCalendar>();
        holidays.add(new GregorianWeekday(GregorianCalendar.SATURDAY)); // Saturdays
        holidays.add(new GregorianWeekday(GregorianCalendar.SUNDAY)); // Sundays
        holidays.add(new GregorianAnniversary(0, 1)); // New Year's day
        holidays.add(new GregorianAnniversary(5, 5)); // Constitution day
        holidays.add(new GregorianAnniversary(11, 24)); // Christmas eve
        holidays.add(new GregorianAnniversary(11, 25)); // Christmas day
        holidays.add(new GregorianAnniversary(11, 26)); // Second day of Christmas
        holidays.add(new GregorianAnniversary(11, 31)); // New Year's eve
        holidays.add(_WesternEaster(
                -3, // Maundy Thurday
                -2, // Good Friday
                1, // Easter Monday
                26, // General Prayer day
                39, // Ascension day
                40, // Day after Ascension - This was added 2008 or 2009.
                50)); // Whit Monday.
        return holidays;
    }

    /**
     * {@see Holiday Holidays} as specified by the
     * <a href="http://en.wikipedia.org/wiki/TARGET">TARGET</a>
     * (Trans-European Automated Real-time Gross Settlement Express Transfer
     * System) in the {@see GregorianCalendar Gregorian calendar}.<br>
     * TARGET was incepted on January 4th 1999, so the TARGET holidays
     * are not applicable prior to that date.<br>
     * As stated on the Wikipedia TARGET was replaced with the TARGET2
     * during November of 2007, so the TARGET holidays are not applicable
     * after that.<br>
     * This setup of the TARGET holidays allows usage ouside the applicable range.
     * @return TARGET holidays.
     */
    public static Holiday<GregorianCalendar> TARGET() {
        And<GregorianCalendar> holidays = new And<GregorianCalendar>();
        holidays.add(new GregorianWeekday(GregorianCalendar.SATURDAY)); // Saturdays
        holidays.add(new GregorianWeekday(GregorianCalendar.SUNDAY)); // Sundays
        holidays.add(new GregorianAnniversary(0, 1)); // New Year's day
        holidays.add(new GregorianAnniversary(4, 1)); // Labor day
        holidays.add(new GregorianAnniversary(11, 25)); // Christmas day
        holidays.add(new GregorianAnniversary(11, 26)); // Second day of Christmas
        holidays.add(_WesternEaster(-2, 1)); // Good Friday and Easter Monday
        return holidays;
    }

    /**
     * {@see Holiday Holidays} as specified by the
     * <a href="http://en.wikipedia.org/wiki/TARGET">TARGET2</a>
     * (Trans-European Automated Real-time Gross Settlement Express Transfer
     * System) in the {@see GregorianCalendar Gregorian calendar}.<br>
     * As stated on the Wikipedia TARGET2 was started during November of 2007,
     * so the TARGET2 holidays are not applicable prior to that.<br>
     * This setup of the TARGET2 holidays allows usage ouside the applicable range.
     * @return TARGET2 holidays.
     */
    public static Holiday<GregorianCalendar> TARGET2() {
        And<GregorianCalendar> holidays = new And<GregorianCalendar>();
        holidays.add(new GregorianWeekday(GregorianCalendar.SATURDAY)); // Saturdays
        holidays.add(new GregorianWeekday(GregorianCalendar.SUNDAY)); // Sundays
        holidays.add(new GregorianAnniversary(0, 1)); // New Year's day
        holidays.add(new GregorianAnniversary(4, 1)); // Labor day
        holidays.add(new GregorianAnniversary(11, 25)); // Christmas day
        holidays.add(new GregorianAnniversary(11, 26)); // Second day of Christmas
        holidays.add(_WesternEaster(-2, 1)); // Good Friday and Easter Monday
        return holidays;
    }

    private static Holiday<GregorianCalendar> _WesternEaster(int... displacedDays) {
        Relatives<GregorianCalendar> holidays = new Relatives<GregorianCalendar>(
                new GregorianWesternEaster(), new ArrayList<Period<GregorianCalendar>>());
        if (displacedDays != null)
            for (int displacedDay : displacedDays)
                holidays.add(new Time.Periods.GregorianDay(displacedDay));
        return holidays;
    }
}