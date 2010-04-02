/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface for a stateful class with a criterion.
 * @author Rune Dahl Iversen
 * @param <TypeOfCriterion> Type of criterion.
 */
public interface Criterion<TypeOfCriterion> {
    /**
     * Gets the criterion.
     * @return The criterion.
     */
    public TypeOfCriterion getCriterion();

    /**
     * Sets the criterion.
     * @param criterion The criterion.
     */
    public void setCriterion(final TypeOfCriterion criterion);
}