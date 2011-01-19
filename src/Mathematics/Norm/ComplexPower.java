/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
 * for a {@see Complex complex number}.
 * @author Rune Dahl Iversen
 */
public final class ComplexPower extends Power<Complex> {
    private final static ComplexMaximum __maxNorm = new ComplexMaximum();

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
     * for a {@see Complex complex number} with the specified power.
     * @param power Power. Must be greater than or equal to 1 and finite.
     */
    public ComplexPower(double power) {
        super(power);
    }

    @Override
    public Double value(final Complex input) {
        // The trick of normalizing the size by the value of the maximum norm
        // prevents destructive overruns and underruns.
        double power = this.getPower();
        double max = __maxNorm.value(input);
        // Handle the case Complex.Inifity, that would result in max equaling Double.POSITIVE_INFINITY.
        if (Double.isInfinite(max))
            return max;
        // Handle the case Complex.Origin, that would result in max equaling 0.
        else if (max == 0.0)
            return max;
        double norm = Math.pow(Math.abs(input.getReal()) / max, power);
        norm += Math.pow(Math.abs(input.getImaginary()) / max, power);
        return max * Math.pow(norm, 1.0 / power);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = (obj != null);
        if (obj instanceof ComplexPower)
            equals = this._equals((ComplexPower)obj);
        else
            equals = false;
        return equals;
    }

    @Override
    public int hashCode() {
        return this._hashCode();
    }
}