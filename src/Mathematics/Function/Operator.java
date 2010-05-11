/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Interface that represents an
 * <a href="http://en.wikipedia.org/wiki/Operator">operator</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfFirstInput>  Type of first input.
 * @param <TypeOfSecondInput> Type of second input.
 * @param <TypeOfOutput>      Type of output.
 */
public interface Operator<TypeOfFirstInput, TypeOfSecondInput, TypeOfOutput> {
    /**
     * Returns the result of this
     * <a href="http://en.wikipedia.org/wiki/Operator">operation</a>
     * with the specified inputs.
     * @param firstInput  First input.
     * @param secondInput Second input.
     * @return            Resulting value.
     */
    public TypeOfOutput Value(final TypeOfFirstInput firstInput,
            final TypeOfSecondInput secondInput);
}