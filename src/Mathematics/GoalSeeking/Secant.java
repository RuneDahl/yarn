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
        Mathematics.Algorithm.Iterative<Function<Double, Double>>  {
    private int _maxIter;
    private Equals<Double> _criterion;
    private final Interval<Double> _initialValue;
    private double _goalValue;

    private static Validator<Double> __validator =
            Validation.Factory.FiniteReal();
    private static Validator<Integer> __maxIterValidator =
            new IntegerGreaterThan();

    /**
     * Creates an instance of the secant method {@see Algorithm algorithm}
     * for goal-seeking the input to a funtion.
     * @param goalValue         Target value.
     * @param initialValue1     First initial value.
     * @param initialValue2     Second initial value.
     * @param criterion         End criterion for the iteration.
     * @param maximumIterations Maximum number of iterations allowed.
     */
    public Secant(final double goalValue,
            final double initialValue1,
            final double initialValue2,
            final Equals<Double> criterion,
            final int maximumIterations) {
        this._initialValue = new IntervalReal(
                initialValue1, Interval.EndType.Includes,
                initialValue2, Interval.EndType.Includes);

        this.setGoalValue(goalValue);
        this.setInitialValue1(initialValue1);
        this.setInitialValue2(initialValue2);
        this.setCriterion(criterion);
        this.setMaximumIterations(maximumIterations);
    }

    public Equals<Double> getCriterion() {
        return this._criterion;
    }

    public Double getGoalValue() {
        return this._goalValue;
    }

    /**
     * Gets the first initial value of this {@see Secant} algorithm.
     * @return The first initial value.
     */
    public double getInitialValue1() {
        return this._initialValue.getLowerBound();
    }

    /**
     * Gets the second initial value of this {@see Secant} algorithm.
     * @return The second initial value.
     */
    public double getInitialValue2() {
        return this._initialValue.getUpperBound();
    }

    public int getMaximumIterations() {
        return this._maxIter;
    }

    public void setCriterion(final Equals<Double> criterion) {
        if (criterion == null)
            throw new NullPointerException("Criterion is not properly specified.");
        this._criterion = criterion;
    }

    public void setGoalValue(final Double value) {
        if (!__validator.isValid(value))
            throw new IllegalArgumentException(
                    __validator.Message(value, "Goal value"));
        this._goalValue = value;
    }

    /**
     * Sets the first initial value.
     * @param initialValue1 The first initial value.
     */
    public void setInitialValue1(final double initialValue1) {
        if (!__validator.isValid(initialValue1))
            throw new IllegalArgumentException(
                    __validator.Message(initialValue1, "First initial value"));
        this._initialValue.setLowerBound(initialValue1);
    }

    /**
     * Sets the second initial value.
     * @param initialValue2 The second initial value.
     */
    public void setInitialValue2(final double initialValue2) {
        if (!__validator.isValid(initialValue2))
            throw new IllegalArgumentException(
                    __validator.Message(initialValue2, "Second initial value"));
        this._initialValue.setUpperBound(initialValue2);
    }

    public void setMaximumIterations(final int iterations) {
        if (!__maxIterValidator.isValid(iterations))
            throw new IllegalArgumentException(
                    __maxIterValidator.Message(iterations, "Maximum iterations"));
        this._maxIter = iterations;
    }

    public Result Run(final Function<Double, Double> value) {
        double x_1 = this.getInitialValue1();
        double fx_1 = value.value(x_1);
        if (this._criterion.value(fx_1, this._goalValue))
            return new SuccessWithValue(x_1);
        double x = this.getInitialValue2();
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