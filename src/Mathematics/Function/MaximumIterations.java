/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Abstract class containing a number specifying the maximum number of
 * <a href="http://en.wikipedia.org/wiki/Iteration">iterations</a>.
 * @author Rune Dahl Iversen
 */
public abstract class MaximumIterations {
    private int _maximumIterations;

    /**
     * Creates an instance of this class with
     * the specified maximum number of iterations.
     * @param maximumIterations The maximum number of iterations.
     */
    protected MaximumIterations(final int maximumIterations) {
        this.setMaximumIterations(maximumIterations);
    }

    /**
     * Gets the maximum number of iterations.
     * @return The maximum number of iterations.
     */
    public final int getMaximumIterations() {
        return this._maximumIterations;
    }

    /**
     * Sets the maximum number of iterations.
     * @param maximumIterations The maximum number of iterations.
     */
    public final void setMaximumIterations(final int maximumIterations) {
        this._maximumIterations = maximumIterations;
    }
}