/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 * Comparison of double values.<br>
 * @see <a href="http://en.wikipedia.org/wiki/Loss_of_significance">
 * [1] Wikipedia - Loss of significance</a>.
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
        if (a == null || b == null ||
                Double.isInfinite(a) || Double.isNaN(a) ||
                Double.isInfinite(b) || Double.isNaN(b))
            return false;
        /*
         * In an attempt to not destroy a large number of significant
         * digits the code does not subtract a from b, but considers
         * if b is within the precision of a.
         * See [1].
         */
        return a - this.getPrecision() <= b && b <= a + this.getPrecision();
    }
}