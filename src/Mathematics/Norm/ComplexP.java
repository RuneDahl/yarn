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
public final class ComplexP extends Power<Complex> {
    private ComplexMaximum _maxNorm = new ComplexMaximum();

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
     * for a {@see Complex complex number} with the specified power.
     * @param power Power. Must be greater than or equal to 1 and finite.
     * @throws IllegalArgumentException Power is not finite.
     * @throws IllegalArgumentException Power must be greater than or equal to 1.
     */
    public ComplexP(double power) {
        super(power);
    }

    public Double Value(final Complex input) {
        // The trick of normalizing the size by the value of the maximum norm
        // prevents destructive overruns and underruns.
        double power = this.getPower();
        double max = this._maxNorm.Value(input);
        double norm = Math.pow(Math.abs(input.getReal()) / max, power);
        norm += Math.pow(Math.abs(input.getImaginary()) / max, power);
        return max * Math.pow(norm, 1.0 / power);
    }
}