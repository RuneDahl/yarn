/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface for an algorithm with an initial value.
 * @author Rune Dahl Iversen
 * @param <TypeOfAlgorithmValue> Type of value of the algorithm.
 * @param <TypeOfInitialValue>   Type of initial value.
 */
public interface InitialValue<TypeOfInitialValue, TypeOfAlgorithmValue>
        extends Algorithm<TypeOfAlgorithmValue> {
    /**
     * Gets the initial value of this algorithm.
     * @return The initial value.
     */
    public TypeOfInitialValue getInitialValue();

    /**
     * Sets the initial value of this algorithm.
     * @param initialValue The initial value.
     */
    public void setInitialValue(final TypeOfInitialValue initialValue);
}