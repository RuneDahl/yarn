/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Validation.*;

/**
 *
 * @author Rune Dahl Iversen
 */
public abstract class PrecisionBased<TypeOfValue>
        implements Equals<TypeOfValue> {
    private double _precision;
    private Validator<Double> _precisionValidator;

    /**
     * Creates an instance of a PrecisionBased equality-comparer
     * with the specified required precision.
     * @param precision The precision.
     *                  Must be a non-negative, finite number.
     */
    protected PrecisionBased(double precision) {
        Validation.And<Double> validator = new Validation.And<Double>();
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        validator.add(new DoubleGreaterThanOrEqual(0.0));

        this._precisionValidator = validator;
        this.setPrecision(precision);
    }

    /**
     * Gets the required precision of this equality-comparer.
     * @return The required precision.
     */
    public double getPrecision() {
        return _precision;
    }

    /**
     * Sets the required precision of this equality-comparer
     * to the specified value.
     * @param precision The desired precision.
     *                  Must be a non-negative, finite number.
     */
    public void setPrecision(double precision) {
        if (this._precisionValidator.Validate(precision))
            this._precision = precision;
        else
            throw new IllegalArgumentException(
                    this._precisionValidator.Message(precision, "Precision"));
    }
}