/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Metric;

import Mathematics.Subtractable;
import Mathematics.Norm.Norm;

/**
 * Implementation of a {@see Mathematics.Norm.Norm norm}-based {@see Metric metric}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public final class NormBased<TypeOfValue> implements Metric<TypeOfValue> {
    private Norm<TypeOfValue> _norm;

    /**
     * Creates an instance of a {@see Mathematics.Norm.Norm norm}-based
     * {@see Metric metric}.
     * @param norm The norm.
     */
    public NormBased(final Norm<TypeOfValue> norm) {
        this.setNorm(norm);
    }

    /**
     * Gets the {@see Mathematics.Norm.Norm norm} that is the basis of this metric.
     * @return The norm.
     * @throws NullPointerException The norm is not properly specified.
     */
    public Norm<TypeOfValue> getNorm() {
        return this._norm;
    }

    /**
     * Sets the {@see Mathematics.Norm.Norm norm} that is the basis of this metric.
     * @param norm The norm.
     * @throws NullPointerException The norm is not properly specified.
     */
    public void setNorm(final Norm<TypeOfValue> norm) {
        if (norm == null)
            throw new NullPointerException("The norm is not properly specified.");
        this._norm = norm;
    }

    @Override
    public Double value(final TypeOfValue firstInput,
            final TypeOfValue secondInput) {
        if (firstInput == null)
            throw new NullPointerException("First input is null.");
        else if (secondInput == null)
            throw new NullPointerException("Second input is null.");
        else if (!(firstInput instanceof Subtractable))
            throw new IllegalStateException("The type of value is not subtractable.");
        Subtractable<TypeOfValue> base = (Subtractable<TypeOfValue>) firstInput;
        TypeOfValue diff = base.subtract(secondInput);
        return this._norm.value(diff);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj == null)
            equals = false;
        else if (obj == this)
            equals = true;
        else if (obj instanceof NormBased)
            equals = this._norm.equals(((NormBased)obj).getNorm());
        else
            equals = false;
        return equals;
    }

    @Override
    public int hashCode() {
        return this._norm.hashCode();
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName() + "(Norm: " + this._norm.toString() + ")}";
    }
}