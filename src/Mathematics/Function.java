/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface of a
 * <a href="http://en.wikipedia.org/wiki/Function_%28mathematics%29">function</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input.
 * @param <TypeOfOutput> Type of output.
 */
public interface Function<TypeOfInput, TypeOfOutput> {
    public TypeOfOutput Value(final TypeOfInput input);
}