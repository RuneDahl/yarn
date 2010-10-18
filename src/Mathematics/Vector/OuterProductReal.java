/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Mathematics.Function.Operator;
import Mathematics.Matrix.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Outer_product">outer product</a> of
 * two {@see Vector vectors} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public final class OuterProductReal
        implements Operator<Vector<Double>, Vector<Double>, Matrix<Double>> {
    public Matrix<Double> value(final Vector<Double> firstInput,
            final Vector<Double> secondInput) {
        int startR = firstInput.getFirstDimension();
        int endR = startR + firstInput.getDimensions();
        int startC = secondInput.getFirstDimension();
        int endC = startC + secondInput.getDimensions();
        Matrix<Double> op = new MatrixReal(startR, firstInput.getDimensions(),
                startC, secondInput.getDimensions());
        for (int row = startR; row < endR; row++)
            for (int col = startC; col < endC; col++)
                op.setValue(row, col,
                        firstInput.getValue(row) * secondInput.getValue(col));
        return op;
    }
}