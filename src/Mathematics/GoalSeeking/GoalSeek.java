/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.Function.Function;
import Mathematics.Result.Result;

/**
 * Interface of a
 * <a href="http://en.wikipedia.org/wiki/Goal_seeking">goal-seeking</a>
 * <a href="http://en.wikipedia.org/wiki/Algorithm">algorithm</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input.
 * @param <TypeOfOutput> Type of output.
 */
public interface GoalSeek<TypeOfInput, TypeOfOutput> {
    public Result GoalSeek(final Function<TypeOfInput, TypeOfOutput> function);
}