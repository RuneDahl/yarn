/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface for a stateful class with an initial value.
 * @author Rune Dahl Iversen
 * @param <TypeOfInitialValue> Type of initial value.
 */
public interface InitialValue<TypeOfInitialValue> {
    /**
     * Gets the initial value.
     * @return The initial value.
     */
    public TypeOfInitialValue getInitialValue();

    /**
     * Sets the initial value.
     * @param initialValue The initial value.
     */
    public void setInitialValue(final TypeOfInitialValue initialValue);
}