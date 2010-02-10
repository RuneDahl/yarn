/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a mathematical
 * <a href="http://en.wikipedia.org/wiki/Metric_%28mathematics%29">metric</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Metric<TypeOfValue>
        extends Operator<TypeOfValue, TypeOfValue, Double> {
}