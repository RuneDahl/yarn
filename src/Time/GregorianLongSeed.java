/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time;

import java.util.GregorianCalendar;

/**
 * Implementation of a class that can be used to generate
 * {@see Random.Seed seed} values. The values are generated based on the
 * <a href="http://en.wikipedia.org/wiki/Gregorian_calendar">Gregorian</a>
 * time of day and then transformed non-linearly to make the seed values
 * appear more random. However seed values generated on the exact same
 * time every day will be identical.
 * <br>Warning: This class is not suited for use as a
 * {@see Random.Generator generator} of pseudo random values.
 * The intention of this class is to be used to generate (sort of random)
 * seed values for use in proper generators of pseudo random values.
 * @author Rune Dahl Iversen
 */
public final class GregorianLongSeed {
    private long _lowerBound;
    private long _upperBound;

    /**
     * Creates an instance of the
     * @param lowerBound
     * @param upperBound
     */
    public GregorianLongSeed(final long lowerBound,
            final long upperBound) {
        this.setLowerBound(lowerBound);
        this.setUpperBound(upperBound);
    }

    /**
     * Gets the lower bound of possible seed values.
     * @return Lower bound.
     */
    public long getLowerBound() {
        return this._lowerBound;
    }

    /**
     * Gets the upper bound of possible seed values.
     * @return Upper bound.
     */
    public long getUpperBound() {
        return this._upperBound;
    }

    /**
     * Sets the lower bound of possible seed values to the specified value.
     * @param lowerBound Lower bound.
     */
    public void setLowerBound(final long lowerBound) {
        this._lowerBound = lowerBound;
    }

    /**
     * Sets the upper bound of possible seed values to the specified value.
     * @param upperBound Upper bound.
     */
    public void setUpperBound(final long upperBound) {
        this._upperBound = upperBound;
    }

    /**
     * Gets a seed value based on the present system date/time.
     * @return Seed value.
     */
    public long getSeed() {
        return this.getSeed(new GregorianCalendar());
    }

    /**
     * Gets a seed value based on the specified date/time.
     * @param dateTime date/time.
     * @return         Seed value.
     */
    public long getSeed(final GregorianCalendar dateTime) {
        GregorianCalendar today = Gregorian.date(dateTime);
        double fraction = Gregorian.belowDateDifference(today, dateTime);
        if (fraction != 0.0)
            fraction = 1.0/fraction;
        int number = (int)fraction;
        fraction -= number;
        fraction = this._Jumble(fraction);
        if (fraction == 0.0 && number != 0)
            fraction = 1.0/number;
        long retval = (long)((this._upperBound-this._lowerBound)*fraction) +
                this._lowerBound;
        return retval;
    }

    private double _Jumble(final double value) {
        String vString = Double.toString(value).substring(2);
        double div = 1.0;
        StringBuilder retval = new StringBuilder("0");
        for (int i = vString.length()-1; -1 < i; i--) {
            retval.append(vString.substring(i, i+1));
            div *= 10.0;
        }
        return Double.parseDouble(retval.toString())/div;
    }
}
