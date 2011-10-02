/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Function;

import Mathematics.Command;
import Mathematics.Function.*;
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

        Operator<Double, Double, Boolean> comparer = new LargestAbsoluteValue();
        IndexOfBestValueInColumn indexFinder =
                new IndexOfBestValueInColumn(0, 0, matrix.getLastRow(), comparer);
        // For each column in the matrix going forward
        for (int col = matrix.getFirstColumn(); col <= matrix.getLastColumn(); col++) {
            // Identify the row that has the same relative position as the column.
            // Thus the position (cRow, col) is in the diagonal.
            int cRow = matrix.getFirstRow() + col - matrix.getFirstColumn();
            // Find the index of the numerically largest value below the diagonal.
            indexFinder.setColumn(col);
            indexFinder.setLowerRowBound(cRow);
            int r = indexFinder.value(matrix);
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

    private final class LargestAbsoluteValue
            implements Operator<Double, Double, Boolean> {
        @Override
        public Boolean value(Double firstInput, Double secondInput) {
            return Math.abs(firstInput) < Math.abs(secondInput);
        }
    }
}
