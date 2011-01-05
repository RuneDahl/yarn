/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
/**
 * {@see Result} from an {@see Mathematics.Algorithm.Algorithm algorithm}
 * representing a failure due to the slope being 0 (zero).
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public final class SlopeEqualsZeroFailure<TypeOfValue> implements Result {
    private TypeOfValue _value;

    /**
     * Creates a failure due to the slope equalling zero at the specified value.
     * @param value Value.
     */
    public SlopeEqualsZeroFailure(TypeOfValue value) {
        this._value = value;
    }

    /**
     * Gets the value at which the slope equals zero.
     * @return
     */
    public TypeOfValue getValue() {
        return this._value;
    }
}