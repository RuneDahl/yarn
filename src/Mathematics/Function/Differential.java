/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Validation.Validator;

/**
 * Abstract implementation of a {@see Differentiator differentiator} using a
 * <a href="http://en.wikipedia.org/wiki/Derivative#Definition_via_difference_quotients">differential</a>
 * to estimate the derivative value of a function.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input of the function.
 * @param <TypeOfOutput> Type of output of the function.
 */
public abstract class Differential<TypeOfInput, TypeOfOutput>
        implements Differentiator<TypeOfInput, TypeOfOutput, TypeOfOutput> {
    private DifferentialDirection _direction;
    private TypeOfInput _step;
    private final Validator<TypeOfInput> _stepValidator;

    /**
     * Creates an instance of a differentiator using a differential and
     * the specified values.
     * @param stepValidator {@see Validation.Validator Validator} for the step.
     * @param step          Step.
     * @param direction     Direction(s) to step in.
     */
    protected Differential(final Validator<TypeOfInput> stepValidator,
            final TypeOfInput step, final DifferentialDirection direction) {
        if (stepValidator == null)
            throw new NullPointerException("Step validator is not specified.");
        this._stepValidator = stepValidator;
        this.setDirection(direction);
        this.setStep(step);
    }

    /**
     * Gets the direction/way the differential is computed relative to the step.
     * @return The direction.
     */
    public final DifferentialDirection getDirection() {
        return this._direction;
    }

    /**
     * Gets the step added to the input when computing the derivative value.
     * @return Step.
     */
    public final TypeOfInput getStep() {
        return this._step;
    }

    /**
     * Sets the direction/way the differential is computed relative to the step.
     * @param direction The direction.
     */
    public final void setDirection(final DifferentialDirection direction) {
        this._direction = direction;
    }

    /**
     * Sets the step added to the input when computing the derivative value.
     * @param step Step.
     */
    public final void setStep(final TypeOfInput step) {
        if (!this._stepValidator.isValid(step))
            throw new IllegalArgumentException(
                    this._stepValidator.message(step, "Step"));
        this._step = step;
    }

    /**
     * Possible values for the direction to use in computing the
     * <a href="http://en.wikipedia.org/wiki/Derivative#Definition_via_difference_quotients">differential</a>.
     */
    public enum DifferentialDirection {
        /**
         * Step is taken in the opposite direction of the step specified.
         */
        Negative,
        /**
         * Both positive and negative steps are taken.
         */
        Central,
        /**
         * Step is taken in the direction of the step specified.
         */
        Positive
    }
}