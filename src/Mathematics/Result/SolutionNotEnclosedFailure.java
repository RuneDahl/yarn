/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

import Mathematics.Function.Function;
import Mathematics.Interval;

/**
 * {@see Result} representing a failure as the specified interval cannot be
 * guaranteed to contain the target value as output from the function.
 * @author Rune Dahl Iversen
 * @param <TypeOfInput>  Type of input of the function and the type of values
 *                       of the interval.
 * @param <TypeOfOutput> Type of output from the function.
 */
public final class SolutionNotEnclosedFailure<TypeOfInput, TypeOfOutput>
        implements Result {
    private final Interval<TypeOfInput> _interval;
    private final Function<TypeOfInput, TypeOfOutput> _function;
    private final TypeOfOutput _goalValue;

    /**
     * Creates an instance of root not enclosed failure for the specified
     * function, interval and goal value.
     * @param function  Function.
     * @param interval  Interval.
     * @param goalValue Target value.
     */
    public SolutionNotEnclosedFailure(final Function<TypeOfInput, TypeOfOutput> function,
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