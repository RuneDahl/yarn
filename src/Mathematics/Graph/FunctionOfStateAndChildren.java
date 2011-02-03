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

    /**
     * Creates an instance of the state, value, function and weighted child node
     * values tree node with the specified state, value, child nodes and function.
     * @param stateValidator State validator.
     * @param state          State value.
     * @param valueValidator Value validator.
     * @param value          Value.
     * @param children       Child nodes.
     * @param function       Function.
     */
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

    /**
     * Creates an instance of the state, value, function and weighted child node
     * values tree node with the specified state, value and function.
     * @param stateValidator State validator.
     * @param state          State value.
     * @param valueValidator Value validator.
     * @param value          Value.
     * @param function       Function.
     */
    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator, value);
        this.setFunction(function);
    }

    /**
     * Creates an instance of the state, value, function and weighted child node
     * values tree node with the specified state, child nodes and function.
     * @param stateValidator State validator.
     * @param state          State value.
     * @param valueValidator Value validator.
     * @param children       Child nodes.
     * @param function       Function.
     */
    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final Map<TreeNode<TypeOfState, TypeOfValue>, Double> children,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator, children);
        this.setFunction(function);
    }

    /**
     * Creates an instance of the state, value, function and weighted child node
     * values tree node with the specified state, value, child nodes and function.
     * @param stateValidator State validator.
     * @param state          State value.
     * @param valueValidator Value validator.
     * @param function       Function.
     */
    protected FunctionOfStateAndChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final Function<TypeOfState, TypeOfValue> function) {
        super(stateValidator, state, valueValidator);
        this.setFunction(function);
    }

    /**
     * Gets the function of this node.
     * @return Function.
     */
    public final Function<TypeOfState, TypeOfValue> getFunction() {
        return this._function;
    }

    /**
     * Sets the function of this node.
     * @param function Function.
     * @throws NullPointerException Nunction not properly specified.
     */
    public final void setFunction(final Function<TypeOfState, TypeOfValue> function) {
        if (function == null)
            throw new NullPointerException("Function not properly specified.");
        this._function = function;
    }
}
