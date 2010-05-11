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
        Scaleable<TypeOfValue, Matrix<TypeOfValue>> {
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
    public Matrix<TypeOfValue> AddColumn(final Vector<TypeOfValue> column);

    /**
     * Returns a clone of this matrix with the values from the specified vector
     * added as the rows+1st row.
     * @param column Vector of values.
     * @return       A matrix composed of this matrix and the values from the vector.
     */
    public Matrix<TypeOfValue> AddRow(final Vector<TypeOfValue> row);

    /**
     * Add the the specified scalar times one column to another column.
     * @param columnToAddTo Column to add the scaled column to.
     * @param columnToAdd   Column to scale and add.
     * @param scalar        Scalar.
     */
    public void AddScaledCloumn(final int columnToAddTo, final int columnToAdd,
            final TypeOfValue scalar);

    /**
     * Add the the specified scalar times one row to another row.
     * @param rowToAddTo Row to add the scaled row to.
     * @param rowToAdd   Row to scale and add.
     * @param scalar     Scalar.
     */
    public void AddScaledRow(final int rowToAddTo, final int rowToAdd,
            final TypeOfValue scalar);

    /**
     * Add the values of the specified vector to the column.
     * @param column Column.
     * @param vector Vector of values.
     */
    public void AddToColumn(final int column, final Vector<TypeOfValue> vector);

    /**
     * Add the values of the specified vector to the row.
     * @param row    Row.
     * @param vector Vector of values.
     */
    public void AddToRow(final int row, final Vector<TypeOfValue> vector);

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
    public Matrix<TypeOfValue> Join(final Matrix<TypeOfValue> matrix);

    /**
     * Returns a clone of this matrix with the specified column removed.
     * @param column Column to be removed.
     * @return       Clone of this matrix with the column removed.
     */
    public Matrix<TypeOfValue> RemoveColumn(final int column);

    /**
     * Returns a clone of this matrix with the specified row removed.
     * @param row Row to be removed.
     * @return    Clone of this matrix with the row removed.
     */
    public Matrix<TypeOfValue> RemoveRow(final int row);

    /**
     * Scale the values of the specified column by the scalar.
     * @param column Column.
     * @param scalar Scalar.
     */
    public void ScaleColumn(final int column, final TypeOfValue scalar);

    /**
     * Scale the values of the specified row by the scalar.
     * @param row    Row.
     * @param scalar Scalar.
     */
    public void ScaleRow(final int row, final TypeOfValue scalar);

    /**
     * Returns a matrix consisting of this matrix
     * stacked on top of the specified matrix.
     * @param matrix Matrix.
     * @return       Stacked matrix.
     */
    public Matrix<TypeOfValue> Stack(final Matrix<TypeOfValue> matrix);

    /**
     * Switch the values of the 2 specified columns.
     * @param column1 Column.
     * @param column2 Column.
     */
    public void SwitchColumns(final int column1, final int column2);

    /**
     * Switch the values of the 2 specified rows.
     * @param row1 Row.
     * @param row2 Row.
     */
    public void SwitchRows(final int row1, final int row2);

    /**
     * Returns the values of this matrix as a 2-dimensional array.
     * @return The values of this matrix.
     */
    public TypeOfValue[][] ToArray();

    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Transpose">transpose</a>
     * of this matrix.
     * @return The transpose of this matrix.
     */
    public Matrix<TypeOfValue> Transpose();
}