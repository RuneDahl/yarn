/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 */
public abstract class LimitBased<TypeOfValue> implements Validator<TypeOfValue> {
    private TypeOfValue _limit;

    protected LimitBased(TypeOfValue limit) {
        this._limit = limit;
    }

    public TypeOfValue getLimit() {
        return _limit;
    }

    public void setLimit(TypeOfValue limit) {
        if (limit == null)
            throw new NullPointerException("Limit must be specified.");
        this._limit = limit;
    }
}