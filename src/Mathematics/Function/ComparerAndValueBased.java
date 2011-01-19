/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Equality.Equals;
import Validation.*;

/**
 * Abstract implementation of a function with a {@see Equals comparer}
 * and a value as basic input.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class ComparerAndValueBased<TypeOfValue>
        extends ComparerBased<TypeOfValue> {
    private TypeOfValue _value;
    private final Validator<TypeOfValue> _valueValidator;

    /**
     * Creates an instance with the specified comparer, value and validator.
     * @param comparer       The comparer.
     * @param value          The value.
     * @param valueValidator Value validator.
     */
    protected ComparerAndValueBased(
            final Equals<TypeOfValue> comparer, final TypeOfValue value,
            final Validator<TypeOfValue> valueValidator) {
        super(comparer);
        this.setValue(value);
        if (valueValidator == null)
            throw new NullPointerException("Value validator not specified.");
        this._valueValidator = valueValidator;
    }

    /**
     * Returns the value of this function.
     * @return The value.
     */
    public final TypeOfValue getValue() {
        return this._value;
    }

    /**
     * Sets the value of this function.
     * @param value The value.
     * @exception IllegalArgumentException Value is not valid.
     */
    public final void setValue(final TypeOfValue value) {
        if (!this._valueValidator.isValid(value))
            throw new IllegalArgumentException("Value is not valid.");
        this._value = value;
    }
}