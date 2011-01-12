/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Determinant;

import Mathematics.Function.Function;
import Mathematics.Matrix.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Determinant">determinant</a>
 * of a square {@see Matrix matrix} of {@see Double real} numbers
 * having 3 or fewer columns/rows.
 * @author Rune Dahl Iversen
 */
public final class MatrixRealThreeDimensionsOrLess
        extends DimensionLimits
        implements Function<Matrix<Double>, Double> {
    /**
     * Creates an instance of this determinant calculator.
     */
    public MatrixRealThreeDimensionsOrLess() {
        super(3);
    }

    @Override
    public Double value(final Matrix<Double> input) {
        if (!input.isSquare())
            throw new IllegalArgumentException("Matrix is not square.");
        int r = input.getFirstRow();
        int c = input.getFirstColumn();
        switch (input.getRows()) {
            case 1:
                return input.getValue(r, c);
            case 2:
                return input.getValue(r, c) * input.getValue(r + 1, c + 1) -
                        input.getValue(r + 1, c) * input.getValue(r, c + 1);
            case 3:
                return input.getValue(r, c) * input.getValue(r + 1, c + 1) * input.getValue(r + 2, c + 2) +
                        input.getValue(r + 1, c) * input.getValue(r + 2, c + 1) * input.getValue(r, c + 2) +
                        input.getValue(r + 2, c) * input.getValue(r, c + 1) * input.getValue(r + 1, c + 2) -
                        input.getValue(r, c) * input.getValue(r + 2, c + 1) * input.getValue(r + 1, c + 2) -
                        input.getValue(r + 1, c) * input.getValue(r, c + 1) * input.getValue(r + 2, c + 2) -
                        input.getValue(r + 2, c) * input.getValue(r + 1, c + 1) * input.getValue(r, c + 2);
            default:
                throw new IllegalArgumentException("Matrix dimensions are too large.");
        }
    }
}