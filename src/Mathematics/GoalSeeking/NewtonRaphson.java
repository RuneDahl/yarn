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
    private static final Validator<Double> __validator = Factory.FiniteReal();
    private static final Validator<Integer> __maxIterValidator = new IntegerGreaterThan();

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
        this.setCriterion(criterion);
        this.setDifferentiator(differentiator);
        this.setGoalValue(goalValue);
        this.setInitialValue(initialValue);
        this.setMaximumIterations(maximumIterations);
    }

    @Override
    public Equals<Double> getCriterion() {
        return this._criterion;
    }

    @Override
    public Differentiator<Double, Double, Double> getDifferentiator() {
        return this._differentiator;
    }

    @Override
    public Double getGoalValue() {
        return this._goalValue;
    }

    @Override
    public Double getInitialValue() {
        return this._initialValue;
    }

    @Override
    public int getMaximumIterations() {
        return this._maxIter;
    }

    @Override
    public void setCriterion(final Equals<Double> criterion) {
        if (criterion == null)
            throw new NullPointerException("Criterion is not properly specified.");
        this._criterion = criterion;
    }

    @Override
    public void setDifferentiator(
            final Differentiator<Double, Double, Double> differentiator) {
        if (differentiator == null)
            throw new NullPointerException("Differentiator is not properly specified.");
        this._differentiator = differentiator;
    }

    @Override
    public void setGoalValue(final Double value) {
        if (!__validator.isValid(value))
            throw new IllegalArgumentException(
                    __validator.message(value, "Goal value"));
        this._goalValue = value;
    }

    @Override
    public void setInitialValue(final Double initialValue) {
        if (!__validator.isValid(initialValue))
            throw new IllegalArgumentException(
                    __validator.message(initialValue, "Initial value"));
        this._initialValue = initialValue;
    }

    @Override
    public void setMaximumIterations(final int iterations) {
        if (!__maxIterValidator.isValid(iterations))
            throw new IllegalArgumentException(
                    __maxIterValidator.message(iterations, "Maximum iterations"));
        this._maxIter = iterations;
    }

    @Override
    public Result Run(final Function<Double, Double> function) {
        double value = this._initialValue;
        int iterations = 0;
        double output = function.value(value);
        for (iterations = 0; iterations < this._maxIter &&
                !this._criterion.value(output, this._goalValue);
                iterations++) {
            output = function.value(value);
            double denominator = this._differentiator.value(value, function);
            if (denominator == 0.0)
                return new SlopeEqualsZeroFailure<Double>(value);
            else
                value -= (output - this.getGoalValue()) /
                        denominator;
        }
        if (this._maxIter <= iterations) {
            return new MaximumIterationsFailure(iterations);
        }
        return new IterativeSuccess<Double>(iterations, value);
    }
}