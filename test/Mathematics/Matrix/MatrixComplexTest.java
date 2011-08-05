/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Complex;
import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Matrix.MatrixComplex.
 * @author Rune Dahl Iversen
 */
public class MatrixComplexTest {
    private MatrixComplex _matrix;
    private MatrixBaseTest _base;

    public MatrixComplexTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Matrix.MatrixComplex");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._base = new MatrixBaseTest();
        this._matrix = MatrixComplex.Identity(0, 3);
    }

    @After
    public void tearDown() {
        this._base = null;
        this._matrix = null;
    }

    /**
     * Test of constructor, of class MatrixComplex,
     * for the overload taking the values (int, int, Complex).
     */
    @Test
    public void testCtor_Int_Int_Complex() {
        System.out.println("MatrixComplex(int, int, Complex)");
        MatrixComplex instance = new MatrixComplex(4, 2, Complex.RealNumber(7.4));

        assertNotNull("Result from ctor(int, int, Complex).", instance);
        assertEquals("Wrong number of first row.", 0, instance.getFirstRow());
        assertEquals("Wrong number of rows.", 4, instance.getRows());
        assertEquals("Wrong number of first column.", 0, instance.getFirstColumn());
        assertEquals("Wrong number of columns.", 2, instance.getColumns());

        for (int c = instance.getFirstColumn(); c < instance.getLastColumn(); c++)
            for (int r = instance.getFirstRow(); r < instance.getLastRow(); r++)
                assertEquals("The value of row " + Integer.toString(r) +
                        " column " + Integer.toString(c),
                        Complex.RealNumber(7.4), instance.getValue(r, c));

    }

    /**
     * Test of constructor, of class MatrixComplex,
     * for the overload taking the values (int, int, Complex[0][]).
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testCtor_Int_Int_ComplexArray_ZeroRows() {
        System.out.println("MatrixComplex(int, int, Complex[0][])");
        Complex[][] values = new Complex[0][];
        MatrixComplex instance = new MatrixComplex(4, 2, values);
    }

    /**
     * Test of addColumn method, of class MatrixComplex.
     */
    @Test
    public void testAddColumn() {
        System.out.println("addColumn");
        Vector<Complex> vector = VectorComplex.Unit(3, 2);
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[3][4];
        for (int row = 0; row < values.length; row++)
            for (int col = 0; col < values[0].length; col++)
                values[row][col] = Complex.Origin;
        for (int col = 0; col < 4; col++) {
            int row = (col == 3 ? 2: col);
            values[row][col] = Complex.RealNumber(1.0);
        }
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.addColumn(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of addColumn method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddColumn_Null() {
        System.out.println("addColumn(null)");
        Vector<Complex> vector = null;
        MatrixComplex instance = this._matrix;
        instance.addColumn(vector);
    }

    /**
     * Test of addColumn method, of class MatrixComplex,
     * for a vector of the wrong dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testAddColumn_WrongDimensions() {
        System.out.println("addColumn(wrong dimensions)");
        Vector<Complex> vector = new VectorComplex(17, 5);
        MatrixComplex instance = this._matrix;
        instance.addColumn(vector);
    }

    /**
     * Test of addRow method, of class MatrixComplex.
     */
    @Test
    public void testAddRow() {
        System.out.println("addRow");
        Vector<Complex> vector = VectorComplex.Unit(3, 2);
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[4][3];
        for (int row = 0; row < values.length; row++)
            for (int col = 0; col < values[0].length; col++)
                values[row][col] = Complex.Origin;
        for (int row = 0; row < 4; row++) {
            int col = (row == 3 ? 2: row);
            values[row][col] = Complex.RealNumber(1.0);
        }
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.addRow(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of addRow method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddRow_Null() {
        System.out.println("addRow(null)");
        Vector<Complex> vector = null;
        MatrixComplex instance = this._matrix;
        instance.addRow(vector);
    }

    /**
     * Test of addRow method, of class MatrixComplex,
     * for a vector of the wrong dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testAddRow_WrongDimensions() {
        System.out.println("addRow(wrong dimensions)");
        Vector<Complex> vector = new VectorComplex(17, 5);
        MatrixComplex instance = this._matrix;
        instance.addRow(vector);
    }

    /**
     * Test of addToColumn method, of class MatrixComplex.
     */
    @Test
    public void testAddToColumn() {
        System.out.println("addToColumn");
        int column = 2;
        Vector<Complex> vector = VectorComplex.Unit(3, 0);
        MatrixComplex instance = this._matrix;
        instance.addToColumn(column, vector);
        Complex[][] values = new Complex[3][3];
        for (int row = 0; row < values.length; row++)
            for (int col = 0; col < values[0].length; col++)
                values[row][col] = Complex.Origin;
        for (int row = 0; row < 3; row++) {
            values[row][row] = Complex.RealNumber(1.0);
        }
        values[0][2] = Complex.RealNumber(1.0);
        MatrixComplex expResult = new MatrixComplex(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of addToColumn method, of class MatrixComplex.
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddToColumn_Column_OutOfRange() {
        System.out.println("addToColumn(x, v)");
        int column = 5;
        Vector<Complex> vector = VectorComplex.Unit(3, 0);
        MatrixComplex instance = this._matrix;
        instance.addToColumn(column, vector);
    }

    /**
     * Test of addToColumn method, of class MatrixComplex.
     * for a value of the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testAddToColumn_Values_NotConform() {
        System.out.println("addToColumn(c, x)");
        int column = 1;
        Vector<Complex> vector = VectorComplex.Unit(4, 1);
        MatrixComplex instance = this._matrix;
        instance.addToColumn(column, vector);
    }

    /**
     * Test of addToColumn method, of class MatrixComplex.
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddToColumn_ValuesNull() {
        System.out.println("addToColumn(c, null)");
        int column = 1;
        Vector<Complex> vector = null;
        MatrixComplex instance = this._matrix;
        instance.addToColumn(column, vector);
    }

    /**
     * Test of addToRow method, of class MatrixComplex.
     */
    @Test
    public void testAddToRow() {
        System.out.println("addToRow");
        int row = 0;
        Vector<Complex> vector = VectorComplex.Unit(3, 2);
        MatrixComplex instance = this._matrix;
        instance.addToRow(row, vector);
        Complex[][] values = new Complex[3][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int col = 0; col < 3; col++) {
            values[col][col] = Complex.RealNumber(1.0);
        }
        values[0][2] = Complex.RealNumber(1.0);
        MatrixComplex expResult = new MatrixComplex(values);
        assertEquals(expResult, instance);
    }

    /**
     * Test of addToRow method, of class MatrixComplex.
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testAddToRow_Row_OutOfRange() {
        System.out.println("addToRow(x, v)");
        int row = 5;
        Vector<Complex> vector = VectorComplex.Unit(3, 0);
        MatrixComplex instance = this._matrix;
        instance.addToRow(row, vector);
    }

    /**
     * Test of addToRow method, of class MatrixComplex.
     * for a value of the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testAddToRow_Values_NotConform() {
        System.out.println("addToRow(r, x)");
        int row = 1;
        Vector<Complex> vector = VectorComplex.Unit(4, 1);
        MatrixComplex instance = this._matrix;
        instance.addToRow(row, vector);
    }

    /**
     * Test of addToRow method, of class MatrixComplex.
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddToRow_ValuesNull() {
        System.out.println("addToRow(r, null)");
        int row = 1;
        Vector<Complex> vector = null;
        MatrixComplex instance = this._matrix;
        instance.addToRow(row, vector);
    }

    /**
     * Test of hasSameColumns(Matrix) method, for class MatrixComplex.
     */
    @Test
    public void testHasSameColumns_Matrix() {
        System.out.println("hasSameColumns");
        MatrixComplex instance = this._matrix;
        MatrixComplex matrix = new MatrixComplex(2, 3);
        this._base.testHasSameColumns_Matrix(instance, matrix, true);

        matrix = new MatrixComplex(3, 2);
        this._base.testHasSameColumns_Matrix(instance, matrix, false);

        matrix = new MatrixComplex(1, 3, 1, 3);
        this._base.testHasSameColumns_Matrix(instance, matrix, false);
    }

    /**
     * Test of hasSameColumns(Matrix) method, for class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameColumns_Matrix_Null() {
        System.out.println("hasSameColumns(null)");
        MatrixComplex instance = this._matrix;
        MatrixComplex matrix = null;
        this._base.testHasSameColumns_Matrix(instance, matrix, true);
    }

    /**
     * Test of hasSameColumns(Vector) method, for class MatrixComplex.
     */
    @Test
    public void testHasSameColumns_Vector() {
        System.out.println("hasSameColumns");
        MatrixComplex instance = this._matrix;
        Vector vector = new VectorComplex(3);
        this._base.testHasSameColumns_Vector(instance, vector, true);

        vector = new VectorComplex(2);
        this._base.testHasSameColumns_Vector(instance, vector, false);

        vector = new VectorComplex(1, 3);
        this._base.testHasSameColumns_Vector(instance, vector, false);
    }

    /**
     * Test of hasSameColumns(Vector) method, for class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameColumns_Vector_Null() {
        System.out.println("hasSameColumns(null)");
        MatrixComplex instance = this._matrix;
        Vector vector = null;
        this._base.testHasSameColumns_Vector(instance, vector, true);
    }

    /**
     * Test of hasSameDimensions method, for class MatrixComplex.
     */
    @Test
    public void testHasSameDimensions() {
        System.out.println("hasSameDimensions");
        MatrixComplex instance = this._matrix;
        MatrixComplex matrix = new MatrixComplex(3, 3);
        this._base.testHasSameDimensions(instance, matrix, true);

        matrix = new MatrixComplex(3, 2);
        this._base.testHasSameDimensions(instance, matrix, false);

        matrix = new MatrixComplex(2, 3);
        this._base.testHasSameDimensions(instance, matrix, false);

        matrix = new MatrixComplex(11, 3, 0, 3);
        this._base.testHasSameDimensions(instance, matrix, false);

        matrix = new MatrixComplex(0, 3, 10, 3);
        this._base.testHasSameDimensions(instance, matrix, false);
    }

    /**
     * Test of hasSameDimensions method, for class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameDimensions_Null() {
        System.out.println("hasSameDimensions(null)");
        MatrixComplex instance = this._matrix;
        MatrixComplex matrix = null;
        this._base.testHasSameDimensions(instance, matrix, true);
    }

    /**
     * Test of hasSameColumns(Matrix) method, for class MatrixComplex.
     */
    @Test
    public void testHasSameRows_Matrix() {
        System.out.println("hasSameRows");
        MatrixComplex instance = this._matrix;
        MatrixComplex matrix = new MatrixComplex(3, 2);
        this._base.testHasSameRows_Matrix(instance, matrix, true);

        matrix = new MatrixComplex(2, 3);
        this._base.testHasSameRows_Matrix(instance, matrix, false);

        matrix = new MatrixComplex(1, 3, 1, 3);
        this._base.testHasSameRows_Matrix(instance, matrix, false);
    }

    /**
     * Test of hasSameRows(Matrix) method, for class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameRows_Matrix_Null() {
        System.out.println("hasSameRows(null)");
        MatrixComplex instance = this._matrix;
        MatrixComplex matrix = null;
        this._base.testHasSameRows_Matrix(instance, matrix, true);
    }

    /**
     * Test of hasSameColumns(Vector) method, for class MatrixComplex.
     */
    @Test
    public void testHasSameRows_Vector() {
        System.out.println("hasSameRows");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = new VectorComplex(3);
        this._base.testHasSameRows_Vector(instance, vector, true);

        vector = new VectorComplex(2);
        this._base.testHasSameRows_Vector(instance, vector, false);

        vector = new VectorComplex(1, 3);
        this._base.testHasSameRows_Vector(instance, vector, false);
    }

    /**
     * Test of hasSameRows(Vector) method, for class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameRows_Vector_Null() {
        System.out.println("hasSameRows(null)");
        MatrixComplex instance = this._matrix;
        Vector vector = null;
        this._base.testHasSameRows_Vector(instance, vector, true);
    }

    /**
     * Test of isSquare method, of MatrixComplex.
     */
    @Test
    public void testIsSquare() {
        System.out.println("isSquare");
        MatrixComplex instance = this._matrix;
        this._base.testIsSquare(instance, true);

        instance = new MatrixComplex(3, 2);
        this._base.testIsSquare(instance, false);

        instance = new MatrixComplex(3, 2, 4, 2);
        this._base.testIsSquare(instance, true);

        instance = new MatrixComplex(2, 3);
        this._base.testIsSquare(instance, false);
    }

    /**
     * Test of join method, of class MatrixComplex.
     */
    @Test
    public void testJoin() {
        System.out.println("join");
        Matrix<Complex> matrix = this._matrix;
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[3][6];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int row = 0; row < 3; row++) {
            values[row][row] = Complex.RealNumber(1.0);
            values[row][row + 3] = Complex.RealNumber(1.0);
        }
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.join(matrix);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class MatrixComplex,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testJoin_WrongNumberOfRows() {
        System.out.println("join(wrong number of rows)");
        Matrix<Complex> matrix = MatrixComplex.Zero(0, 1, 0, 1);
        MatrixComplex instance = this._matrix;
        instance.join(matrix);
    }

    /**
     * Test of join method, of class MatrixComplex,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testJoin_WrongFirstRow() {
        System.out.println("join(wrong first row)");
        Matrix<Complex> matrix = MatrixComplex.Zero(10, 3, 0, 1);
        MatrixComplex instance = this._matrix;
        instance.join(matrix);
    }

    /**
     * Test of join method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testJoin_Null() {
        System.out.println("join(null)");
        Matrix<Complex> matrix = null;
        MatrixComplex instance = this._matrix;
        instance.join(matrix);
    }

    /**
     * Test of removeColumn method, of class MatrixComplex.
     */
    @Test
    public void testRemoveColumn() {
        System.out.println("removeColumn");
        int column = 1;
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[3][2];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        values[0][0] = Complex.RealNumber(1.0);
        for (int col = 1; col < 2; col++) {
            values[col + 1][col] = Complex.RealNumber(1.0);
        }
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.removeColumn(column);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeColumn method, of class MatrixComplex,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testRemoveColumn_OutOfRange() {
        System.out.println("removeColumn(x)");
        int column = 7;
        MatrixComplex instance = this._matrix;
        instance.removeColumn(column);
    }

    /**
     * Test of removeColumn method, of class MatrixComplex,
     * for the last column.
     */
    @Test (expected=NullPointerException.class)
    public void testRemoveColumn_LastColumn() {
        System.out.println("removeColumn(last column)");
        int column = 0;
        MatrixComplex instance = MatrixComplex.Value(0, 2, 0, 1, Complex.RealNumber(3.0));
        instance.removeColumn(column);
    }

    /**
     * Test of removeRow method, of class MatrixComplex.
     */
    @Test
    public void testRemoveRow() {
        System.out.println("removeRow");
        int row = 1;
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[2][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        values[0][0] = Complex.RealNumber(1.0);
        for (int col = 1; col < 2; col++) {
            values[col][col + 1] = Complex.RealNumber(1.0);
        }
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.removeRow(row);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeRow method, of class MatrixComplex,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testRemoveRow_OutOfrange() {
        System.out.println("removeRow(x)");
        int row = -1;
        MatrixComplex instance = this._matrix;
        instance.removeRow(row);
    }

    /**
     * Test of removeRow method, of class MatrixComplex,
     * for the last row.
     */
    @Test (expected=NullPointerException.class)
    public void testRemoveRow_LastRow() {
        System.out.println("removeRow(last row)");
        int row = 0;
        MatrixComplex instance = MatrixComplex.Value(0, 1, 0, 2, Complex.RealNumber(3.0));
        instance.removeRow(row);
    }

    /**
     * Test of stack method, of class MatrixComplex.
     */
    @Test
    public void testStack() {
        System.out.println("stack");
        Matrix<Complex> matrix = this._matrix;
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[6][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int row = 0; row < 3; row++) {
            values[row][row] = Complex.RealNumber(1.0);
            values[row + 3][row] = Complex.RealNumber(1.0);
        }
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.stack(matrix);
        assertEquals(expResult, result);
    }

    /**
     * Test of stack method, of class MatrixComplex,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testStack_WrongNumberOfRows() {
        System.out.println("stack(wrong number of rows)");
        Matrix<Complex> matrix = MatrixComplex.Zero(0, 1, 0, 1);
        MatrixComplex instance = this._matrix;
        instance.stack(matrix);
    }

    /**
     * Test of stack method, of class MatrixComplex,
     * for a matrix with the wrong number of rows.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testStack_WrongFirstRow() {
        System.out.println("stack(wrong first row)");
        Matrix<Complex> matrix = MatrixComplex.Zero(10, 3, 2, 3);
        MatrixComplex instance = this._matrix;
        instance.stack(matrix);
    }

    /**
     * Test of stack method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testStack_Null() {
        System.out.println("stack(null)");
        Matrix<Complex> matrix = null;
        MatrixComplex instance = this._matrix;
        instance.stack(matrix);
    }

    /**
     * Test of toArray method, of class MatrixComplex.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        MatrixComplex instance = this._matrix;
        Complex[][] expResult = new Complex[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                expResult[row][col] = (row == col ? Complex.RealNumber(1.0) : Complex.Origin);
        Complex[][] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of transpose method, of class MatrixComplex.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        MatrixComplex instance = this._matrix;
        instance.setRow(0, new VectorComplex(3, Complex.RealNumber(4.0)));
        Matrix expResult = MatrixComplex.Identity(0, 3);
        expResult.setColumn(0, new VectorComplex(3, Complex.RealNumber(4.0)));
        Matrix result = instance.transpose();
        assertEquals(expResult, result);

        result = result.transpose(); // Test that transpose is self-inverting.
        assertEquals("Twice transposed should equals itself.", instance, result);
    }

    /**
     * Test of getColumn method, of class MatrixComplex.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        int column = 0;
        MatrixComplex instance = this._matrix;
        Vector expResult = VectorComplex.Unit(3, 0);
        Vector result = instance.getColumn(column);
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumn method, of class MatrixComplex,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetColumn_OutOfRange() {
        System.out.println("getColumn(out of range)");
        int column = -1;
        MatrixComplex instance = this._matrix;
        instance.getColumn(column);
    }

    /**
     * Test of getColumns method, of class MatrixComplex.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        MatrixComplex instance = this._matrix;
        int expResult = 3;
        int result = instance.getColumns();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstColumn method, of class MatrixComplex.
     */
    @Test
    public void testGetFirstColumn() {
        System.out.println("getFirstColumn");
        MatrixComplex instance = this._matrix;
        int expResult = 0;
        this._base.testGetFirstColumn(instance, expResult);
    }

    /**
     * Test of getFirstRow method, of class MatrixComplex.
     */
    @Test
    public void testGetFirstRow() {
        System.out.println("getFirstRow");
        MatrixComplex instance = this._matrix;
        int expResult = 0;
        this._base.testGetFirstRow(instance, expResult);
    }

    /**
     * Test of getLastColumn method, of class MatrixComplex.
     */
    @Test
    public void testGetLastColumn() {
        System.out.println("getLastColumn");
        MatrixComplex instance = this._matrix;
        int expResult = 2;
        this._base.testGetLastColumn(instance, expResult);
    }

    /**
     * Test of getLastRow method, of class MatrixComplex.
     */
    @Test
    public void testGetLastRow() {
        System.out.println("getLastRow");
        MatrixComplex instance = this._matrix;
        int expResult = 2;
        this._base.testGetLastRow(instance, expResult);
    }

    /**
     * Test of getRow method, of class MatrixComplex.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        int row = 2;
        MatrixComplex instance = this._matrix;
        Vector expResult = VectorComplex.Unit(3, 2);
        Vector result = instance.getRow(row);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRow method, of class MatrixComplex,
     * and a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetRow_OutOfRange() {
        System.out.println("getRow(out of range)");
        int row = 3;
        MatrixComplex instance = this._matrix;
        instance.getRow(row);
    }

    /**
     * Test of getRows method, of class MatrixComplex.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        MatrixComplex instance = this._matrix;
        int expResult = 3;
        int result = instance.getRows();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class MatrixComplex.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        MatrixComplex instance = this._matrix;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Complex expResult = (row == column ? Complex.RealNumber(1.0) : Complex.Origin);
                Complex result = instance.getValue(row, column);
                assertEquals("Row: " + Integer.toString(row) + " Column: " +
                        Integer.toString(column),
                        expResult, result);
            }
        }
    }

    /**
     * Test of getValue method, of class MatrixComplex,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetValue_RowOutOfRange() {
        System.out.println("getValue(x, c)");
        MatrixComplex instance = this._matrix;
        instance.getValue(-7, 0);
    }

    /**
     * Test of getValue method, of class MatrixComplex,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetValue_columnOutOfRange() {
        System.out.println("getValue(r, x)");
        MatrixComplex instance = this._matrix;
        instance.getValue(0, 8);
    }

    /**
     * Test of method setColumn, of class MatrixComplex.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = VectorComplex.Unit(3, 2);
        Complex[][] values = new Complex[3][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int c = 0; c < 3; c++)
            values[c][c] = Complex.RealNumber(1.0);
        values[2][1] = Complex.RealNumber(1.0);
        values[1][1] = Complex.Origin;
        MatrixComplex expResult = new MatrixComplex(values);
        this._base.testSetColumn(instance, vector, 1, expResult);
    }

    /**
     * Test of method setColumn, of class MatrixComplex, for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetColumn_Column_OutOfRange() {
        System.out.println("setColumn(x, vector)");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = VectorComplex.Unit(3, 2);
        this._base.testSetColumn(instance, vector, 3, null);
    }

    /**
     * Test of method setColumn, of class MatrixComplex, for a null vector.
     */
    @Test (expected=NullPointerException.class)
    public void testSetColumn_VectorNull() {
        System.out.println("setColumn(c, null)");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = null;
        this._base.testSetColumn(instance, vector, 1, null);
    }

    /**
     * Test of method setColumn, of class MatrixComplex,
     * for a vector of the wrong size.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetColumn_WrongDimension() {
        System.out.println("setColumn(c, wrong size)");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = VectorComplex.Unit(2, 1);
        this._base.testSetColumn(instance, vector, 1, null);
    }

    /**
     * Test of method setRow, of class MatrixComplex.
     */
    @Test
    public void testSetRow() {
        System.out.println("setRow");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = VectorComplex.Unit(3, 2);
        Complex[][] values = new Complex[3][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int c = 0; c < 3; c++)
            values[c][c] = Complex.RealNumber(1.0);
        values[1][2] = Complex.RealNumber(1.0);
        values[1][1] = Complex.Origin;
        MatrixComplex expResult = new MatrixComplex(values);
        this._base.testSetRow(instance, vector, 1, expResult);
    }

    /**
     * Test of method setRow, of class MatrixComplex, for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetRow_Row_OutOfRange() {
        System.out.println("setRow(x, vector)");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = VectorComplex.Unit(3, 2);
        this._base.testSetRow(instance, vector, 3, null);
    }

    /**
     * Test of method setRow, of class MatrixComplex, for a null vector.
     */
    @Test (expected=NullPointerException.class)
    public void testSetRow_VectorNull() {
        System.out.println("setRow(c, null)");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = null;
        this._base.testSetRow(instance, vector, 1, null);
    }

    /**
     * Test of method setRow, of class MatrixComplex,
     * for a vector of the wrong size.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetRow_WrongDimension() {
        System.out.println("setRow(r, wrong size)");
        MatrixComplex instance = this._matrix;
        VectorComplex vector = VectorComplex.Unit(2, 1);
        this._base.testSetRow(instance, vector, 1, null);
    }

    /**
     * Test of setValue method, of class MatrixComplex.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int row = 0;
        int column = 0;
        Complex value = Complex.RealNumber(3.141);
        MatrixComplex instance = this._matrix;
        instance.setValue(row, column, value);
        Complex result = instance.getValue(row, column);
        Complex expResult = Complex.RealNumber(3.141);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class MatrixComplex,
     * for a row out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetValue_RowOutOfRange() {
        System.out.println("setValue(x, c, v)");
        int row = 8;
        int column = 0;
        Complex value = Complex.RealNumber(3.141);
        MatrixComplex instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of setValue method, of class MatrixComplex,
     * for a column out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetValue_ColumnOutOfRange() {
        System.out.println("setValue(r, x, v)");
        int row = 0;
        int column = -10;
        Complex value = Complex.RealNumber(3.141);
        MatrixComplex instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of setValue method, of class MatrixComplex,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_ValueNull() {
        System.out.println("setValue(r, c, null)");
        int row = 0;
        int column = 0;
        Complex value = null;
        MatrixComplex instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of setValue method, of class MatrixComplex,
     * for a Complex.NaN value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_ValueNaN() {
        System.out.println("setValue(r, c, Complex.NAN)");
        int row = 0;
        int column = 0;
        Complex value = Complex.NaN;
        MatrixComplex instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of setValue method, of class MatrixComplex,
     * for a Complex.Infinity value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_ValueInfinity() {
        System.out.println("setValue(r, c, Complex.Infinity)");
        int row = 0;
        int column = 0;
        Complex value = Complex.Infinity;
        MatrixComplex instance = this._matrix;
        instance.setValue(row, column, value);
    }

    /**
     * Test of sum method, of class MatrixComplex.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Matrix<Complex> value = MatrixComplex.Value(0, 3, 0, 3, Complex.RealNumber(4.5));
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[3][3];
        for (int row = 0; row < 3; row++)
            for (int column = 0; column < 3; column++)
                values[row][column] = (row == column ? Complex.RealNumber(5.5) : Complex.RealNumber(4.5));
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.sum(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of sum method, of class MatrixComplex, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSum_NotConform() {
        System.out.println("sum(not conform)");
        Matrix<Complex> value = new MatrixComplex(3, 1, 3, 2, Complex.RealNumber(2.7));
        MatrixComplex instance = this._matrix;
        instance.sum(value);
    }

    /**
     * Test of sum method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSum_Null() {
        System.out.println("sum(null)");
        Matrix<Complex> value = null;
        MatrixComplex instance = this._matrix;
        instance.sum(value);
    }

    /**
     * Test of product method, of class MatrixComplex.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        Vector<Complex> factor = new VectorComplex(3, Complex.RealNumber(2.56));
        MatrixComplex instance = this._matrix;
        Vector expResult = new VectorComplex(3, Complex.RealNumber(2.56));
        Vector result = instance.product(factor);
        assertEquals(expResult, result);
    }

    /**
     * Test of product method, of class MatrixComplex, for a not conforming value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testProduct_NotConform() {
        System.out.println("product(not conform)");
        Vector<Complex> factor = new VectorComplex(2, Complex.RealNumber(3.4));
        MatrixComplex instance = this._matrix;
        instance.product(factor);
    }

    /**
     * Test of product method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testProduct_Null() {
        System.out.println("product(null)");
        Vector<Complex> factor = null;
        MatrixComplex instance = this._matrix;
        instance.product(factor);
    }

    /**
     * Test of scale method, of class MatrixComplex.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        Complex scalar = Complex.RealNumber(7.3);
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[3][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int r = 0; r < 3; r++)
            values[r][r] = Complex.RealNumber(7.3);
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.scale(scalar);
        assertEquals(expResult, result);
    }

    /**
     * Test of scale method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testScale_Null() {
        System.out.println("scale(null)");
        Complex scalar = null;
        MatrixComplex instance = this._matrix;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class MatrixComplex, for a value of Complex.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_NaN() {
        System.out.println("scale(Complex.NaN)");
        Complex scalar = Complex.NaN;
        MatrixComplex instance = this._matrix;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class MatrixComplex,
     * for the value Complex.Infinity.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_Infinity() {
        System.out.println("scale(Complex.Infinity)");
        Complex scalar = Complex.Infinity;
        MatrixComplex instance = this._matrix;
        instance.scale(scalar);
    }

    /**
     * Test of subtract method, of class MatrixComplex.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Matrix<Complex> value = MatrixComplex.Value(0, 3, 0, 3, Complex.RealNumber(2.718281828));
        MatrixComplex instance = this._matrix;
        Complex[][] values = new Complex[3][3];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                values[r][c] = (r == c ? Complex.RealNumber(-1.7182818279999998) : Complex.RealNumber(-2.718281828));
        Matrix expResult = new MatrixComplex(values);
        Matrix result = instance.subtract(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class MatrixComplex, for a not conforming value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSubtract_NotConforming() {
        System.out.println("subtract(not conform)");
        Matrix<Complex> value = new MatrixComplex(3, 1, 3, 2, Complex.RealNumber(2.7));
        MatrixComplex instance = this._matrix;
        instance.subtract(value);
    }

    /**
     * Test of subtract method, of class MatrixComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSubtract_Null() {
        System.out.println("subtract(null)");
        Matrix<Complex> value = null;
        MatrixComplex instance = this._matrix;
        instance.subtract(value);
    }

    /**
     * Test of equals method, of class MatrixComplex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        MatrixComplex instance = this._matrix;
        Complex[][] array = instance.toArray();
        Complex[][] values = new Complex[array.length][array[0].length];
        for (int r = 0; r < array.length; r++)
            for (int c = 0; c < array[0].length; c++)
                values[r][c] = array[r][c];
        MatrixComplex matrix = new MatrixComplex(values);
        MatrixComplex three = MatrixComplex.Zero(0, 3, 0, 2);
        MatrixComplex two = MatrixComplex.Identity(0, 2);
        this._base.testEquals(instance, matrix, three, two);

        MatrixComplex wrongValue = MatrixComplex.Identity(0, 3);
        wrongValue.setValue(1, 0, Complex.RealNumber(5.0));

        assertFalse(instance.toString() + " compared to " + wrongValue.toString(),
                instance.equals(wrongValue));
    }

    /**
     * Test of toString method, of class MatrixComplex.
     */
    @Test
    public void testToString() {
        System.out.println("equals");
        MatrixComplex instance = this._matrix;
        String expResult = "{Mathematics.Matrix.MatrixComplex Rows: 0-2 Columns: 0-2 [[(1.0 + î 0.0); (0.0 + î 0.0); (0.0 + î 0.0)]; [(0.0 + î 0.0); (1.0 + î 0.0); (0.0 + î 0.0)]; [(0.0 + î 0.0); (0.0 + î 0.0); (1.0 + î 0.0)]]}";
        this._base.testToString(instance, expResult);
    }

    /**
     * Test of hashCode method, of class MatrixComplex.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        this._base.testHashCode(this._matrix, 23188331);
    }

    /**
     * Test of Identity method, of class MatrixComplex.
     */
    @Test
    public void testIdentity() {
        System.out.println("Identity");
        int firstDimension = 78;
        int dimensions = 4;
        Complex[][] values = new Complex[dimensions][dimensions];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        for (int c = 0; c < dimensions; c++)
            values[c][c] = Complex.RealNumber(1.0);
        MatrixComplex expResult = new MatrixComplex(firstDimension, firstDimension, values);
        MatrixComplex result = MatrixComplex.Identity(firstDimension, dimensions);
        assertEquals(expResult, result);
    }

    /**
     * Test of Identity method, of class MatrixComplex, with 0 dimensions.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testIdentity_NoDimensions() {
        System.out.println("Identity(fd, 0)");
        int firstDimension = 78;
        int dimensions = 0;
        MatrixComplex.Identity(firstDimension, dimensions);
    }

    /**
     * Test of Value method, of class MatrixComplex.
     */
    @Test
    public void testValue() {
        System.out.println("Value");
        int firstRow = 0;
        int rows = 2;
        int firstColumn = 4;
        int columns = 2;
        Complex value = Complex.RealNumber(2.718281828);
        Complex[][] values = new Complex[rows][columns];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                values[r][c] = value;
        MatrixComplex expResult = new MatrixComplex(firstRow, firstColumn, values);
        MatrixComplex result = MatrixComplex.Value(
                firstRow, rows, firstColumn, columns, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of Value method, of class MatrixComplex, with zero rows.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testValue_RowsZero() {
        System.out.println("Value(fr, 0, fc, c, value");
        int firstRow = 0;
        int rows = 0;
        int firstColumn = 4;
        int columns = 2;
        Complex value = Complex.RealNumber(2.718281828);
        MatrixComplex.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Value method, of class MatrixComplex, with zero columns.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testValue_ColumnsZero() {
        System.out.println("Value(fr, r, fc, 0, value");
        int firstRow = 5;
        int rows = 4;
        int firstColumn = 4;
        int columns = 0;
        Complex value = Complex.RealNumber(2.718281828);
        MatrixComplex.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Value method, of class MatrixComplex, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_ValueNull() {
        System.out.println("Value(fr, r, fc, c, null)");
        int firstRow = 0;
        int rows = 2;
        int firstColumn = 4;
        int columns = 2;
        Complex value = null;
        MatrixComplex.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Value method, of class MatrixComplex, for a Complex.NaN value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_ValueNaN() {
        System.out.println("Value(fr, r, fc, c, Complex.NaN)");
        int firstRow = 0;
        int rows = 2;
        int firstColumn = 4;
        int columns = 2;
        Complex value = Complex.NaN;
        MatrixComplex.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Value method, of class MatrixComplex, for the value Complex.Infinity.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_ValueInfinity() {
        System.out.println("Value(fr, r, fc, c, Complex.Infinity)");
        int firstRow = 0;
        int rows = 2;
        int firstColumn = 4;
        int columns = 2;
        Complex value = Complex.Infinity;
        MatrixComplex.Value(firstRow, rows, firstColumn, columns, value);
    }

    /**
     * Test of Zero method, of class MatrixComplex.
     */
    @Test
    public void testZero() {
        System.out.println("Zero");
        int firstRow = 0;
        int rows = 1;
        int firstColumn = 0;
        int columns = 1;
        Complex[][] values = new Complex[rows][columns];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[0].length; c++)
                values[r][c] = Complex.Origin;
        MatrixComplex expResult = new MatrixComplex(firstRow, firstColumn, values);
        MatrixComplex result = MatrixComplex.Zero(firstRow, rows, firstColumn, columns);
        assertEquals(expResult, result);
    }

    /**
     * Test of Zero method, of class MatrixComplex, with zero rows.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testZero_RowsZero() {
        System.out.println("Zero(fr, 0, fc, c)");
        int firstRow = 0;
        int rows = 0;
        int firstColumn = 0;
        int columns = 1;
        MatrixComplex.Zero(firstRow, rows, firstColumn, columns);
    }

    /**
     * Test of Zero method, of class MatrixComplex, with zero columns.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testZero_ColumnsZero() {
        System.out.println("Zero(fr, r, fc, 0)");
        int firstRow = 0;
        int rows = 1;
        int firstColumn = 0;
        int columns = 0;
        MatrixComplex.Zero(firstRow, rows, firstColumn, columns);
    }
}