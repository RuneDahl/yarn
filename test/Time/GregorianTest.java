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
    public GregorianTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Gregorian");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() { // Intentional
    }

    @After
    public void tearDown() { // Intentional
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
    public void testBelowDateDifference_BothNull() {
        System.out.println("belowDateDifference(null, null)");
        Gregorian.belowDateDifference(null, null);
    }

    /**
     * Test of belowDateDifference method, of class Gregorian, for from null.
     */
    @Test (expected=NullPointerException.class)
    public void testBelowDateDifference_FromNull() {
        System.out.println("belowDateDifference(null, x)");
        Gregorian.belowDateDifference(null, new GregorianCalendar());
    }

    /**
     * Test of belowDateDifference method, of class Gregorian, for from null.
     */
    @Test (expected=NullPointerException.class)
    public void testBelowDateDifference_ToNull() {
        System.out.println("belowDateDifference(x, null)");
        Gregorian.belowDateDifference(new GregorianCalendar(), null);
    }

    /**
     * Test of belowDateDifference method, of class Gregorian.
     */
    @Test
    public void testCorrectionInDaysFromJulianToGregorian() {
        System.out.println("correctionInDaysFromJulianToGregorian");
        for (int year = 1582; year < 4100; year++) {
            int result = Gregorian.correctionInDaysFromJulianToGregorian(year);
            int expResult = 10;
            if (1700 <= year)
                expResult++;
            if (1800 <= year)
                expResult++;
            if (1900 <= year)
                expResult++;
            if (2100 <= year)
                expResult++;
            if (2200 <= year)
                expResult++;
            if (2300 <= year)
                expResult++;
            if (2500 <= year)
                expResult++;
            if (2600 <= year)
                expResult++;
            if (2700 <= year)
                expResult++;
            if (2900 <= year)
                expResult++;
            if (3000 <= year)
                expResult++;
            if (3100 <= year)
                expResult++;
            if (3300 <= year)
                expResult++;
            if (3400 <= year)
                expResult++;
            if (3500 <= year)
                expResult++;
            if (3700 <= year)
                expResult++;
            if (3800 <= year)
                expResult++;
            if (3900 <= year)
                expResult++;
            assertEquals("Failed computation of days to add for the year: " +
                    Integer.toString(year), expResult, result);
        }
    }

    /**
     * Test of belowDateDifference method, of class Gregorian, for the year 1581.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testCorrectionInDaysFromJulianToGregorian_1581() {
        System.out.println("correctionInDaysFromJulianToGregorian(1581)");
        Gregorian.correctionInDaysFromJulianToGregorian(1581);
    }

    /**
     * Test of belowDateDifference method, of class Gregorian.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testCorrectionInDaysFromJulianToGregorian_4100() {
        System.out.println("correctionInDaysFromJulianToGregorian(4100)");
        Gregorian.correctionInDaysFromJulianToGregorian(4100);
    }

    /**
     * Test of date method, of class Gregorian.
     */
    @Test
    public void testDate() {
        System.out.println("date");
        GregorianCalendar dateTime = new GregorianCalendar();
        GregorianCalendar result = Gregorian.date(dateTime);
        int year = dateTime.get(GregorianCalendar.YEAR);
        int month = dateTime.get(GregorianCalendar.MONTH);
        int dayOfMonth = dateTime.get(GregorianCalendar.DAY_OF_MONTH);
        GregorianCalendar expResult = new GregorianCalendar(year, month, dayOfMonth);
        assertEquals(expResult, result);
    }

    /**
     * Test of date method, of class Gregorian, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDate_Null() {
        System.out.println("date(null)");
        GregorianCalendar dateTime = null;
        Gregorian.date(dateTime);
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
        Gregorian.isLeapYear(date);
    }

    /**
     * Test of lengthOfMonth method, of class Gregorian.
     */
    @Test
    public void testLengthOfMonth() {
        System.out.println("lengthOfMonth");
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
                    default:
                        throw new IndexOutOfBoundsException("Index for the " +
                                "month is out of range.");
                }
                double result = Gregorian.lengthOfMonth(year, month);
                assertEquals(Integer.toString(year) + ":" + Integer.toString(month) +
                        " wrong length of month.",
                        expResult, result, 0.0);
            }
        }
    }

    /**
     * Test of lengthOfMonth method, of class Gregorian, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testLengthOfMonth_MinusOne() {
        System.out.println("lengthOfMonth(-1)");
        Gregorian.lengthOfMonth(2000, -1);
    }

    /**
     * Test of lengthOfMonth method, of class Gregorian, for the value 12.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testLengthOfMonth_Twelve() {
        System.out.println("lengthOfMonth(12)");
        Gregorian.lengthOfMonth(2000, 12);
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
    public void testMax_BothNull() {
        System.out.println("max(null, null)");
        Gregorian.max(null, null);
    }

    /**
     * Test of max method, of class Gregorian, with first input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMax_Null1() {
        System.out.println("max(null, x)");
        Gregorian.max(null, new GregorianCalendar());
    }

    /**
     * Test of max method, of class Gregorian, with second input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMax_Null2() {
        System.out.println("max(x, null)");
        Gregorian.max(new GregorianCalendar(), null);
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
    public void testMin_BothNull() {
        System.out.println("min(null, null)");
        Gregorian.min(null, null);
    }

    /**
     * Test of min method, of class Gregorian, with first input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMin_Null1() {
        System.out.println("min(null, x)");
        Gregorian.min(null, new GregorianCalendar());
    }

    /**
     * Test of min method, of class Gregorian, with second input as null.
     */
    @Test (expected=NullPointerException.class)
    public void testMin_Null2() {
        System.out.println("min(x, null)");
        Gregorian.min(new GregorianCalendar(), null);
    }

    /**
     * Test of toString method, of class Gregorian, for a null value.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GregorianCalendar date = new GregorianCalendar(2010, 3, 23, 12, 34, 56);
        date.add(GregorianCalendar.MILLISECOND, 789);
        String result = Gregorian.toString(date);
        String expResult = "2010-04-23 12:34:56.789";
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Gregorian, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testToString_Null() {
        System.out.println("toString(null)");
        Gregorian.toString(null);
    }
}