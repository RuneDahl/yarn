/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Time.Holidays.GregorianMonthly.
 * @author Rune Dahl Iversen
 */
public class GregorianMonthlyTest {
    private GregorianMonthly _first;
    private GregorianMonthly _ninth;
    private GregorianMonthly _thirtyFirst;

    public GregorianMonthlyTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.GregorianMonthly");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._first = new GregorianMonthly(1);
        this._ninth = new GregorianMonthly(9);
        this._thirtyFirst = new GregorianMonthly(31);
    }

    @After
    public void tearDown() {
        this._first = null;
        this._ninth = null;
        this._thirtyFirst = null;
    }

    /**
     * Test of getDate method, of class GregorianMonthly.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        GregorianMonthly instance = this._first;
        int expResult = 1;
        int result = instance.getDate();
        assertEquals(expResult, result);

        instance = this._ninth;
        expResult = 9;
        result = instance.getDate();
        assertEquals(expResult, result);

        instance = this._thirtyFirst;
        expResult = 31;
        result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class GregorianMonthly.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        GregorianMonthly instance = this._first;
        for (int date = 1; date < 32; date++) {
            instance.setDate(date);
            assertEquals(date, instance.getDate());
        }
    }

    /**
     * Test of setDate method, of class GregorianMonthly, for the value 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetDate_Zero() {
        System.out.println("setDate(0)");
        GregorianMonthly instance = this._first;
        instance.setDate(0);
        fail("No exception thrown.");
    }

    /**
     * Test of setDate method, of class GregorianMonthly, for the value 32.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetDate_ThirtySecond() {
        System.out.println("setDate(32)");
        GregorianMonthly instance = this._first;
        instance.setDate(32);
        fail("No exception thrown.");
    }

    /**
     * Test of getHoliday method, of class GregorianMonthly.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        for (int year = 2000; year < 2010; year++) {
            for (int month = 0; month < 12; month++) {
                GregorianMonthly instance = this._first;
                GregorianCalendar expResult = new GregorianCalendar(year, month, 1);
                GregorianCalendar result = instance.getHoliday(year, month);
                assertEquals(expResult, result);

                instance = this._ninth;
                expResult = new GregorianCalendar(year, month, 9);
                result = instance.getHoliday(year, month);
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of getHoliday method, of class GregorianMonthly,
     * for an invalid/non-existing holiday.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_InvalidHoliday() {
        System.out.println("getHoliday from invalid/non-existing holiday");
        int year = 2000;
        int month = 1;
        GregorianMonthly instance = this._thirtyFirst;
        instance.getHoliday(year, month);
        fail("No exception thrown.");
    }

    /**
     * Test of occurs method, of class GregorianMonthly.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        for (int year = 1900; year < 2010; year++) {
            for (int month = 0; month < 12; month++) {
                GregorianMonthly instance = this._first;
                boolean expResult = true;
                boolean result = instance.occurs(year, month);
                assertEquals(expResult, result);

                instance = this._ninth;
                result = instance.occurs(year, month);
                assertEquals(expResult, result);

                instance = this._thirtyFirst;
                expResult = true;
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 8:
                    case 10:
                        expResult = false;
                        break;
                    default:
                        expResult = true;
                        break;
                }
                result = instance.occurs(year, month);
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of isHoliday method, of class GregorianMonthly.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 10000; i++) {
            GregorianMonthly instance = this._first;
            boolean expResult = date.get(GregorianCalendar.DAY_OF_MONTH) == 1;
            boolean result = instance.isHoliday(date);
            assertEquals(expResult, result);

            instance = this._ninth;
            expResult = date.get(GregorianCalendar.DAY_OF_MONTH) == 9;
            result = instance.isHoliday(date);
            assertEquals(expResult, result);

            instance = this._thirtyFirst;
            expResult = date.get(GregorianCalendar.DAY_OF_MONTH) == 31;
            result = instance.isHoliday(date);
            assertEquals(expResult, result);
        }
    }
}