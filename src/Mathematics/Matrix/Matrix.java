/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.*;
import Mathematics.Vector.Vector;

/**
 * Interface declaring a finite dimensional
 * <a href="http://en.wikipedia.org/wiki/Matrix_%28mathematics%29">matrix</a>.
 * <br>- It is implicitly assumed that the type of scalar that can be applied
 * to the matrix is of the same type as the values of matrix.
 * <br>- It is suggested that any classes implementing Matrix be implemented
 * with <a href="http://en.wikipedia.org/wiki/Mutable_object">mutable</a>
 * values, but immutable dimensions.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Matrix<TypeOfValue>
        extends Additive<Matrix<TypeOfValue>>,
        Multiplicative<Vector<TypeOfValue>>,
        Scaleable<TypeOfValue, Matrix<TypeOfValue>>,
        Subtractable<Matrix<TypeOfValue>> {
    /**
     * Gets the values of the specified column as a vector.
     * @param column Column.
     * @return       Vector with the relevant values.
     */
    public Vector<TypeOfValue> getColumn(final int column);

    /**
     * Gets the number of columns of this matrix.
     * @return Number of columns.
     */
    public int getColumns();

    /**
     * Gets the index of the first dimension of the columns of this matrix.
     * @return The index of the first dimension of the columns of this matrix.
     */
    public int getFirstColumn();

    /**
     * Gets the index of the first dimension of the rows of this matrix.
     * @return The index of the first dimension of the rows of this matrix.
     */
    public int getFirstRow();

    /**
     * Gets the index of the last dimension of the columns of this matrix.
     * @return The index of the last dimension of the columns of this matrix.
     */
    public int getLastColumn();

    /**
     * Gets the index of the last dimension of the rows of this matrix.
     * @return The index of the last dimension of the rows of this matrix.
     */
    public int getLastRow();

    /**
     * Gets the values of the specified row as a vector.
     * @param row Row.
     * @return    Vector with the relevant values.
     */
    public Vector<TypeOfValue> getRow(final int row);

    /**
     * Gets the number of rows of this matrix.
     * @return Number of rows.
     */
    public int getRows();

    /**
     * Gets the value from this matrix with the
     * specified combination of row and column.
     * @param row    Row.
     * @param column Column.
     * @return       The value.
     */
    public TypeOfValue getValue(final int row, final int column);

    /**
     * Sets the values of the specified column to the vector of values.
     * @param column Column.
     * @param values Vector of values.
     */
    public void setColumn(final int column, final Vector<TypeOfValue> values);

    /**
     * Sets the values of the specified row to the vector of values.
     * @param row    Row.
     * @param values Vector of values.
     */
    public void setRow(final int row, final Vector<TypeOfValue> values);

    /**
     * Sets the value of the specified row and column to the desired value.
     * @param row    Row.
     * @param column Column.
     * @param value  Value.
     */
    public void setValue(final int row, final int column,
            final TypeOfValue value);

    /**
     * Returns a clone of this matrix with the values from the specified vector
     * added as the columns+1st column.
     * @param column Vector of values.
     * @return       A matrix composed of this matrix and the values from the vector.
     */
    public Matrix<TypeOfValue> addColumn(final Vector<TypeOfValue> column);

    /**
     * Returns a clone of this matrix with the values from the specified vector
     * added as the rows+1st row.
     * @param row Vector of values.
     * @return    A matrix composed of this matrix and the values from the vector.
     */
    public Matrix<TypeOfValue> addRow(final Vector<TypeOfValue> row);

    /**
     * Add the values of the specified vector to the column.
     * @param column Column.
     * @param vector Vector of values.
     */
    public void addToColumn(final int column, final Vector<TypeOfValue> vector);

    /**
     * Add the values of the specified vector to the row.
     * @param row    Row.
     * @param vector Vector of values.
     */
    public void addToRow(final int row, final Vector<TypeOfValue> vector);

    /**
     * Returns a clone of this matrix with the same dimensions and values.
     * @return Cloned matrix.
     */
    public Object clone();

    /**
     * Indicates whether the specified vector has the same dimensions
     * (getFirstDimension() and getDimensions()) as the columns
     * (getFirstColumn() and getColumns()) of this matrix.
     * @param column Vector.
     * @return       True for the same dimensions, else false.
     */
    public boolean hasSameColumns(final Vector<TypeOfValue> column);

    /**
     * Indicates whether the specified matrix has the same columns
     * (getFirstColumn() and getColumns()) as the columns
     * (getFirstColumn() and getColumns()) of this matrix.
     * @param matrix Matrix.
     * @return       True for the same columns, else false.
     */
    public boolean hasSameColumns(final Matrix<TypeOfValue> matrix);

    /**
     * Indicates whether the specified matrix has the same dimensions
     * (getFirstColumn(), getColumns(), getFirstRow() and getRows())
     * as this matrix.
     * @param matrix Matrix.
     * @return       True for the same dimensions, else false.
     */
    public boolean hasSameDimensions(final Matrix<TypeOfValue> matrix);

    /**
     * Indicates whether the specified vector has the same dimensions
     * (getFirstDimension() and getDimensions()) as the rows
     * (getFirstRow() and getRows()) of this matrix.
     * @param row Vector.
     * @return    True for the same dimensions, else false.
     */
    public boolean hasSameRows(final Vector<TypeOfValue> row);

    /**
     * Indicates whether the specified matrix has the same rows
     * (getFirstRow() and getRows()) as the rows
     * (getFirstRow() and getRows()) of this matrix.
     * @param matrix Matrix.
     * @return       True for the same rows, else false.
     */
    public boolean hasSameRows(final Matrix<TypeOfValue> matrix);

    /**
     * Returns whether the matrix is
     * <a href="http://en.wikipedia.org/wiki/Matrix_%28mathematics%29#Square_matrices">square</a>
     * , i.e. if the number of rows equal the number of columns.
     * @return True if the matrix is square, else false.
     */
    public boolean isSquare();

    /**
     * Returns a matrix consisting of this matrix joined
     * on the righthand side with the specified matrix.
     * @param matrix Matrix.
     * @return       Joined matrix.
     */
    public Matrix<TypeOfValue> join(final Matrix<TypeOfValue> matrix);

    /**
     * Returns a clone of this matrix with the specified column removed.
     * @param column Column to be removed.
     * @return       Clone of this matrix with the column removed.
     */
    public Matrix<TypeOfValue> removeColumn(final int column);

    /**
     * Returns a clone of this matrix with the specified row removed.
     * @param row Row to be removed.
     * @return    Clone of this matrix with the row removed.
     */
    public Matrix<TypeOfValue> removeRow(final int row);

    /**
     * Returns a matrix consisting of this matrix
     * stacked on top of the specified matrix.
     * @param matrix Matrix.
     * @return       Stacked matrix.
     */
    public Matrix<TypeOfValue> stack(final Matrix<TypeOfValue> matrix);

    /**
     * Returns the values of this matrix as a 2-dimensional zero-based array.
     * @return The values of this matrix.
     */
    public TypeOfValue[][] toArray();

    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Transpose">transpose</a>
     * of this matrix.
     * @return The transpose of this matrix.
     */
    public Matrix<TypeOfValue> transpose();
}
