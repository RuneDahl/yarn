/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.Algorithm.Algorithm;
import Mathematics.Function.Function;

/**
 * Interface of a
 * <a href="http://en.wikipedia.org/wiki/Goal_seeking">goal-seeking</a>
 * {@see Algorithm algorithm} where the function is the last input to
 * the algorithm. <br>
 * This allows the user to change the function easily while keeping
 * the other values (goal value, initial value et c.) constant.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input.
 * @param <TypeOfOutput> Type of output.
 */
public interface GoalSeekFunction<TypeOfInput, TypeOfOutput>
        extends Algorithm<Function<TypeOfInput, TypeOfOutput>> {
    /**
     * Gets the goal value.
     * This is the value that this algorithm seek
     * to hit as the output value from the function.
     * @return The goal value.
     */
    public TypeOfOutput getGoalValue();

    /**
     * Sets the goal value.
     * @param value The goal value.
     */
    public void setGoalValue(final TypeOfOutput value);
} // http://en.wikipedia.org/wiki/Steffensen's_method