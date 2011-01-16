/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import java.util.Collection;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Time.Periods.Periods.
 * @author Rune Dahl Iversen
 */
public class PeriodsTest {
    private Periods<GregorianCalendar> _periods;
    private Period<GregorianCalendar> _day;
    private Period<GregorianCalendar> _hour;

    public PeriodsTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Periods.Periods");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._day = new GregorianDay(1);
        this._hour = new GregorianHour(5);
        this._periods = new Periods<GregorianCalendar>(2, this._day, this._hour);
    }

    @After
    public void tearDown() {
        this._periods = null;
    }

    /**
     * Test of ctor, of class Periods, for a null period specified.
     */
    @Test
    public void testCtor_PeriodNull() {
        System.out.println("ctor(c, null period)");
        Period per = null;
        Periods p = new Periods(2, per);
    }

    /**
     * Test of ctor, of class Periods, for a null collection of periods specified.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_CollectionNull() {
        System.out.println("ctor(c, null collection)");
        Collection<Period> per = null;
        Periods p = new Periods(2, per);
    }

    /**
     * Test of getCount method, of class Periods.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Periods instance = this._periods;
        int expResult = 2;
        int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCount method, of class Periods.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        int count = 1234;
        Periods instance = this._periods;
        int result = instance.getCount();
        assertEquals("Failed pre-condition for test of setCount", 2, result);
        instance.setCount(count);
        result = instance.getCount();
        assertEquals("Wrong value from getCount after use of setCount", 1234, result);
    }

    /**
     * Test of shift method, of class Periods.
     */
    @Test
    public void testShift() {
        System.out.println("shift");
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        Periods<GregorianCalendar> instance = this._periods;
        for (int count = -10; count < 10; count ++) {
            GregorianCalendar expResult = (GregorianCalendar)date.clone();
            int sign = (int)Math.signum(count);
            for (int i = 0; i < Math.abs(count); i++) {
                expResult.add(GregorianCalendar.DAY_OF_YEAR, sign * 2);
                expResult.add(GregorianCalendar.HOUR, sign * 10);
            }
            GregorianCalendar result = instance.shift(date, count);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of shift method, of class Periods, for a date/time value of null.
     */
    @Test (expected=NullPointerException.class)
    public void testShift_DateTimeNull() {
        System.out.println("shift(null, c)");
        GregorianCalendar date = null;
        Periods<GregorianCalendar> instance = this._periods;
        instance.shift(date, 0);
    }

    /**
     * Test of shift method, of class Periods,
     * when it contains a null period.
     */
    @Test (expected=NullPointerException.class)
    public void testShift_WithNullPeriodInside() {
        System.out.println("shift containing a null period");
        GregorianCalendar date = new GregorianCalendar();
        Periods<GregorianCalendar> instance = this._periods;
        instance.add(null);
        instance.shift(date, 1);
    }
}