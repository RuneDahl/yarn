/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph;

import Validation.Validator;

/**
 * Abstract implementation of the state and value of a {@see TreeNode tree-node}
 * including {@see Validator validation} of both.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public abstract class StateValueBased<TypeOfState, TypeOfValue>
        implements TreeNode<TypeOfState, TypeOfValue> {
    private TypeOfState _state;
    private Validator<TypeOfState> _stateValidator;
    private TypeOfValue _value;
    private Validator<TypeOfValue> _valueValidator;

    /**
     * Creates an instance of this tree-node with the specified state
     * and validators.
     * @param stateValidator Validator of the state.
     * @param state          State.
     * @param valueValidator Validator of the value.
     */
    protected StateValueBased(final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator) {
        if (stateValidator == null)
            throw new NullPointerException("No state-validator specified.");
        this._stateValidator = stateValidator;
        if (valueValidator == null)
            throw new NullPointerException("No value-validator specified.");
        this._valueValidator = valueValidator;
        this.setState(state);
        this._value = null;
    }

    /**
     * Creates an instance of this tree-node with the specified state, value
     * and validators.
     * @param stateValidator Validator of the state.
     * @param state          State.
     * @param valueValidator Validator of the value.
     * @param value          Value.
     */
    protected StateValueBased(final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value) {
        this(stateValidator, state, valueValidator);
        this.setValue(value);
    }

    @Override
    public final TypeOfState getState() {
        return this._state;
    }

    @Override
    public final TypeOfValue getValue() {
        if (this._value == null)
            this.computeValue();
        return this._value;
    }

    @Override
    public final void setState(final TypeOfState state) {
        if (!this._stateValidator.isValid(state))
            throw new IllegalArgumentException(
                    this._stateValidator.message(state, "State"));
        this._state = state;
    }

    @Override
    public final void setValue(final TypeOfValue value) {
        if (!this._valueValidator.isValid(value))
            throw new IllegalArgumentException(
                    this._valueValidator.message(value, "Value"));
        this._value = value;
    }
}