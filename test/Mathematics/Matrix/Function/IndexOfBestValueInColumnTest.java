/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Function;

import Mathematics.Function.Function;
import Mathematics.Function.Operator;
import Mathematics.Matrix.Matrix;
import Mathematics.Matrix.MatrixReal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-testing for the class
 * Mathematics.Matrix.Function.IndexOfBestValueInColumn<T>.
 * The unit-tests are implemented for the type Double.
 * @author Rune Dahl Iversen
 */
public class IndexOfBestValueInColumnTest {
    private IndexOfBestValueInColumn<Double> _instance;
    private Operator<Double, Double, Boolean> _comparer;
    private Matrix<Double> _input;

    public IndexOfBestValueInColumnTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._input = MatrixReal.Identity(1, 4);
        this._input.setValue(2, 1, 2.0);
        this._input.setValue(3, 1, -3.0);
        this._input.setValue(4, 1, 4.0);
        this._input.setValue(1, 2, -2.0);
        this._input.setValue(3, 2, 4.0);
        this._input.setValue(4, 2, -3.0);
        this._input.setValue(1, 3, 3.0);
        this._input.setValue(2, 3, -4.0);
        this._input.setValue(4, 3, 2.0);
        this._input.setValue(1, 4, -4.0);
        this._input.setValue(2, 4, 3.0);
        this._input.setValue(3, 4, -2.0);

        this._comparer = new LargestAbsoluteValue();
        this._instance = new IndexOfBestValueInColumn<Double>(1, 2, 4, this._comparer);
    }

    @After
    public void tearDown() {
        this._input = null;
        this._instance = null;
    }

    /**
     * Test of getColumn method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        int expResult = 1;
        int result = this._instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColumn method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        this._instance.setColumn(2);
        int expResult = 2;
        int result = this._instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getComparer method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testGetComparer() {
        System.out.println("getComparer");
        Operator<Double, Double, Boolean> expResult = this._comparer;
        Operator<Double, Double, Boolean> result = this._instance.getComparer();
        assertSame(expResult, result);
    }

    /**
     * Test of setComparer method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testSetComparer() {
        System.out.println("setComparer");
        Operator<Double, Double, Boolean> comparer = this._instance.getComparer();
        this._instance.setComparer(new LargestAbsoluteValue());
        assertNotSame(comparer, this._instance.getComparer());
    }

    /**
     * Test of setComparer method, of class IndexOfLargestAbsoluteRealInColumn,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetComparer_Null() {
        System.out.println("setComparer(null)");
        this._instance.setComparer(null);
    }

    /**
     * Test of getLowerRowBound method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testGetLowerRowBound() {
        System.out.println("getLowerRowBound");
        int expResult = 2;
        int result = this._instance.getLowerRowBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLowerRowBound method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testSetLowerRowBound() {
        System.out.println("setLowerRowBound");
        this._instance.setLowerRowBound(3);
        int expResult = 3;
        int result = this._instance.getLowerRowBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUpperRowBound method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testGetUpperRowBound() {
        System.out.println("fetUpperRowBound");
        int expResult = 4;
        int result = this._instance.getUpperRowBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUpperRowBound method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testSetUpperRowBound() {
        System.out.println("setUpperRowBound");
        this._instance.setUpperRowBound(1);
        int expResult = 1;
        int result = this._instance.getUpperRowBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        int expResult = 4;
        Function<Matrix<Double>, Integer> instance = this._instance;
        int result = instance.value(this._input);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testValue2() {
        System.out.println("value");
        int expResult = 3;
        this._instance.setColumn(2);
        int result = this._instance.value(this._input);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testValue3() {
        System.out.println("value");
        int expResult = 2;
        this._instance.setColumn(3);
        int result = this._instance.value(this._input);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn.
     */
    @Test
    public void testValue4() {
        System.out.println("value");
        int expResult = 2;
        this._instance.setColumn(4);
        int result = this._instance.value(this._input);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Matrix<Double> matrix = null;
        this._instance.value(matrix);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn,
     * having reversed row bounds.
     */
    @Test (expected=IllegalStateException.class)
    public void testValue_RowBoundsReversed() {
        System.out.println("value(row bounds reversed)");
        this._instance.setUpperRowBound(1);
        this._instance.value(this._input);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn,
     * with row bounds out of range relative to the input.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_LowerRowBoundOutOfRange() {
        System.out.println("value(lower row bound out of range)");
        this._instance.setLowerRowBound(0);
        this._instance.value(this._input);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn,
     * with row bounds out of range relative to the input.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_UpperRowBoundOutOfRange() {
        System.out.println("value(upper row bound out of range)");
        this._instance.setUpperRowBound(5);
        this._instance.value(this._input);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn,
     * with row bounds out of range relative to the input.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_ColumnTooLow() {
        System.out.println("value(column index too low)");
        this._instance.setColumn(0);
        this._instance.value(this._input);
    }

    /**
     * Test of value method, of class IndexOfLargestAbsoluteRealInColumn,
     * with row bounds out of range relative to the input.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_ColumnTooHigh() {
        System.out.println("value(column index too high)");
        this._instance.setColumn(5);
        this._instance.value(this._input);
    }

    private final class LargestAbsoluteValue
            implements Operator<Double, Double, Boolean> {
        @Override
        public Boolean value(Double firstInput, Double secondInput) {
            return Math.abs(firstInput) < Math.abs(secondInput);
        }
    }
}
