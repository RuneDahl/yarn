/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Product;

import Mathematics.Function.*;
import Mathematics.Matrix.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Kronecker_product">
 * Kronecker product</a> of two {@see Matrix matrices} of {@see Double real values}.
 * @author Rune Dahl Iversen
 */
public class KroneckerReal implements
        Operator<Matrix<Double>, Matrix<Double>, Matrix<Double>> {
    public Matrix<Double> value(Matrix<Double> firstInput,
            Matrix<Double> secondInput) {
        int sir = secondInput.getRows();
        int sic = secondInput.getColumns();
        int rows = firstInput.getRows() * sir;
        int columns = firstInput.getColumns() * sic;
        int ffr = firstInput.getFirstRow();
        int ffc = firstInput.getFirstColumn();
        int sfr = secondInput.getFirstRow();
        int sfc = secondInput.getFirstColumn();
        MatrixReal kp = new MatrixReal(0, rows, 0, columns);
        for (int r = 0; r < rows; r++) {
            int fr = (r % sir);
            int sr = r - (fr * sir);
            for (int c = 0; c < columns; c++)
            {
                int fc = (c % sic);
                int sc = c - (fc * sic);
                kp.setValue(r, c,
                        firstInput.getValue(fr + ffr, fc + ffc) *
                        secondInput.getValue(sr + sfr, sc + sfc));
            }
        }
        return kp;
    }
}