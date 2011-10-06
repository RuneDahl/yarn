/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Exception;

/**
 * Implementation of an {@see Exception exception} that represents too many
 * attempted iterations.
 * @author Rune Dahl Iversen
 */
public final class MaximumIterationsException extends ArithmeticException {
    private int _iterations = -1;

    /**
     * Creates an instance of a maximum iterations exception without data.
     */
    public MaximumIterationsException() {
    }

    /**
     * Creates an instance of a maximum iterations exception with the specified
     * message.
     * @param message Message.
     */
    public MaximumIterationsException(final String message) {
        super(message);
    }

    /**
     * Creates an instance of a maximum iterations exception with the specified
     * number of iterations.
     * @param iterations Iterations.
     */
    public MaximumIterationsException(final int iterations) {
        super();
        this._iterations = iterations;
    }

    /**
     * Creates an instance of a maximum iterations exception with the specified
     * message and number of iterations.
     * @param message    Message.
     * @param iterations Iterations.
     */
    public MaximumIterationsException(final String message, final int iterations) {
        super(message);
        this._iterations = iterations;
    }

    /**
     * Gets the numboer of iterations.
     * @return Iterations.
     */
    public int getIterations() {
        return this._iterations;
    }
}
