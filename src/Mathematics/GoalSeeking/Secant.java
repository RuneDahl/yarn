/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.*;
import Mathematics.Algorithm.*;
import Mathematics.Equality.Equals;
import Mathematics.Function.Function;
import Mathematics.Result.*;
import Validation.*;

/**
 * {@see Algorithm} implementing the
 * <a href="http://en.wikipedia.org/wiki/Secant_method">secant method</a>
 * for a function of double into double.
 * @author Rune Dahl Iversen
 */
public final class Secant implements GoalSeekFunction<Double, Double>,
        Criterion<Equals<Double>>,
        InitialValue<Interval<Double>>,
        Mathematics.Algorithm.Iterative<Function<Double, Double>>  {
    private int _maxIter;
    private Equals<Double> _criterion;
    private Interval<Double> _initialValue;
    private double _goalValue;

    private static final Validator<Double> __validator =
            Validation.Factory.FiniteReal();
    private static final Validator<Integer> __maxIterValidator =
            new IntegerGreaterThan();

    /**
     * Creates an instance of the secant method {@see Algorithm algorithm}
     * for goal-seeking the input to a funtion.
     * @param goalValue         Target value.
     * @param initialValue     First initial value.
     * @param initialValue2     Second initial value.
     * @param criterion         End criterion for the iteration.
     * @param maximumIterations Maximum number of iterations allowed.
     */
    public Secant(final double goalValue,
            final Interval<Double> initialValue,
            final Equals<Double> criterion,
            final int maximumIterations) {
        this.setGoalValue(goalValue);
        this.setInitialValue(initialValue);
        this.setCriterion(criterion);
        this.setMaximumIterations(maximumIterations);
    }

    @Override
    public Equals<Double> getCriterion() {
        return this._criterion;
    }

    @Override
    public Double getGoalValue() {
        return this._goalValue;
    }

    @Override
    public Interval<Double> getInitialValue() {
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
    public void setGoalValue(final Double value) {
        if (!__validator.isValid(value))
            throw new IllegalArgumentException(
                    __validator.Message(value, "Goal value"));
        this._goalValue = value;
    }

    @Override
    public void setInitialValue(final Interval<Double> initialValue) {
        if (initialValue == null)
            throw new NullPointerException("Initial values are not properly specified.");
        this._initialValue = initialValue;
    }

    @Override
    public void setMaximumIterations(final int iterations) {
        if (!__maxIterValidator.isValid(iterations))
            throw new IllegalArgumentException(
                    __maxIterValidator.Message(iterations, "Maximum iterations"));
        this._maxIter = iterations;
    }

    @Override
    public Result Run(final Function<Double, Double> value) {
        double x_1 = this.getInitialValue().getLowerBound();
        double fx_1 = value.value(x_1);
        if (this._criterion.value(fx_1, this._goalValue))
            return new SuccessWithValue(x_1);
        double x = this.getInitialValue().getUpperBound();
        double fx = value.value(x);
        if (this._criterion.value(fx, this._goalValue))
            return new SuccessWithValue(x);
        int iter;
        for (iter = 0; iter < this._maxIter &&
                !this._criterion.value(fx, this._goalValue); iter++) {
            double n = x - (fx - this._goalValue) * (x - x_1) / (fx - fx_1);
            double fn = value.value(n);
            x_1 = x;
            fx_1 = fx;
            x = n;
            fx = fn;
        }
        if (this._maxIter <= iter)
            return new MaximumIterationsFailure(iter);
        return new IterativeSuccess(iter, x);
    }
}