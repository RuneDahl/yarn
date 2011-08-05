/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Command;
import Mathematics.Matrix.Matrix;

/**
 * Abstract implementation of a {@see Command command}
 * that applies to a single row in a {@see Matrix matrix}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class Row<TypeOfValue>
        implements Command<Matrix<TypeOfValue>> {
    private int _row;

    /**
     * Creates an instance of a row based command with the specified row index.
     * @param row Row index.
     */
    protected Row(final int row) {
        this.setRow(row);
    }

    /**
     * Gets the row index.
     * @return Row index.
     */
    public final int getRow() {
        return this._row;
    }

    /**
     * Sets the row index.
     * @param row Row index.
     */
    public final void setRow(final int row) {
        this._row = row;
    }
}
