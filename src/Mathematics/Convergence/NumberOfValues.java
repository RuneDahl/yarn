/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

/**
 * Implementation of a convergence criterion based on the number of values in
 * the series. More values than the set count yields a positive result.
 * No check of whether the values are null or similar is performed.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public final class NumberOfValues<TypeOfValue>
        implements Criterion<TypeOfValue>, Mathematics.Count {
    private static final Validation.Validator<Integer> _validator =
            Validation.Factory.PositiveInteger();
    private int _count;

    /**
     * Create an instance of the convergence criterion based on the number
     * of values using the specified count as limit.
     * @param count Number of values to achieve convergence.
     */
    public NumberOfValues(final int count) {
        this.setCount(count);
    }

    public boolean converges(final TypeOfValue[] series) {
        return (this._count <= series.length);
    }

    public int getCount() {
        return this._count;
    }

    public void setCount(final int count) {
        if (!_validator.isValid(count))
            throw new IllegalArgumentException(_validator.message(count, "Count"));
        this._count = count;
    }
}