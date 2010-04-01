/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

/**
 * Interface for a mathematical
 * <a href="http://en.wikipedia.org/wiki/Constraint_%28mathematics%29">constraint</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Constraint<TypeOfValue> {
    /**
     * Returns if this constraint is
     * <a href="http://en.wikipedia.org/wiki/Constraint_%28mathematics%29#Terminology">binding</a>
     * at the specified value.
     * @param value Value.
     * @return True if this constraint is binding else false.
     */
    public boolean isBinding(final TypeOfValue value);

    /**
     * Returns if the specified values is
     * <a href="http://en.wikipedia.org/wiki/Constraint_%28mathematics%29#Terminology">feasible</a>
     * for this constraint.
     * @param value Value.
     * @return True if the value is feasible else false.
     */
    public boolean isFeasible(final TypeOfValue value);
}