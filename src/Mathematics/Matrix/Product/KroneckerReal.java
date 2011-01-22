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
    @Override
    public Matrix<Double> value(final Matrix<Double> firstInput,
            final Matrix<Double> secondInput) {
        int fir = firstInput.getRows();
        int fic = firstInput.getColumns();
        int rows = secondInput.getRows() * fir;
        int columns = secondInput.getColumns() * fic;
        int ffr = firstInput.getFirstRow();
        int ffc = firstInput.getFirstColumn();
        int sfr = secondInput.getFirstRow();
        int sfc = secondInput.getFirstColumn();
        MatrixReal kp = new MatrixReal(0, rows, 0, columns);
        int sr = -1;
        for (int r = 0; r < rows; r++) {
            int fr = (r % fir);
            sr += (fr == 0 ? 1 : 0);
            int sc = -1;
            for (int c = 0; c < columns; c++)
            {
                int fc = (c % fic);
                sc += (fc == 0 ? 1 : 0);
                kp.setValue(r, c,
                        firstInput.getValue(fr + ffr, fc + ffc) *
                        secondInput.getValue(sr + sfr, sc + sfc));
            }
        }
        return kp;
    }
}