/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation;

import Mathematics.Function.Function;

/**
 * Abstract implementation of a stategy for
 * <a href="http://en.wikipedia.org/wiki/Interpolation">interpolation</a>
 * based on data. The interpolation can be treated as a {@see Function function}
 * with input and output.
 * @author Rune Dahl Iversen
 * @param <TypeOfData>   Type of data.
 * @param <TypeOfInput>  Type of input.
 * @param <TypeOfOutput> Type of output.
 */
public abstract class Interpolator<TypeOfData, TypeOfInput, TypeOfOutput>
        implements Function<TypeOfInput, TypeOfOutput> {
    private TypeOfData _data;

    /**
     * Creates a startegy for interpolation based on the specified data.
     * @param data Data to interpolate in.
     */
    protected Interpolator(final TypeOfData data) {
        this.setData(data);
    }

    /**
     * Gets the data to interpolate in.
     * @return Data.
     */
    public final TypeOfData getData() {
        return this._data;
    }

    /**
     * Sets the data to interpolate in.
     * @param data Data.
     * @throws NullPointerException Data not properly specified.
     */
    public final void setData(final TypeOfData data) {
        if (data == null)
            throw new NullPointerException("Data not properly specified.");
        this._data = data;
    }
}
