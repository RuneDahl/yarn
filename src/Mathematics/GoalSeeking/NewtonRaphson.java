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
public final class NewtonRaphson extends GoalSeekFunction<Double, Double, Double>
        implements Mathematics.Algorithm.Criterion<Equals<Double>>,
        Mathematics.Algorithm.Differentiator<Differentiator<Double, Double, Double>>,
        Mathematics.Algorithm.InitialValue<Double>,
        Mathematics.Algorithm.Iterative<Result> {

    private Differentiator<Double, Double, Double> _differentiator;
    private int _maxIter;
    private static final Validator<Double> __validator = Factory.FiniteReal();
    private static final Validator<Integer> __maxIterValidator = new IntegerGreaterThan();

    /**
     * Creates an instance of a Newton-Raphson
     * {@see GoalSeekFunction goal-seeking}
     * {@see Mathematics.Algorithm.Algorithm algorithm}.
     * @param function          Function being goal-seeked.
     * @param goalValue         Target output value.
     * @param initialValue      Initial value of the algorithm.
     * @param criterion         End criterion for the iteration.
     * @param differentiator    Differentiation used to estimate/compute the
     *                          differential of the function.
     * @param maximumIterations Maximum number of iterations allowed.
     */
    public NewtonRaphson(final Function<Double, Double> function,
            final double goalValue,
            final double initialValue,
            final Equals<Double> criterion,
            final Differentiator<Double, Double, Double> differentiator,
            final int maximumIterations) {
        super(criterion, function, __validator, goalValue, initialValue);
        this.setDifferentiator(differentiator);
        this.setMaximumIterations(maximumIterations);
    }

    @Override
    public Differentiator<Double, Double, Double> getDifferentiator() {
        return this._differentiator;
    }

    @Override
    public int getMaximumIterations() {
        return this._maxIter;
    }

    @Override
    public void setDifferentiator(
            final Differentiator<Double, Double, Double> differentiator) {
        if (differentiator == null) {
            throw new NullPointerException("Differentiator not properly specified.");
        }
        this._differentiator = differentiator;
    }

    @Override
    public void setMaximumIterations(final int iterations) {
        if (!__maxIterValidator.isValid(iterations)) {
            throw new IllegalArgumentException(
                    __maxIterValidator.message(iterations, "Maximum iterations"));
        }
        this._maxIter = iterations;
    }

    @Override
    public Result run() {
        Result result = null;
        try {
            Equals<Double> criterion = this.getCriterion();
            Function<Double, Double> function = this.getFunction();
            double goalValue = this.getGoalValue();
            double value = this.getInitialValue();
            int maxIter = this.getMaximumIterations();
            int iterations = 0;
            double output = function.value(value);
            for (iterations = 0; iterations < maxIter
                    && !criterion.value(output, goalValue);
                    iterations++) {
                output = function.value(value);
                double denominator = this._differentiator.value(value, function);
                if (denominator == 0.0) {
                    result = new SlopeEqualsZeroFailure<Double>(value);
                } else {
                    value -= (output - this.getGoalValue())
                            / denominator;
                }
            }
            if (result == null) {
                if (maxIter <= iterations) {
                    result = new MaximumIterationsFailure(iterations);
                } else {
                    result = new IterativeSuccess<Double>(iterations, value);
                }
            }
        } catch (Exception e) {
            result = new UnhandledExceptionThrown(e);
        }
        return result;
    }
}
