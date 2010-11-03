/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

/**
 * Interface for a class having an {@see Evaluator evaluator}.
 * @author Rune Dahl Iversen
 * @param <TypeOfFunction> Type of function.
 * @param <TypeOfRegion>   Type of region.
 * @param <TypeOfValue>    Type of output value.
 */
public interface EvaluatorBased<TypeOfFunction, TypeOfRegion, TypeOfValue> {
    /**
     * Gets the evaluator.
     * @return The evaluator.
     */
    public Evaluator<TypeOfFunction, TypeOfRegion, TypeOfValue> getEvaluator();

    /**
     * Sets the evaluator.
     * @param evaluator The evaluator.
     */
    public void setEvaluator(
            final Evaluator<TypeOfFunction, TypeOfRegion, TypeOfValue> evaluator);
}