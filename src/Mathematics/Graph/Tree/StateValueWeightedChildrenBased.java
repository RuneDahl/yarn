/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mathematics.Graph.Tree;

import Validation.Validator;
import java.util.*;

/**
 * Abstract implementation of a {@see TreeNode tree-node} with state, value,
 * {@see Validator validation} of these and child-nodes with weights.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public abstract class StateValueWeightedChildrenBased<TypeOfState, TypeOfValue>
        extends StateValueBased<TypeOfState, TypeOfValue> {
    private final LinkedHashMap<Node<TypeOfState, TypeOfValue>, Double> _children =
            new LinkedHashMap<Node<TypeOfState, TypeOfValue>, Double>();

    /**
     * Creates an instance of a node with state and value
     * without specifying the value.
     * @param stateValidator {@see Validator} for the state.
     * @param state          State of the node.
     * @param valueValidator {@see Validator} for the value.
     */
    protected StateValueWeightedChildrenBased(
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
    protected StateValueWeightedChildrenBased(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final Map<Node<TypeOfState, TypeOfValue>, Double> children) {
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
    protected StateValueWeightedChildrenBased(
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
    protected StateValueWeightedChildrenBased(
            final Validator<TypeOfState> stateValidator,
            final TypeOfState state,
            final Validator<TypeOfValue> valueValidator,
            final TypeOfValue value,
            final Map<Node<TypeOfState, TypeOfValue>, Double> children) {
        this(stateValidator, state, valueValidator, value);
        this._children.putAll(children);
    }

    @Override
    public final Node<TypeOfState, TypeOfValue> getChild(final int index) {
        return this._child(index).getKey();
    }

    @Override
    public final int getChildren() {
        return this._children.size();
    }

    /**
     * Gets the weight associated with the specified child node. With a
     * safe-guard for non-child-nodes returning the weight 0 (zero).
     * @param child Child-node.
     * @return      Weight of the child node.
     */
    public final double getWeight(final Node<TypeOfState, TypeOfValue> child) {
        if (this.hasChild(child))
            return this._children.get(child);
        else
            return 0.0;
    }

    /**
     * Gets the weight associated with the child-node of the specified index.
     * @param index Index.
     * @return      Weight of the child-node.
     */
    public final double getWeight(final int index) {
        return this._child(index).getValue();
    }

    /**
     * Adds a child-node and its weight.
     * @param child  Child-node.
     * @param weight Weight.
     */
    public final void addChild(final Node<TypeOfState, TypeOfValue> child,
            final double weight) {
        if (child == null)
            throw new NullPointerException("Child node not properly specified.");
        this._children.put(child, weight);
    }

    @Override
    public final boolean hasChild(final Node<TypeOfState, TypeOfValue> node) {
        return this._children.containsKey(node);
    }

    /**
     * Removes the child-node with the specified index.
     * @param index Index.
     */
    public final void removeChild(final int index) {
        this.removeChild(this.getChild(index));
    }

    /**
     * Removes the specified child-node.
     * @param child Child-node.
     */
    public final void removeChild(final Node<TypeOfState, TypeOfValue> child) {
        this._children.remove(child);
    }

    /**
     * Returns an iterator for the child-nodes.<br>
     * This iterator will only iterate through the direct child-nodes of this
     * node and not any child-nodes of the child-nodes.
     * @return Iterator of the child-nodes.
     */
    @Override
    public final Iterator<Node<TypeOfState, TypeOfValue>>
            iterator() {
        return this._children.keySet().iterator();
    }

    /**
     * Returns the child and weight with the specified index in this node's
     * collection of child-nodes and weights.
     * @param index Index.
     * @return      Child-node and weight.
     */
    protected final Map.Entry<Node<TypeOfState, TypeOfValue>, Double> _child(
            final int index) {
        if (index < 0 || this.getChildren() <= index) {
            throw new ArrayIndexOutOfBoundsException("Index out of range: " +
                    Integer.toString(index));
        }
        int i = 0;
        for (Map.Entry<Node<TypeOfState, TypeOfValue>, Double> child :
            this._children.entrySet()) {
            if (i == index) {
                return child;
            }
            i++;
        }
        throw new IllegalStateException("This should never occur.");
    }
}