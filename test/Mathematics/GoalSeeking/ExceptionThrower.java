/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.Function.Function;

/**
 * A function that merely throw an exception when invoked.
 * @author Rune Dahl Iversen
 */
public class ExceptionThrower<TypeOfInput, TypeOfOutput>
        implements Function<TypeOfInput, TypeOfOutput> {

    @Override
    public TypeOfOutput value(TypeOfInput input) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
