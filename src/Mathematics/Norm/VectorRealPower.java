/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Vector.*;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
 * for a {@see Vector vector} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public class VectorRealPower extends Power<Vector<Double>> {
    private final static VectorRealMaximum __maxNorm = new VectorRealMaximum();

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
     * for a {@see Vector vector} of {@see Double real} values with the specified power.
     * @param power Power. Must be greater than or equal to 1 and finite.
     */
    public VectorRealPower(double power) {
        super(power);
    }

    @Override
    public Double value(Vector<Double> input) {
        // The trick of normalizing the size by the value of the maximum norm
        // prevents destructive overruns and underruns.
        double power = this.getPower();
        double max = __maxNorm.value(input);
        double norm = 0.0;
        for (int d = 0; d < input.getDimensions(); d++)
            norm += Math.pow(Math.abs(input.getValue(d)) / max, power);
        return max * Math.pow(norm, 1.0 / power);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = (obj != null);
        if (obj instanceof VectorRealPower)
            equals = this._equals((VectorRealPower)obj);
        else
            equals = false;
        return equals;
    }

    @Override
    public int hashCode() {
        return this._hashCode();
    }
}