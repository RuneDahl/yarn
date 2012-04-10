/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Vector.*;
import Validation.*;

/**
 * Implementation of a {@see Matrix finite-dimensional matrix} of
 * {@see Double real} numbers. MatrixReal is implemented with
 * <a href="http://en.wikipedia.org/wiki/Mutable_object">mutable</a> values
 * but immutable dimensions.
 * @author Rune Dahl Iversen
 */
public final class MatrixReal extends MatrixBase<Double> {
    private final static Validator<Double> __valueValidator = Factory.FiniteReal();
    private final static Validator<Integer> __dimensionValidator = Factory.PositiveInteger();
    private double[][] _values; // 2-dimensional array of values: [rows][columns].

    /**
     * Creates a real matrix with the specified rows and columns.
     * The matrix will be initialized with the value 0.0 in all values.
     * @param rows    Number of rows of this matrix.
     * @param columns Number of columns of this matrix.
     */
    public MatrixReal(final int rows, final int columns) {
        this(0, rows, 0, columns);
    }

    /**
     * Creates a real matrix with the specified dimensions
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
     * Creates a real matrix with the specified rows and columns and the
     * specified value.
     * @param rows    Number of rows of this matrix.
     * @param columns Number of columns of this matrix.
     * @param value   Value.
     */
    public MatrixReal(final int rows, final int columns, final double value) {
        this(0, rows, 0, columns, value);
    }

    /**
     * Creates a real matrix with the specified dimensions
     * (firstRow, rows, firstColumn and columns) and value.
     * @param firstRow    First row of this matrix.
     * @param rows        Number of rows of this matrix.
     * @param firstColumn First column of this matrix.
     * @param columns     Number of columns of this matrix.
     * @param value       Value.
     */
    public MatrixReal(final int firstRow, final int rows,
            final int firstColumn, final int columns, final double value) {
        super(firstRow, firstColumn);
        double[][] values = new double[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                values[r][c] = value;
        this._setValues(rows, columns, values);
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
        super(firstRow, firstColumn);
        int columns = (values.length == 0 ? 0 : values[0].length);
        this._setValues(values.length, columns, values);
    }

    @Override
    public Matrix<Double> addColumn(final Vector<Double> column) {
        if (!this.hasSameRows(column))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the rows of this matrix.");
        Matrix<Double> matrix = new MatrixReal(this.getFirstRow(), this.getRows(),
                this.getFirstColumn(), this.getColumns() + 1);
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

    @Override
    public Matrix<Double> addRow(final Vector<Double> row) {
        if (!this.hasSameColumns(row))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the columns of this matrix.");
        Matrix<Double> matrix = new MatrixReal(this.getFirstRow(), this.getRows() + 1,
                this.getFirstColumn(), this.getColumns());
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

    @Override
    public void addToColumn(final int column, final Vector<Double> vector) {
        if (!this.hasSameRows(vector))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the rows of this matrix.");
        int start = this.getFirstRow();
        int end = start + this.getRows();
        for (int r = start; r < end; r++)
            this.setValue(r, column, this.getValue(r, column) + vector.getValue(r));
    }

    @Override
    public void addToRow(final int row, final Vector<Double> vector) {
        if (!this.hasSameColumns(vector))
            throw new IllegalArgumentException("The dimensions of the vecor " +
                    "does not match the columns of this matrix.");
        int start = this.getFirstColumn();
        int end = start + this.getColumns();
        for (int c = start; c < end; c++)
            this.setValue(row, c, this.getValue(row, c) + vector.getValue(c));
    }

    @Override
    public Object clone() {
        return new MatrixReal(this.getFirstRow(), this.getFirstColumn(), this._values);
    }

    @Override
    public Matrix<Double> join(final Matrix<Double> matrix) {
        if (!this.hasSameRows(matrix))
            throw new IllegalArgumentException("The matrix does not have " +
                    "the same rows as this matrix.");
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC1 = this.getFirstColumn();
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

    @Override
    public Matrix<Double> removeColumn(final int column) {
        if (this.getColumns() == 1)
            throw new NullPointerException("No matrix left after removal " +
                    "of the specified column.");
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
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

    @Override
    public Matrix<Double> removeRow(final int row) {
        if (this.getRows() == 1)
            throw new NullPointerException("No matrix left after removal " +
                    "of the specified row.");
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
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

    @Override
    public Matrix<Double> stack(final Matrix<Double> matrix) {
        if (!this.hasSameColumns(matrix))
            throw new IllegalArgumentException("The matrix does not have " +
                    "the same columns as this matrix.");
        int startR1 = this.getFirstRow();
        int endR1 = startR1 + this.getRows();
        int startR2 = matrix.getFirstRow();
        int endR2 = startR2 + matrix.getRows();
        int startC = this.getFirstColumn();
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

    @Override
    public Double[][] toArray() {
        Double[][] array = new Double[this.getRows()][this.getColumns()];
        for (int r = 0; r < this.getRows(); r++)
            for (int c = 0; c < this.getColumns(); c++)
            {
                double v = this._values[r][c];
                array[r][c] = v;
            }
        return array;
    }

    @Override
    public Matrix<Double> transpose() {
        Matrix<Double> transpose = new MatrixReal(this.getFirstColumn(),
                this.getColumns(), this.getFirstRow(), this.getRows());
        int startC = this.getFirstColumn();
        int endC = startC + getColumns();
        int startR = this.getFirstRow();
        int endR = startR + getRows();
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                transpose.setValue(c, r, this.getValue(r, c));
        return transpose;
    }

    @Override
    public Vector<Double> getColumn(final int column) {
        Vector<Double> c = new VectorReal(this.getFirstRow(), this.getRows());
        int start = c.getFirstDimension();
        int end = start + c.getDimensions();
        for (int r = start; r < end; r++)
            c = c.setValue(r, this.getValue(r, column));
        return c;
    }

    @Override
    public int getColumns() {
        return this._values[0].length;
    }

    @Override
    public Vector<Double> getRow(final int row) {
        Vector<Double> r = new VectorReal(this.getFirstColumn(), this.getColumns());
        int start = r.getFirstDimension();
        int end = start + r.getDimensions();
        for (int c = start; c < end; c++)
            r = r.setValue(c, this.getValue(row, c));
        return r;
    }

    @Override
    public int getRows() {
        return this._values.length;
    }

    @Override
    public Double getValue(final int row, final int column) {
        return this._values[row - this.getFirstRow()][column - this.getFirstColumn()];
    }

    @Override
    public void setValue(final int row, final int column, final Double value) {
        if (!__valueValidator.isValid(value))
            throw new IllegalArgumentException(
                    __valueValidator.message(value, "Value(" +
                    Integer.toString(row) + ";" + Integer.toString(column) + ")"));
        this._values[row - this.getFirstRow()][column - this.getFirstColumn()] = value;
    }

    @Override
    public Matrix<Double> sum(final Matrix<Double> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The matrix does not have the " +
                    "same dimensions as this matrix.");
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        Matrix<Double> sum = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns());
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                sum.setValue(r, c, this.getValue(r, c) + value.getValue(r, c));
        return sum;
    }

    @Override
    public Vector<Double> product(final Vector<Double> factor) {
        if (!this.hasSameColumns(factor))
            throw new IllegalArgumentException("The dimensions of the vector " +
                    "does not match the columns of this matrix.");
        Vector<Double> product = new VectorReal(this.getFirstRow(), this.getRows());
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        for (int r = startR; r < endR; r++) {
            double v = 0.0;
            for (int c = startC; c  < endC; c++)
                v += this.getValue(r, c) * factor.getValue(c);
            product = product.setValue(r, v);
        }
        return product;
    }

    @Override
    public Matrix<Double> scale(final Double scalar) {
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        Matrix<Double> scale = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns());
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                scale.setValue(r, c, this.getValue(r, c) * scalar);
        return scale;
    }

    @Override
    public Matrix<Double> subtract(final Matrix<Double> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The matrix does not have the " +
                    "same dimensions as this matrix.");
        int startR = this.getFirstRow();
        int endR = startR + this.getRows();
        int startC = this.getFirstColumn();
        int endC = startC + this.getColumns();
        Matrix<Double> difference = new MatrixReal(startR, this.getRows(),
                startC, this.getColumns());
        for (int r = startR; r < endR; r++)
            for (int c = startC; c < endC; c++)
                difference.setValue(r, c,
                        this.getValue(r, c) - value.getValue(r, c));
        return difference;
    }

    /**
     * Sets all the values of this matrix to the values specified in the array.
     * <br> The values are validated. Any invalid values causes an IllegalArgumentException.
     * @param rows    Number of rows.
     * @param columns Number of columns.
     * @param values  Array of values. This is assumed to be indexed starting from 0.
     * @throws IllegalArgumentException The value of row r and column c ...
     */
    private void _setValues(final int rows, final int columns, final double[][] values)
            throws IllegalArgumentException {
        if (!__dimensionValidator.isValid(rows))
            throw new ArrayIndexOutOfBoundsException("Number of rows must be positive.");
        if (!__dimensionValidator.isValid(columns))
            throw new ArrayIndexOutOfBoundsException("Number of columns must be positive.");
        int fRow = this.getFirstRow();
        int fColumn = this.getFirstColumn();
        this._values = new double[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                this.setValue(r + fRow, c + fColumn, values[r][c]);
    }

    /**
     * Returns the <a href="http://en.wikipedia.org/wiki/Identity_matrix">
     * identity</a> {@see MatrixReal matrix} of {@see Double real} values
     * with the specified first dimension and number of dimensions.
     * @param firstDimension Dimension of the first row/column.
     * @param dimensions     Number of dimensions. (Size of matrix.)
     * @return               The identity matrix.
     */
    public static MatrixReal Identity(
            final int firstDimension, final int dimensions) {
        MatrixReal identity = Zero(firstDimension, dimensions, firstDimension, dimensions);
        for (int dim = 0; dim < dimensions; dim++)
            identity.setValue(dim + firstDimension, dim + firstDimension, 1.0);
        return identity;
    }

    /**
     * Returns a {@see MatrixReal matrix} of {@see Double real} values
     * with the specified dimensions and the value of each element
     * set to the specified value.
     * @param firstRow    Dimension of the first row.
     * @param rows        Number of rows.
     * @param firstColumn Dimension of the first column.
     * @param columns     Number of columns.
     * @param value       Value.
     * @return            Matrix.
     */
    public static MatrixReal Value(final int firstRow, final int rows,
            final int firstColumn, final int columns, final Double value) {
        return new MatrixReal(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Returns a {@see MatrixReal matrix} of {@see Double real}
     * zeroes with the specified dimensions.
     * @param firstRow    Dimension of the first row.
     * @param rows        Number of rows.
     * @param firstColumn Dimension of the first column.
     * @param columns     Number of columns.
     * @return            Matrix.
     */    public static MatrixReal Zero(final int firstRow, final int rows,
            final int firstColumn, final int columns) {
        return Value(firstRow, rows, firstColumn, columns, 0.0);
    }
}
