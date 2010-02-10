/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 * Comparison of double values using the absolute value of the difference
 * relative to the sum of the absolute values.
 * @author Rune Dahl Iversen
 */
public class DoubleFractionalRange extends PrecisionBased<Double> {
    /**
     * Creates an instance of a DoubleRelative equality-comparer
     * with the default precision of 0.
     */
    public DoubleFractionalRange() {
        super();
    }

    /**
     * Creates an instance of a DoubleRelative equality-comparer
     * with the specified required precision.
     * @param precision The precision.
     *                  Must be a non-negative, finite number.
     */
    public DoubleFractionalRange(final double precision) {
        super(precision);
    }

    public boolean Equal(final Double a, final Double b) {
        double denominator = Math.abs(a) + Math.abs(b);
        if (denominator == 0.0)
            return true;
        return (Math.abs(a - b) / denominator) <= this.getPrecision();
    }
}