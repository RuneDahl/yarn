/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

import Mathematics.Interval.EndType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the class Mathematics.IntervalReal.
 * @author Rune Dahl Iversen
 */
public class IntervalRealTest {
    private IntervalReal _normal;
    private IntervalReal _reverse;

    public IntervalRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.IntervalReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._normal = new IntervalReal(-3.0, EndType.Includes, 4.5, EndType.Excludes);
        this._reverse = new IntervalReal(4.5, EndType.Excludes, -3.0, EndType.Includes);
    }

    @After
    public void tearDown() {
        this._normal = null;
        this._reverse = null;
    }

    /**
     * Test of contains method, of class IntervalReal.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        double value = -3.5;
        IntervalReal instance = this._normal;
        for (; value < 5; value += 0.1) {
            boolean expResult = -3.0 <= value && value < 4.5;
            boolean result = instance.contains(value);
            assertEquals("Normal for the value " + Double.toString(value),
                    expResult, result);
            result = this._reverse.contains(value);
            assertFalse("Reverse for the value " + Double.toString(value),
                    result);
        }
    }

    /**
     * Test of getLowerBound method, of class IntervalReal.
     */
    @Test
    public void testGetLowerBound() {
        System.out.println("getLowerBound");
        IntervalReal instance = this._normal;
        double expResult = -3.0;
        double result = instance.getLowerBound();
        assertEquals("LowerBound from normal.", expResult, result, 0.0);

        instance = this._reverse;
        expResult = 4.5;
        result = instance.getLowerBound();
        assertEquals("LowerBound from reverse.", expResult, result, 0.0);
    }

    /**
     * Test of getLowerType method, of class IntervalReal.
     */
    @Test
    public void testGetLowerType() {
        System.out.println("getLowerType");
        IntervalReal instance = this._normal;
        EndType expResult = EndType.Includes;
        EndType result = instance.getLowerType();
        assertEquals("LowerEndType from normal.", expResult, result);

        instance = this._reverse;
        expResult = EndType.Excludes;
        result = instance.getLowerType();
        assertEquals("LowerEndType from reverse.", expResult, result);
    }

    /**
     * Test of getUpperBound method, of class IntervalReal.
     */
    @Test
    public void testGetUpperBound() {
        System.out.println("getUpperBound");
        IntervalReal instance = this._normal;
        double expResult = 4.5;
        double result = instance.getUpperBound();
        assertEquals("UpperBound from normal", expResult, result, 0.0);

        instance = this._reverse;
        expResult = -3.0;
        result = instance.getUpperBound();
        assertEquals("UpperBound from reverse", expResult, result, 0.0);
    }

    /**
     * Test of getUpperType method, of class IntervalReal.
     */
    @Test
    public void testGetUpperType() {
        System.out.println("getUpperType");
        IntervalReal instance = this._normal;
        EndType expResult = EndType.Excludes;
        EndType result = instance.getUpperType();
        assertEquals("UpperEndType from normal.", expResult, result);

        instance = this._reverse;
        expResult = EndType.Includes;
        result = instance.getUpperType();
        assertEquals("UpperEndType from reverse.", expResult, result);
    }

    /**
     * Test of setLowerBound method, of class IntervalReal.
     */
    @Test
    public void testSetLowerBound() {
        System.out.println("setLowerBound");
        double lowerBound = 7.0;
        IntervalReal instance = this._normal;
        instance.setLowerBound(lowerBound);

        double expResult = 7.0;
        double result = instance.getLowerBound();
        assertEquals("LowerBound from normal after setLowerBound.",
                expResult, result, 0.0);

    }

    /**
     * Test of setLowerType method, of class IntervalReal.
     */
    @Test
    public void testSetLowerType() {
        System.out.println("setLowerType");
        EndType lowerType = EndType.Excludes;
        IntervalReal instance = this._normal;
        instance.setLowerType(lowerType);

        EndType expResult = EndType.Excludes;
        EndType result = instance.getLowerType();
        assertEquals("LowerType from normal after setLowerType.",
                expResult, result);

        instance = this._reverse;
        instance.setLowerType(lowerType);

        expResult = EndType.Excludes;
        result = instance.getLowerType();
        assertEquals("LowerType from reverse after setLowerType.",
                expResult, result);
    }

    /**
     * Test of setUpperBound method, of class IntervalReal.
     */
    @Test
    public void testSetUpperBound() {
        System.out.println("setUpperBound");
        double upperBound = 7.0;
        IntervalReal instance = this._normal;
        instance.setUpperBound(upperBound);

        double expResult = 7.0;
        double result = instance.getUpperBound();
        assertEquals("UpperBound from normal after setUpperBound.",
                expResult, result, 0.0);
    }

    /**
     * Test of setUpperType method, of class IntervalReal.
     */
    @Test
    public void testSetUpperType() {
        System.out.println("setUpperType");
        EndType upperType = EndType.Excludes;
        IntervalReal instance = this._normal;
        instance.setUpperType(upperType);

        EndType expResult = EndType.Excludes;
        EndType result = instance.getUpperType();
        assertEquals("LowerType from normal after setLowerType.",
                expResult, result);

        instance = this._reverse;
        instance.setUpperType(upperType);

        expResult = EndType.Excludes;
        result = instance.getUpperType();
        assertEquals("LowerType from reverse after setLowerType.",
                expResult, result);
    }

    /**
     * Test of equals method, of class IntervalReal.
     */
    @Test
    public void testEquals_Object() {
        System.out.println("equals(Object)");
        Object o = Complex.Origin;
        IntervalReal instance = this._normal;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class IntervalReal.
     */
    @Test
    public void testEquals_IntervalReal() {
        System.out.println("equals");
        IntervalReal interval = this._reverse;
        IntervalReal instance = this._normal;
        boolean expResult = false;
        boolean result = instance.equals(interval);
        assertEquals(expResult, result);
        result = interval.equals(instance);
        assertEquals(expResult, result);

        interval = new IntervalReal(-3.0, EndType.Excludes, 4.5, EndType.Excludes);
        result = instance.equals(interval);
        assertEquals(expResult, result);
        result = interval.equals(instance);
        assertEquals(expResult, result);

        interval = new IntervalReal(-3.1, EndType.Includes, 4.5, EndType.Excludes);
        result = instance.equals(interval);
        assertEquals(expResult, result);
        result = interval.equals(instance);
        assertEquals(expResult, result);

        interval = new IntervalReal(-3.0, EndType.Includes, 4.4, EndType.Excludes);
        result = instance.equals(interval);
        assertEquals(expResult, result);
        result = interval.equals(instance);
        assertEquals(expResult, result);

        interval = new IntervalReal(-3.0, EndType.Includes, 4.5, EndType.Includes);
        result = instance.equals(interval);
        assertEquals(expResult, result);
        result = interval.equals(instance);
        assertEquals(expResult, result);

        expResult = true;
        interval = new IntervalReal(-3.0, EndType.Includes, 4.5, EndType.Excludes);
        result = instance.equals(interval);
        assertEquals(expResult, result);
        result = interval.equals(instance);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class IntervalReal, for the value null.
     */
    @Test
    public void testEquals_Null() {
        System.out.println("equals(null)");
        IntervalReal instance = this._normal;
        IntervalReal nullValue = null;
        boolean expResult = false;
        boolean result = instance.equals(nullValue);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class IntervalReal.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        IntervalReal instance = this._normal;
        IntervalReal interval = new IntervalReal(-3.0, EndType.Includes, 4.5, EndType.Excludes);
        int expResult = interval.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class IntervalReal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        IntervalReal instance = this._normal;
        String expResult = "[-3.0 : 4.5[";
        String result = instance.toString();
        assertEquals("toString from normal.", expResult, result);

        instance = this._reverse;
        expResult = "]4.5 : -3.0]";
        result = instance.toString();
        assertEquals("toString from reverse.", expResult, result);
    }
}