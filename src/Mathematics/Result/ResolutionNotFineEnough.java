/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

import Mathematics.Function.Function;
import Mathematics.Interval;

/**
 * {@see Result} representing a formal failure to identify the solution as the
 * <a href="http://en.wikipedia.org/wiki/Double_precision">numerical resolution</a>
 * is not fine enough. This situation leads to a interval that contain
 * no identiable numbers other than the bounds.
 * <BR>This is an artefact of the way numbers are represented in computers.
 * <BR>In a less strict use this result can be interpreted as a
 * {@see Success succes}, since it does return a narrow interval that
 * the correct solution exist within. However this interpretation of the result
 * must be left to the individual implementation.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input of the function and the type of values
 *                       of the interval.
 * @param <TypeOfOutput> Type of output from the function.
 */
public final class ResolutionNotFineEnough<TypeOfInput, TypeOfOutput>
        implements Result {
    private final Interval<TypeOfInput> _interval;
    private final Function<TypeOfInput, TypeOfOutput> _function;
    private final TypeOfOutput _goalValue;

    /**
     * Creates an instance of the resolution not fine enough {@see Result result}
     * with the specified function, interval and target value.
     * The interval represents the 2 best guesses at a solution.
     * @param function  Function.
     * @param interval  Interval.
     * @param goalValue Target value.
     */
    public ResolutionNotFineEnough(
            final Function<TypeOfInput, TypeOfOutput> function,
            final Interval<TypeOfInput> interval, final TypeOfOutput goalValue) {
        if (function == null)
            throw new NullPointerException("Function not properly specified.");
        this._function = function;
        if (goalValue == null)
            throw new NullPointerException("Target value not properly specified.");
        this._goalValue = goalValue;
        if (interval == null)
            throw new NullPointerException("Interval not properly specified.");
        this._interval = interval;
    }

    /**
     * Returns the function.
     * @return The function.
     */
    public Function<TypeOfInput, TypeOfOutput> getFunction() {
        return this._function;
    }

    /**
     * Returns the target value.
     * @return The target value.
     */
    public TypeOfOutput getGoalValue() {
        return this._goalValue;
    }

    /**
     * Returns the interval.
     * @return The interval.
     */
    public Interval<TypeOfInput> getInterval() {
        return this._interval;
    }
}