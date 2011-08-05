/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Matrix.Matrix;

/**
 * Implementation of a {@see Mathematics.Command command} that switches
 * the values of two specified columns in a {@see Matrix matrix}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value in the matrix.
 */
public final class SwitchColumns<TypeOfValue>
        extends Columns<TypeOfValue> {

    /**
     * Creates an instance of a column switching command
     * with the specified column indices.
     * @param firstColumn  Index of the first column.
     * @param secondColumn Index of the second column.
     */
    public SwitchColumns(final int firstColumn, final int secondColumn) {
        super(firstColumn, secondColumn);
    }

    @Override
    public Matrix<TypeOfValue> applyTo(Matrix<TypeOfValue> matrix) {
        int fColumn = this.getFirstColumn();
        int sColumn = this.getSecondColumn();
        if (fColumn == sColumn)
            return matrix;
        for (int r = matrix.getFirstRow(); r <= matrix.getLastRow(); r++) {
            TypeOfValue temp = matrix.getValue(r, fColumn);
            matrix.setValue(r, fColumn, matrix.getValue(r, sColumn));
            matrix.setValue(r, sColumn, temp);
        }
        return matrix;
    }
}
