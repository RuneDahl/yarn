/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph;

import Mathematics.Function.Function;
import Validation.Validator;
import java.util.Map;

/**
 * Abstract class representing a {@see TreeNode tree node} where
 * the value is a function of the state and the children.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public abstract class FunctionOfStateAndChildren<TypeOfState, TypeOfValue>
        extends StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> {
    private Function<TypeOfState, TypeOfValue> _function;

    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value,
            final Map<TreeNode<TypeOfState, TypeOfValue>, Double> children,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator, value, children);
        this.setFunction(function);
    }

    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator, value);
        this.setFunction(function);
    }

    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final Map<TreeNode<TypeOfState, TypeOfValue>, Double> children,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator, children);
        this.setFunction(function);
    }

    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator);
        this.setFunction(function);
    }

    public final Function<TypeOfState, TypeOfValue> getFunction() {
        return this._function;
    }

    public final void setFunction(final Function<TypeOfState, TypeOfValue> function) {
        if (function == null)
            throw new NullPointerException("Function not properly specified.");
        this._function = function;
    }
}
