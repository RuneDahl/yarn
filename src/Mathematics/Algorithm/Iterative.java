/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface for an
 * <a href="http://en.wikipedia.org/wiki/Iterative">iterative</a>
 * {@see Algorithm algorithm}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Iterative<TypeOfValue> extends Algorithm<TypeOfValue> {
    /**
     * Gets the maximum number of iterations allowed.
     * @return The maximum number of iterations allowed.
     */
    public int getMaximumIterations();

    /**
     * Sets the maximum number of iterations allowed.
     * @param iterations The maximum number of iterations allowed.
     */
    public void setMaximumIterations(final int iterations);
}