/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
 * {@see Result} from an {@see Mathematics.Algorithm.Iterative iterative}
 * {@see Mathematics.Algorithm.Algorithm algorithm} representing a failure
 * due to hitting the maximum number of iterations allowed.
 * @author Rune Dahl Iversen
 */
public final class MaximumIterationsFailure extends Iterative {
    /**
     * Creates an instance of a maximum iterations failure with the
     * specified number of iterations.
     * @param iterations Number of iterations used.
     */
    public MaximumIterationsFailure(int iterations) {
        super(iterations);
    }
}