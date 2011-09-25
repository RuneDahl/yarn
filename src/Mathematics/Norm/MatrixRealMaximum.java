/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Matrix.Matrix;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
 * for a {@see Matrix matrix} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public class MatrixRealMaximum implements Norm<Matrix<Double>> {
    @Override
    public Double value(Matrix<Double> input) {
        double norm = 0.0;
        for (int col = input.getFirstColumn(); col <= input.getLastColumn(); col++)
            for (int row = input.getFirstRow(); row <= input.getLastRow(); row++)
                norm = Math.max(norm, Math.abs(input.getValue(row, col)));
        return norm;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj == null)
            equals = false;
        else
            equals = (obj instanceof MatrixRealMaximum);
        return equals;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName() + "}";
    }
}
