/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Vector.*;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
 * for a {@see Vector vector} of real values.
 * @author Rune Dahl Iversen
 */
public class VectorDoubleP extends Power<Vector<Double>> {
    private final static VectorDoubleMaximum __maxNorm = new VectorDoubleMaximum();

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
     * for a {@see Vector vector} of real values with the specified power.
     * @param power Power. Must be greater than or equal to 1 and finite.
     * @throws IllegalArgumentException Power is not finite.
     * @throws IllegalArgumentException Power must be greater than or equal to 1.
     */
    public VectorDoubleP(double power) {
        super(power);
    }

    public Double Value(Vector<Double> input) {
        // The trick of normalizing the size by the value of the maximum norm
        // prevents destructive overruns and underruns.
        double power = this.getPower();
        double max = __maxNorm.Value(input);
        double norm = 0.0;
        for (int d = 0; d < input.getDimensions(); d++)
            norm += Math.pow(Math.abs(input.getValue(d)) / max, power);
        return max * Math.pow(norm, 1.0 / power);
    }
}