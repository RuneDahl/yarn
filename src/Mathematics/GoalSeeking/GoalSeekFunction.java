/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mathematics.GoalSeeking;

import Mathematics.Algorithm.Algorithm;
import Mathematics.Equality.Equals;
import Mathematics.Function.Function;
import Mathematics.Result.Result;
import Validation.Validator;

/**
 * Interface of a
 * <a href="http://en.wikipedia.org/wiki/Goal_seeking">goal-seeking</a>
 * {@see Algorithm algorithm}.
 * @author Rune Dahl Iversen
 * @param <TypeOfInitialValue> Type of initial value(s).
 * @param <TypeOfInput>        Type of input.
 * @param <TypeOfOutput>       Type of output.
 */
public abstract class GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput>
        implements Algorithm<Result> {

    private Equals<TypeOfOutput> _criterion;
    private Function<TypeOfInput, TypeOfOutput> _function;
    private TypeOfOutput _goalValue;
    private Validator<TypeOfOutput> _goalValidator;
    private TypeOfInitialValue _initialValue;

    /**
     * Creates an instance of a goal-seeking algorithm with the specified values.
     * @param function         Function.
     * @param goalValidator    Validator for the goal values.
     * @param goalValue        Goal value.
     * @param initialValidator Validator for the initial value.
     * @param initialValue     Initial value.
     */
    protected GoalSeekFunction(
            final Equals<TypeOfOutput> criterion,
            final Function<TypeOfInput, TypeOfOutput> function,
            final Validator<TypeOfOutput> goalValidator,
            final TypeOfOutput goalValue,
            final TypeOfInitialValue initialValue) {
        this.setCriterion(criterion);
        this.setFunction(function);
        if (goalValidator == null) {
            throw new NullPointerException("Goal validator not properly specified.");
        }
        this._goalValidator = goalValidator;
        this.setGoalValue(goalValue);
        this.setInitialValue(initialValue);
    }

    /**
     * Gets the criterion.
     * @return
     */
    public final Equals<TypeOfOutput> getCriterion() {
        return this._criterion;
    }

    /**
     * Gets the function being goal-seeked.
     * @return The function.
     */
    public final Function<TypeOfInput, TypeOfOutput> getFunction() {
        return this._function;
    }

    /**
     * Gets the goal value.
     * This is the value that this algorithm seek
     * to hit as the output value from the function.
     * @return The goal value.
     */
    public final TypeOfOutput getGoalValue() {
        return this._goalValue;
    }

    /**
     * Gets the initial value.
     * @return The initial value.
     */
    public final TypeOfInitialValue getInitialValue() {
        return this._initialValue;
    }

    /**
     * Sets the criterion.
     * @param criterion Criterion.
     * @throws NullPointerException Criterion not properly specified.
     */
    public final void setCriterion(final Equals<TypeOfOutput> criterion) {
        if (criterion == null) {
            throw new NullPointerException("Criterion not properly specified.");
        }
        this._criterion = criterion;
    }

    /**
     * Sets the function to be goal-seeked.
     * @param function The function.
     * @throws NullPointerException Function not properly specified.
     */
    public final void setFunction(
            final Function<TypeOfInput, TypeOfOutput> function) {
        if (function == null) {
            throw new NullPointerException("Function not properly specified.");
        }
        this._function = function;
    }

    /**
     * Sets the goal value.
     * @param value The goal value.
     * @throws IllegalArgumentException Goal value not valid.
     */
    public final void setGoalValue(final TypeOfOutput value) {
        if (!this._goalValidator.isValid(value)) {
            throw new IllegalArgumentException(
                    this._goalValidator.message(value, "Goal value"));
        }
        this._goalValue = value;
    }

    /**
     * Sets the initial value.
     * @param value The initial value.
     * @throws NullPointerException Initial value not properly specified.
     */
    public final void setInitialValue(final TypeOfInitialValue value) {
        if (value == null) {
            throw new NullPointerException("Initial value not properly specified.");
        }
        this._initialValue = value;
    }
}
