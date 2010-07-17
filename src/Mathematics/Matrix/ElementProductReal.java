/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Function.*;

/**
 * Implementation of the element-by-element product
 * of two {@see Matrix matrices} of real values.
 * @author Rune Dahl Iversen
 */
public final class ElementProductReal
        implements Operator<Matrix<Double>, Matrix<Double>, Matrix<Double>> {
    public Matrix<Double> Value(final Matrix<Double> firstInput,
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
