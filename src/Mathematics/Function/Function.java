/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Function_%28mathematics%29">function</a>.
 * <br> NB: It is assumed that a function does not
 * (significantly) alter the state of the input value.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input.
 * @param <TypeOfOutput> Type of output.
 */
public interface Function<TypeOfInput, TypeOfOutput> {
    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Function_%28mathematics%29">function</a>
     * value evaluated at the specified input value.
     * @param input Input value.
     * @return      The function value.
     */
    public TypeOfOutput value(final TypeOfInput input);
}