/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

/**
 * Abstract class to have a unified interface for functions of
 * {@see Matrix matrices} that are limited in the number of dimensions
 * of the matrix.<br>
 * For instance there are easy
 * <a href="http://en.wikipedia.org/wiki/Closed-form_expression">closed-form
 * solutions</a> to the
 * <a href="http://en.wikipedia.org/wiki/Determinant">determinant</a> of
 * small matrices that are of dimension 3 or less.
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
    public int getDimensionLimit() {
        return this._dimensionLimit;
    }
}