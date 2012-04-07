/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.*;
import Mathematics.Equality.DoubleAbsolute;
import Mathematics.Exception.*;
import Mathematics.Function.*;
import Mathematics.Result.*;
import java.util.*;

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
public final class AdaptiveRealReal extends IterativeQuadrature
        implements Mathematics.Algorithm.Criterion<DoubleAbsolute>,
        Integrator<Function<Double, Double>, Interval<Double>>,
        EvaluatorBased<Function<Double, Double>, Interval<Double>, Double> {
    private DoubleAbsolute _criterion;
    private Evaluator<Function<Double, Double>, Interval<Double>, Double> _evaluator;
    private Interval<Double> _region;

    /**
     * Creates an instance of the adaptive integrator with the specified values.
     * @param maximumIterations Maximum number of iterations allowed.
     * @param initialSplits     Number of subintervals to split the original interval into.
     * @param iterativeSplits   Number of subintervals to split the preceeding interval into.
     * @param evaluator         Evaluator.
     * @param region            Interval to integrate over.
     * @param criterion         Criterion for convergence.
     */
    public AdaptiveRealReal(final int maximumIterations, final int initialSplits,
            final int iterativeSplits,
            final Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator,
            final Interval<Double> region,
            final DoubleAbsolute criterion) {
        super(maximumIterations, initialSplits, iterativeSplits);
        this.setEvaluator(evaluator);
        this.setRegion(region);
        this.setCriterion(criterion);
    }

    @Override
    public DoubleAbsolute getCriterion() {
        return this._criterion;
    }

    @Override
    public void setCriterion(final DoubleAbsolute criterion) {
        if (criterion == null)
            throw new NullPointerException("Criterion is not properly specified.");
        this._criterion = criterion;
    }

    @Override
    public Evaluator<Function<Double, Double>, Interval<Double>, Double> getEvaluator() {
        return this._evaluator;
    }

    @Override
    public void setEvaluator(
            final Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator) {
        if (evaluator == null)
            throw new NullPointerException("Evaluator is not properly specified.");
        this._evaluator = evaluator;
    }

    @Override
    public Interval<Double> getRegion() {
        return this._region;
    }

    @Override
    public void setRegion(final Interval<Double> region) {
        if (region == null)
            throw new NullPointerException("Region is not properly specified.");
        this._region = region;
    }

    @Override
    public Result value(final Function<Double, Double> function) {
        Result result;
        try {
            double value = this._value(
                    this.getRegion(), function, Double.POSITIVE_INFINITY, 0, this.getCriterion());
            result = new IterativeSuccess<Double>(this.getMaximumIterations(), value);
        }
        catch (MaximumIterationsException e) {
            result = new MaximumIterationsFailure(e.getIterations());
        }
        catch (Exception e) {
            result = new UnhandledExceptionThrown(e);
        }
        return result;
    }

    private Collection<Interval<Double>> _SplitInterval(
            final Interval<Double> interval,
            final int iteration) {
        int splitFactor = iteration == 0 ? this.getInitialSplits() : this.getIterativeSplits();
        Collection<Interval<Double>> splits = new ArrayList<Interval<Double>>(
                splitFactor);
        double lb = interval.getLowerBound();
        double additive = (interval.getUpperBound() - lb) / splitFactor;
        Interval.EndType endType = Interval.EndType.Includes;
        for (int i = 0; i < splitFactor; i++)
            splits.add(new IntervalReal(lb + i*additive, endType, lb + (i+1)*additive, endType));
        return splits;
    }

    private double _value(final Interval<Double> region,
            final Function<Double, Double> function, final double firstGuess,
            final int iteration, final DoubleAbsolute criterion) {
        if (this.getMaximumIterations() < iteration)
            throw new MaximumIterationsException(iteration);
        HashMap<Interval<Double>, Double> values =
                new HashMap<Interval<Double>, Double>();
        Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator =
                this.getEvaluator();
        for (Interval<Double> interval : this._SplitInterval(region, iteration))
            values.put(interval, evaluator.value(function, interval));
        double v = 0.0;
        for (Interval<Double> value : values.keySet())
            v += values.get(value);
        if (!criterion.value(firstGuess, v))
        {
            for (Interval<Double> value : values.keySet())
                values.put(value, this._value(value, function, values.get(value),
                iteration+1, new DoubleAbsolute(criterion.getPrecision()/2.0)));
            v = 0.0;
            for (Interval<Double> value : values.keySet())
                v += values.get(value);
        }
        return v;
    }
}
