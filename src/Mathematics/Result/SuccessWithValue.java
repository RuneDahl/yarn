/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
 * Implementation of a {@see Success successful} {@see Result result} with
 * a resulting value.
 * @author Rune Dahl Iversen
 * @param <TypeOfResult> Type of result.
 */
public final class SuccessWithValue<TypeOfResult>
        implements Success<TypeOfResult> {
    private final TypeOfResult _result;

    /**
     * Creates an instance of a {@see Success successful} {@see Result result}
     * with a resulting value.
     * @param result Value.
     */
    public SuccessWithValue(final TypeOfResult result) {
        this._result = result;
    }

    public TypeOfResult getResult() {
        return this._result;
    }
}