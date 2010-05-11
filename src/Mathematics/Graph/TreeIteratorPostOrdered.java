/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph;

import java.util.*;

/**
 * Implementation of an {@see Iterator iterator} using
 * <a href="http://en.wiktionary.org/wiki/repetition">non-repeating</a> post-order
 * <a href="http://en.wikipedia.org/wiki/Tree_traversal">tree-traversal</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public final class TreeIteratorPostOrdered<TypeOfState, TypeOfValue>
        implements Iterator<TreeNode<TypeOfState, TypeOfValue>> {
    private ArrayList<TreeNode<TypeOfState, TypeOfValue>> _done;
    private TreeNode<TypeOfState, TypeOfValue> _origin;
    private LinkedList<TreeNode<TypeOfState, TypeOfValue>> _stack;

    /**
     * Creates an instance of this non-repeating post-order tree-iterator
     * from the specified node of origin.
     * @param origin Node of origin.
     */
    public TreeIteratorPostOrdered(TreeNode<TypeOfState, TypeOfValue> origin) {
        this._origin = origin;
        this._stack = new LinkedList<TreeNode<TypeOfState, TypeOfValue>>();
        this._stack.add(this._origin);
        this._done = new ArrayList<TreeNode<TypeOfState, TypeOfValue>>();
    }

    public boolean hasNext() {
        return !this._stack.isEmpty();
    }

    public TreeNode<TypeOfState, TypeOfValue> next() {
        if (!this.hasNext())
            throw new NoSuchElementException("No more nodes to iterate.");
        TreeNode<TypeOfState, TypeOfValue> node;
        boolean keepGoing = true;
        while (keepGoing)
        {
            node = this._stack.peekLast(); // Get current suggestion for next node.
            keepGoing = false; // Assume that node is next in the iteration.
            if (0 < node.getChildren()) // If node has any children:
            {
                for (int c = 0; c < node.getChildren(); c++) // Iterate through the children.
                {
                    TreeNode<TypeOfState, TypeOfValue> child = node.getChild(c);
                    if (!this._stack.contains(child) &&
                            !this._done.contains(child)) // For any child not stacked and not done:
                    {
                        this._stack.addLast(child); // Add child to stack.
                        keepGoing = true; // Because a child was added, another node is the next in the iteration.
                    }
                }
            }
        }
        node = this._stack.pollLast(); // Get next node.
        this._done.add(node); // Add return value to done nodes.
        return node;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}