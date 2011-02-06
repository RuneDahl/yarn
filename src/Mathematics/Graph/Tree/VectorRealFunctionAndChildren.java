/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import Mathematics.Function.Function;
import Mathematics.Result.*;
import Mathematics.Vector.Vector;
import Validation.*;
import java.util.Map;

/**
 * Implementation of a {@see TreeNode tree node} with state and value values
 * of {@see Vector vectors} of {@see Double real} values using a function of
 * the state and the weighted sum of values of the child nodes to compute the
 * value.
 * @author Rune Dahl Iversen
 */
public class VectorRealFunctionAndChildren
        extends FunctionOfStateAndChildren<Vector<Double>, Vector<Double>> {
    private final static Validator<Vector<Double>> __validator = Factory.VectorRealValues(Factory.FiniteReal());

    /**
     * Creates an instance of the real vector, function and weighted child node
     * values tree node with the specified state and function.
     * @param state    State value.
     * @param function Function.
     */
    public VectorRealFunctionAndChildren(
            final Vector<Double> state,
            final Function<Vector<Double>, Vector<Double>> function) {
        super(__validator, state, __validator, function);
    }

    /**
     * Creates an instance of the real vector, function and weighted child node
     * values tree node with the specified state, child nodes and function.
     * @param state    State value.
     * @param children Child nodes.
     * @param function Function.
     */
    public VectorRealFunctionAndChildren(
            final Vector<Double> state,
            final Map<Node<Vector<Double>, Vector<Double>>, Double> children,
            final Function<Vector<Double>, Vector<Double>> function) {
        super(__validator, state, __validator, children, function);
    }

    /**
     * Creates an instance of the real vector, function and weighted child node
     * values tree node with the specified state, value and function.
     * @param state    State value.
     * @param value    Value.
     * @param function Function.
     */
    public VectorRealFunctionAndChildren(
            final Vector<Double> state,
            final Vector<Double> value,
            final Function<Vector<Double>, Vector<Double>> function) {
        super(__validator, state, __validator, value, function);
    }

    /**
     * Creates an instance of the real vector, function and weighted child node
     * values tree node with the specified state, value, child nodes and function.
     * @param state    State value.
     * @param value    Value.
     * @param children Child nodes.
     * @param function Function.
     */
    public VectorRealFunctionAndChildren(
            final Vector<Double> state,
            final Vector<Double> value,
            final Map<Node<Vector<Double>, Vector<Double>>, Double> children,
            final Function<Vector<Double>, Vector<Double>> function) {
        super(__validator, state, __validator, value, children, function);
    }

    @Override
    public Result computeValue() {
        Result result = null;
        try {
            Vector<Double> value = this.getFunction().value(this.getState());
            for (Map.Entry<Node<Vector<Double>, Vector<Double>>, Double>
                    child : this)
                value = value.sum(child.getKey().getValue().scale(child.getValue()));
            this.setValue(value);
            result = new SuccessWithValue<Vector<Double>>(value);
        }
        catch (Exception e) {
            result = new UnhandledExceptionThrown(e);
        }
        return result;
    }
}
