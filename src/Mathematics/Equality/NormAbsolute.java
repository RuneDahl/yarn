/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.Norm.Norm;

/**
 * Implementation of an {@see Mathematics.Norm norm}-based comparison of
 * {@see Mathematics.Additive additive} values considering the norm of the
 * difference relative to the specified precision.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class NormAbsolute<TypeOfValue> extends NormBased<TypeOfValue> {
    /**
     * Creates an instance of a NormAbsolute equality-comparer
     * with the specified required precision and {@see Mathematics.Norm norm}.
     * @param precision The precision.
     * @param norm      The norm.
     */
    public NormAbsolute(final double precision, final Norm<TypeOfValue> norm) {
        super(precision, norm);
    }

    @Override
    public Boolean value(final TypeOfValue a, final TypeOfValue b) {
        return this.getMetric().value(a, b) <= this.getPrecision();
    }
}