/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import Mathematics.Result.Result;

/**
 * Interface of a
 * <a href="http://en.wikipedia.org/wiki/Tree_%28data_structure%29#Terminology">node</a>
 * in a <a href="http://en.wikipedia.org/wiki/Tree_%28data_structure%29">tree</a>
 * or <a href="http://en.wikipedia.org/wiki/Lattice_graph">lattice</a> structure.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public interface Node<TypeOfState, TypeOfValue>
        extends Iterable<Node<TypeOfState, TypeOfValue>> {
    /**
     * Gets the child-node with the specified index in this node.
     * @param index Index.
     * @return      Child-node.
     */
    public Node<TypeOfState, TypeOfValue> getChild(final int index);

    /**
     * Gets the number of (direct, 1-step) child-nodes of this node.
     * @return Number of child-nodes.
     */
    public int getChildren();

    /**
     * Gets the state of this node.
     * @return The state.
     */
    public TypeOfState getState();

    /**
     * Gets the value of this node.
     * @return The value.
     */
    public TypeOfValue getValue();

    /**
     * Sets the state of this node.
     * @param state The state.
     */
    public void setState(final TypeOfState state);

    /**
     * Sets the value of this node.
     * @param value The value.
     */
    public void setValue(final TypeOfValue value);

    /**
     * Computes the value of this node and returns the result.
     * @return Result of the computation.
     */
    public Result computeValue();

    /**
     * Indicates whether the tree from this node and on contains the
     * specified node.
     * @param node TreeNode.
     * @return     True if found, else false.
     */
    public boolean hasChild(final Node<TypeOfState, TypeOfValue> node);
}