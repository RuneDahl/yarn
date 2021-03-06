/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.DayCounting;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class GregorianUS30.
 * @author Rune Dahl Iversen
 */
public class GregorianUS30Test {
    private GregorianUS30 _us30;
    private GregorianCalendar _may9th1974;
    private GregorianCalendar _jan1st2000;
    private GregorianCalendar _feb28th2008;
    private GregorianCalendar _mar1st2008;
    private GregorianCalendar _feb28th2009;
    private GregorianCalendar _mar1st2009;
    private GregorianCalendar _mar31st2009;
    private GregorianCalendar _mar31st2010;

    public GregorianUS30Test() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.DayCounting.GregorianUS30");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._us30 = new GregorianUS30();
        this._may9th1974 = new GregorianCalendar(1974, 4, 9);
        this._jan1st2000 = new GregorianCalendar(2000, 0, 1);
        this._feb28th2008 = new GregorianCalendar(2008, 1, 28, 13, 46, 26);
        this._mar1st2008 = new GregorianCalendar(2008, 2, 1, 04, 51, 42);
        this._feb28th2009 = new GregorianCalendar(2009, 1, 28, 11, 22, 33);
        this._mar1st2009 = new GregorianCalendar(2009, 2, 1, 12, 34, 56);
        this._mar31st2009 = new GregorianCalendar(2009, 2, 31, 12, 34, 56);
        this._mar31st2010 = new GregorianCalendar(2010, 2, 31, 12, 34, 56);
    }

    @After
    public void tearDown() {
        this._us30 = null;
        this._may9th1974 = null;
        this._jan1st2000 = null;
        this._feb28th2008 = null;
        this._mar1st2008 = null;
        this._feb28th2009 = null;
        this._mar1st2009 = null;
        this._mar31st2009 = null;
        this._mar31st2010 = null;
    }

    /**
     * Test of days method, of class GregorianActual.
     */
    @Test
    public void testDays() {
        System.out.println("days");
        GregorianUS30 instance = this._us30;

        double expResult = 9232.0;
        double result = instance.days(this._may9th1974, this._jan1st2000);
        assertEquals(expResult, result, 0.0);

        expResult *= -1.0;
        result = instance.days(this._jan1st2000, this._may9th1974);
        assertEquals(expResult, result, 0.0);

        expResult = 2.628657407407406;
        result = instance.days(this._feb28th2008, this._mar1st2008);
        assertEquals(expResult, result, 0.0);

        expResult = -3.0502662037037034;
        result = instance.days(this._mar1st2009, this._feb28th2009);
        assertEquals(expResult, result, 0.0);

        expResult = 750.3216898148148;
        result = instance.days(this._mar1st2008, this._mar31st2010);
        assertEquals(expResult, result, 0.0);

        expResult = 360;
        result = instance.days(this._mar31st2009, this._mar31st2010);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of days method, of class GregorianActual, for a from null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDays_FromNull() {
        System.out.println("days(null, to)");
        GregorianUS30 instance = this._us30;
        GregorianCalendar nullValue = null;
        instance.days(this._may9th1974, nullValue);
        fail("No exception thrown.");
    }

    /**
     * Test of days method, of class GregorianActual, for a to null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDays_ToNull() {
        System.out.println("days(from, null)");
        GregorianUS30 instance = this._us30;
        GregorianCalendar nullValue = null;
        instance.days(this._may9th1974, nullValue);
        fail("No exception thrown.");
    }

    /**
     * Test of days method, of class GregorianActual, for both null values.
     */
    @Test (expected=NullPointerException.class)
    public void testDays_BothNull() {
        System.out.println("days(null, null)");
        GregorianUS30 instance = this._us30;
        GregorianCalendar nullValue = null;
        instance.days(nullValue, nullValue);
        fail("No exception thrown.");
    }

    /**
     * Test of month method, of class GregorianActual.
     */
    @Test
    public void testMonth() {
        System.out.println("month");
        GregorianCalendar g = new GregorianCalendar();
        GregorianUS30 instance = this._us30;
        for (int year = 1583; year < 4100; year++) {
            for (int month = 0; month < 12; month++) {
                double expResult = 30.0;
                Double result = instance.month(year, month);
                assertEquals("Failure for year " + Integer.toString(year) +
                        " and month " + Integer.toString(month),
                        expResult, result, 0.0);
            }
        }
    }

    /**
     * Test of month method, of class GregorianActual, for a month value of -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testMonth_NegativeOne() {
        System.out.println("month(-1)");
        GregorianUS30 instance = this._us30;
        instance.month(2000, -1);
        fail("No exception thrown.");
    }

    /**
     * Test of month method, of class GregorianActual, for a month value of 12.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testMonth_Twelve() {
        System.out.println("month(12)");
        GregorianUS30 instance = this._us30;
        instance.month(2000, 12);
        fail("No exception thrown.");
    }

    /**
     * Test of year method, of class GregorianActual.
     */
    @Test
    public void testYear() {
        System.out.println("year");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = 1583; year < 4100; year++) {
            GregorianUS30 instance = new GregorianUS30();
            double expResult = 360;
            double result = instance.year(year);
            assertEquals("Failure for year " + Integer.toString(year),
                    expResult, result, 0.0);
        }
    }

    /**
     * Test of getDenominator method, of class GregorianActual.
     */
    @Test
    public void testGetDenominator() {
        System.out.println("getDenominator");
        GregorianUS30 instance = this._us30;
        String expResult = "360";
        String result = instance.getDenominator();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumerator method, of class GregorianActual.
     */
    @Test
    public void testGetNumerator() {
        System.out.println("getNumerator");
        GregorianUS30 instance = this._us30;
        String expResult = "30U";
        String result = instance.getNumerator();
        assertEquals(expResult, result);
    }
}