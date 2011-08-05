/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Matrix.Matrix;

/**
 * Implementation of a {@see Mathematics.Command command} that switches
 * the values of two specified rows in a {@see Matrix matrix}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value in the matrix.
 */
public final class SwitchRows<TypeOfValue>
        extends Rows<TypeOfValue> {

    /**
     * Creates an instance of a row switching command
     * with the specified row indices.
     * @param firstRow  Index of the first row.
     * @param secondRow Index of the second row.
     */
    public SwitchRows(final int firstRow, final int secondRow) {
        super(firstRow, secondRow);
    }

    @Override
    public Matrix<TypeOfValue> applyTo(Matrix<TypeOfValue> matrix) {
        int fRow = this.getFirstRow();
        int sRow = this.getSecondRow();
        if (fRow == sRow)
            return matrix;
        for (int c = matrix.getFirstColumn(); c <= matrix.getLastColumn(); c++) {
            TypeOfValue temp = matrix.getValue(fRow, c);
            matrix.setValue(fRow, c, matrix.getValue(sRow, c));
            matrix.setValue(sRow, c, temp);
        }
        return matrix;
    }
}
