/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Differentiable_function">differentiable</a>
 * {@see Function function}.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>              Type of input.
 * @param <TypeOfFunctionOutput>     Type of output of the function.
 * @param <TypeOfDifferentialOutput> Type of output of the differential.
 */
public interface Differentiable<TypeOfInput, TypeOfFunctionOutput, TypeOfDifferentialOutput>
        extends Function<TypeOfInput, TypeOfFunctionOutput> {
    /**
     * Gets the differential ({@see Function function}) of this function.
     * @return The differential.
     */
    public Function<TypeOfInput, TypeOfDifferentialOutput> getDifferential();

    /**
     * Gets the value of the differential of this function at the specified value.
     * @param input Value.
     * @return      The value of the differential of this function.
     */
    public TypeOfDifferentialOutput getDifferential(final TypeOfInput input);
}