/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

import Validation.*;

/**
 * Implementation of an {@see Interval interval} of doubles.
 * @author Rune Dahl Iversen
 */
public final class DoubleInterval implements Interval<Double> {
    private double _lowerBound;
    private EndType _lowerType;
    private double _upperBound;
    private EndType _upperType;
    private Validator<Double> _validator;

    /**
     * Creates an instance of an {@see Interval interval} of doubles.
     * @param lowerbound Lower bound value.
     * @param lowerType  Lower bound type.
     * @param upperBound Upper bound value.
     * @param upperType  Upper bound type.
     */
    public DoubleInterval(final double lowerbound, final EndType lowerType,
            final double upperBound, final EndType upperType) {
        this._validator = this._setValidator();
        this.setLowerBound(lowerbound);
        this.setLowerType(lowerType);
        this.setUpperBound(upperBound);
        this.setUpperType(upperType);
    }

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

    public Double getLowerBound() {
        return this._lowerBound;
    }

    public EndType getLowerType() {
        return this._lowerType;
    }

    public Double getUpperBound() {
        return this._upperBound;
    }

    public EndType getUpperType() {
        return this._upperType;
    }

    public void setLowerBound(final Double lowerBound) {
        if (!this._validator.isValid(lowerBound))
            throw new IllegalArgumentException(
                    this._validator.Message(lowerBound, "Lower bound"));
        this._lowerBound = lowerBound;
    }

    public void setLowerType(final EndType lowerType) {
        this._lowerType = lowerType;
    }

    public void setUpperBound(final Double upperBound) {
        if (!this._validator.isValid(upperBound))
            throw new IllegalArgumentException(
                    this._validator.Message(upperBound, "Upper bound"));
        this._upperBound = upperBound;
    }

    public void setUpperType(final EndType upperType) {
        this._upperType = upperType;
    }

    @Override
    public boolean equals(Object o) {
        boolean equals;
        if (o == null)
            equals = false;
        else if (o == this)
            equals = true;
        else if (o instanceof DoubleInterval)
            equals = this.equals((DoubleInterval)o);
        else
            equals = false;
        return equals;
    }

    public boolean equals(DoubleInterval interval) {
        boolean equals;
        if (interval == null)
            equals = false;
        else if (interval == this)
            equals = true;
        else {
            equals = this.getLowerType() == interval.getLowerType();
            equals &= this.getLowerBound() - interval.getLowerBound() == 0.0;
            equals &= this.getUpperType() == interval.getUpperType();
            equals &= this.getUpperBound() - interval.getUpperBound() == 0.0;
        }
        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._lowerBound) ^ (Double.doubleToLongBits(this._lowerBound) >>> 32));
        hash = 37 * hash + (this._lowerType != null ? this._lowerType.hashCode() : 0);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._upperBound) ^ (Double.doubleToLongBits(this._upperBound) >>> 32));
        hash = 37 * hash + (this._upperType != null ? this._upperType.hashCode() : 0);
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

    private Validator<Double> _setValidator() {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        return validator;
    }
}