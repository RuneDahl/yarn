/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

/**
 * Implementation of a {@see Constraint constraint} requiring the value
 * to be greater than or equal to the specified {@see LimitBased limit}.
 * @author Rune Dahl Iversen
 */
public final class GreaterThanOrEqualReal
        extends LimitBased<Double, Double> {
    /**
     * Creates an instance of the greater than or equal real constraint
     * with the specified limit.
     * @param limit Limit.
     */
    public GreaterThanOrEqualReal(final double limit) {
        super(Validation.Factory.FiniteReal(), limit);
    }

    @Override
    public boolean isBinding(final Double value) {
        return this.getLimit().equals(value);
    }

    @Override
    public boolean isFeasible(final Double value) {
        return this.getLimit() <= value;
    }
}