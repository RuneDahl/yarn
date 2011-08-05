/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Command;
import Mathematics.Matrix.Matrix;
import Validation.*;

/**
 * {@see Command} that scales a specified column of a
 * {@see Matrix matrix} with the specified factor.
 * @author Rune Dahl Iversen
 */
public final class ScaleColumnReal extends Column<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private double _factor;

    /**
     * Creates an instance of a column scaling {@see Command command}
     * with the specified row index and factor.
     * @param row    Row index.
     * @param factor Factor.
     */
    public ScaleColumnReal(final int row, final double factor) {
        super(row);
        this.setFactor(factor);
    }

    /**
     * Gets the factor.
     * @return The factor.
     */
    public double getFactor() {
        return this._factor;
    }

    /**
     * Sets the factor to the specified value.
     * @param factor Factor.
     */
    public void setFactor(final double factor) {
        if (!__valueValidator.isValid(factor))
            throw new IllegalArgumentException(
                    __valueValidator.message(factor, "Factor"));
        this._factor = factor;
    }

    @Override
    public Matrix<Double> applyTo(final Matrix<Double> matrix) {
        if (matrix == null)
            throw new NullPointerException("Matrix not properly specified.");
        int start = matrix.getFirstRow();
        int end = start + matrix.getRows();
        int column = this.getColumn();
        for (int r = start; r < end; r++)
            matrix.setValue(r, column, matrix.getValue(r, column) * this._factor);
        return matrix;
    }
}
