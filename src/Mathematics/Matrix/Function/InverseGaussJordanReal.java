/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Function;

import Mathematics.Command;
import Mathematics.Function.Function;
import Mathematics.Matrix.*;
import Mathematics.Matrix.Command.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Gauss%E2%80%93Jordan_elimination">
 * Gauss-Jordan elimination</a> for
 * <a href="http://en.wikipedia.org/wiki/Inverse_matrix">inverting</a> a
 * {@see Matrix matrix} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public class InverseGaussJordanReal
        implements Function<Matrix<Double>, Matrix<Double>> {

    @Override
    public Matrix<Double> value(final Matrix<Double> input) {
        if (!input.isSquare())
            throw new IllegalArgumentException("Input is not a square matrix.");
        Matrix<Double> matrix = (Matrix<Double>) input.clone();
        Matrix<Double> inverse =
                MatrixReal.Identity(matrix.getFirstRow(), matrix.getRows());

        // For each column in the matrix going forward
        for (int col = matrix.getFirstColumn(); col <= matrix.getLastColumn(); col++) {
            double maxValue = 0.0;
            int r = matrix.getFirstRow();
            // Identify the row that has the same relative position as the column.
            // Thus the position (cRow, col) is in the diagonal.
            int cRow = matrix.getFirstRow() + col - matrix.getFirstColumn();
            // Identify the largest value in the column, that is below the diagonal.
            for (int row = cRow; row <= matrix.getLastRow(); row++) {
                double value = matrix.getValue(row, col);
                if (maxValue < Math.abs(value)) {
                    maxValue = Math.abs(value);
                    r = row;
                }
            }
            // Switch rows to place the largest value in the diagonal.
            Command<Matrix<Double>> switchRows = new SwitchRows<Double>(cRow, r);
            switchRows.applyTo(matrix);
            switchRows.applyTo(inverse);
            // Scale the cRow to get a 1.0 in the diagonal.
            Command<Matrix<Double>> scaleRow = new ScaleRowReal(
                    cRow, 1.0 / matrix.getValue(cRow, col));
            scaleRow.applyTo(matrix);
            scaleRow.applyTo(inverse);
            // For each row below the diagonal
            for (int row = cRow + 1; row <= matrix.getLastRow(); row++)
                if (matrix.getValue(row, col) != 0.0) {
                    // Add the scaled cRow to get a 0.0 in the column value.
                    Command<Matrix<Double>> addScaledRow = new AddScaledRowReal(
                            row, cRow, -matrix.getValue(row, col));
                    addScaledRow.applyTo(matrix);
                    addScaledRow.applyTo(inverse);
                }
        }
        // For each column in the matrix going backward
        for (int col = matrix.getLastColumn(); matrix.getFirstColumn() < col; col--) {
            // Identify the row that has the same relative position as the column.
            // Thus the position (cRow, col) is in the diagonal.
            int cRow = matrix.getLastRow() + col - matrix.getLastColumn();
            // For each row above the diagonal
            for (int row = cRow - 1; matrix.getFirstRow() <= row; row--)
                if (matrix.getValue(row, col) != 0.0) {
                    // Add the scaled cRow to get a 0.0 in the column value.
                    Command<Matrix<Double>> addScaledRow = new AddScaledRowReal(
                            row, cRow, -matrix.getValue(row, col));
                    addScaledRow.applyTo(matrix);
                    addScaledRow.applyTo(inverse);
                }
        }
        return inverse.transpose();
    }
}
