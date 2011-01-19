/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

import Validation.*;

/**
 * Implementation of an {@see Interval interval} of {@see Double real numbers}.
 * @author Rune Dahl Iversen
 */
public final class IntervalReal implements Interval<Double> {
    private double _lowerBound;
    private EndType _lowerType;
    private double _upperBound;
    private EndType _upperType;
    private static Validator<Double> __validator =
            Validation.Factory.FiniteReal();

    /**
     * Creates an instance of an {@see Interval interval} of doubles.
     * @param lowerbound Lower bound value.
     * @param lowerType  Lower bound type.
     * @param upperBound Upper bound value.
     * @param upperType  Upper bound type.
     */
    public IntervalReal(final double lowerbound, final EndType lowerType,
            final double upperBound, final EndType upperType) {
        this.setLowerBound(lowerbound);
        this.setLowerType(lowerType);
        this.setUpperBound(upperBound);
        this.setUpperType(upperType);
    }

    @Override
    public boolean contains(final Double value) {
        boolean contained = true;
        contained &= (this._lowerType == EndType.Includes ?
            this._lowerBound <= value:
            this._lowerBound < value);
        contained &= (this._upperType == EndType.Includes ?
            value <= this._upperBound:
            value < this._upperBound);
        return contained;
    }

    @Override
    public Double getLowerBound() {
        return this._lowerBound;
    }

    @Override
    public EndType getLowerType() {
        return this._lowerType;
    }

    @Override
    public Double getUpperBound() {
        return this._upperBound;
    }

    @Override
    public EndType getUpperType() {
        return this._upperType;
    }

    @Override
    public void setLowerBound(final Double lowerBound) {
        if (!__validator.isValid(lowerBound))
            throw new IllegalArgumentException(
                    __validator.message(lowerBound, "Lower bound"));
        this._lowerBound = lowerBound;
    }

    @Override
    public void setLowerType(final EndType lowerType) {
        if (lowerType == null)
            throw new NullPointerException("Lower type not properly specified.");
        this._lowerType = lowerType;
    }

    @Override
    public void setUpperBound(final Double upperBound) {
        if (!__validator.isValid(upperBound))
            throw new IllegalArgumentException(
                    __validator.message(upperBound, "Upper bound"));
        this._upperBound = upperBound;
    }

    @Override
    public void setUpperType(final EndType upperType) {
        if (upperType == null)
            throw new NullPointerException("Upper type not properly specified.");
        this._upperType = upperType;
    }

    @Override
    public boolean equals(Object o) {
        boolean equals;
        if (o == null)
            equals = false;
        else if (o == this)
            equals = true;
        else if (o instanceof Interval)
            equals = this._equals((Interval)o);
        else
            equals = false;
        return equals;
    }

    /**
     * Indicates whether the specified interval equals this interval.
     * @param interval Interval.
     * @return         True if the intervals are equal, else false.
     */
    private boolean _equals(Interval<Double> interval) {
        boolean equals = this.getLowerType() == interval.getLowerType();
        equals &= this.getLowerBound() - interval.getLowerBound() == 0.0;
        equals &= this.getUpperType() == interval.getUpperType();
        equals &= this.getUpperBound() - interval.getUpperBound() == 0.0;
        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._lowerBound) ^ (Double.doubleToLongBits(this._lowerBound) >>> 32));
        hash = 37 * hash + this._lowerType.hashCode();
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._upperBound) ^ (Double.doubleToLongBits(this._upperBound) >>> 32));
        hash = 37 * hash + this._upperType.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        String value = "";
        value += (this._lowerType == EndType.Includes ? "[" : "]");
        value += Double.toString(this._lowerBound);
        value += " : ";
        value += Double.toString(this._upperBound);
        value += (this._upperType == EndType.Excludes ? "[" : "]");
        return value;
    }
}