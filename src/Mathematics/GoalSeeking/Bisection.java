/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.*;
import Mathematics.Algorithm.*;
import Mathematics.Equality.*;
import Mathematics.Function.*;
import Mathematics.Result.*;
import Validation.*;

/**
 * {@see Algorithm} implementing the
 * <a href="http://en.wikipedia.org/wiki/Bisection_method">bisection method</a>
 * for a function of double into double.
 * @author Rune Dahl Iversen
 */
public class Bisection implements GoalSeekFunction<Double, Double>,
        Criterion<Equals<Double>>,
        InitialValue<Interval<Double>>,
        Mathematics.Algorithm.Iterative<Function<Double, Double>> {
    private int _maxIter;
    private Equals<Double> _criterion;
    private Interval<Double> _initialValue;
    private double _goalValue;

    private static Validator<Double> __validator =
            Validation.Factory.FiniteReal();
    private static Validator<Integer> _maxIterValidator =
            new IntegerGreaterThan();;

    /**
     * Creates an instance of the bisection method {@see Algorithm algorithm}
     * for goal-seeking the input to a funtion.
     * @param goalValue         Target value.
     * @param initialValue      Initial values. The 2 values must be on either
     *                          side of the solution.
     * @param criterion         End criterion for the iteration.
     * @param maximumIterations Maximum number of iterations allowed.
     */
    public Bisection(final double goalValue,
            final Interval<Double> initialValue,
            final Equals<Double> criterion,
            final int maximumIterations) {
        this.setGoalValue(goalValue);
        this.setInitialValue(initialValue);
        this.setCriterion(criterion);
        this.setMaximumIterations(maximumIterations);
    }

    public Equals<Double> getCriterion() {
        return this._criterion;
    }

    public Double getGoalValue() {
        return this._goalValue;
    }

    public Interval<Double> getInitialValue() {
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

    public void setGoalValue(final Double value) {
        if (!__validator.isValid(value))
            throw new IllegalArgumentException(
                    __validator.Message(value, "Goal value"));
        this._goalValue = value;
    }

    public void setInitialValue(final Interval<Double> initialValue) {
        if (initialValue == null)
            throw new NullPointerException("Initial values are not properly specified.");
        this._initialValue = initialValue;
    }

    public void setMaximumIterations(final int iterations) {
        if (!_maxIterValidator.isValid(iterations))
            throw new IllegalArgumentException(
                    _maxIterValidator.Message(iterations, "Maximum iterations"));
        this._maxIter = iterations;
    }

    public Result Run(final Function<Double, Double> value) {
        try
        {
            Interval<Double> interval = new IntervalReal(
                    this._initialValue.getLowerBound(), Interval.EndType.Includes,
                    this._initialValue.getUpperBound(), Interval.EndType.Includes);
            double output = value.value(this._initialValue.getLowerBound()) -
                    this._goalValue;
            if (this._criterion.Equal(output, this._goalValue))
                return new SuccessWithValue(output);
            double lSign = Math.signum(output);
            output = value.value(interval.getUpperBound()) - this._goalValue;
            if (this._criterion.Equal(output, this._goalValue))
                return new SuccessWithValue(output);
            double uSign = Math.signum(output);

            if (0.0 < lSign * uSign)
                return new SolutionNotEnclosedFailure<Double, Double>(
                        value, interval, this._goalValue);
            int iter;
            for (iter = 0; iter < this._maxIter &&
                    !this._criterion.Equal(output, this._goalValue); iter++) {
                double midPoint = interval.getLowerBound() / 2.0 +
                        interval.getUpperBound() / 2.0;
                if (midPoint == interval.getLowerBound() ||
                        midPoint == interval.getUpperBound())
                    return new ResolutionNotFineEnough<Double, Double>(
                            value, interval, this._goalValue);
                output = value.value(midPoint) - this._goalValue;
                if (Math.signum(output) == lSign)
                    interval.setLowerBound(midPoint);
                else
                    interval.setUpperBound(midPoint);
            }
            if (this._maxIter <= iter)
                return new MaximumIterationsFailure(iter);
            return new IterativeSuccess(iter, output);
        }
        catch (Exception e)
        { return new UnhandledExceptionThrown(e); }
    }
}