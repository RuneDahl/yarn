/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 *
 * @author Rune Dahl Iversen
 */
public class DoubleRelative extends PrecisionBased<Double> {
    /**
     * Creates an instance of a DoubleRelative equality-comparer
     * with the default precision of 0.
     */
    public DoubleRelative() {
        super();
    }

    /**
     * Creates an instance of a DoubleRelative equality-comparer
     * with the specified required precision.
     * @param precision The precision.
     *                  Must be a non-negative, finite number.
     */
    public DoubleRelative(final double precision) {
        super(precision);
    }

    public boolean Equal(final Double a, final Double b) {
        double denominator = Math.max(Math.abs(a), Math.abs(b));
        if (denominator == 0.0)
            return true;
        return (Math.abs(a - b) / denominator) <= this.getPrecision();
    }
}
