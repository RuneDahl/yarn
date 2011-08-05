/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Command;
import Mathematics.Matrix.Matrix;

/**
 * Abstract implementation of a {@see Command command}
 * that applies to two rows in a {@see Matrix matrix}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value in the matrix.
 */
public abstract class Rows<TypeOfValue>
        implements Command<Matrix<TypeOfValue>> {
    private int _firstRow;
    private int _secondRow;

    /**
     * Creates an instance of a rows command with the specified row indices.
     * @param firstRow  Index of the first row.
     * @param secondRow Index of the second row.
     */
    protected Rows(final int firstRow, final int secondRow) {
        this.setFirstRow(firstRow);
        this.setSecondRow(secondRow);
    }

    /**
     * Gets the index of the first row.
     * @return Index of the first row.
     */
    public final int getFirstRow() {
        return _firstRow;
    }

    /**
     * Sets the index of the first row to the specified value.
     * @param firstRow Index of the first row.
     */
    public final void setFirstRow(final int firstRow) {
        this._firstRow = firstRow;
    }

    /**
     * Gets the index of the second fow.
     * @return Index of the second row.
     */
    public final int getSecondRow() {
        return _secondRow;
    }

    /**
     * Sets the index of the second row to the specified value.
     * @param secondRow Index of the second row.
     */
    public final void setSecondRow(final int secondRow) {
        this._secondRow = secondRow;
    }
}
