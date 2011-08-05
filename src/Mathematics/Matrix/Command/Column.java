/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Command;
import Mathematics.Matrix.Matrix;

/**
 * Abstract implementation of a {@see Command command}
 * that applies to a single column in a {@see Matrix matrix}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value in the matrix.
 */
public abstract class Column<TypeOfValue>
        implements Command<Matrix<TypeOfValue>> {
    private int _column;

    /**
     * Creates an instance of a column command with the specified column index.
     * @param column Column index.
     */
    protected Column(final int column) {
        this.setColumn(column);
    }

    /**
     * Sets the column index to the specified value.
     * @param column Column index.
     */
    public final void setColumn(final int column) {
        this._column = column;
    }

    /**
     * Gets the column index.
     * @return Column index.
     */
    public final int getColumn() {
        return this._column;
    }
}
