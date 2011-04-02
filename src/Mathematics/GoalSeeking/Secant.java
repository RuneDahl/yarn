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
public final class Secant extends GoalSeekFunction<Interval<Double>, Double, Double>
        implements Criterion<Equals<Double>>,
        InitialValue<Interval<Double>>,
        Mathematics.Algorithm.Iterative<Result>  {
    private int _maxIter;

    private static final Validator<Double> __validator =
            Validation.Factory.FiniteReal();
    private static final Validator<Integer> __maxIterValidator =
            new IntegerGreaterThan();

    /**
     * Creates an instance of the secant method {@see Algorithm algorithm}
     * for goal-seeking the input to a funtion.
     * @param goalValue         Target value.
     * @param initialValue      First initial value.
     * @param criterion         End criterion for the iteration.
     * @param maximumIterations Maximum number of iterations allowed.
     */
    public Secant(final Function<Double, Double> function,
            final double goalValue,
            final Interval<Double> initialValue,
            final Equals<Double> criterion,
            final int maximumIterations) {
        super(criterion, function, __validator, goalValue, initialValue);
        this.setInitialValue(initialValue);
        this.setCriterion(criterion);
        this.setMaximumIterations(maximumIterations);
    }

    @Override
    public int getMaximumIterations() {
        return this._maxIter;
    }

    @Override
    public void setMaximumIterations(final int iterations) {
        if (!__maxIterValidator.isValid(iterations))
            throw new IllegalArgumentException(
                    __maxIterValidator.message(iterations, "Maximum iterations"));
        this._maxIter = iterations;
    }

    @Override
    public Result run() {
        Result result = null;
        try {
            Equals<Double> criterion = this.getCriterion();
            Function<Double, Double> value = this.getFunction();
            double goalValue = this.getGoalValue();
            double x_1 = this.getInitialValue().getLowerBound();
            double fx_1 = value.value(x_1);
            if (criterion.value(fx_1, goalValue))
                return new SuccessWithValue(x_1);
            double x = this.getInitialValue().getUpperBound();
            double fx = value.value(x);
            if (criterion.value(fx, goalValue))
                return new SuccessWithValue(x);
            int iter = -1;
            for (iter = 0; iter < this._maxIter &&
                    !criterion.value(fx, goalValue); iter++) {
                double n = x - (fx - goalValue) * (x - x_1) / (fx - fx_1);
                double fn = value.value(n);
                x_1 = x;
                fx_1 = fx;
                if (x == n)
                    result = new ResolutionNotFineEnough(value,
                            new IntervalReal(
                            Math.min(x_1, n), Interval.EndType.Includes,
                            Math.max(x_1, n), Interval.EndType.Includes),
                            goalValue);
                x = n;
                fx = fn;
            }
            if (result == null) {
                if (this._maxIter <= iter)
                    result = new MaximumIterationsFailure(iter);
                else
                    result = new IterativeSuccess(iter, x);
            }
        }
        catch (Exception e) {
            result = new UnhandledExceptionThrown(e);
        }
        return result;
    }
}