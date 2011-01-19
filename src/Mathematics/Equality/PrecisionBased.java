/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Validation.*;

/**
 * An implementation allowing easy implementation of precision-based
 * equality-comparers through inheritance.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class PrecisionBased<TypeOfValue>
        implements Equals<TypeOfValue> {
    private double _precision;
    private static final Validator<Double> __precisionValidator =
            Factory.FiniteRealGreaterThanOrEqual(0.0);

    /**
     * Creates an instance of a PrecisionBased equality-comparer
     * with the default precision of 0.
     */
    protected PrecisionBased() {
        this(0.0);
    }

    /**
     * Creates an instance of a PrecisionBased equality-comparer
     * with the specified required precision.
     * @param precision The precision.
     *                  Must be a non-negative, finite number.
     * @throws IllegalArgumentException Precision is not a
     *                                  non-negative finite number.
     */
    protected PrecisionBased(final double precision) {
        this.setPrecision(precision);
    }

    /**
     * Gets the required precision of this equality-comparer.
     * @return The required precision.
     */
    public final double getPrecision() {
        return _precision;
    }

    /**
     * Sets the required precision of this equality-comparer
     * to the specified value.
     * @param precision The desired precision.
     *                  Must be a non-negative, finite number.
     * @throws IllegalArgumentException Precision is not a
     *                                  non-negative finite number.
     */
    public final void setPrecision(final double precision) {
        if (__precisionValidator.isValid(precision))
            this._precision = precision;
        else
            throw new IllegalArgumentException(
                    __precisionValidator.message(precision, "Precision"));
    }
}