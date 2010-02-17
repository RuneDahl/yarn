/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.Additive;
import Mathematics.Norm;

/**
 * Implementation of an {@see Mathematics.Norm}-based comparison of
 * {@see Mathematics.Additive} values considering the norm of the difference
 * relative to the maximum of the two value's norm in relation to the
 * specified precision.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class NormRelative<TypeOfValue> extends NormBased<TypeOfValue> {
    /**
     * Creates an instance of a NormRelative equality-comparer
     * with the specified required precision and {@see Mathematics.Norm norm}.
     * @param precision The precision.
     * @param norm      The norm.
     */
    public NormRelative(double precision, Norm<TypeOfValue> norm) {
        super(precision, norm);
    }

    public boolean Equal(final TypeOfValue a, final TypeOfValue b) {
        if (a == null)
            throw new NullPointerException("The value a is null.");
        else if (b == null)
            throw new NullPointerException("The value b is null.");
        else if (a instanceof Additive) {
            Additive<TypeOfValue> basis = (Additive<TypeOfValue>) a;
            Norm<TypeOfValue> norm = this.getNorm();
            double denominator = Math.max(norm.Value(a), norm.Value(b));
            if (denominator == 0.0)
                return true;
            TypeOfValue difference = basis.Subtract(b);
            return norm.Value(difference) / denominator <= this.getPrecision();
        }
        else
            throw new IllegalStateException("The specified values are not additive.");
    }
}