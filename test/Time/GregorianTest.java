/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of the class Time.Gregorian.
 * @author Rune Dahl Iversen
 */
public class GregorianTest {

    public GregorianTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of belowDateDifference method, of class Gregorian.
     */
    @Test
    public void testBelowDateDifference() {
        System.out.println("belowDateDifference");
        GregorianCalendar from = new GregorianCalendar(2000, 0, 1, 0, 0, 0);
        GregorianCalendar to = new GregorianCalendar(2000, 0, 1, 0, 0, 0);
        double expResult = 0.0;
        double result = Gregorian.belowDateDifference(from, to);
        assertEquals("For equal dates.", expResult, result, 0.0);

        to.add(GregorianCalendar.YEAR, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding a year.", expResult, result, 0.0);

        to.add(GregorianCalendar.MONTH, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding a month.", expResult, result, 0.0);
        
        to.add(GregorianCalendar.DAY_OF_YEAR, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding a day.", expResult, result, 0.0);

        expResult += 1.0/24.0;
        to.add(GregorianCalendar.HOUR, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding an hour.", expResult, result, 0.0);

        expResult += 1.0/(24.0*60.0);
        to.add(GregorianCalendar.MINUTE, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding a minute.", expResult, result, 0.0);

        expResult += 1.0/(24.0*60.0*60.0);
        to.add(GregorianCalendar.SECOND, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding a second.", expResult, result, Math.pow(10.0, -17.0));

        expResult += 1.0/(24.0*60.0*60.0*1000.0);
        to.add(GregorianCalendar.MILLISECOND, 1);
        result = Gregorian.belowDateDifference(from, to);
        assertEquals("After adding a milli-second.", expResult, result, Math.pow(10.0, -17.0));
    }

    /**
     * Test of belowDateDifference method, of class Gregorian, for both input null.
     */
    @Test (expected=NullPointerException.class)
    public void testBelowDateDifferenceBothNull() {
        System.out.println("belowDateDifference(null, null)");
        double result = Gregorian.belowDateDifference(null, null);
        fail("No exception thrown.");
    }

    /**
     * Test of belowDateDifference method, of class Gregorian, for from null.
     */
    @Test (expected=NullPointerException.class)
    public void testBelowDateDifferenceFromNull() {
        System.out.println("belowDateDifference(null, x)");
        double result = Gregorian.belowDateDifference(null, new GregorianCalendar());
        fail("No exception thrown.");
    }

    /**
     * Test of belowDateDifference method, of class Gregorian, for from null.
     */
    @Test (expected=NullPointerException.class)
    public void testBelowDateDifferenceToNull() {
        System.out.println("belowDateDifference(x, null)");
        double result = Gregorian.belowDateDifference(new GregorianCalendar(), null);
        fail("No exception thrown.");
    }

    /**
     * Test of isLeapYear method, of class Gregorian, for an integer.
     */
    @Test
    public void testIsLeapYear_int() {
        System.out.println("isLeapYear(int)");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = 1582; year < 2101; year++){
            boolean expResult = g.isLeapYear(year);
            boolean result = Gregorian.isLeapYear(year);
            assertEquals(Integer.toString(year) + " wrong on leap-year status.",
                    expResult, result);
        }
    }

    /**
     * Test of isLeapYear method, of class Gregorian, for a GregorianCalendar.
     */
    @Test
    public void testIsLeapYear_GregorianCalendar() {
        System.out.println("isLeapYear(GregorianCalendar)");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = 1582; year < 2101; year++){
            boolean expResult = g.isLeapYear(year);
            boolean result = Gregorian.isLeapYear(new GregorianCalendar(year, 1, 1));
            assertEquals(Integer.toString(year) + " wrong on leap-year status.",
                    expResult, result);
        }
    }

    /**
     * Test of isLeapYear method, of class Gregorian, for the values null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsLeapYear_Null() {
        System.out.println("isLeapYear(null)");
        GregorianCalendar date = null;
        boolean result = Gregorian.isLeapYear(date);
        fail("No exception thrown.");
    }

    /**
     * Test of lengthOfMonth method, of class Gregorian.
     */
    @Test
    public void testLengthOfMonth() {
        System.out.println("lengthOfMonth");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = 1582; year < 2101; year++){
            for (int month = 0; month < 12; month++) {
                double expResult = 0.0;
                switch (month)
                {
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
                        expResult = (Gregorian.isLeapYear(year) ? 29.0 : 28.0);
                        break;
                    case 3:
                    case 5:
                    case 8:
                    case 10:
                        expResult = 30.0;
                        break;
                }
                double result = Gregorian.lengthOfMonth(year, month);
                assertEquals(Integer.toString(year) + ":" + Integer.toString(month) +
                        " wrong length of month.",
                        expResult, result, 0.0);
            }
        }
    }

    /**
     * Test of lengthOfYear method, of class Gregorian.
     */
    @Test
    public void testLengthOfYear() {
        System.out.println("lengthOfYear");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = 1582; year < 2101; year++){
            double expResult = (g.isLeapYear(year) ? 366.0 : 365.0);
            double result = Gregorian.lengthOfYear(year);
            assertEquals(Integer.toString(year) + " wrong length of year.",
                    expResult, result, 0.0);
        }
    }

    /**
     * Test of max method, of class Gregorian.
     */
    @Test
    public void testMax() {
        System.out.println("max");
        GregorianCalendar date1 = new GregorianCalendar(2000, 1, 1);
        GregorianCalendar date2 = new GregorianCalendar(2001, 1, 1);
        GregorianCalendar expResult = new GregorianCalendar(2001, 1, 1);
        GregorianCalendar result = Gregorian.max(date1, date2);
        assertEquals(expResult, result);
        result = Gregorian.max(date2, date1);
        assertEquals(expResult, result);
    }

    /**
     * Test of max method, of class Gregorian, with both input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMaxBothNull() {
        System.out.println("max(null, null)");
        GregorianCalendar result = Gregorian.max(null, null);
        fail("No exception thrown.");
    }

    /**
     * Test of max method, of class Gregorian, with first input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMaxNull1() {
        System.out.println("max(null, x)");
        GregorianCalendar result = Gregorian.max(null, new GregorianCalendar());
        fail("No exception thrown.");
    }

    /**
     * Test of max method, of class Gregorian, with second input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMaxNull2() {
        System.out.println("max(x, null)");
        GregorianCalendar result = Gregorian.max(new GregorianCalendar(), null);
        fail("No exception thrown.");
    }

    /**
     * Test of min method, of class Gregorian.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        GregorianCalendar date1 = new GregorianCalendar(2000, 1, 1);
        GregorianCalendar date2 = new GregorianCalendar(2001, 1, 1);
        GregorianCalendar expResult = new GregorianCalendar(2000, 1, 1);
        GregorianCalendar result = Gregorian.min(date1, date2);
        assertEquals(expResult, result);
        result = Gregorian.min(date2, date1);
        assertEquals(expResult, result);
    }

    /**
     * Test of min method, of class Gregorian, with both input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testminBothNull() {
        System.out.println("min(null, null)");
        GregorianCalendar result = Gregorian.min(null, null);
        fail("No exception thrown.");
    }

    /**
     * Test of min method, of class Gregorian, with first input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testminNull1() {
        System.out.println("min(null, x)");
        GregorianCalendar result = Gregorian.min(null, new GregorianCalendar());
        fail("No exception thrown.");
    }

    /**
     * Test of min method, of class Gregorian, with second input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testminNull2() {
        System.out.println("min(x, null)");
        GregorianCalendar result = Gregorian.min(new GregorianCalendar(), null);
        fail("No exception thrown.");
    }
}