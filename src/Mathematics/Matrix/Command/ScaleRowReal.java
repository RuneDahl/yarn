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
 * {@see Matrix matrix} with the specified scalar factor.
 * @author Rune Dahl Iversen
 */
public final class ScaleRowReal extends Row<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private double _scalar;

    /**
     * Creates an instance of a row scaling command
     * with the specified row index and scalar factor.
     * @param row    Row index.
     * @param scalar Scalar factor.
     */
    public ScaleRowReal(final int row, final double scalar) {
        super(row);
        this.setScalar(scalar);
    }

    /**
     * Gets the factor.
     * @return The factor.
     */
    public double getScalar() {
        return this._scalar;
    }

    /**
     * Sets the scalar factor to the specified value.
     * @param scalar Scalar factor.
     */
    public void setScalar(final double scalar) {
        if (!__valueValidator.isValid(scalar))
            throw new IllegalArgumentException(
                    __valueValidator.message(scalar, "Scalar"));
        this._scalar = scalar;
    }

    @Override
    public Matrix<Double> applyTo(final Matrix<Double> matrix) {
        if (matrix == null)
            throw new NullPointerException("Matrix not properly specified.");
        int start = matrix.getFirstColumn();
        int end = start + matrix.getColumns();
        int row = this.getRow();
        double scalar = this._scalar;
        for (int c = start; c < end; c++)
            matrix.setValue(row, c, matrix.getValue(row, c) * scalar);
        return matrix;
    }
}
