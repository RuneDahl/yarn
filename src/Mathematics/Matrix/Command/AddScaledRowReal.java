/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Matrix.Matrix;
import Validation.Factory;
import Validation.Validator;

/**
 * {@see Command} that scales a specified row of a {@see Matrix matrix}
 * with the specified scalar factor and adds the result to another row.
 * @author Rune Dahl Iversen
 */
public final class AddScaledRowReal extends Rows<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private double _scalar;

    /**
     * Creates an instance of a command that adds the scaled values from one
     * row to another row.
     * @param rowToAddTo       Index of the row to add the scaled row values to.
     * @param rowToScaleAndAdd Index of the row to scale and add to another row.
     * @param scalar           The scalar factor.
     */
    public AddScaledRowReal(int rowToAddTo, int rowToScaleAndAdd, double scalar) {
        super(rowToAddTo, rowToScaleAndAdd);
        this.setScalar(scalar);
    }

    /**
     * Gets the index of the row to add the scaled row values to.
     * @return Index of the row to add the scaled row values to.
     */
    public int getRowToAddTo() {
        return this.getFirstRow();
    }

    /**
     * Sets the index of the row to add the scaled row values to.
     * @param RowToAddTo Index of the row to add the scaled row values to.
     */
    public void setRowToAddTo(final int RowToAddTo) {
        this.setFirstRow(RowToAddTo);
    }

    /**
     * Gets the index of the row to scale and add to another row.
     * @return Index of the row to scale and add to another row.
     */
    public int getRowToScaleAndAdd() {
        return this.getSecondRow();
    }

    /**
     * Gets the index of the row to scale and add to another row.
     * @param RowToScaleAndAdd Index of the row to scale and add to another row.
     */
    public void setRowToScaleAndAdd(final int RowToScaleAndAdd) {
        this.setSecondRow(RowToScaleAndAdd);
    }

    /**
     * Gets the scalar factor.
     * @return The scalar factor.
     */
    public double getScalar() {
        return _scalar;
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
    public Matrix<Double> applyTo(Matrix<Double> matrix) {
        double scalar = this.getScalar();
        if (scalar == 0.0)
            return matrix;
        int rTAT = this.getRowToAddTo();
        int rTSAA = this.getRowToScaleAndAdd();
        for (int c = matrix.getFirstColumn(); c <= matrix.getLastColumn(); c++) {
            double v = matrix.getValue(rTSAA, c);
            v *= scalar;
            v += matrix.getValue(rTAT, c);
            matrix.setValue(rTAT, c, v);
        }
        return matrix;
    }
}
