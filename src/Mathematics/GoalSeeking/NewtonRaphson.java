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
        Mathematics.Algorithm.Iterative<Function<Double, Double>>,
        Mathematics.Algorithm.InitialValue<Double, Function<Double, Double>> {
    private double _initialValue;
    private Equals<Double> _criterion;
    private Differentiator<Double, Double, Double> _differentiator;
    private int _maxIter;
    private double _goalValue;
    private Validation.And<Double> _validator;

    public NewtonRaphson(final double goalValue,
            final double initialValue,
            final Equals<Double> criterion,
            final Differentiator<Double, Double, Double> differentiator,
            final int maximumIterations) {
        this._validator = new Validation.And();
        this._validator.add(new NotNull<Double>());
        this._validator.add(new DoubleIsNumeric());
        this._validator.add(new DoubleIsFinite());

    }

    public Differentiator<Double, Double, Double> getDifferentiator() {
        return this._differentiator;
    }

    public Equals<Double> getCriterion() {
        return this._criterion;
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

        this._maxIter = iterations;
    }

    public Result Run(final Function<Double, Double> function) {
        double value = this._initialValue;
        int iterations = 0;
        double output = function.Value(value);
        for (iterations = 0; iterations < this._maxIter ||
                this._criterion.Equal(output, this._goalValue);
                iterations++) {
            output = function.Value(value);
            value -= (output - this.getGoalValue()) /
                    this._differentiator.Value(value, function);
        }
        if (this._maxIter < iterations) {
            return new MaximumIterationsFailure(iterations);
        }
        return new IterativeSuccess<Double>(iterations, value);
    }
}