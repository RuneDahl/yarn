/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Function;

import Mathematics.Function.*;
import Mathematics.Matrix.Matrix;

/**
 * {@see Function Function} of a {@see Matrix matrix} of values that return the
 * row index of the "best" value in the specified column between the specified
 * rows. The "best" value is determined by the specified comparer.
 * @author Rune Dahl Iversen
 */
public final class IndexOfBestValueInColumn<TypeOfValue>
        implements Function<Matrix<TypeOfValue>, Integer> {
    private int _column;
    private int _upperRowBound;
    private int _lowerRowBound;
    private Operator<TypeOfValue, TypeOfValue, Boolean> _comparer;

    /**
     *
     * @param column        Column index.
     * @param upperRowBound Upper bound on the row index.
     * @param lowerRowBound Lower bound on the row index.
     * @param comparer      Comparer. An operator that compare two values and
     *                      returns true if the second is "better" than the first.
     */
    public IndexOfBestValueInColumn(final int column,
            final int lowerRowBound, final int upperRowBound,
            final Operator<TypeOfValue, TypeOfValue, Boolean> comparer) {
        this.setColumn(column);
        this.setLowerRowBound(lowerRowBound);
        this.setUpperRowBound(upperRowBound);
        this.setComparer(comparer);
    }

    /**
     * Gets the column index.
     * @return Column index.
     */
    public int getColumn() {
        return this._column;
    }

    /**
     * Sets the column index.
     * @param column Column index.
     */
    public void setColumn(final int column) {
        this._column = column;
    }

    /**
     * Gets the Comparer.
     * @return Comparer.
     */
    public Operator<TypeOfValue, TypeOfValue, Boolean> getComparer() {
        return this._comparer;
    }

    /**
     * Sets the comparer. The comparer is an {@see Operator operator} that
     * returns true is the second input is "better" than the first input.
     * @param comparer Comparer.
     */
    public void setComparer(
            final Operator<TypeOfValue, TypeOfValue, Boolean> comparer) {
        if (comparer == null)
            throw new NullPointerException("Comparer is not properly specified.");
        this._comparer = comparer;
    }

    /**
     * Gets the lower bound on the row index.
     * @return The lower bound on the row index.
     */
    public int getLowerRowBound() {
        return this._lowerRowBound;
    }

    /**
     * Sets the lower bound on the row index.
     * @param lowerRowBound The lower bound on the row index.
     */
    public void setLowerRowBound(final int lowerRowBound) {
        this._lowerRowBound = lowerRowBound;
    }

    /**
     * Gets the upper bound on the row index.
     * @return The upper bound on the row index.
     */
    public int getUpperRowBound() {
        return this._upperRowBound;
    }

    /**
     * Sets the upper bound on the row index.
     * @param upperRowBound The upper bound on the row index.
     */
    public void setUpperRowBound(final int upperRowBound) {
        this._upperRowBound = upperRowBound;
    }

    @Override
    public Integer value(final Matrix<TypeOfValue> matrix) {
        int column = this._column;
        int lowRow = this._lowerRowBound;
        int highRow = this._upperRowBound;
        Operator<TypeOfValue, TypeOfValue, Boolean> comparer = this._comparer;
        if (highRow < lowRow)
            throw new IllegalStateException("The bounds on the rows are incorrectly specified.");
        else if (matrix == null)
            throw new NullPointerException("Matrix not properly specified.");
        else if (matrix.getLastColumn() < column ||
                column < matrix.getFirstColumn())
            throw new IllegalArgumentException("Matrix does not contain the specified column.");
        else if (lowRow < matrix.getFirstRow() || matrix.getLastRow() < highRow)
            throw new IllegalArgumentException("Matrix does not contain the specified rows.");
        int index = lowRow - 1;
        TypeOfValue value = null;
        for (int row = lowRow; row <= highRow; row++)
        {
            TypeOfValue v = matrix.getValue(row, column);
            if (value == null || comparer.value(value, v))
            {
                index = row;
                value = v;
            }
        }
        return index;
    }
}
