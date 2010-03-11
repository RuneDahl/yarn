/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

/**
 * Interface of a criterion to determine
 * <a href="http://en.wikipedia.org/wiki/Convergence">convergence</a>
 * of a series of values.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Criterion<TypeOfValue> {
    /**
     * Determines if the specified series of values converges according to
     * this {@see Criterion convergence criterion}.
     * @param series Series of values. The first value of the series  is assumed
     *               to have the lowest index.
     * @return       True for convergent else false.
     */
    public boolean Converges(final TypeOfValue[] series);
}