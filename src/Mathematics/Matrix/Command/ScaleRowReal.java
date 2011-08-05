/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Command;
import Mathematics.Matrix.Matrix;
import Validation.*;

/**
 * {@see Command} that scales a specified row of a
 * {@see Matrix matrix} with the specified factor.
 * @author Rune Dahl Iversen
 */
public final class ScaleRowReal extends Row<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private double _factor;

    /**
     * Creates an instance of a row scaling command
     * with the specified row index and factor.
     * @param row    Row index.
     * @param factor Factor.
     */
    public ScaleRowReal(final int row, final double factor) {
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
        int start = matrix.getFirstColumn();
        int end = start + matrix.getColumns();
        int row = this.getRow();
        for (int c = start; c < end; c++)
            matrix.setValue(row, c, matrix.getValue(row, c) * this._factor);
        return matrix;
    }
}
