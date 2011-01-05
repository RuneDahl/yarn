/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 * Comparison of double values using a
 * <a href="http://en.wikipedia.org/wiki/Relative_difference">fractional range scale</a>.<br>
 * @see <a href="http://en.wikipedia.org/wiki/Loss_of_significance">
 * [1] Wikipedia - Loss of significance</a>.
 * @author Rune Dahl Iversen
 */
public class DoubleFractionalRange extends PrecisionBased<Double> {
    /**
     * Creates an instance of a DoubleFractionalRange equality-comparer
     * with the default precision of 0.
     */
    public DoubleFractionalRange() {
        super();
    }

    /**
     * Creates an instance of a DoubleFractionalRange equality-comparer
     * with the specified required precision.
     * @param precision The precision.
     *                  Must be a non-negative, finite number.
     */
    public DoubleFractionalRange(final double precision) {
        super(precision);
    }

    @Override
    public Boolean value(final Double a, final Double b) {
        if (a == null || b == null ||
                Double.isInfinite(a) || Double.isNaN(a) ||
                Double.isInfinite(b) || Double.isNaN(b))
            return false;
        double denominator = Math.abs(a) + Math.abs(b);
        if (denominator == 0.0)
            return true;
        denominator /= 2.0; // The denominator is now the average absolute value.
        /*
         * In an attempt to not destroy a large number of significant
         * digits the code does not subtract a from b, but considers
         * if the value b divided by the denominator is within the
         * precision of the value a divided by the denominator.
         * See [1].
         */
        return a / denominator - this.getPrecision() <= b / denominator &&
                b / denominator <= a / denominator + this.getPrecision();
    }
}