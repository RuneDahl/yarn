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
 * jUnit-test of the class Time.Julian.
 * @author Rune Dahl Iversen
 */
public class JulianTest {
    public JulianTest() {
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
     * Test of isLeapYear method, of class Julian.
     */
    @Test
    public void testIsLeapYear_int() {
        System.out.println("isLeapYear(int)");
        for (int year = -45; year < 2101; year++) {
            boolean expResult = year %4 == 0;
            boolean result = Julian.isLeapYear(year);
            assertEquals("Wrong leap-year status for the year: " +
                    Integer.toString(year), expResult, result);
        }
    }

    /**
     * Test of isLeapYear method, of class Julian.
     */
    @Test
    public void testIsLeapYear_GregorianCalendar() {
        System.out.println("isLeapYear(GregorianCalendar)");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = 1; year < 2101; year++){
            boolean expResult = year % 4 == 0;
            boolean result = Julian.isLeapYear(new GregorianCalendar(year, 1, 1));
            assertEquals(Gregorian.toString(new GregorianCalendar(year, 1, 1)) +
                    " wrong on leap-year status.", expResult, result);
        }
    }

    /**
     * Test of isLeapYear method, of class Julian, for the values null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsLeapYear_Null() {
        System.out.println("isLeapYear(null)");
        GregorianCalendar date = null;
        Julian.isLeapYear(date);
    }

    /**
     * Test of lengthOfMonth method, of class Julian.
     */
    @Test
    public void testLengthOfMonth() {
        System.out.println("lengthOfMonth");
        for (int year = -45; year < 2101; year++){
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
                        expResult = (Julian.isLeapYear(year) ? 29.0 : 28.0);
                        break;
                    case 3:
                    case 5:
                    case 8:
                    case 10:
                        expResult = 30.0;
                        break;
                    default:
                        throw new IndexOutOfBoundsException("Index for the " +
                                "month is out of range.");
                }
                double result = Julian.lengthOfMonth(year, month);
                assertEquals(Integer.toString(year) + ":" + Integer.toString(month) +
                        " wrong length of month.",
                        expResult, result, 0.0);
            }
        }
    }

    /**
     * Test of lengthOfMonth method, of class Julian, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testLengthOfMonth_MinusOne() {
        System.out.println("lengthOfMonth(-1)");
        Julian.lengthOfMonth(2000, -1);
    }

    /**
     * Test of lengthOfMonth method, of class Julian, for the value 12.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testLengthOfMonth_Twelve() {
        System.out.println("lengthOfMonth(12)");
        Julian.lengthOfMonth(2000, 12);
    }

    /**
     * Test of lengthOfYear method, of class Julian.
     */
    @Test
    public void testLengthOfYear() {
        System.out.println("lengthOfYear");
        GregorianCalendar g = new GregorianCalendar();
        for (int year = -45; year < 2101; year++){
            double expResult = (Julian.isLeapYear(year) ? 366.0 : 365.0);
            double result = Julian.lengthOfYear(year);
            assertEquals(Integer.toString(year) + " wrong length of year.",
                    expResult, result, 0.0);
        }
    }
}
