/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import java.util.Collection;

/**
 * Interface of a criterion to determine
 * <a href="http://en.wikipedia.org/wiki/Convergence">convergence</a>
 * of a series of values.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Converges<TypeOfValue> {
    /**
     * Determines if the specified series of values is converging according to
     * this convergence criterion.
     * @param series Series of values.
     * @return       True for convergent else false.
     */
    public boolean Converge(final Collection<TypeOfValue> series);

    /**
     * Determines if the specified series of values is converging according to
     * this convergence criterion.
     * @param series Series of values. The first value of the series  is assumed
     *               to have the lowest index.
     * @return       True for convergent else false.
     */
    public boolean Converge(final TypeOfValue[] series);
}