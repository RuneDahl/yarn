/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Vector.Vector;

/**
 * Abstract class implementing some of the properties and methods of a
 * {@see Matrix}.<br>
 * The idea is to provide an abstract class to base new classes of matrices
 * on that require less implementation than the full interface.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class MatrixBase<TypeOfValue> implements Matrix<TypeOfValue> {
    /**
     * Creates a new instance of a matrix.
     */
    protected MatrixBase() { // Intentional
    }

    public final void SwitchColumns(final int column1, final int column2) {
        Vector<TypeOfValue> temp = this.getColumn(column1);
        int start = this.getFirstRow();
        int end = this.getLastRow();
        for (int r = start; r <= end; r++) {
            this.setValue(r, column1, this.getValue(r, column2));
            this.setValue(r, column2, temp.getValue(r));
        }
    }

    public final void SwitchRows(final int row1, final int row2) {
        Vector<TypeOfValue> temp = this.getRow(row1);
        int start = this.getFirstColumn();
        int end = this.getLastColumn();
        for (int c = start; c <= end; c++) {
            this.setValue(row1, c, this.getValue(row2, c));
            this.setValue(row2, c, temp.getValue(c));
        }
    }

    public final int getLastColumn() {
        return this.getFirstColumn() + this.getColumns() - 1;
    }

    public final int getLastRow() {
        return this.getFirstRow() + this.getRows() - 1;
    }

    public final boolean hasSameColumns(Vector<TypeOfValue> column) {
        return this.getFirstColumn() == column.getFirstDimension() &&
                this.getColumns() == column.getDimensions();
    }

    public final boolean hasSameColumns(Matrix<TypeOfValue> matrix) {
        return this.getFirstColumn() == matrix.getFirstColumn() &&
                this.getColumns() == matrix.getColumns();
    }

    public final boolean hasSameDimensions(Matrix<TypeOfValue> matrix) {
        return this.hasSameColumns(matrix) &&
                this.hasSameRows(matrix);
    }

    public final boolean hasSameRows(Vector<TypeOfValue> row) {
        return this.getFirstRow() == row.getFirstDimension() &&
                this.getRows() == row.getDimensions();
    }

    public final  boolean hasSameRows(Matrix<TypeOfValue> matrix) {
        return this.getFirstRow() == matrix.getFirstRow() &&
                this.getRows() == matrix.getRows();
    }

    public final boolean isSquare() {
        return this.getColumns() == this.getRows();
    }

    public final void setColumn(final int column, final Vector<TypeOfValue> values) {
        if (!this.hasSameRows(values))
            throw new IllegalArgumentException("The vector does not have the " +
                    "same dimensions as the rows of this matrix.");
        int start = this.getFirstRow();
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, column, values.getValue(r));
    }

    public final void setRow(final int row, final Vector<TypeOfValue> values) {
        if (!this.hasSameColumns(values))
            throw new IllegalArgumentException("The vector does not have the " +
                    "same dimensions as the columns of this matrix.");
        int start = this.getFirstColumn();
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(row, c, values.getValue(c));
    }
}