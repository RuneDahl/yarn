/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a command that changes the target value and returns the altered
 * value.<br>
 * The difference between a {@see Command command} and a
 * {@see Function.Function function} is that a command can change the input
 * value while a function cannot do so. Further the type of a command's
 * input and output values are by definition identical.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> The type of value that this command applies to.
 */
public interface Command<TypeOfValue> {
    /**
     * Apply this command to the specified target, thus altering the target.
     * @param target Target value.
     * @return       Altered target value.
     */
    public TypeOfValue applyTo(TypeOfValue target);
}
