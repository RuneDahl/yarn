/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface that represents an
 * <a href="http://en.wikipedia.org/wiki/Operator">operator</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfFirstInput>  Type of first input.
 * @param <TypeOfSecondInput> Type of second input.
 * @param <TypeOfOutput>      Type of output.
 */
public interface Operator<TypeOfFirstInput, TypeOfSecondInput, TypeOfOutput> {
    public TypeOfOutput Value(final TypeOfFirstInput firstInput,
            final TypeOfSecondInput secondInput);
}