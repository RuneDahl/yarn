/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface for an
 * <a href="http://en.wikipedia.org/wiki/Algorithm">algorithm</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfResult> Type of result.
 */
public interface Algorithm<TypeOfResult> {
    /**
     * Returns the result of running this algorithm.
     * @return The result from this algorithm.
     */
    public TypeOfResult run();
}