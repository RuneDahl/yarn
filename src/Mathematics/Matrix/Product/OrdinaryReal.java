/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Product;

import Mathematics.Function.*;
import Mathematics.Matrix.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Matrix_product#Ordinary_matrix_product">
 * ordinary matrix product</a> of two {@see Matrix matrices} of {@see Double real values}.
 * @author Rune Dahl Iversen
 */
public class OrdinaryReal implements
        Operator<Matrix<Double>, Matrix<Double>, Matrix<Double>> {
    @Override
    public Matrix<Double> value(final Matrix<Double> firstInput,
            final Matrix<Double> secondInput) {
        if (firstInput.getFirstColumn() != secondInput.getFirstRow())
             throw new IllegalArgumentException("The matrices are not " +
                    "conforming in dimensions: First column does not " +
                    "match the first row.");
        if (firstInput.getColumns() != secondInput.getRows())
            throw new IllegalArgumentException("The matrices are not " +
                    "conforming in dimensions: Number of columns does not " +
                    "match the number of rows.");
        int fr = firstInput.getFirstRow();
        int rs = firstInput.getRows();
        int fc = secondInput.getFirstColumn();
        int cs = secondInput.getColumns();
        MatrixReal mp = new MatrixReal(fr, rs, fc, cs);
        rs += fr;
        cs += fc;
        int fi = firstInput.getFirstColumn();
        int is = fi + firstInput.getColumns();
        for (int r = fr; r < rs; r++)
            for (int c = fc; c < cs; c++)
            {
                double v = 0.0;
                for (int i = fi; i < is; i++)
                    v += firstInput.getValue(r, i) * secondInput.getValue(i, c);
                mp.setValue(r, c, v);
            }
        return mp;
    }
}