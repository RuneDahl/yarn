/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
 * Abstract class representing a result from an iterative algorithm.
 * @author Rune Dahl Iversen
 */
public abstract class Iterative implements Result {
    private final int _iterations;

    /**
     * Create an instance of a result from an iterative algorithm
     * with the specified number of iterations used.
     * @param iterations Number of iterations used.
     */
    protected Iterative(final int iterations) {
        this._iterations= iterations;
    }

    /**
     * Returns the number of iterations used in the algorithm.
     * @return Number of iterations.
     */
    public final int getIterations() {
        return this._iterations;
    }
}