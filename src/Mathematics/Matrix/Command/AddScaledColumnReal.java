/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Matrix.Matrix;
import Validation.Factory;
import Validation.Validator;

/**
 * {@see Command} that scales a specified column of a {@see Matrix matrix}
 * with the specified scalar factor and adds the result to another column.
 * @author Rune Dahl Iversen
 */
public final class AddScaledColumnReal extends Columns<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private double _scalar;

    /**
     * Creates an instance of a command that adds the scaled values from one
     * column to another column.
     * @param columnToAddTo       Index of the column to add the scaled column values to.
     * @param columnToScaleAndAdd Index of the column to scale and add to another column.
     * @param scalar              The scalar factor.
     */
    public AddScaledColumnReal(int columnToAddTo, int columnToScaleAndAdd, double scalar) {
        super(columnToAddTo, columnToScaleAndAdd);
        this.setScalar(scalar);
    }

    /**
     * Gets the index of the column to add the scaled column values to.
     * @return Index of the column to add the scaled column values to.
     */
    public int getColumnToAddTo() {
        return this.getFirstColumn();
    }

    /**
     * Sets the index of the column to add the scaled column values to.
     * @param columnToAddTo Index of the column to add the scaled column values to.
     */
    public void setColumnToAddTo(final int columnToAddTo) {
        this.setFirstColumn(columnToAddTo);
    }

    /**
     * Gets the index of the column to scale and add to another column.
     * @return Index of the column to scale and add to another column.
     */
    public int getColumnToScaleAndAdd() {
        return this.getSecondColumn();
    }

    /**
     * Gets the index of the column to scale and add to another column.
     * @param columnToScaleAndAdd Index of the column to scale and add to another column.
     */
    public void setColumnToScaleAndAdd(final int columnToScaleAndAdd) {
        this.setSecondColumn(columnToScaleAndAdd);
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
        int cTAT = this.getColumnToAddTo();
        int cTSAA = this.getColumnToScaleAndAdd();
        for (int r = matrix.getFirstRow(); r <= matrix.getLastRow(); r++) {
            double v = matrix.getValue(r, cTSAA);
            v *= scalar;
            v += matrix.getValue(r, cTAT);
            matrix.setValue(r, cTAT, v);
        }
        return matrix;
    }
}
