/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.MaximumIterations;

/**
 * Abstract class with a {@see MaximumIterations maximum number of iterations}
 * using <a href="http://en.wikipedia.org/wiki/Numerical_integration#Quadrature_rules_based_on_interpolating_functions">
 * numerical quadrature</a>.<br>
 * This combination of values will prove helpful in implementing numerical
 * integration using quadrature. The quadrature can be implemented as
 * <a href="http://en.wikipedia.org/wiki/Numerical_integration#Quadrature_rules_based_on_interpolating_functions">composite</a>
 * or <a href="http://en.wikipedia.org/wiki/Adaptive_quadrature">adaptive</a>.
 * @author Rune Dahl Iversen
 */
public abstract class IterativeQuadrature extends MaximumIterations {
    private int _initialSplits;
    private int _iterativeSplits;

    private final static Validation.Validator<Integer> __validator =
            Validation.Factory.PositiveInteger();

    /**
     * Creates an instance of an iterative split-based class with the specified values.
     * @param maximumIterations The maximum number of iterations.
     * @param initialSplits     The number of initial splits.
     * @param iterativeSplits   The number of sub-intervals to split an interval into.
     */
    protected IterativeQuadrature(
            final int maximumIterations,
            final int initialSplits,
            final int iterativeSplits) {
        super(maximumIterations);
        this.setInitialSplits(initialSplits);
        this.setIterativeSplits(iterativeSplits);
    }

    /**
     * Gets the number of initial splits.
     * @return The number of initial splits.
     */
    public final int getInitialSplits() {
        return this._initialSplits;
    }

    /**
     * Sets the number of initial splits.
     * This value muct be positive.
     * @param initialSplits The number of initial splits.
     */
    public final void setInitialSplits(final int initialSplits) {
        if (!__validator.isValid(initialSplits))
            throw new IllegalArgumentException(
                    __validator.message(initialSplits, "Initial splits"));
        this._initialSplits = initialSplits;
    }

    /**
     * Gets the number of sub-intervals to split an interval into.
     * @return The number of sub-intervals to split an interval into.
     */
    public final int getIterativeSplits() {
        return this._iterativeSplits;
    }

    /**
     * Sets the number of sub-intervals to split an interval into.<br>
     * This value must be greater than 1.
     * @param iterativeSplits The number of sub-intervals to split an interval into.
     */
    public final void setIterativeSplits(final int iterativeSplits) {
        if (!__validator.isValid(iterativeSplits - 1))
            throw new IllegalArgumentException("Iterative splits must be " +
                    "greater than 1.");
        this._iterativeSplits = iterativeSplits;
    }
}