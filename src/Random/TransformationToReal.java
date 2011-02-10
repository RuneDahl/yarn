/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import Mathematics.Function.Function;

/**
 * Implementation of a {@see Function single input transformation}
 * of samples from a {@see Generator generator} to {@see Double real} values.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input.
 */
public final class TransformationToReal<TypeOfInput>
        extends TransformationBased<TypeOfInput, Double> {
    private Function<TypeOfInput, Double> _function;
    private Generator<TypeOfInput> _generator;

    /**
     * Create an instance of a transformation into real values using
     * the specified generator and function.
     * @param generator Generator.
     * @param function  Function.
     */
    public TransformationToReal(
            final Generator<TypeOfInput> generator,
            final Function<TypeOfInput, Double> function) {
        super(generator, function);
    }

    @Override
    public Double[] getSample(final int count) {
        TypeOfInput[] inputs = this._generator.getSample(count);
        Double[] samples = new Double[count];
        for (int index = 0; index < count; index++)
            samples[index] = this._function.value(inputs[index]);
        return samples;
    }
}
