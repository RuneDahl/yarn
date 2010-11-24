/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.Equality.*;
import Mathematics.Function.*;
import Mathematics.Result.*;
import Validation.*;

/**
 * Implementation of an unconstrained
 * <a href="http://en.wikipedia.org/wiki/Newton-Raphson">Newton-Raphson</a>
 * {@see Mathematics.Algorithm.Algorithm algorithm}.
 * @author Rune Dahl Iversen
 */
public final class NewtonRaphson implements GoalSeekFunction<Double, Double>,
        Mathematics.Algorithm.Criterion<Equals<Double>>,
        Mathematics.Algorithm.Differentiator<Differentiator<Double, Double, Double>>,
        Mathematics.Algorithm.InitialValue<Double>,
        Mathematics.Algorithm.Iterative<Function<Double, Double>> {
    private double _initialValue;
    private Equals<Double> _criterion;
    private Differentiator<Double, Double, Double> _differentiator;
    private int _maxIter;
    private double _goalValue;
    private Validator<Double> _validator;
    private Validator<Integer> _maxIterValidator;

    /**
     * Creates an instance of a Newton-Raphson
     * {@see GoalSeekFunction goal-seeking}
     * {@see Mathematics.Algorithm.Algorithm algorithm}.
     * @param goalValue         Target output value.
     * @param initialValue      Initial value of the algorithm.
     * @param criterion         End criterion for the iteration.
     * @param differentiator    Differentiation used to estimate/compute the
     *                          differential of the function.
     * @param maximumIterations Maximum number of iterations allowed.
     */
    public NewtonRaphson(final double goalValue,
            final double initialValue,
            final Equals<Double> criterion,
            final Differentiator<Double, Double, Double> differentiator,
            final int maximumIterations) {
        this._validator = this._setValidator();
        this._maxIterValidator = new IntegerGreaterThan();
        this.setCriterion(criterion);
        this.setDifferentiator(differentiator);
        this.setGoalValue(goalValue);
        this.setInitialValue(initialValue);
        this.setMaximumIterations(maximumIterations);
    }

    public Equals<Double> getCriterion() {
        return this._criterion;
    }

    public Differentiator<Double, Double, Double> getDifferentiator() {
        return this._differentiator;
    }

    public Double getGoalValue() {
        return this._goalValue;
    }

    public Double getInitialValue() {
        return this._initialValue;
    }

    public int getMaximumIterations() {
        return this._maxIter;
    }

    public void setCriterion(final Equals<Double> criterion) {
        if (criterion == null)
            throw new NullPointerException("Criterion is not properly specified.");
        this._criterion = criterion;
    }

    public void setDifferentiator(
            final Differentiator<Double, Double, Double> differentiator) {
        if (differentiator == null)
            throw new NullPointerException("Differentiator is not properly specified.");
        this._differentiator = differentiator;
    }

    public void setGoalValue(final Double value) {
        if (!this._validator.isValid(value))
            throw new IllegalArgumentException(
                    this._validator.Message(value, "Goal value"));
        this._goalValue = value;
    }

    public void setInitialValue(final Double initialValue) {
        if (!this._validator.isValid(initialValue))
            throw new IllegalArgumentException(
                    this._validator.Message(initialValue, "Initial value"));
        this._initialValue = initialValue;
    }

    public void setMaximumIterations(final int iterations) {
        if (!this._maxIterValidator.isValid(iterations))
            throw new IllegalArgumentException(
                    this._maxIterValidator.Message(iterations, "Maximum iterations"));
        this._maxIter = iterations;
    }

    public Result Run(final Function<Double, Double> function) {
        double value = this._initialValue;
        int iterations = 0;
        double output = function.value(value);
        for (iterations = 0; iterations < this._maxIter &&
                !this._criterion.value(output, this._goalValue);
                iterations++) {
            output = function.value(value);
            double denominator = this._differentiator.Value(value, function);
            if (denominator != 0.0)
                value -= (output - this.getGoalValue()) /
                        denominator;
            else
                return new SlopeEqualsZeroFailure();
        }
        if (this._maxIter <= iterations) {
            return new MaximumIterationsFailure(iterations);
        }
        return new IterativeSuccess<Double>(iterations, value);
    }

    private Validator<Double> _setValidator() {
        Validation.And<Double> validator = new Validation.And();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        return validator;
    }
}