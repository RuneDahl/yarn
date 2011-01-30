/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;
import Mathematics.Vector.*;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
 * for a {@see Vector vector} of {@see Complex complex} values.
 * @author Rune Dahl Iversen
 */
public final class VectorComplexPower extends Power<Vector<Complex>> {
    private final VectorComplexMaximum _maxNorm;
    private Norm<Complex> _norm;

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
     * for a {@see Vector vector} of {@see Complex complex} values with the specified power.
     * @param power Power. Must be greater than or equal to 1 and finite.
     */
    public VectorComplexPower(double power, final Norm<Complex> norm) {
        super(power);
        this._maxNorm = new VectorComplexMaximum(norm);
        this.setNorm(norm);
    }

    /**
     * Gets the norm of the individual complex numbers of the vector.
     * @return Norm.
     */
    public Norm<Complex> getNorm() {
        return this._norm;
    }

    /**
     * Sets the norm of the individual complex numbers of the vector.
     * @param norm Norm.
     * @throws NullPointerException Norm not properly specified.
     */
    public void setNorm(final Norm<Complex> norm) {
        if (norm == null)
            throw new NullPointerException("Norm not properly specified.");
        this._norm = norm;
        this._maxNorm.setNorm(norm);
    }

    @Override
    public Double value(Vector<Complex> input) {
        // The trick of normalizing the size by the value of the maximum norm
        // prevents destructive overruns and underruns.
        double power = this.getPower();
        double max = _maxNorm.value(input);
        // Handle the case infinity, that would result in max equaling Double.POSITIVE_INFINITY.
        if (Double.isInfinite(max))
            return max;
        // Handle the case zero, that would result in max equaling 0.
        else if (max == 0.0)
            return max;
        double norm = 0.0;
        for (int d = input.getFirstDimension(); d <= input.getLastDimension(); d++)
            norm += Math.pow(this._norm.value(input.getValue(d)) / max, power);
        return max * Math.pow(norm, 1.0 / power);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = (obj != null);
        if (obj instanceof VectorComplexPower)
            equals = this._equals((VectorComplexPower)obj);
        else
            equals = false;
        return equals;
    }

    @Override
    public int hashCode() {
        return this._hashCode();
    }
}