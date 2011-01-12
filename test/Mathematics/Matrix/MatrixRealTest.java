/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Matrix.MatrixReal.
 * @author Rune Dahl Iversen
 */
public class MatrixRealTest {
    private MatrixReal _matrix;
    private MatrixBaseTest _base;

    public MatrixRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Matrix.MatrixReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._base = new MatrixBaseTest();
        this._matrix = MatrixReal.Identity(0, 3);
    }

    @After
    public void tearDown() {
        this._base = null;
        this._matrix = null;
    }

    /**
     * Test of addColumn method, of class MatrixReal.
     */
    @Test
    public void testAddColumn() {
        System.out.println("addColumn");
        Vector<Double> vector = VectorReal.Unit(3, 2);
        MatrixReal instance = this._matrix;
        double[][] values = new double[3][4];
        for (int col = 0; col < 4; col++) {
            int row = (col == 3 ? 2: col);
            values[row][col] = 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.addColumn(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of addColumn method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddColumn_Null() {
        System.out.println("addColumn(null)");
        Vector<Double> vector = null;
        MatrixReal instance = this._matrix;
        instance.addColumn(vector);
    }

    /**
     * Test of addRow method, of class MatrixReal.
     */
    @Test
    public void testAddRow() {
        System.out.println("addRow");
        Vector<Double> vector = VectorReal.Unit(3, 2);
        MatrixReal instance = this._matrix;
        double[][] values = new double[4][3];
        for (int row = 0; row < 4; row++) {
            int col = (row == 3 ? 2: row);
            values[row][col] = 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.addRow(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of addRow method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddRow_Null() {
        System.out.println("addRow(null)");
        Vector<Double> vector = null;
        MatrixReal instance = this._matrix;
        instance.addRow(vector);
    }

    /**
     * Test of addScaledColumn method, of class MatrixReal.
     */
    @Test
    public void testAddScaledColumn() {
        System.out.println("addScaledColumn");
        int columnToAddTo = 0;
        int columnToAdd = 1;
        Double scalar = 5.0;
        MatrixReal instance = this._matrix;
        instance.addScaledColumn(columnToAddTo, columnToAdd, scalar);
        double[][] values = new double[3][3];
        for (int row = 0; row < 3; row++) {
            values[row][row] = 1.0;
        }
        values[1][0] = 5.0;
        MatrixReal expResult = new MatrixReal(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of addScaledColumn method, of class MatrixReal,
     * for a column to add to out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddScaledColumn_ColumnToAddTo_OutOfRange() {
        System.out.println("addScaledColumn(x, from, scalar)");
        int columnToAddTo = -1;
        int columnToAdd = 1;
        Double scalar = 5.0;
        MatrixReal instance = this._matrix;
        instance.addScaledColumn(columnToAddTo, columnToAdd, scalar);
    }

    /**
     * Test of addScaledColumn method, of class MatrixReal,
     * for a column to add out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddScaledColumn_ColumnToAdd_OutOfRange() {
        System.out.println("addScaledColumn(to, x, scalar)");
        int columnToAddTo = 0;
        int columnToAdd = 9;
        Double scalar = 5.0;
        MatrixReal instance = this._matrix;
        instance.addScaledColumn(columnToAddTo, columnToAdd, scalar);
    }

    /**
     * Test of addScaledColumn method, of class MatrixReal,
     * for a scalar null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddScaledColumn_ScalarNull() {
        System.out.println("addScaledColumn(to, from, null)");
        int columnToAddTo = 0;
        int columnToAdd = 1;
        Double scalar = null;
        MatrixReal instance = this._matrix;
        instance.addScaledColumn(columnToAddTo, columnToAdd, scalar);
    }

    /**
     * Test of addScaledRow method, of class MatrixReal.
     */
    @Test
    public void testAddScaledRow() {
        System.out.println("addScaledRow");
        int rowToAddTo = 0;
        int rowToAdd = 1;
        Double scalar = 7.0;
        MatrixReal instance = this._matrix;
        instance.addScaledRow(rowToAddTo, rowToAdd, scalar);
        double[][] values = new double[3][3];
        for (int row = 0; row < 3; row++) {
            values[row][row] = 1.0;
        }
        values[0][1] = 7.0;
        MatrixReal expResult = new MatrixReal(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of addScaledRow method, of class MatrixReal,
     * for a row to add to out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddScaledRow_RowToAddTo_OutOfRange() {
        System.out.println("addScaledRow(x, from ,scalar)");
        int rowToAddTo = 4;
        int rowToAdd = 1;
        Double scalar = 7.0;
        MatrixReal instance = this._matrix;
        instance.addScaledRow(rowToAddTo, rowToAdd, scalar);
    }

    /**
     * Test of addScaledRow method, of class MatrixReal,
     * for a row to add out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddScaledRow_RowToAdd_OutOfRange() {
        System.out.println("addScaledRow(to, x ,scalar)");
        int rowToAddTo = 0;
        int rowToAdd = -3;
        Double scalar = 7.0;
        MatrixReal instance = this._matrix;
        instance.addScaledRow(rowToAddTo, rowToAdd, scalar);
    }

    /**
     * Test of addScaledRow method, of class MatrixReal,
     * for a scalar null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddScaledRow_ScalarNull() {
        System.out.println("addScaledRow(to, from, null)");
        int rowToAddTo = 0;
        int rowToAdd = 1;
        Double scalar = null;
        MatrixReal instance = this._matrix;
        instance.addScaledRow(rowToAddTo, rowToAdd, scalar);
    }

    /**
     * Test of addToColumn method, of class MatrixReal.
     */
    @Test
    public void testAddToColumn() {
        System.out.println("addToColumn");
        int column = 2;
        Vector<Double> vector = VectorReal.Unit(3, 0);
        MatrixReal instance = this._matrix;
        instance.addToColumn(column, vector);
        double[][] values = new double[3][3];
        for (int row = 0; row < 3; row++) {
            values[row][row] = 1.0;
        }
        values[0][2] = 1.0;
        MatrixReal expResult = new MatrixReal(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of addToColumn method, of class MatrixReal.
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddToColumn_Column_OutOfRange() {
        System.out.println("addToColumn(x, v)");
        int column = 5;
        Vector<Double> vector = VectorReal.Unit(3, 0);
        MatrixReal instance = this._matrix;
        instance.addToColumn(column, vector);
    }

    /**
     * Test of addToColumn method, of class MatrixReal.
     * for a value of the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testAddToColumn_Values_NotConform() {
        System.out.println("addToColumn(c, x)");
        int column = 1;
        Vector<Double> vector = VectorReal.Unit(4, 1);
        MatrixReal instance = this._matrix;
        instance.addToColumn(column, vector);
    }

    /**
     * Test of addToColumn method, of class MatrixReal.
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddToColumn_ValuesNull() {
        System.out.println("addToColumn(c, null)");
        int column = 1;
        Vector<Double> vector = null;
        MatrixReal instance = this._matrix;
        instance.addToColumn(column, vector);
    }

    /**
     * Test of addToRow method, of class MatrixReal.
     */
    @Test
    public void testAddToRow() {
        System.out.println("addToRow");
        int row = 0;
        Vector<Double> vector = VectorReal.Unit(3, 2);
        MatrixReal instance = this._matrix;
        instance.addToRow(row, vector);
        double[][] values = new double[3][3];
        for (int col = 0; col < 3; col++) {
            values[col][col] = 1.0;
        }
        values[0][2] = 1.0;
        MatrixReal expResult = new MatrixReal(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of addToRow method, of class MatrixReal.
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddToRow_Row_OutOfRange() {
        System.out.println("addToRow(x, v)");
        int row = 5;
        Vector<Double> vector = VectorReal.Unit(3, 0);
        MatrixReal instance = this._matrix;
        instance.addToRow(row, vector);
    }

    /**
     * Test of addToRow method, of class MatrixReal.
     * for a value of the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testAddToRow_Values_NotConform() {
        System.out.println("addToRow(r, x)");
        int row = 1;
        Vector<Double> vector = VectorReal.Unit(4, 1);
        MatrixReal instance = this._matrix;
        instance.addToRow(row, vector);
    }

    /**
     * Test of addToRow method, of class MatrixReal.
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddToRow_ValuesNull() {
        System.out.println("addToRow(r, null)");
        int row = 1;
        Vector<Double> vector = null;
        MatrixReal instance = this._matrix;
        instance.addToRow(row, vector);
    }

    /**
     * Test of join method, of class MatrixReal.
     */
    @Test
    public void testJoin() {
        System.out.println("join");
        Matrix<Double> matrix = this._matrix;
        MatrixReal instance = this._matrix;
        double[][] values = new double[3][6];
        for (int row = 0; row < 3; row++) {
            values[row][row] = 1.0;
            values[row][row + 3] = 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.join(matrix);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class MatrixReal,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testJoin_WrongNumberOfRows() {
        System.out.println("join(wrong number of rows)");
        Matrix<Double> matrix = MatrixReal.Zero(0, 1, 0, 1);
        MatrixReal instance = this._matrix;
        instance.join(matrix);
    }

    /**
     * Test of join method, of class MatrixReal,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testJoin_WrongFirstRow() {
        System.out.println("join(wrong first row)");
        Matrix<Double> matrix = MatrixReal.Zero(10, 3, 0, 1);
        MatrixReal instance = this._matrix;
        instance.join(matrix);
    }

    /**
     * Test of join method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testJoin_Null() {
        System.out.println("join(null)");
        Matrix<Double> matrix = null;
        MatrixReal instance = this._matrix;
        instance.join(matrix);
    }

    /**
     * Test of removeColumn method, of class MatrixReal.
     */
    @Test
    public void testRemoveColumn() {
        System.out.println("removeColumn");
        int column = 0;
        MatrixReal instance = this._matrix;
        double[][] values = new double[3][2];
        for (int col = 0; col < 2; col++) {
            values[col + 1][col] = 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.removeColumn(column);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeColumn method, of class MatrixReal,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testRemoveColumn_OutOfRange() {
        System.out.println("removeColumn(x)");
        int column = 7;
        MatrixReal instance = this._matrix;
        instance.removeColumn(column);
    }

    /**
     * Test of removeRow method, of class MatrixReal.
     */
    @Test
    public void testRemoveRow() {
        System.out.println("removeRow");
        int row = 0;
        MatrixReal instance = this._matrix;
        double[][] values = new double[2][3];
        for (int col = 0; col < 2; col++) {
            values[col][col + 1] = 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.removeRow(row);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeRow method, of class MatrixReal,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testRemoveRow_OutOfrange() {
        System.out.println("removeRow(x)");
        int row = -1;
        MatrixReal instance = this._matrix;
        instance.removeRow(row);
    }

    /**
     * Test of scaleColumn method, of class MatrixReal.
     */
    @Test
    public void testScaleColumn() {
        System.out.println("scaleColumn");
        int column = 0;
        Double scalar = 3.5;
        MatrixReal instance = this._matrix;
        instance.scaleColumn(column, scalar);
        double[][] values = new double[3][3];
        for (int col = 0; col < 3; col++) {
            values[col][col] = col == column ? scalar : 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of scaleColumn method, of class MatrixReal,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testScaleColumn_OutOfRange() {
        System.out.println("scaleColumn(x, scalar)");
        int column = 3;
        Double scalar = 3.5;
        MatrixReal instance = this._matrix;
        instance.scaleColumn(column, scalar);
    }

    /**
     * Test of scaleColumn method, of class MatrixReal,
     * for a null scalar.
     */
    @Test (expected=NullPointerException.class)
    public void testScaleColumn_ScalarNull() {
        System.out.println("scaleColumn(c, null)");
        int column = 0;
        Double scalar = null;
        MatrixReal instance = this._matrix;
        instance.scaleColumn(column, scalar);
    }

    /**
     * Test of scaleRow method, of class MatrixReal.
     */
    @Test
    public void testScaleRow() {
        System.out.println("scaleRow");
        int row = 2;
        Double scalar = -2.718281828;
        MatrixReal instance = this._matrix;
        instance.scaleRow(row, scalar);
        double[][] values = new double[3][3];
        for (int col = 0; col < 3; col++) {
            values[col][col] = col == row ? scalar : 1.0;
            if (col == row)
            {
                values[row][0] = -0.0;
                values[row][1] = -0.0;
            }
        }
        Matrix expResult = new MatrixReal(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of scaleRow method, of class MatrixReal,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testScaleRow_OutOfRange() {
        System.out.println("scaleRow(x, scalar)");
        int row = 3;
        Double scalar = -2.718281828;
        MatrixReal instance = this._matrix;
        instance.scaleRow(row, scalar);
    }

    /**
     * Test of scaleRow method, of class MatrixReal,
     * for a null scalar.
     */
    @Test (expected=NullPointerException.class)
    public void testScaleRow_ScalarNull() {
        System.out.println("scaleRow(r, null)");
        int row = 2;
        Double scalar =null;
        MatrixReal instance = this._matrix;
        instance.scaleRow(row, scalar);
    }

    /**
     * Test of stack method, of class MatrixReal.
     */
    @Test
    public void testStack() {
        System.out.println("stack");
        Matrix<Double> matrix = this._matrix;
        MatrixReal instance = this._matrix;
        double[][] values = new double[6][3];
        for (int row = 0; row < 3; row++) {
            values[row][row] = 1.0;
            values[row + 3][row] = 1.0;
        }
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.stack(matrix);
        assertEquals(expResult, result);
    }

    /**
     * Test of stack method, of class MatrixReal,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testStack_WrongNumberOfRows() {
        System.out.println("stack(wrong number of rows)");
        Matrix<Double> matrix = MatrixReal.Zero(0, 1, 0, 1);
        MatrixReal instance = this._matrix;
        instance.stack(matrix);
    }

    /**
     * Test of stack method, of class MatrixReal,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testStack_WrongFirstRow() {
        System.out.println("stack(wrong first row)");
        Matrix<Double> matrix = MatrixReal.Zero(10, 3, 2, 3);
        MatrixReal instance = this._matrix;
        instance.stack(matrix);
    }

    /**
     * Test of stack method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testStack_Null() {
        System.out.println("stack(null)");
        Matrix<Double> matrix = null;
        MatrixReal instance = this._matrix;
        instance.stack(matrix);
    }

    /**
     * Test of toArray method, of class MatrixReal.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        MatrixReal instance = this._matrix;
        Double[][] expResult = new Double[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                expResult[row][col] = (row == col ? 1.0 : 0.0);
        Double[][] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of transpose method, of class MatrixReal.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        MatrixReal instance = this._matrix;
        instance.setRow(0, new VectorReal(3, 4.0));
        Matrix expResult = MatrixReal.Identity(0, 3);
        expResult.setColumn(0, new VectorReal(3, 4.0));
        Matrix result = instance.transpose();
        assertEquals(expResult, result);

        result = result.transpose(); // Test that transpose is self-inverting.
        assertEquals("Twice transposed should equals itself.", instance, result);
    }

    /**
     * Test of getColumn method, of class MatrixReal.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        int column = 0;
        MatrixReal instance = this._matrix;
        Vector expResult = VectorReal.Unit(3, 0);
        Vector result = instance.getColumn(column);
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumn method, of class MatrixReal,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetColumn_OutOfRange() {
        System.out.println("getColumn(out of range)");
        int column = -1;
        MatrixReal instance = this._matrix;
        instance.getColumn(column);
    }

    /**
     * Test of getColumns method, of class MatrixReal.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        MatrixReal instance = this._matrix;
        int expResult = 3;
        int result = instance.getColumns();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstColumn method, of class MatrixReal.
     */
    @Test
    public void testGetFirstColumn() {
        System.out.println("getFirstColumn");
        MatrixReal instance = this._matrix;
        int expResult = 0;
        int result = instance.getFirstColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstRow method, of class MatrixReal.
     */
    @Test
    public void testGetFirstRow() {
        System.out.println("getFirstRow");
        MatrixReal instance = this._matrix;
        int expResult = 0;
        int result = instance.getFirstRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRow method, of class MatrixReal.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        int row = 2;
        MatrixReal instance = this._matrix;
        Vector expResult = VectorReal.Unit(3, 2);
        Vector result = instance.getRow(row);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRow method, of class MatrixReal,
     * and a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetRow_OutOfRange() {
        System.out.println("getRow(out of range)");
        int row = 3;
        MatrixReal instance = this._matrix;
        instance.getRow(row);
    }

    /**
     * Test of getRows method, of class MatrixReal.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        MatrixReal instance = this._matrix;
        int expResult = 3;
        int result = instance.getRows();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class MatrixReal.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        MatrixReal instance = this._matrix;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Double expResult = (row == column ? 1.0 : 0.0);
                Double result = instance.getValue(row, column);
                assertEquals("Row: " + Integer.toString(row) + " Column: " +
                        Integer.toString(column),
                        expResult, result);
            }
        }
    }

    /**
     * Test of getValue method, of class MatrixReal,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetValue_RowOutOfRange() {
        System.out.println("getValue(x, c)");
        MatrixReal instance = this._matrix;
        instance.getValue(-7, 0);
    }

    /**
     * Test of getValue method, of class MatrixReal,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetValue_columnOutOfRange() {
        System.out.println("getValue(r, x)");
        MatrixReal instance = this._matrix;
        instance.getValue(0, 8);
    }

    /**
     * Test of setValue method, of class MatrixReal.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int row = 0;
        int column = 0;
        Double value = 3.141;
        MatrixReal instance = this._matrix;
        instance.setValue(row, column, value);
        double result = instance.getValue(row, column);
        double expResult = 3.141;
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setValue method, of class MatrixReal,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetValue_RowOutOfRange() {
        System.out.println("setValue(x, c, v)");
        int row = 8;
        int column = 0;
        Double value = 3.141;
        MatrixReal instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of setValue method, of class MatrixReal,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetValue_ColumnOutOfRange() {
        System.out.println("setValue(r, x, v)");
        int row = 0;
        int column = -10;
        Double value = 3.141;
        MatrixReal instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of setValue method, of class MatrixReal,
     * for a row out of range.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_ValueNull() {
        System.out.println("setValue(r, c, null)");
        int row = 0;
        int column = 0;
        Double value = null;
        MatrixReal instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of sum method, of class MatrixReal.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Matrix<Double> value = MatrixReal.Value(0, 3, 0, 3, 4.5);
        MatrixReal instance = this._matrix;
        double[][] values = new double[3][3];
        for (int row = 0; row < 3; row++)
            for (int column = 0; column < 3; column++)
                values[row][column] = (row == column ? 5.5 : 4.5);
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.sum(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of sum method, of class MatrixReal, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSum_NotConform() {
        System.out.println("sum(not conform)");
        Matrix<Double> value = new MatrixReal(3, 1, 3, 2, 2.7);
        MatrixReal instance = this._matrix;
        instance.sum(value);
    }

    /**
     * Test of sum method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSum_Null() {
        System.out.println("sum(null)");
        Matrix<Double> value = null;
        MatrixReal instance = this._matrix;
        instance.sum(value);
    }

    /**
     * Test of product method, of class MatrixReal.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        Vector<Double> factor = new VectorReal(3, 2.56);
        MatrixReal instance = this._matrix;
        Vector expResult = new VectorReal(3, 2.56);
        Vector result = instance.product(factor);
        assertEquals(expResult, result);
    }

    /**
     * Test of product method, of class MatrixReal, for a not conforming value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testProduct_NotConform() {
        System.out.println("product(not conform)");
        Vector<Double> factor = new VectorReal(2, 3.4);
        MatrixReal instance = this._matrix;
        instance.product(factor);
    }

    /**
     * Test of product method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testProduct_Null() {
        System.out.println("product(null)");
        Vector<Double> factor = null;
        MatrixReal instance = this._matrix;
        instance.product(factor);
    }

    /**
     * Test of scale method, of class MatrixReal.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        Double scalar = 7.3;
        MatrixReal instance = this._matrix;
        double[][] values = new double[3][3];
        for (int r = 0; r < 3; r++)
            values[r][r] = 7.3;
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.scale(scalar);
        assertEquals(expResult, result);
    }

    /**
     * Test of scale method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testScale_Null() {
        System.out.println("scale(null)");
        Double scalar = null;
        MatrixReal instance = this._matrix;
        instance.scale(scalar);
    }

    /**
     * Test of subtract method, of class MatrixReal.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Matrix<Double> value = MatrixReal.Value(0, 3, 0, 3, 2.718281828);
        MatrixReal instance = this._matrix;
        double[][] values = new double[3][3];
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                values[r][c] = (r == c ? -1.7182818279999998 : -2.718281828);
        Matrix expResult = new MatrixReal(values);
        Matrix result = instance.subtract(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class MatrixReal, for a not conforming value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSubtract_NotConforming() {
        System.out.println("subtract(not conform)");
        Matrix<Double> value = new MatrixReal(3, 1, 3, 2, 2.7);
        MatrixReal instance = this._matrix;
        instance.subtract(value);
    }

    /**
     * Test of subtract method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSubtract_Null() {
        System.out.println("subtract(null)");
        Matrix<Double> value = null;
        MatrixReal instance = this._matrix;
        instance.subtract(value);
    }

    /**
     * Test of Identity method, of class MatrixReal.
     */
    @Test
    public void testIdentity() {
        System.out.println("Identity");
        int firstDimension = 78;
        int dimensions = 4;
        double[][] values = new double[dimensions][dimensions];
        for (int c = 0; c < dimensions; c++)
            values[c][c] = 1.0;
        MatrixReal expResult = new MatrixReal(firstDimension, firstDimension, values);
        MatrixReal result = MatrixReal.Identity(firstDimension, dimensions);
        assertEquals(expResult, result);
    }

    /**
     * Test of Identity method, of class MatrixReal, with 0 dimensions.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testIdentity_NoDimensions() {
        System.out.println("Identity");
        int firstDimension = 78;
        int dimensions = 0;
        MatrixReal.Identity(firstDimension, dimensions);
    }

    /**
     * Test of Value method, of class MatrixReal.
     */
    @Test
    public void testValue() {
        System.out.println("Value");
        int firstRow = 0;
        int rows = 2;
        int firstColumn = 4;
        int columns = 2;
        Double value = 2.718281828;
        double[][] values = new double[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                values[r][c] = value;
        MatrixReal expResult = new MatrixReal(firstRow, firstColumn, values);
        MatrixReal result = MatrixReal.Value(
                firstRow, rows, firstColumn, columns, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of Value method, of class MatrixReal, with zero rows.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testValue_RowsZero() {
        System.out.println("Value(fr, 0, fc, c, value");
        int firstRow = 0;
        int rows = 0;
        int firstColumn = 4;
        int columns = 2;
        Double value = 2.718281828;
        MatrixReal.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Value method, of class MatrixReal, with zero columns.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testValue_ColumnsZero() {
        System.out.println("Value(fr, r, fc, 0, value");
        int firstRow = 5;
        int rows = 4;
        int firstColumn = 4;
        int columns = 0;
        Double value = 2.718281828;
        MatrixReal.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Value method, of class MatrixReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_ValueNull() {
        System.out.println("Value(fr, r, fc, c, null)");
        int firstRow = 0;
        int rows = 2;
        int firstColumn = 4;
        int columns = 2;
        Double value = null;
        MatrixReal.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Zero method, of class MatrixReal.
     */
    @Test
    public void testZero() {
        System.out.println("Zero");
        int firstRow = 0;
        int rows = 1;
        int firstColumn = 0;
        int columns = 1;
        double[][] values = new double[rows][columns];
        MatrixReal expResult = new MatrixReal(firstRow, firstColumn, values);
        MatrixReal result = MatrixReal.Zero(firstRow, rows, firstColumn, columns);
        assertEquals(expResult, result);
    }

    /**
     * Test of Zero method, of class MatrixReal, with zero rows.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testZero_RowsZero() {
        System.out.println("Zero(fr, 0, fc, c)");
        int firstRow = 0;
        int rows = 0;
        int firstColumn = 0;
        int columns = 1;
        MatrixReal.Zero(firstRow, rows, firstColumn, columns);
    }

    /**
     * Test of Zero method, of class MatrixReal, with zero columns.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testZero_ColumnsZero() {
        System.out.println("Zero(fr, r, fc, 0)");
        int firstRow = 0;
        int rows = 1;
        int firstColumn = 0;
        int columns = 0;
        MatrixReal.Zero(firstRow, rows, firstColumn, columns);
    }
}