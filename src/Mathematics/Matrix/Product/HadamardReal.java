/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Product;

import Mathematics.Function.*;
import Mathematics.Matrix.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Matrix_product#Hadamard_product">
 * Hadamard product</a> of two {@see Matrix matrices} of {@see Double real values}. <br>
 * This function result in a matrix containing the multiplies the individual
 * entries in the 2 matrices, that must be the of the same dimensions.
 * @author Rune Dahl Iversen
 */
public final class HadamardReal
        implements Operator<Matrix<Double>, Matrix<Double>, Matrix<Double>> {
    public Matrix<Double> value(final Matrix<Double> firstInput,
            final Matrix<Double> secondInput) {
        if (!firstInput.hasSameDimensions(secondInput))
            throw new IllegalArgumentException("The matrices are not " +
                    "conforming in dimensions.");
        int fr = firstInput.getFirstRow();
        int rs = firstInput.getRows();
        int fc = firstInput.getFirstColumn();
        int cs = firstInput.getColumns();
        Matrix<Double> ep = new MatrixReal(fr, rs, fc, cs);
        rs += fr;
        cs += fc;
        for (int r = fr; r < rs; r++)
            for (int c = fc; c < cs; c++)
                ep.setValue(r, c,
                        firstInput.getValue(r, c) * secondInput.getValue(r, c));
        return ep;
    }
}
