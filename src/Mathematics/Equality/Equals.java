/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.Function.Operator;

/**
 * Interface for comparison of values.
 * The declaration of this interface allows all comparison of values to
 * be implemented using the design pattern Strategy.
 * Further it allows the design pattern Composite.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Equals<TypeOfValue>
        extends Operator<TypeOfValue, TypeOfValue, Boolean> {
}