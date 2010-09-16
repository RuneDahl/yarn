/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 * Comparison of double values using a
 * <a href="http://en.wikipedia.org/wiki/Relative_difference">relative scale</a>.<br>
 * @see <a href="http://en.wikipedia.org/wiki/Loss_of_significance">
 * [1] Wikipedia - Loss of significance</a>.
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
        if (a == null || b == null ||
                Double.isInfinite(a) || Double.isNaN(a) ||
                Double.isInfinite(b) || Double.isNaN(b))
            return false;
        double denominator = Math.max(Math.abs(a), Math.abs(b));
        if (denominator == 0.0)
            return true;
        /*
         * In an attempt to not destroy a large number of significant
         * digits the code does not subtract a from b, but considers
         * if the smallest absolute value times the sign of the product
         * relative to the largest absolute value is close to 1.
         * See [1].
         */
        double numerator = Math.min(Math.abs(a), Math.abs(b)) *
                Math.signum(a * b);
        return 1.0 - this.getPrecision() <= (numerator / denominator);
    }
}