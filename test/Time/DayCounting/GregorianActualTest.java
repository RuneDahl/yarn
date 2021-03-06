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
 * Unit-test for the class GregorianActual.
 * @author Rune Dahl Iversen
 */
public class GregorianActualTest {
    private GregorianActual _actual;
    private GregorianCalendar _may9th1974;
    private GregorianCalendar _jan1st2000;
    private GregorianCalendar _feb28th2008;
    private GregorianCalendar _mar1st2008;
    private GregorianCalendar _feb28th2009;
    private GregorianCalendar _mar1st2009;

    public GregorianActualTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.DayCounting.GregorianActual");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._actual = new GregorianActual();
        this._may9th1974 = new GregorianCalendar(1974, 4, 9);
        this._jan1st2000 = new GregorianCalendar(2000, 0, 1);
        this._feb28th2008 = new GregorianCalendar(2008, 1, 28, 13, 46, 26);
        this._mar1st2008 = new GregorianCalendar(2008, 2, 1, 04, 51, 42);
        this._feb28th2009 = new GregorianCalendar(2009, 1, 28, 11, 22, 33);
        this._mar1st2009 = new GregorianCalendar(2009, 2, 1, 12, 34, 56);
    }

    @After
    public void tearDown() {
        this._actual = null;
        this._may9th1974 = null;
        this._jan1st2000 = null;
        this._mar1st2008 = null;
    }

    /**
     * Test of days method, of class GregorianActual.
     */
    @Test
    public void testDays() {
        System.out.println("days");
        GregorianActual instance = this._actual;

        double expResult = 9368.0;
        double result = instance.days(this._may9th1974, this._jan1st2000);
        assertEquals(expResult, result, 0.0);

        expResult *= -1.0;
        result = instance.days(this._jan1st2000, this._may9th1974);
        assertEquals(expResult, result, 0.0);

        expResult = 1.6286574074074025;
        result = instance.days(this._feb28th2008, this._mar1st2008);
        assertEquals(expResult, result, 0.0);

        expResult = -1.0502662037036998;
        result = instance.days(this._mar1st2009, this._feb28th2009);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of days method, of class GregorianActual, for a from null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDays_FromNull() {
        System.out.println("days(null, to)");
        GregorianActual instance = this._actual;
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
        GregorianActual instance = this._actual;
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
        GregorianActual instance = this._actual;
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
        GregorianActual instance = this._actual;
        for (int year = 1583; year < 4100; year++) {
            for (int month = 0; month < 12; month++) {
                double expResult = 0.0;
                switch (month) {
                    case 0:
                    case 2:
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                        expResult = 31.0;
                        break;
                    case 1:
                        expResult = (g.isLeapYear(year) ? 29.0 : 28.0);
                        break;
                    case 3:
                    case 5:
                    case 8:
                    case 10:
                        expResult = 30.0;
                        break;
                    default:
                        throw new IllegalArgumentException("Month out of range: " +
                                Integer.toString(month));
                }
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
        GregorianActual instance = this._actual;
        instance.month(2000, -1);
        fail("No exception thrown.");
    }

    /**
     * Test of month method, of class GregorianActual, for a month value of 12.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testMonth_Twelve() {
        System.out.println("month(12)");
        GregorianActual instance = this._actual;
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
            GregorianActual instance = new GregorianActual();
            double expResult = (g.isLeapYear(year) ? 366.0 : 365.0);
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
        GregorianActual instance = this._actual;
        String expResult = "Act";
        String result = instance.getDenominator();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumerator method, of class GregorianActual.
     */
    @Test
    public void testGetNumerator() {
        System.out.println("getNumerator");
        GregorianActual instance = this._actual;
        String expResult = "Act";
        String result = instance.getNumerator();
        assertEquals(expResult, result);
    }
}