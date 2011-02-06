/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree.Builder;

import Mathematics.Graph.Tree.*;
import Mathematics.Graph.Builder.StateShift;
import Mathematics.Result.*;
import Mathematics.Vector.Vector;
import java.util.*;

/**
 * {@see TreeBuilder Builder} for a tree of {@see TreeNode nodes} with
 * {@see Vector vector} state and value.
 * @author Rune Dahl Iversen
 */
public final class Recombining
        extends LinkedHashSet<StateShift<Vector<Double>>>
        implements TreeBuilder<Vector<Double>, Vector<Double>> {
    private int _stepCount;

    /**
     * Creates an instance of the recombining tree builder for a tree of
     * nodes with real vector state and value.
     * @param stepCount
     * @param shifts
     */
    public Recombining(final int stepCount,
            final StateShift<Vector<Double>>... shifts) {
        super(shifts == null ? 16 : shifts.length);
        this._stepCount = stepCount;
        if (shifts != null)
            for (StateShift<Vector<Double>> shift : shifts)
                this.add(shift);
    }

    @Override
    public Result Build(
            final Node<Vector<Double>, Vector<Double>> origin) {
        Result result = null;
        try {
            HashMap<Vector<Double>, Node<Vector<Double>, Vector<Double>>> nodes =
                    new HashMap<Vector<Double>, Node<Vector<Double>, Vector<Double>>>();
            nodes.put(origin.getState(), origin);
            for (int step = 0; step < this._stepCount; step++) {
                HashMap<Vector<Double>, Node<Vector<Double>, Vector<Double>>> cache =
                        new HashMap<Vector<Double>, Node<Vector<Double>, Vector<Double>>>();
                for (Node<Vector<Double>, Vector<Double>> node : nodes.values()) {
                    for (StateShift<Vector<Double>> shift : this) {
                        Vector<Double> state = shift.value(node.getState());
                        Node<Vector<Double>, Vector<Double>> child;
                        if (cache.containsKey(state))
                            child = cache.get(state);
                        else
                            child = new VectorRealFunctionAndChildren(null, state, null, shift);
                    }
                }
                nodes = cache;
            }
            result = new SuccessWithValue<Node<Vector<Double>, Vector<Double>>>(origin);
        }
        catch (Exception e) {
            result = new UnhandledExceptionThrown(e);
        }
        return result;
    }
}