/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Determinant;

import Mathematics.Complex;
import Mathematics.Function.Function;
import Mathematics.Matrix.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Determinant">determinant</a>
 * of a square {@see Matrix matrix} of {@see Complex complex} numbers
 * having 3 or fewer columns/rows.
 * @author Rune Dahl Iversen
 */
public final class MatrixComplexThreeDimensionsOrLess
        extends DimensionLimit
        implements Function<Matrix<Complex>, Complex> {
    /**
     * Creates an instance of this determinant calculator.
     */
    public MatrixComplexThreeDimensionsOrLess() {
        super(3);
    }

    public Complex Value(Matrix<Complex> input) {
        if (!input.isSquare())
            throw new IllegalArgumentException("Matrix is not square.");
        int r = input.getFirstRow();
        int c = input.getFirstColumn();
        switch (input.getRows()) {
            case 1:
                return input.getValue(r, c);
            case 2:
                return input.getValue(r, c).Multiply(input.getValue(r + 1, c + 1))
                        .Subtract(input.getValue(r + 1, c).Multiply(input.getValue(r, c + 1)));
            case 3:
                return input.getValue(r, c).Multiply(input.getValue(r + 1, c + 1).Multiply(input.getValue(r + 2, c + 2)))
                        .Add(input.getValue(r + 1, c).Multiply(input.getValue(r + 2, c + 1).Multiply(input.getValue(r, c + 2))))
                        .Add(input.getValue(r + 2, c).Multiply(input.getValue(r, c + 1).Multiply(input.getValue(r + 1, c + 2))))
                        .Subtract(input.getValue(r, c).Multiply(input.getValue(r + 2, c + 1).Multiply(input.getValue(r + 1, c + 2))))
                        .Subtract(input.getValue(r + 1, c).Multiply(input.getValue(r, c + 1).Multiply(input.getValue(r + 2, c + 2))))
                        .Subtract(input.getValue(r + 2, c).Multiply(input.getValue(r + 1, c + 1).Multiply(input.getValue(r, c + 2))));
            default:
                throw new IllegalArgumentException("Matrix dimensions are too large.");
        }
    }
}