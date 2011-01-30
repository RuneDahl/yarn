/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;
import Mathematics.Vector.*;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
 * for a {@see Vector vector} of {@see Complex complex} values.
 * @author Rune Dahl Iversen
 */
public final class VectorComplexMaximum implements Norm<Vector<Complex>> {
    private Norm<Complex> _norm;

    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
     * for a {@see Vector vector} of {@see Complex complex} values.
     */
    public VectorComplexMaximum(final Norm<Complex> norm) {
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
    }

    @Override
    public Double value(final Vector<Complex> input) {
        double norm = 0.0;
        for (int d = input.getFirstDimension(); d <= input.getLastDimension(); d++)
            norm = Math.max(norm, this._norm.value(input.getValue(d)));
        return norm;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean equals = false;
        if (obj == null)
            equals = false;
        else if (obj == this)
            equals = true;
        else
            equals = (obj instanceof VectorComplexMaximum);
        return equals;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "{Mathematics.Norm.VectorComplexMaximum(" + this._norm.toString() + ")}";
    }
}