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
 * {@see Matrix matrix} with the specified scalar factor.
 * @author Rune Dahl Iversen
 */
public final class ScaleColumnReal extends Column<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private double _scalar;

    /**
     * Creates an instance of a column scaling command
     * with the specified row index and scalar factor.
     * @param row    Row index.
     * @param scalar Scalar factor.
     */
    public ScaleColumnReal(final int row, final double scalar) {
        super(row);
        this.setScalar(scalar);
    }

    /**
     * Gets the scalar factor.
     * @return The scalar factor.
     */
    public double getScalar() {
        return this._scalar;
    }

    /**
     * Sets the scalar factor to the specified value.
     * @param scalar The scalar factor.
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
        int start = matrix.getFirstRow();
        int end = start + matrix.getRows();
        int column = this.getColumn();
        double scalar = this._scalar;
        for (int r = start; r < end; r++)
            matrix.setValue(r, column, matrix.getValue(r, column) * scalar);
        return matrix;
    }
}
