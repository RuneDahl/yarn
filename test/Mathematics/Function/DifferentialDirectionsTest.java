/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the enum Mathematics.Function.DifferentialDirections.
 * @author Rune Dahl Iversen
 */
public class DifferentialDirectionsTest {
    private DifferentialDirections _cen;
    private DifferentialDirections _neg;
    private DifferentialDirections _pos;

    public DifferentialDirectionsTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.DifferentialDirections");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._cen = DifferentialDirections.Central;
        this._neg = DifferentialDirections.Negative;
        this._pos = DifferentialDirections.Positive;
    }

    @After
    public void tearDown() {
        this._cen = null;
        this._neg = null;
        this._pos = null;
    }

    /**
     * Test of values method, of class DifferentialDirections.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        DifferentialDirections[] expResult = new DifferentialDirections[3];
        expResult[0] = DifferentialDirections.Negative;
        expResult[1] = DifferentialDirections.Central;
        expResult[2] = DifferentialDirections.Positive;
        DifferentialDirections[] result = DifferentialDirections.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class DifferentialDirections.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "Negative";
        DifferentialDirections expResult = DifferentialDirections.Negative;
        DifferentialDirections result = DifferentialDirections.valueOf(name);
        assertEquals("Wrong valueOf from the name: " + name, expResult, result);

        name = "Central";
        expResult = DifferentialDirections.Central;
        result = DifferentialDirections.valueOf(name);
        assertEquals("Wrong valueOf from the name: " + name, expResult, result);

        name = "Positive";
        expResult = DifferentialDirections.Positive;
        result = DifferentialDirections.valueOf(name);
        assertEquals("Wrong valueOf from the name: " + name, expResult, result);
    }

    /**
     * Test of valueOf method, of class DifferentialDirections,
     * for a value with the wrong casing.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValueOf_WrongCase() {
        System.out.println("valueOf(wrong case)");
        String name = "negative";
        DifferentialDirections.valueOf(name);
    }

    /**
     * Test of valueOf method, of class DifferentialDirections,
     * for a value with the wrong letters.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValueOf_WrongLetters() {
        System.out.println("valueOf(wrong letters)");
        String name = "testFailExpected";
        DifferentialDirections.valueOf(name);
    }

    /**
     * Test of valueOf method, of class DifferentialDirections,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValueOf_Null() {
        System.out.println("valueOf(null)");
        String name = null;
        DifferentialDirections.valueOf(name);
    }

    /**
     * Test of getValue method, of class DifferentialDirections.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        DifferentialDirections instance = this._cen;
        int expResult = 0;
        int result = instance.getValue();
        assertEquals("Wrong value from " + instance.toString(), expResult, result);

        instance = this._neg;
        expResult = -1;
        result = instance.getValue();
        assertEquals("Wrong value from " + instance.toString(), expResult, result);

        instance = this._pos;
        expResult = 1;
        result = instance.getValue();
        assertEquals("Wrong value from " + instance.toString(), expResult, result);
    }
}