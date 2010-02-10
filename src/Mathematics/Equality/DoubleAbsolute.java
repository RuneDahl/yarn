/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 * Comparison of double values using the absolute value of the difference.
 * @author Rune Dahl Iversen
 */
public final class DoubleAbsolute extends PrecisionBased<Double> {
    /**
     * Creates an instance of a DoubleAbsolute equality-comparer
     * with the default precision of 0.
     */
    public DoubleAbsolute() {
        super();
    }

    /**
     * Creates an instance of a DoubleAbsolute equality-comparer
     * with the specified required precision.
     * @param precision The precision.
     *                  Must be a non-negative, finite number.
     */
    public DoubleAbsolute(final double precision) {
        super(precision);
    }

    public boolean Equal(final Double a, final Double b) {
        return Math.abs(a - b) <= this.getPrecision();
    }
}