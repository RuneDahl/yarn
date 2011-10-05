/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Matrix.Matrix;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
 * for a {@see Matrix matrix} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public class MatrixRealPower extends Power<Matrix<Double>> {
    private final static MatrixRealMaximum __maxNorm = new MatrixRealMaximum();

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">
     * P-norm</a> for a matrix of real values with the specified power.
     * @param power Power. Must be greater than or equal to 1 and finite.
     */
    public MatrixRealPower(double power) {
        super(power);
    }

    @Override
    public Double value(Matrix<Double> input) {
        // The trick of normalizing the size by the value of the maximum norm
        // prevents destructive overruns and underruns.
        double power = this.getPower();
        double max = __maxNorm.value(input);
        // Handle the case infinity, that would result in max equaling Double.POSITIVE_INFINITY.
        if (Double.isInfinite(max))
            return max;
        // Handle the case zero, that would result in max equaling 0.
        else if (max == 0.0)
            return max;
        double norm = 0.0;
        for (int col = input.getFirstColumn(); col <= input.getLastColumn(); col++)
            for (int row = input.getFirstRow(); row <= input.getLastRow(); row++)
                norm += Math.pow(Math.abs(input.getValue(row, col)) / max, power);
        return max * Math.pow(norm, 1.0 / power);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = (obj != null);
        if (obj instanceof Power)
            equals = this._equals((Power<Matrix<Double>>)obj);
        else
            equals = false;
        return equals;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName() + "(" +
                Double.toString(this.getPower()) + ")}";
    }
}
