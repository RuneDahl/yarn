/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * Abstract class to allow easy implementation of {@see Validator validators}
 * with a limit i.e. 'GreaterThan X' or 'LessThan Z'.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value
 */
public abstract class LimitBased<TypeOfValue> implements Validator<TypeOfValue> {
    private TypeOfValue _limit;

    /**
     * Creates a new instance of a limit based validator with the specified limit.
     * @param limit The limit.
     */
    protected LimitBased(final TypeOfValue limit) {
        this._limit = limit;
    }

    /**
     * Gets the limit of this limit based validator.
     * @return The limit.
     */
    public final TypeOfValue getLimit() {
        return _limit;
    }

    /**
     * Sets the limit of this limit based validator to the specified limit.
     * @param limit The limit.
     */
    public final void setLimit(final TypeOfValue limit) {
        if (limit == null)
            throw new NullPointerException("Limit must be specified.");
        this._limit = limit;
    }
}