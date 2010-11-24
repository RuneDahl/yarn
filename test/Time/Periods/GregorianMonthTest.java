/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Time.Periods.GregorianMonth.
 * @author Rune Dahl Iversen
 */
public class GregorianMonthTest {
    private GregorianMonth _negativeOne;
    private GregorianMonth _one;
    private GregorianMonth _two;

    public GregorianMonthTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._negativeOne = new GregorianMonth(-1);
        this._one = new GregorianMonth(1);
        this._two = new GregorianMonth(2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCount method, of class GregorianMonth.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        assertEquals(-1, this._negativeOne.getCount());
        assertEquals(1, this._one.getCount());
        assertEquals(2, this._two.getCount());
    }

    /**
     * Test of setCount method, of class GregorianMonth.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        int count = 17;

        this._negativeOne.setCount(count);
        this._one.setCount(count);
        this._two.setCount(count);

        assertEquals(17, this._negativeOne.getCount());
        assertEquals(17, this._one.getCount());
        assertEquals(17, this._two.getCount());
    }

    /**
     * Test of shift method, of class GregorianMonth.
     */
    @Test
    public void testShift() {
        System.out.println("shift");
        GregorianCalendar date = new GregorianCalendar(2000, 2, 1);
        int count = 15;
        GregorianCalendar expResult = new GregorianCalendar(1998, 11, 1);
        GregorianCalendar result = this._negativeOne.shift(date, count);
        assertEquals(expResult, result);

        expResult = new GregorianCalendar(2001, 5, 1);
        result = this._one.shift(date, count);
        assertEquals(expResult, result);

        expResult = new GregorianCalendar(2002, 8, 1);
        result = this._two.shift(date, count);
        assertEquals(expResult, result);
    }

    /**
     * Test of shift method, of class GregorianMonth, for a null date.
     */
    @Test (expected=NullPointerException.class)
    public void testShift_NullDate() {
        System.out.println("shift(null ,i)");
        int count = 15;
        GregorianCalendar result = this._negativeOne.shift(null, count);
        fail("No exception thrown.");
    }
}