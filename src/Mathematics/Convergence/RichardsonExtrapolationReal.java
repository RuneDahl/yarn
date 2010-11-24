/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

/**
 * Implementation of <a href="http://en.wikipedia.org/wiki/Richardson_extrapolation">
 * Richardson extrapolation</a> for sequence of <{@see Double real numbers}.
 * @author Rune Dahl Iversen
 */
public final class RichardsonExtrapolationReal
        implements AcceleratorSingleStep<Double> {
    private double _factor;

    private static final Validation.Validator<Double> __validator = __SetValidator();

    private double[] _storage = null;

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
            throw new IllegalArgumentException(__validator.Message(factor, "Factor"));
        this._factor = factor;
    }

    public Double value(final Integer iteration, final Double[] sequence) {
        if (sequence == null)
            throw new NullPointerException("Sequence not properly specified.");
        if (sequence.length == 0)
            throw new IllegalArgumentException("No values in sequence.");
        if (iteration == 0) { // Reset the extrapolation algortithm.
            this._storage = new double[] { sequence[iteration] };
            return sequence[iteration];
        }
        double[] temp = new double[iteration + 1];
        temp[0] = sequence[iteration];
        for (int j = 1; j <= iteration; j++) {
            double weight = Math.pow(_factor, (double)j);
                temp[j] = (weight*temp[j-1] - this._storage[j-1]) / (weight - 1);
        }
        this._storage = temp;
        return temp[iteration];
    }

    public Double[] value(final Double[] sequence) {
        if (sequence == null)
            return null;
        Double[] accelerated = new Double[sequence.length];
        if (sequence.length == 0)
            return accelerated;
        accelerated[0] = sequence[0];
        double[] storage = null;
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

    private static Validation.Validator<Double> __SetValidator() {
        Validation.And<Double> validator =
                (Validation.And<Double>)Validation.Factory.FiniteReal();
        validator.add(new Validation.DoubleGreaterThan(1.0));
        return validator;
    }
}