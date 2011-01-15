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
    private final int _firstRow;
    private final int _firstColumn;

    /**
     * Creates a new instance of a matrix with the specified first row and column.
     * @param firstRow    First row of this matrix.
     * @param firstColumn First column of this matrix.
     */
    protected MatrixBase(final int firstRow, final int firstColumn) {
        this._firstRow = firstRow;
        this._firstColumn = firstColumn;
    }

    @Override
    public final void addScaledColumn(final int columnToAddTo, final int columnToAdd,
            final TypeOfValue scalar) {
        this.addToColumn(columnToAddTo, this.getColumn(columnToAdd).scale(scalar));
    }

    @Override
    public final void addScaledRow(final int rowToAddTo, final int rowToAdd,
            final TypeOfValue scalar) {
        this.addToRow(rowToAddTo, this.getRow(rowToAdd).scale(scalar));
    }

    @Override
    public final void switchColumns(final int column1, final int column2) {
        Vector<TypeOfValue> temp = this.getColumn(column1);
        int start = this.getFirstRow();
        int end = this.getLastRow();
        for (int r = start; r <= end; r++) {
            this.setValue(r, column1, this.getValue(r, column2));
            this.setValue(r, column2, temp.getValue(r));
        }
    }

    @Override
    public final void switchRows(final int row1, final int row2) {
        Vector<TypeOfValue> temp = this.getRow(row1);
        int start = this.getFirstColumn();
        int end = this.getLastColumn();
        for (int c = start; c <= end; c++) {
            this.setValue(row1, c, this.getValue(row2, c));
            this.setValue(row2, c, temp.getValue(c));
        }
    }

    @Override
    public final int getFirstColumn() {
        return this._firstColumn;
    }

    @Override
    public final int getFirstRow() {
        return this._firstRow;
    }

    @Override
    public final int getLastColumn() {
        return this.getFirstColumn() + this.getColumns() - 1;
    }

    @Override
    public final int getLastRow() {
        return this.getFirstRow() + this.getRows() - 1;
    }

    @Override
    public final boolean hasSameColumns(Vector<TypeOfValue> column) {
        return this.getFirstColumn() == column.getFirstDimension() &&
                this.getColumns() == column.getDimensions();
    }

    @Override
    public final boolean hasSameColumns(Matrix<TypeOfValue> matrix) {
        return this.getFirstColumn() == matrix.getFirstColumn() &&
                this.getColumns() == matrix.getColumns();
    }

    @Override
    public final boolean hasSameDimensions(Matrix<TypeOfValue> matrix) {
        return this.hasSameColumns(matrix) &&
                this.hasSameRows(matrix);
    }

    @Override
    public final boolean hasSameRows(Vector<TypeOfValue> row) {
        return this.getFirstRow() == row.getFirstDimension() &&
                this.getRows() == row.getDimensions();
    }

    @Override
    public final  boolean hasSameRows(Matrix<TypeOfValue> matrix) {
        return this.getFirstRow() == matrix.getFirstRow() &&
                this.getRows() == matrix.getRows();
    }

    @Override
    public final boolean isSquare() {
        return this.getColumns() == this.getRows();
    }

    @Override
    public final void setColumn(final int column, final Vector<TypeOfValue> values) {
        if (!this.hasSameRows(values))
            throw new IllegalArgumentException("The vector does not have the " +
                    "same dimensions as the rows of this matrix.");
        int start = this.getFirstRow();
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, column, values.getValue(r));
    }

    @Override
    public final void setRow(final int row, final Vector<TypeOfValue> values) {
        if (!this.hasSameColumns(values))
            throw new IllegalArgumentException("The vector does not have the " +
                    "same dimensions as the columns of this matrix.");
        int start = this.getFirstColumn();
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(row, c, values.getValue(c));
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == null)
            equals = false;
        else if (obj instanceof Matrix)
            equals = this._equals((Matrix)obj);
        else
            equals = false;
        return equals;
    }

    private boolean _equals(Matrix<TypeOfValue> matrix) {
        boolean equals = this.hasSameDimensions(matrix);
        for (int col = this.getFirstColumn(); equals && col <= this.getLastColumn(); col++) {
            for (int row = this.getFirstRow(); equals && row <= this.getLastRow(); row++) {
                equals &= this.getValue(row, col).equals(matrix.getValue(row, col));
            }
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder to = new StringBuilder("{" + this.getClass().getName() +
                " Rows: " + Integer.toString(this.getFirstRow()) + "-" +
                Integer.toString(this.getLastRow()) + " Columns: " +
                Integer.toString(this.getFirstColumn()) + "-" +
                Integer.toString(this.getLastColumn()) +
                " [[");
        for (int row = this.getFirstRow(); row <= this.getLastRow(); row++) {
            for (int col = this.getFirstColumn(); col <= this.getLastColumn(); col++) {
                to.append(this.getValue(row, col).toString());
                if (col != this.getLastColumn())
                    to.append("; ");
            }
            if (row != this.getLastRow())
                to.append("]; [");
        }
        to.append("]]}");
        return to.toString();
    }
}