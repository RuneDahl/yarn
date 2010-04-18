/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph;

import java.util.*;

/**
 * Implementation of an {@see Iterator iterator} using
 * <a href="http://en.wiktionary.org/wiki/repetition">non-repeating</a> pre-order
 * <a href="http://en.wikipedia.org/wiki/Tree_traversal">tree-traversal</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public final class TreeIteratorPreOrdered<TypeOfState, TypeOfValue>
        implements Iterator<TreeNode<TypeOfState, TypeOfValue>> {
    private ArrayList<TreeNode<TypeOfState, TypeOfValue>> _done;
    private TreeNode<TypeOfState, TypeOfValue> _origin;
    private LinkedList<TreeNode<TypeOfState, TypeOfValue>> _queue;

    /**
     * Creates an instance of this non-repeating pre-order tree-iterator
     * from the specified node of origin.
     * @param origin Node of origin.
     */
    public TreeIteratorPreOrdered(TreeNode<TypeOfState, TypeOfValue> origin) {
        this._origin = origin;
        this._queue = new LinkedList<TreeNode<TypeOfState, TypeOfValue>>();
        this._queue.add(this._origin);
        this._done = new ArrayList<TreeNode<TypeOfState, TypeOfValue>>();
    }

    public boolean hasNext() {
        return !this._queue.isEmpty();
    }

    public TreeNode<TypeOfState, TypeOfValue> next() {
        if (!this.hasNext())
            throw new NoSuchElementException("No more nodes to iterate.");
        TreeNode<TypeOfState, TypeOfValue> node = this._queue.pollFirst();
        if (0 < node.getChildren()) // If the node has children:
            for (int c = 0; c < node.getChildren(); c++) // Iterate through the children.
            {
                TreeNode<TypeOfState, TypeOfValue> child = node.getChild(c);
                if (!this._queue.contains(child) &&
                        !this._done.contains(child)) // Any child not queued and not done:
                    this._queue.addLast(child); // Add child to queue.
            }
        this._done.add(node); // Add return value to done nodes.
        return node;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}