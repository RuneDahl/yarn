/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a {@see Distribution probability distribution} with a
 * <a href="http://en.wikipedia.org/wiki/Quantile_function">
 * quantile function</a>. The quantile function is also known as the
 * <a href="http://en.wikipedia.org/wiki/Inverse_function">inverse</a>
 * {@see DistributionFunction cumulative distribution function}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface QuantileFunction<TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Returns the quantile value of this distribution
     * evaluated at the specified quantile.
     * @param quantile Quantile. This should be a number in the interval 0 through 1.
     * @return         Quantile value.
     */
    public TypeOfValue quantileFunction(final double quantile);
}