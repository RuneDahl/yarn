/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

/**
 * Implementation of <a href="http://en.wikipedia.org/wiki/Richardson_extrapolation">
 * Richardson extrapolation</a> for sequence of {@see Double real numbers}.<br>
 * This implementation allows the Richardson extrapolation to be applied
 * one step at a time by invoking the method value(Integer, Double[]). This way
 * of invoking the accelerator requires that the method is called in successive
 * iterations from the first iteration (with the iteration count 0) and on.
 * @author Rune Dahl Iversen
 */
public final class RichardsonExtrapolationReal
        implements AcceleratorSingleStep<Double> {
    private double _factor;
    private double[] _storage = null;
    private static final Validation.Validator<Double> __validator =
            Validation.Factory.FiniteRealGreaterThan(1.0);

    /**
     * Create an instance of the Richardson extrapolation with the specified factor.
     * @param factor Factor.
     */
    public RichardsonExtrapolationReal(final double factor) {
        this.setFactor(factor);
    }

    /**
     * Get the factor of this Richardson extrapolation.
     * @return Factor.
     */
    public double getFactor() {
        return _factor;
    }

    /**
     * Set the factor of this Richardson extrapolation.
     * @param factor Factor.
     * @throws IllegalArgumentException Factor
     */
    public void setFactor(double factor) {
        if (!__validator.isValid(factor))
            throw new IllegalArgumentException(__validator.message(factor, "Factor"));
        this._factor = factor;
    }

    @Override
    public Double value(final Integer iteration, final Double[] sequence) {
        if (sequence == null)
            throw new NullPointerException("Sequence not properly specified.");
        if (sequence.length == 0)
            throw new IllegalArgumentException("No values in sequence.");
        if (iteration == 0) { // Reset the extrapolation algortithm.
            this._storage = new double[] { sequence[iteration] };
            return sequence[iteration];
        }
        if (iteration == this._storage.length) {
            double[] temp = new double[iteration+1];
            temp[0] = sequence[iteration];
            for (int j = 1; j <= iteration; j++) {
                double weight = Math.pow(_factor, (double)j);
                temp[j] = (weight*temp[j-1] - this._storage[j-1]) / (weight - 1);
            }
            this._storage = temp;
            return temp[iteration];
        }
        else
            throw new IllegalStateException("The internal state of this " +
                    "Richardson extrapolation is not consistent with applying" +
                    "the " + Integer.toString(iteration) + "th iteration.");
    }

    @Override
    public Double[] value(final Double[] sequence) {
        if (sequence == null)
            return null;
        Double[] accelerated = new Double[sequence.length];
        if (sequence.length == 0)
            return accelerated;
        accelerated[0] = sequence[0];
        double[] storage = new double[] {sequence[0]};
        for (int i = 1; i < sequence.length; i++) {
            double[] temp = new double[i + 1];
            temp[0] = sequence[i];
            for (int j = 1; j <= i; j++){
                double weight = Math.pow(_factor, (double)j);
                temp[j] = (weight*temp[j-1] - storage[j-1]) / (weight - 1);
            }
            storage = temp;
            accelerated[i] = temp[i];
        }
        return accelerated;
    }
}