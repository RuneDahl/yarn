/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Vector.*;
import Validation.*;

/**
 * Implementation of a {@see Matrix finite-dimensional matrix} of real numbers
 * (doubles). MatrixReal is implemented with
 * <a href="http://en.wikipedia.org/wiki/Mutable_object">mutable</a> values
 * but immutable dimensions.
 * @author Rune Dahl Iversen
 */
public final class MatrixReal implements Matrix<Double> {
    private Validator<Double> _validator;
    private double[][] _values; //2-dimensional array of values:[rows][columns].
    private int _firstColumn;
    private int _firstRow;

    /**
     * Cerates a real matrix with the specified rows and columns.
     * The matrix will be initialized with the value 0.0 in all values.
     * @param rows    Number of rows of this matrix.
     * @param columns Number of columns of this matrix.
     */
    public MatrixReal(final int rows, final int columns) {
        this(0, rows, 0, columns);
    }

    /**
     * Cerates a real matrix with the specified dimensions
     * (firstRow, rows, firstColumn and columns).
     * The matrix will be initialized with the value 0.0 in all values.
     * @param firstRow    First row of this matrix.
     * @param rows        Number of rows of this matrix.
     * @param firstColumn First column of this matrix.
     * @param columns     Number of columns of this matrix.
     */
    public MatrixReal(final int firstRow, final int rows,
            final int firstColumn, final int columns) {
        this(firstRow, rows, firstColumn, columns, 0.0);
    }

    /**
    /**
     * Cerates a real matrix with the specified rows and columns and the
     * specified value.
     * @param rows    Number of rows of this matrix.
     * @param columns Number of columns of this matrix.
     * @param value   Value.
     */
    public MatrixReal(final int rows, final int columns, final double value) {
        this(0, rows, 0, columns, value);
    }

    /**
    /**
     * Cerates a real matrix with the specified dimensions
     * (firstRow, rows, firstColumn and columns) and value.
     * @param firstRow    First row of this matrix.
     * @param rows        Number of rows of this matrix.
     * @param firstColumn First column of this matrix.
     * @param columns     Number of columns of this matrix.
     * @param value       Value.
     */
    public MatrixReal(final int firstRow, final int rows,
            final int firstColumn, final int columns, final double value) {
        this._validator = this._setValidator();
        this._firstColumn = firstColumn;
        this._firstRow = firstRow;
        double[][] values = new double[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                values[r][c] = value;
        this._setValues(values);
    }

    /**
     * Creates a matrix with the specified
     * zero-based 2-dimensional array of values.
     * @param values Zero-based 2-dimensional array of values.
     */
    public MatrixReal(final double[][] values) {
        this(0, 0, values);
    }

    /**
     * Creates a matrix with the specified first row and first column and
     * zero-based 2-dimensional array of values.
     * @param firstRow    First row of this matrix.
     * @param firstColumn First column of this matrix.
     * @param values      Zero-based 2-dimensional array of values.
     */
    public MatrixReal(final int firstRow, final int firstColumn,
            final double[][] values) {
        this._validator = this._setValidator();
        this._firstColumn = firstColumn;
        this._firstRow = firstRow;
        this._setValues(values);
    }

    public Matrix<Double> AddColumn(final Vector<Double> column) {
        if (!this.hasSameRows(column))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the rows of this matrix.");
        Matrix<Double> matrix = new MatrixReal(this._firstRow, this.getRows(),
                this._firstColumn, this.getColumns() + 1);
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        for (int r = startR; r < endR; r++)
        {
            for (int c = startC; c < endC; c++)
                matrix.setValue(r, c, this.getValue(r, c));
            matrix.setValue(r, endC, column.getValue(r));
        }
        return matrix;
    }

    public Matrix<Double> AddRow(final Vector<Double> row) {
        if (!this.hasSameColumns(row))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the columns of this matrix.");
        Matrix<Double> matrix = new MatrixReal(this._firstRow, this.getRows() + 1,
                this._firstColumn, this.getColumns());
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        for (int c = startC; c < endC; c++)
        {
            for (int r = startR; r < endR; r++)
                matrix.setValue(r, c, this.getValue(r, c));
            matrix.setValue(endR, c, row.getValue(c));
        }
        return matrix;
    }

    public void AddScaledCloumn(final int columnToAddTo, final int columnToAdd,
            final Double scalar) {
        int start = this.getFirstRow();
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, columnToAddTo, this.getValue(r, columnToAdd) * scalar);
    }

    public void AddScaledRow(final int rowToAddTo, final int rowToAdd,
            final Double scalar) {
        int start = this.getFirstColumn();
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(rowToAddTo, c, this.getValue(rowToAdd, c) * scalar);
    }

    public void AddToColumn(final int column, final Vector<Double> vector) {
        if (!this.hasSameRows(vector))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the rows of this matrix.");
        int start = this.getFirstRow();
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, column, vector.getValue(r));
    }

    public void AddToRow(final int row, final Vector<Double> vector) {
        if (!this.hasSameColumns(vector))
            throw new IllegalArgumentException("The dimensions of the vecor " +
                    "does not match the columns of this matrix.");
        int start = this.getFirstColumn();
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(row, c, vector.getValue(c));
    }

    public Matrix<Double> Join(final Matrix<Double> matrix) {
        if (!this.hasSameRows(matrix))
            throw new IllegalArgumentException("The matrix does not have " +
                    "the same rows as this matrix.");
        int startR = this._firstRow;
        int endR = startR + this.getRows();
        int startC1 = this._firstColumn;
        int endC1 = startC1 + this.getColumns();
        int startC2 = matrix.getFirstColumn();
        int endC2 = startC2 + matrix.getColumns();

        Matrix<Double> join = new MatrixReal(startR, this.getRows(),
                startC1, this.getColumns() + matrix.getColumns());
        for (int r = startR; r < endR; r++) {
            for (int c = startC1; c < endC1; c++)
                join.setValue(r, c, this.getValue(r, c));
            for (int c = startC2; c < endC2; c++)
                join.setValue(r, c - startC2 + endC1, matrix.getValue(r, c));
        }
        return join;
    }

    public Matrix<Double> RemoveColumn(final int column) {
        if (this.getColumns() == 1)
            throw new NullPointerException("No matrix left after removal " +
                    "of the specified column.");
        int startR = this._firstRow;
        int endR = startR + this.getRows();
        int startC = this._firstColumn;
        int endC = startC + this.getColumns();
        Matrix<Double> matrix = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns() - 1);
        for (int r = startR; r < endR; r++) {
            for (int c = startC; c < column; c++)
                matrix.setValue(r, c, this.getValue(r, c));
            for (int c = column + 1; c < endC; c++)
                matrix.setValue(r, c - 1, this.getValue(r, c));
        }
        return matrix;
    }

    public Matrix<Double> RemoveRow(final int row) {
        if (this.getRows() == 1)
            throw new NullPointerException("No matrix left after removal " +
                    "of the specified row.");
        int startR = this._firstRow;
        int endR = startR + this.getRows();
        int startC = this._firstColumn;
        int endC = startC + this.getColumns();
        Matrix<Double> matrix = new MatrixReal(startR, this.getRows() - 1,
                startC, this.getColumns());
        for (int c = startC; c < endC; c++) {
            for (int r = startR; r < row; r++)
                matrix.setValue(r, c, this.getValue(r, c));
            for (int r = row + 1; r < endR; r++)
                matrix.setValue(r - 1, c, this.getValue(r, c));
        }
        return matrix;
    }

    public void ScaleColumn(final int column, final Double scalar) {
        int start = this.getFirstRow();
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, column, this.getValue(r, column) * scalar);
    }

    public void ScaleRow(final int row, final Double scalar) {
        int start = this.getFirstColumn();
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(row, c, this.getValue(row, c) * scalar);
    }

    public Matrix<Double> Stack(final Matrix<Double> matrix) {
        if (!this.hasSameColumns(matrix))
            throw new IllegalArgumentException("The matrix does not have " +
                    "the same columns as this matrix.");
        int startR1 = this._firstRow;
        int endR1 = startR1 + this.getRows();
        int startR2 = matrix.getFirstRow();
        int endR2 = startR2 + matrix.getRows();
        int startC = this._firstColumn;
        int endC = startC + this.getColumns();

        Matrix<Double> stack = new MatrixReal(startR1,
                this.getRows() + matrix.getRows(), startC, this.getColumns());
        for (int c = startC; c < endC; c++) {
            for (int r = startR1; r < endR1; r++)
                stack.setValue(r, c, this.getValue(r, c));
            for (int r = startR2; r < endR2; r++)
                stack.setValue(r - startR2 + endR1, c, matrix.getValue(r, c));
        }
        return stack;
    }

    public void SwitchColumns(final int column1, final int column2) {
        Vector<Double> temp = this.getColumn(column1);
        int start = this._firstRow;
        int end = start + this.getRows();
        for (int r = start; r < end; r++) {
            this.setValue(r, column1, this.getValue(r, column2));
            this.setValue(r, column2, temp.getValue(r));
        }
    }

    public void SwitchRows(final int row1, final int row2) {
        Vector<Double> temp = this.getRow(row1);
        int start = this._firstColumn;
        int end = start + this.getColumns();
        for (int c = start; c < end; c++) {
            this.setValue(row1, c, this.getValue(row2, c));
            this.setValue(row2, c, temp.getValue(c));
        }
    }

    public Double[][] ToArray() {
        Double[][] array = new Double[this.getRows()][this.getColumns()];
        for (int r = 0; r < this.getRows(); r++)
            for (int c = 0; c < this.getColumns(); c++)
            {
                double v = this._values[r][c];
                array[r][c] = v;
            }
        return array;
    }

    public Matrix<Double> Transpose() {
        Matrix<Double> transpose = new MatrixReal(this._firstColumn,
                this.getColumns(), this._firstRow, this.getRows());
        int startC = this._firstColumn;
        int endC = startC + getColumns();
        int startR = this._firstRow;
        int endR = startR + getRows();
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                transpose.setValue(c, r, this.getValue(r, c));
        return transpose;
    }

    public Vector<Double> getColumn(final int column) {
        Vector<Double> c = new VectorReal(this._firstRow, this.getRows());
        int start = c.getFirstDimension();
        int end = start + c.getDimensions();
        for (int r = start; r < end; r++)
            c.setValue(r, this.getValue(r, column));
        return c;
    }

    public int getColumns() {
        return this._values[0].length;
    }

    public int getFirstColumn() {
        return this._firstColumn;
    }

    public int getFirstRow() {
        return this._firstRow;
    }

    public Vector<Double> getRow(final int row) {
        Vector<Double> r = new VectorReal(this._firstColumn, this.getColumns());
        int start = r.getFirstDimension();
        int end = start + r.getDimensions();
        for (int c = start; c < end; c++)
            r.setValue(c, this.getValue(row, c));
        return r;
    }

    public int getRows() {
        return this._values.length;
    }

    public Double getValue(final int row, final int column) {
        return this._values[row - this._firstRow][column - this._firstColumn];
    }

    public boolean hasSameColumns(Vector<Double> column) {
        return this.getFirstColumn() == column.getFirstDimension() &&
                this.getColumns() == column.getDimensions();
    }

    public boolean hasSameColumns(Matrix<Double> matrix) {
        return this.getFirstColumn() == matrix.getFirstColumn() &&
                this.getColumns() == matrix.getColumns();
    }

    public boolean hasSameDimensions(Matrix<Double> matrix) {
        return this.hasSameColumns(matrix) &&
                this.hasSameRows(matrix);
    }

    public boolean hasSameRows(Vector<Double> row) {
        return this.getFirstRow() == row.getFirstDimension() &&
                this.getRows() == row.getDimensions();
    }

    public boolean hasSameRows(Matrix<Double> matrix) {
        return this.getFirstRow() == matrix.getFirstRow() &&
                this.getRows() == matrix.getRows();
    }

    public boolean isSquare() {
        return this.getColumns() == this.getRows();
    }

    public void setColumn(final int column, final Vector<Double> values) {
        if (!this.hasSameRows(values))
            throw new IllegalArgumentException("The vector does not have the " +
                    "same dimensions as the rows of this matrix.");
        int start = this._firstRow;
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, column, values.getValue(r));
    }

    public void setRow(final int row, final Vector<Double> values) {
        if (!this.hasSameColumns(values))
            throw new IllegalArgumentException("The vector does not have the " +
                    "same dimensions as the columns of this matrix.");
        int start = this._firstColumn;
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(row, c, values.getValue(c));
    }

    public void setValue(final int row, final int column, final Double value) {
        if (!this._validator.isValid(value))
            throw new IllegalArgumentException(
                    this._validator.Message(value, "Value"));
        this._values[row - this._firstRow][column - this._firstColumn] = value;
    }

    public Matrix<Double> Add(final Matrix<Double> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The matrix does not the same " +
                    "dimensions as this matrix.");
        int startR = this._firstRow;
        int endR = startR + this.getRows();
        int startC = this._firstColumn;
        int endC = startC + this.getColumns();
        Matrix<Double> sum = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns());
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                sum.setValue(r, c, this.getValue(r, c) + value.getValue(r, c));
        return sum;
    }

    public Vector<Double> Multiply(final Vector<Double> factor) {
        if (!this.hasSameColumns(factor))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the columns of this matrix.");
        Vector<Double> product = new VectorReal(this._firstRow, this.getRows());
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        for (int r = startR; r < endR; r++) {
            double v = 0.0;
            for (int c = startC; c  < endC; c++)
                v += this.getValue(r, c) * factor.getValue(c);
            product.setValue(r, v);
        }
        return product;
    }

    public Matrix<Double> Scale(final Double scalar) {
        int startR = this._firstRow;
        int endR = startR + this.getRows();
        int startC = this._firstColumn;
        int endC = startC + this.getColumns();
        Matrix<Double> scale = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns());
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                scale.setValue(r, c, this.getValue(r, c) * scalar);
        return scale;
    }

    public Matrix<Double> Subtract(final Matrix<Double> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The matrix does not the same " +
                    "dimensions as this matrix.");
        int startR = this._firstRow;
        int endR = startR + this.getRows();
        int startC = this._firstColumn;
        int endC = startC + this.getColumns();
        Matrix<Double> difference = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns());
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                difference.setValue(r, c,
                        this.getValue(r, c) - value.getValue(r, c));
        return difference;
    }

    private Validator<Double> _setValidator() {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        return validator;
    }

    private void _setValues(final double[][] values) {
        int rows = values.length;
        int columns = values[0].length;
        this._values = new double[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
            {
                if (this._validator.isValid(values[r][c]))
                    this._values[r][c] = values[r][c];
                else
                    throw new IllegalArgumentException(
                            this._validator.Message(values[r][c],
                            "The value of row " + Integer.toString(r) +
                            " and column " + Integer.toString(c)));
            }
    }
}