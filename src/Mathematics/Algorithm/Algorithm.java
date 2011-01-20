/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface for an
 * <a href="http://en.wikipedia.org/wiki/Algorithm">algorithm</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Algorithm<TypeOfValue> {
    /**
     * Returns the {@see Mathematics.Result.Result result}
     * from this algorithm for the specified value.
     * @param value Value
     * @return The result from this algorithm.
     */
    public Mathematics.Result.Result run(final TypeOfValue value);
}