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
        extends GeneratorBased<TypeOfSample, TypeOfOutput> {
    private Function<TypeOfSample, TypeOfOutput> _function;

    /**
     * Create an instance of a transformation
     * with the specified generator and function.
     * @param generator Generator.
     * @param function  Function.
     */
    protected TransformationBased(
            final Generator<TypeOfSample> generator,
            final Function<TypeOfSample, TypeOfOutput> function) {
        super(generator);
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
     * Sets the transforming {@see Function function} of this transformation.
     * @param function Function.
     * @throws NullPointerException Function not properly specified.
     */
    public final void setFunction(final Function<TypeOfSample, TypeOfOutput> function) {
        if (function == null)
            throw new NullPointerException("Function not properly specified.");
        this._function = function;
    }

    @Override
    public final TypeOfOutput getSample() {
        return this._function.value(this.getGenerator().getSample());
    }
}
