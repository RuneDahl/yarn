/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
 * Implementation of a {@see Result result} where an {@see Exception unhandled
 * exception} was thrown. This will typically represent a failure,
 * so UnhandledExceptionThrown does not implement {@see Success}.
 * @author Rune Dahl Iversen
 */
public final class UnhandledExceptionThrown implements Result {
    private final Exception _exception;

    /**
     * Creates an instance of a result representing that the specified
     * unhandled exception was thrown.
     * @param exception Exception.
     */
    public UnhandledExceptionThrown(final Exception exception) {
        if (exception == null)
            throw new NullPointerException("Exception not specified.");
        this._exception = exception;
    }

    /**
     * Gets the {@see Exception exception} that was thrown.
     * @return The exception.
     */
    public Exception getException() {
        return _exception;
    }
}