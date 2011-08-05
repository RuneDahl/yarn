/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Command;
import Mathematics.Matrix.Matrix;

/**
 * Abstract implementation of a {@see Command command}
 * that applies to two columns in a {@see Matrix matrix}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value in the matrix.
 */
public abstract class Columns<TypeOfValue>
        implements Command<Matrix<TypeOfValue>> {
    private int _firstColumn;
    private int _secondColumn;

    /**
     * Creates an instance of a columns command with the specified column indices.
     * @param firstColumn  Index of the first column.
     * @param secondColumn Index of the second column.
     */
    protected Columns(final int firstColumn, final int secondColumn) {
        this.setFirstColumn(firstColumn);
        this.setSecondColumn(secondColumn);
    }

    /**
     * Gets the index of the first column.
     * @return Index of the first column.
     */
    public final int getFirstColumn() {
        return _firstColumn;
    }

    /**
     * Sets the index of the first column to the specified value.
     * @param firstColumn Index of the first column.
     */
    public final void setFirstColumn(final int firstColumn) {
        this._firstColumn = firstColumn;
    }

    /**
     * Gets the index of the second column.
     * @return Index of the second column.
     */
    public final int getSecondColumn() {
        return _secondColumn;
    }

    /**
     * Sets the index of the second column to the specified value.
     * @param secondColumn Index of the second column.
     */
    public final void setSecondColumn(final int secondColumn) {
        this._secondColumn = secondColumn;
    }
}
