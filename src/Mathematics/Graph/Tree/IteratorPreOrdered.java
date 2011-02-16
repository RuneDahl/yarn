/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import java.util.*;

/**
 * Implementation of an {@see Iterator iterator} using
 * <a href="http://en.wiktionary.org/wiki/repetition">non-repeating</a> pre-order
 * <a href="http://en.wikipedia.org/wiki/Tree_traversal">tree-traversal</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public final class IteratorPreOrdered<TypeOfState, TypeOfValue>
        implements Iterator<Node<TypeOfState, TypeOfValue>> {
    private final ArrayList<Node<TypeOfState, TypeOfValue>> _done;
    private final LinkedList<Node<TypeOfState, TypeOfValue>> _queue;

    /**
     * Creates an instance of this non-repeating pre-order tree-iterator
     * from the specified node of origin.
     * @param origin Node of origin.
     */
    public IteratorPreOrdered(Node<TypeOfState, TypeOfValue> origin) {
        if (origin == null)
            throw new NullPointerException("Origin not properly specified.");
        this._queue = new LinkedList<Node<TypeOfState, TypeOfValue>>();
        this._queue.add(origin);
        this._done = new ArrayList<Node<TypeOfState, TypeOfValue>>();
    }

    @Override
    public boolean hasNext() {
        return !this._queue.isEmpty();
    }

    @Override
    public Node<TypeOfState, TypeOfValue> next() {
        if (!this.hasNext())
            throw new NoSuchElementException("No more nodes to iterate.");
        Node<TypeOfState, TypeOfValue> node = this._queue.pollFirst();
        if (0 < node.getChildren()) { // If the node has children:
            for (Node<TypeOfState, TypeOfValue> child : node) { // Iterate through the children.
                if (!this._queue.contains(child) &&
                        !this._done.contains(child)) // Any child not queued and not done:
                    this._queue.addLast(child); // Add child to queue.
            }
        }
        this._done.add(node); // Add return value to done nodes.
        return node;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}