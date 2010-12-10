/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import Mathematics.Equality.Equals;
import Validation.IntegerGreaterThan;

/**
 * Implementation of a {@see Criterion convergence criterion} based on
 * {@see Equals equality} of a specified number of final values.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public final class EqualsLastValue<TypeOfValue>
        extends EqualityBased<TypeOfValue> {
    private int _numberOfEqualities;
    private static final IntegerGreaterThan __numberValidator =
            new IntegerGreaterThan();

    /**
     * Creates an instance of this convergence criterion using the specified
     * equality-comparer and number of equalities.
     * @param equals             Equality-comparer. May not be null.
     * @param numberOfEqualities Number of equalities. Must be positive.
     * @throws NullPointerException     Equals is null.
     * @throws IllegalArgumentException Number of equalities must be greater
     *                                  than 0.
     */
    public EqualsLastValue(final Equals<TypeOfValue> equals,
            final int numberOfEqualities) {
        super(equals);
        this.setNumberOfEqualities(numberOfEqualities);
    }

    /**
     * Gets the number of final values that must equal the final value
     * to be considered a converging series.
     * @return Number of equalities.
     */
    public int getNumberOfEqualities() {
        return this._numberOfEqualities;
    }

    /**
     * Sets the number of final values that must equal the final value
     * to be considered a converging series.
     * @param numberOfEqualities Number of equalities. Must be positive.
     * @throws IllegalArgumentException Number of equalities must be greater
     *                                  than 0.
     */
    public void setNumberOfEqualities(final int numberOfEqualities) {
        if (!__numberValidator.isValid(numberOfEqualities))
            throw new IllegalArgumentException(
                    __numberValidator.Message(numberOfEqualities,
                    "Number of equalities"));
        this._numberOfEqualities = numberOfEqualities;
    }

    public boolean converges(final TypeOfValue[] series) {
        if (series.length < this._numberOfEqualities + 1)
            return false;
        TypeOfValue lastValue = series[series.length - 1];
        for (int i = 1; i <= this._numberOfEqualities; i++)
        {
            if (!this.getEquals().value(lastValue,
                    series[series.length - 1 - i]))
                return false;
        }
        return true;
    }
}