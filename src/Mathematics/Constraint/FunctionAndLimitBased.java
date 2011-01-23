/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import Mathematics.Function.Function;
import Validation.Validator;

/**
 * Abstract implementation of a {@see Constraint constrant} based on a
 * function and limiting value.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 * @param <TypeOfLimit> Type of limit.
 */
public abstract class FunctionAndLimitBased<TypeOfValue, TypeOfLimit>
        extends LimitBased<TypeOfValue, TypeOfLimit> {
    private Function<TypeOfValue, TypeOfLimit> _function;

    /**
     * Creates an instance of a function and limit based constraint.
     * @param function
     * @param limitValidator
     * @param limit
     */
    protected FunctionAndLimitBased(
            final Function<TypeOfValue, TypeOfLimit> function,
            final Validator<TypeOfLimit> limitValidator,
            final TypeOfLimit limit) {
        super(limitValidator, limit);
        this.setFunction(function);
    }

    /**
     * Gets the function of this constraint.
     * @return The function.
     */
    public final Function<TypeOfValue, TypeOfLimit> getFunction() {
        return this._function;
    }

    /**
     * Sets the function of this constraint.
     * @param function Function.
     * @throws NullPointerException Function not properly specified.
     */
    public final void setFunction(final Function<TypeOfValue, TypeOfLimit> function) {
        if (function == null)
            throw new NullPointerException("Function not properly specified.");
        this._function = function;
    }
}