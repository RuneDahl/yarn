/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.Additive;
import Mathematics.Norm.Norm;
import Validation.*;

/**
 * Implementation of an {@see Mathematics.Norm norm}-based comparison of
 * {@see Mathematics.Additive additive} values.
 * This allows leveraging implementation of a norm for an additive value
 * to combine and form the basis of a comparison of values.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class NormBased<TypeOfValue>
        extends PrecisionBased<TypeOfValue> {
    private Validator<Norm<TypeOfValue>> _normValidator =
            new NotNull<Norm<TypeOfValue>>();
    private Norm<TypeOfValue> _norm;

    /**
     * Creates an instance of a {@see Mathematics.Norm norm}-based comparison of
     * values with the specified norm.
     * @param precision The precision. Must be a non-negative finite number.
     * @param norm      The Norm.
     * @throws IllegalArgumentException Precision is not a
     *                                  non-negative finite number.
     * @throws NullPointerException Norm is null.
     */
    protected NormBased(final double precision, final Norm<TypeOfValue> norm) {
        super(precision);
        this.setNorm(norm);
    }

    /**
     * Gets the {@see Mathematics.Norm norm} of this norm-based comparison of values.
     * @return The norm.
     */
    public Norm<TypeOfValue> getNorm() {
        return this._norm;
    }

    /**
     * Sets the {@see Mathematics.Norm norm} of this norm-based comparison of
     * values to the specified norm.
     * @param norm The desired norm.
     * @throws NullPointerException Norm is null.
     */
    public void setNorm(final Norm<TypeOfValue> norm) {
        if (!this._normValidator.isValid(norm))
            throw new NullPointerException(
                    this._normValidator.Message(norm, "Norm"));
        this._norm = norm;
    }
}