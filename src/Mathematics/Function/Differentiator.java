/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Interface for a differentiator. A differentiator computes/estimates the
 * <a href="http://en.wikipedia.org/wiki/Derivative">derivative</a>
 * of a function at a specified value.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>              Type of input.
 * @param <TypeOfFunctionOutput>     Type of output from the function.
 * @param <TypeOfDifferentialOutput> Type of output from the differential
 *                                   of the function.
 */
public interface Differentiator<TypeOfInput, TypeOfFunctionOutput,
        TypeOfDifferentialOutput> {
    /**
     * Returns the derivative value of the function at the specified value.
     * @param value    Value.
     * @param function Function.
     * @return         The derivative value.
     */
    public abstract TypeOfDifferentialOutput value(final TypeOfInput value,
            final Function<TypeOfInput, TypeOfFunctionOutput> function);
}