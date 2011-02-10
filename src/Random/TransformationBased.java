/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import Mathematics.Function.Function;

/**
 * Abstract implementation of a {@see Function single input
 * transformation} of samples from a {@see Generator generator}.
 * @author Rune Dahl Iversen
 * @param <TypeOfSample> Type of sample.
 * @param <TypeOfOutput> Type of output.
 */
public abstract class TransformationBased<TypeOfSample, TypeOfOutput>
        implements Generator<TypeOfOutput> {
    private Function<TypeOfSample, TypeOfOutput> _function;
    private Generator<TypeOfSample> _generator;

    /**
     * Create an instance of a transformation
     * with the specified generator and function.
     * @param generator Generator.
     * @param function  Function.
     */
    protected TransformationBased(
            final Generator<TypeOfSample> generator,
            final Function<TypeOfSample, TypeOfOutput> function) {
        this.setGenerator(generator);
        this.setFunction(function);
    }

    /**
     * Gets the transforming {@see Function function} of this transformation.
     * @return Function.
     */
    public final Function<TypeOfSample, TypeOfOutput> getFunction() {
        return this._function;
    }

    /**
     * Gets the {@see Generator generator} of this transformation.
     * @return Transformation.
     */
    public final Generator<TypeOfSample> getGenerator() {
        return this._generator;
    }

    /**
     * Sets the transforming {@see Function function} of this transformation.
     * @param function Function.
     * @throws NullPointerException Function not properly specified.
     */
    public final void setFunction(final Function<TypeOfSample, TypeOfOutput> function) {
        if (function == null)
            throw new NullPointerException("Function not properly specified.");
        this._function = function;
    }

    /**
     * Sets the {@see Generator generator} of this transformation.
     * @param generator Generator.
     * @throws NullPointerException Generator not properly specified.
     */
    public final void setGenerator(final Generator<TypeOfSample> generator) {
        if (generator == null)
            throw new NullPointerException("Generator not properly specified.");
        this._generator = generator;
    }

    @Override
    public final TypeOfOutput getSample() {
        return this._function.value(this._generator.getSample());
    }
}
