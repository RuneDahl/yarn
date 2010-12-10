/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Implementation of a {@see Differentiator differentiator} for
 * <a href="http://en.wikipedia.org/wiki/Differentiable_function">differentiable</a>
 * {@see Function functions} using the derivate function to compute the value.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>               Type of input.
 * @param <TypeOfFunctionOutput>      Type of output of the function.
 * @param <TypeOfDifferentialOutput>  Type of output from the differential
 *                                   of the function.
 */
public final class Derivative<TypeOfInput, TypeOfFunctionOutput,
        TypeOfDifferentialOutput>
        implements Differentiator<TypeOfInput, TypeOfFunctionOutput,
        TypeOfDifferentialOutput> {
    /**
     * Creates an instance of a Derivative {@see Differentiator differentiator}.
     */
    public Derivative() { // Intentional
    }

    public TypeOfDifferentialOutput Value(final TypeOfInput value,
            final Function<TypeOfInput, TypeOfFunctionOutput> function) {
        if (function instanceof Differentiable) {
            Differentiable<TypeOfInput, TypeOfFunctionOutput,
                    TypeOfDifferentialOutput> differential =
                    (Differentiable<TypeOfInput, TypeOfFunctionOutput,
                    TypeOfDifferentialOutput>) function;
            return differential.getDifferential(value);
        }
        else
            throw new IllegalArgumentException("Function is not " +
                    "Mathematics.Function.Differentiable.");
    }
}