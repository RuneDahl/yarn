/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import Validation.Validator;

/**
 * Abstract implementation of a {@see Constraint constraint} based on a limit value.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 * @param <TypeOfLimit> Type of limit.
 */
public abstract class LimitBased<TypeOfValue, TypeOfLimit> {
    private TypeOfLimit _limit;
    private Validator<TypeOfLimit> _validator;

    /**
     * Creates an instance of a limitbased constraint with the specified
     * validator for the limit and limit value.
     * @param validator The validator of the limit.
     * @param limit     The limit.
     * @throw NullPointerException Validator not properly specified.
     */
    protected LimitBased(final Validator<TypeOfLimit> validator,
            final TypeOfLimit limit) {
        if (validator == null)
            throw new NullPointerException("Validator not properly specified.");
        this._validator = validator;
        this.setLimit(limit);
    }

    /**
     * Gets the limit of this limitbased constraint.
     * @return The limit.
     */
    public final TypeOfLimit getLimit() {
        return this._limit;
    }

    /**
     * Sets the limit of this limitbased constraint.
     * @param limit Limit.
     * @throws IllegalArgumentException Limit is not properly specified.
     */
    public final void setLimit(final TypeOfLimit limit) {
        if (!this._validator.isValid(limit))
            throw new IllegalArgumentException(
                    this._validator.message(limit, "Limit"));
        this._limit = limit;
    }
}