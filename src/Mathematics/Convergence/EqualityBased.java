/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import Mathematics.Equality.Equals;
import Validation.NotNull;

/**
 * Abstract class to allow easy implementation of
 * {@see Criterion convergence-criteria}
 * based on {@see Mathematics.Equality.Equals equality}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class EqualityBased<TypeOfValue>
        implements Criterion<TypeOfValue> {
    private Equals<TypeOfValue> _equals;
    private final NotNull<Equals<TypeOfValue>> _equalsValidator =
            new NotNull();

    /**
     * Create an instance of an equality-based convergence-criterion
     * with the specified equality-comparer.
     * @param equals Equality-comparer. May not equal null.
     * @throws NullPointerException Equals is null.
     */
    protected EqualityBased(final Equals<TypeOfValue> equals) {
        this.setEquals(equals);
    }

    /**
     * Gets the equality-comparer of this equality-based
     * convergence-criterion.
     * @return Equality-comparer.
     */
    public final Equals<TypeOfValue> getEquals() {
        return this._equals;
    }

    /**
     * Set the equality-comparer to the specified value.
     * @param equals Equality comparer. May not equal null.
     * @throws NullPointerException Equals is null.
     */
    public final void setEquals(final Equals<TypeOfValue> equals) {
        if (!this._equalsValidator.isValid(equals))
            throw new NullPointerException(
                    this._equalsValidator.message(equals, "Equals"));
        this._equals = equals;
    }
}