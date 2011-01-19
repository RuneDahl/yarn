/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mathematics.Graph;

import Validation.Validator;
import java.util.*;

/**
 * Abstract implementation of a {@see TreeNode tree-node} with state, value,
 * {@see Validator validation} of these and child-nodes with weights.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public abstract class AbstractStateValueWeightedChildren<TypeOfState, TypeOfValue>
        extends AbstractStateValue<TypeOfState, TypeOfValue> {
    private final HashMap<TreeNode<TypeOfState, TypeOfValue>, Double> _children =
            new HashMap<TreeNode<TypeOfState, TypeOfValue>, Double>();

    /**
     * Creates an instance of a node with state and value
     * without specifying the value.
     * @param stateValidator {@see Validator} for the state.
     * @param state          State of the node.
     * @param valueValidator {@see Validator} for the value.
     */
    protected AbstractStateValueWeightedChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator) {
        super(stateValidator, state, valueValidator);
    }

    /**
     * Creates an instance of a node with state, weighted child nodes and value
     * without specifying the value.
     * @param stateValidator {@see Validator} for the state.
     * @param state          State of the node.
     * @param valueValidator {@see Validator} for the value.
     * @param children       Collection of weighted child nodes.
     */
    protected AbstractStateValueWeightedChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final Map<TreeNode<TypeOfState, TypeOfValue>, Double> children) {
        super(stateValidator, state, valueValidator);
        this._children.putAll(children);
    }

    /**
     * Creates an instance of a node with state and value.
     * @param stateValidator {@see Validator} for the state.
     * @param state          State of the node.
     * @param valueValidator {@see Validator} for the value.
     * @param value          Value of the node.
     */
    protected AbstractStateValueWeightedChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value) {
        super(stateValidator, state, valueValidator, value);
    }

    /**
     * Creates an instance of a node with state, weighted child nodes and value.
     * @param stateValidator {@see Validator} for the state.
     * @param state          State of the node.
     * @param valueValidator {@see Validator} for the value.
     * @param value          Value of the node.
     * @param children       Collection of weighted child nodes.
     */
    protected AbstractStateValueWeightedChildren(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value,
            final Map<TreeNode<TypeOfState, TypeOfValue>, Double> children) {
        this(stateValidator, state, valueValidator, value);
        this._children.putAll(children);
    }

    @Override
    public TreeNode<TypeOfState, TypeOfValue> getChild(final int index) {
        return this._child(index).getKey();
    }

    @Override
    public int getChildren() {
        return this._children.size();
    }

    /**
     * Gets the weight associated with the child-node of the specified index.
     * @param index Index.
     * @return      Weight of the child-node.
     */
    public double getWeight(final int index) {
        return this._child(index).getValue();
    }

    /**
     * Adds a child-node and its weight.
     * @param child  Child-node.
     * @param weight Weight.
     */
    public void addChild(final TreeNode<TypeOfState, TypeOfValue> child,
            final double weight) {
        this._children.put(child, weight);
    }

    @Override
    public boolean hasChild(final TreeNode<TypeOfState, TypeOfValue> node) {
        return this._children.containsKey(node);
    }

    /**
     * Removes the child-node with the specified index.
     * @param index Index.
     */
    public void removeChild(final int index) {
        this.removeChild(this.getChild(index));
    }

    /**
     * Removes the specified child-node.
     * @param child Child-node.
     */
    public void removeChild(final TreeNode<TypeOfState, TypeOfValue> child) {
        this._children.remove(child);
    }

    /**
     * Returns an iterator for the map of child-nodes and their respective weights.
     * @return Iterator of the child-nodes and weights.
     */
    protected Iterator<Map.Entry<TreeNode<TypeOfState, TypeOfValue>, Double>>
            _childIterator() {
        return this._children.entrySet().iterator();
    }

    /**
     * Returns the child and weight with the specified index in this node's
     * collection of child-nodes.
     * @param index Index.
     * @return      Child-node and weight.
     */
    protected Map.Entry<TreeNode<TypeOfState, TypeOfValue>, Double> _child(
            final int index) {
        if (index < 0 || this.getChildren() <= index) {
            throw new IllegalArgumentException("Index out of range.");
        }
        int i = 0;
        for (Map.Entry<TreeNode<TypeOfState, TypeOfValue>, Double> child :
            this._children.entrySet()) {
            if (i == index) {
                return child;
            }
            i++;
        }
        throw new IllegalStateException("This should never occur.");
    }
}