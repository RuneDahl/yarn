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
public abstract class DimensionLimits {
    private final int _rowLimit;
    private final int _columnLimit;

    /**
     * Creates dimension limits with the specified dimensional limit
     * for both rows and columns.
     * @param dimensionLimit The dimensional limit.
     */
    protected DimensionLimits(final int dimensionLimit) {
        this(dimensionLimit, dimensionLimit);
    }

    /**
     * Creates dimensional limits with the specified limits.
     * @param rowLimit    The row limit.
     * @param columnLimit The column limit.
     */
    protected DimensionLimits(final int rowLimit, final int columnLimit) {
        this._rowLimit = rowLimit;
        this._columnLimit = columnLimit;
    }

    /**
     * Returns the column limit.
     * @return The column limit.
     */
    public final int getColumnLimit() {
        return this._columnLimit;
    }

    /**
     * Returns the row limit.
     * @return The row limit.
     */
    public final int getRowLimit() {
        return this._rowLimit;
    }
}