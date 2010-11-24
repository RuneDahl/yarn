/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.*;
import Mathematics.Convergence.*;
import Mathematics.Function.*;
import Mathematics.Result.*;
import java.util.HashMap;

/**
 * Implementation of <a href="http://en.wikipedia.org/wiki/Romberg%27s_method">
 * Romberg's method</a> for {@see Integrator numerical integration} of a
 * {@see Function function} of {@see Double real} values into real values.
 * @author Rune Dahl Iversen
 */
public final class RombergRealReal extends MaximumIterations
        implements Mathematics.Algorithm.Criterion<Criterion<Double>>,
        Integrator<Function<Double, Double>, Interval<Double>> {
    private Interval<Double> _region;
    private Criterion<Double> _criterion;

    /**
     * Creates an instance of the Romberg integration method with the specified
     * maximum number of iteration, region and convergence criterion.
     * @param maximumIterations Maximum number of iterations.
     * @param region            Region to integrate over.
     * @param criterion         Convergence criterion.
     */
    public RombergRealReal(
            final int maximumIterations,
            final Interval<Double> region,
            final Criterion<Double> criterion) {
        super(maximumIterations);
        this.setRegion(region);
        this.setCriterion(criterion);
    }

    public Criterion<Double> getCriterion() {
        return this._criterion;
    }

    public void setCriterion(Criterion<Double> criterion) {
        if (criterion == null)
            throw new NullPointerException("Criterion not properly specified.");
        this._criterion = criterion;
    }

    public Interval<Double> getRegion() {
        return this._region;
    }

    public void setRegion(Interval<Double> region) {
        if (region == null)
            throw new NullPointerException("Interval not properly specified.");
        this._region = region;
    }

    public Result value(Function<Double, Double> function) {
        Result result = null;
        try
        {
            AcceleratorSingleStep<Double> richardson = new RichardsonExtrapolationReal(4.0);
            HashMap<Integer, Double> values = new HashMap<Integer, Double>();
            double lowerBound = this.getRegion().getLowerBound();
            double length = this.getRegion().getUpperBound() - lowerBound;
            final double iterativeSplits = 2.0;

            int iteration = 0;
            double i = length*(function.value(lowerBound) + function.value(lowerBound + length)) /
                    iterativeSplits;
            values.put(iteration, i);
            this._ImproveValues(values, iteration, richardson);
            for (iteration = 1; iteration < this.getMaximumIterations() &&
                    !this._HasConverged(values, iteration - 1); iteration++) {
                i /= iterativeSplits;
                length /= iterativeSplits;
                for (int j = 1; j <= Math.pow(iterativeSplits, iteration-1.0); j++) {
                    i += length*function.value(lowerBound + ((iterativeSplits*(double)j - 1.0))*length);
                }

                values.put(iteration, i);
                this._ImproveValues(values, iteration, richardson);
            }
            if (this._HasConverged(values, iteration - 1))
                result = new IterativeSuccess(iteration,
                        values.get(iteration - 1));
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
     * Use the specified {@see RichardsonExtrapolationReal Richardson
     * extrapolation} {@see Accelerator convergence accelerator} on the values.
     * @param values     Collection of original and improved values.
     * @param iteration  Iteration counter.
     * @param richardson Richardson extrapolation.
     */
    private void _ImproveValues(
            HashMap<Integer, Double> values,
            final int iteration,
            final AcceleratorSingleStep<Double> richardson) {
        Double[] series = new Double[values.size()];
        for (int i = 0; i < values.size(); i++)
            series[i] = values.get(i);
        values.put(iteration, richardson.value(iteration, series));
    }

    /**
     * Determines if the sequence of numerical approximations has converged.
     * @param values     Collection of numerical approximations of the integral.
     * @param iteration Iteration count.
     * @return True for convergence else false.
     */
    private boolean _HasConverged(
            final HashMap<Integer, Double> values,
            final int iteration) {
        Double[] v = new Double[iteration + 1];
        for (int i = 0; i <= iteration; i++)
            v[i] = values.get(i);
        return this.getCriterion().converges(v);
    }
}