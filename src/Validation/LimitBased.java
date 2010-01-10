/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> TypeOfValue
 */
public abstract class LimitBased<TypeOfValue> implements Validator<TypeOfValue> {
    private TypeOfValue _limit;

    protected LimitBased(final TypeOfValue limit) {
        this._limit = limit;
    }

    public final TypeOfValue getLimit() {
        return _limit;
    }

    public final void setLimit(final TypeOfValue limit) {
        if (limit == null)
            throw new NullPointerException("Limit must be specified.");
        this._limit = limit;
    }
}