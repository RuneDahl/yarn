/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
 * An implementation of a {@see Success successful} {@see Result result}
 * of an {@see Mathematics.Algorithm.Iterative iterative}
 * {@see Mathematics.Algorithm.Algorithm algorithm}.
 * @author Rune Dahl Iversen
 * @param <TypeOfResult> Type of result.
 */
public final class IterativeSuccess<TypeOfResult> extends Iterative
    implements Success<TypeOfResult> {
    private final TypeOfResult _result;

    /**
     * Creates an instance of an iterative succesful result.
     * @param iterations Number of iterations used.
     * @param result     Resulting value.
     */
    public IterativeSuccess(final int iterations, final TypeOfResult result) {
        super(iterations);
        this._result = result;
    }

    @Override
    public TypeOfResult getResult() {
        return this._result;
    }
}