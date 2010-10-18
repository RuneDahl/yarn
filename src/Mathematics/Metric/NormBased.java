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

    public Double Value(final TypeOfValue firstInput,
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
}