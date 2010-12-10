/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Equality.Equals;

/**
 * Abstract implementation of a function with a {@see Equals comparer}
 * as basic input.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value to compare.
 */
public abstract class ComparerBased<TypeOfValue> {
    private Equals<TypeOfValue> _comparer;

    /**
     * Creates an instance with the specified comparer.
     * @param comparer The comparer.
     * @exception NullPointerException Comparer not specified.
     */
    protected ComparerBased(final Equals<TypeOfValue> comparer) {
        this.setComparer(comparer);
    }

    /**
     * Returns the comparer of this function.
     * @return The comparer.
     */
    public final Equals<TypeOfValue> getComparer() {
        return this._comparer;
    }

    /**
     * Sets the comparer of this function.
     * @param comparer The comparer.
     * @exception NullPointerException Comparer not specified.
     */
    public final void setComparer(final Equals<TypeOfValue> comparer) {
        if (comparer == null)
            throw new NullPointerException("Comparer not specified.");
        this._comparer = comparer;
    }
}