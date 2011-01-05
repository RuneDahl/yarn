/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

/**
 * Abstract class to have a unified interface for functions of
 * {@see Vector vectors} that are limited in the number of dimensions
 * of the vector.
 * @author Rune Dahl Iversen
 */
public abstract class DimensionLimit {
    private final int _dimensionLimit;

    /**
     * Creates dimensional limit with the specified limit.
     * @param dimensionLimit The dimensional limit.
     */
    protected DimensionLimit(final int dimensionLimit) {
        this._dimensionLimit = dimensionLimit;
    }

    /**
     * Returns the dimensional limit.
     * @return The dimensional limit.
     */
    public final int getDimensionLimit() {
        return this._dimensionLimit;
    }
}