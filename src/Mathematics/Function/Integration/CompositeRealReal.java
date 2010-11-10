/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.*;
import Mathematics.Convergence.Criterion;
import Mathematics.Function.*;
import Mathematics.Result.*;
import java.util.HashMap;

/**
 * Numerical {@see Integrator integrator} for a function of
 * {@see Double real} values into real values that
 * <a href="http://en.wikipedia.org/wiki/Iteration">iteratively</a>
 * {@see IterativeSplitBased splits} the {@see Interval interval} and
 * evaluates the integral on the sub-intervals followed by
 * <a href="http://en.wikipedia.org/wiki/Numerical_integration#Quadrature_rules_based_on_interpolating_functions">composing</a>
 * them to get a better estimate of the integral.<br>
 * The above refinement proceeds until the values {@see Criterion converge}
 * or the {@see MaximumIterations maximum iterations} are reached.
 * @author Rune Dahl Iversen
 */
public final class CompositeRealReal extends IterativeSplitBased
        implements Mathematics.Algorithm.Criterion<Criterion<Double>>,
        Integrator<Function<Double, Double>, Interval<Double>>,
        EvaluatorBased<Function<Double, Double>, Interval<Double>, Double> {
    private Evaluator<Function<Double, Double>, Interval<Double>, Double> _evaluator;
    private Interval<Double> _region;
    private Criterion<Double> _criterion;

    /**
     * Creates an instance of the composite integrator for a function of
     * real values into real values.
     * @param maximumIterations Maximum number of iterations.
     * @param initialSplits     Initial number of sub-intervals.
     * @param iterativeSplits   Number of sub-intervals to split intervals into.
     * @param evaluator         Evaluator.
     * @param region            Interval to integrate over.
     * @param criterion         Convergence criterion.
     */
    public CompositeRealReal(final int maximumIterations,
            final int initialSplits,
            final int iterativeSplits,
            final Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator,
            final Interval<Double> region,
            final Criterion<Double> criterion) {
        super(maximumIterations, initialSplits, iterativeSplits);
        this.setCriterion(criterion);
        this.setEvaluator(evaluator);
        this.setRegion(region);
    }

    public Criterion<Double> getCriterion() {
        return this._criterion;
    }

    public void setCriterion(final Criterion<Double> criterion) {
        if (criterion == null)
            throw new NullPointerException("Criterion not properly specified.");
        this._criterion = criterion;
    }

    public Evaluator<Function<Double, Double>, Interval<Double>, Double>
            getEvaluator() {
        return this._evaluator;
    }

    public void setEvaluator(final
            Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator) {
        if (evaluator == null)
            throw new NullPointerException("Evaluator not properly specified.");
        this._evaluator = evaluator;
    }

    public Interval<Double> getRegion() {
        return this._region;
    }

    public void setRegion(final Interval<Double> region) {
        if (region == null)
            throw new NullPointerException("Interval not properly specified.");
        this._region = region;
    }

    public Result value(final Function<Double, Double> function) {
        Result result = null;
        try
        {
            HashMap<Integer, Double> values = new HashMap<Integer, Double>();
            double lowerBound = this.getRegion().getLowerBound();
            double length = this.getRegion().getUpperBound() - lowerBound;
            int innerMax = this.getInitialSplits();
            final int iterativeSplits = this.getIterativeSplits();
            length /= (double)innerMax;

            int iteration = 0;
            for (iteration = 0; iteration < this.getMaximumIterations() &&
                    !this._HasConverged(values); iteration++) {
                Interval<Double> t = new IntervalReal(
                        lowerBound, Interval.EndType.Includes,
                        lowerBound + length, Interval.EndType.Includes);

                double i = 0;
                for (int j = 0; j < innerMax; j++) {
                    i += this.getEvaluator().value(function, t);
                    this._ShiftInterval(t, length, lowerBound, j);
                }

                values.put(iteration, i);
                innerMax *= iterativeSplits;
                length /= iterativeSplits;
            }
            if (this._HasConverged(values))
                result = new IterativeSuccess(iteration, values.get(iteration - 1));
            else if (this.getMaximumIterations() <= iteration)
                result = new MaximumIterationsFailure(iteration);
            else
                throw new ArithmeticException("Unknown termination: " +
                        "Values have not converged and maximum iterations " +
                        "have not been reached.");
        }
        catch (Exception e)
        { result = new UnhandledExceptionThrown(e); }
        return result;
    }

    /**
     * Shifts the specified interval to the right/up by the shift value.<br>
     * Should the resulting interval have collapsed the right-hand/upper
     * value is computed based on the specified lower bound, shift value
     * and iteration count.
     * @param interval   Interval.
     * @param shiftValue Shift value.
     * @param lowerBound Lower bound.
     * @param count      Iteration count.
     */
    private void _ShiftInterval(Interval<Double> interval,
            final double shiftValue, final double lowerBound, final int count) {
        interval.setLowerBound(interval.getUpperBound());
        interval.setUpperBound(interval.getUpperBound() + shiftValue);
        if (interval.getLowerBound() == interval.getUpperBound())
            interval.setUpperBound(lowerBound + (count + 1) * shiftValue);
    }

    /**
     * Determines if the sequence of numerical approximations has converged.
     * @param values Sequence of numerical approximations of the integral.
     * @return True for convergence else false.
     */
    private boolean _HasConverged(final HashMap<Integer, Double> values) {
        Double[] v = new Double[values.size()];
        for (int i = 0; i < values.size(); i++)
            v[i] = values.get(i);
        return this.getCriterion().converges(v);
    }
}