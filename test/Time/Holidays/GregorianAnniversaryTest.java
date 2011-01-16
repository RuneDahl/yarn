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
 * Unit-test for the class Time.Holidays.GregorianAnniversary.
 * @author Rune Dahl Iversen
 */
public class GregorianAnniversaryTest {
    private GregorianAnniversary _mayNinth;
    private GregorianAnniversary _februaryThirtyFirst;

    public GregorianAnniversaryTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.GregorianAnniversary");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._mayNinth = new GregorianAnniversary(4, 9);
        this._februaryThirtyFirst = new GregorianAnniversary(1, 31);
    }

    @After
    public void tearDown() {
        this._mayNinth = null;
        this._februaryThirtyFirst = null;
    }

    /**
     * Test of getDate method, of class GregorianAnniversary.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        GregorianAnniversary instance = this._mayNinth;
        int expResult = 9;
        int result = instance.getDate();
        assertEquals(expResult, result);

        instance = this._februaryThirtyFirst;
        expResult = 31;
        result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class GregorianAnniversary.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        GregorianAnniversary instance = this._mayNinth;
        int expResult = 4;
        int result = instance.getMonth();
        assertEquals(expResult, result);

        instance = this._februaryThirtyFirst;
        expResult = 1;
        result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class GregorianAnniversary.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        int date = 15;
        GregorianAnniversary instance = this._mayNinth;
        instance.setDate(date);
        assertEquals(15, instance.getDate());

        instance = this._februaryThirtyFirst;
        instance.setDate(date);
        assertEquals(15, instance.getDate());
    }

    /**
     * Test of setDate method, of class GregorianAnniversary,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetDate_Zero() {
        System.out.println("setDate(0)");
        int date = 0;
        GregorianAnniversary instance = this._mayNinth;
        instance.setDate(date);
    }

    /**
     * Test of setDate method, of class GregorianAnniversary,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetDate_ThirtyTwo() {
        System.out.println("setDate(32)");
        int date = 32;
        GregorianAnniversary instance = this._mayNinth;
        instance.setDate(date);
    }

    /**
     * Test of setMonth method, of class GregorianAnniversary.
     */
    @Test
    public void testSetMonth() {
        System.out.println("setMonth");
        int month = 6;
        GregorianAnniversary instance = this._mayNinth;
        instance.setMonth(month);
        assertEquals(6, instance.getMonth());

        instance = this._februaryThirtyFirst;
        instance.setMonth(month);
        assertEquals(6, instance.getMonth());
    }

    /**
     * Test of setMonth method, of class GregorianAnniversary, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMonth_NegativeOne() {
        System.out.println("setMonth(-1)");
        int month = -1;
        GregorianAnniversary instance = this._mayNinth;
        instance.setMonth(month);
    }

    /**
     * Test of setMonth method, of class GregorianAnniversary, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMonth_Twelve() {
        System.out.println("setMonth(12)");
        int month = 12;
        GregorianAnniversary instance = this._mayNinth;
        instance.setMonth(month);
    }

    /**
     * Test of getHoliday method, of class GregorianAnniversary.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        for (int year = 1900; year < 2100; year++) {
            GregorianAnniversary instance = this._mayNinth;
            GregorianCalendar expResult = new GregorianCalendar(year, 4, 9);
            GregorianCalendar result = instance.getHoliday(year);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getHoliday method, of class GregorianAnniversary,
     * for an invalid/non-existing holiday.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_InvalidHoliday() {
        System.out.println("getHoliday from invalid/non-existing holiday");
        int year = 2000;
        GregorianAnniversary instance = this._februaryThirtyFirst;
        instance.getHoliday(year);
    }

    /**
     * Test of occurs method, of class GregorianAnniversary.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        for (int year = 1900; year < 2100; year++) {
            GregorianAnniversary instance = this._mayNinth;
            boolean expResult = true;
            boolean result = instance.occurs(year);
            assertEquals(expResult, result);

            instance = this._februaryThirtyFirst;
            expResult = false;
            result = instance.occurs(year);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianAnniversary.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar date = new GregorianCalendar(1980, 0, 1);
        for (int i = 0; i < 10000; i++) {
            GregorianAnniversary instance = this._mayNinth;
            boolean expResult = date.get(GregorianCalendar.MONTH) == 4 &&
                    date.get(GregorianCalendar.DAY_OF_MONTH) == 9;
            boolean result = instance.isHoliday(date);
            assertEquals(expResult, result);

            instance = this._februaryThirtyFirst;
            expResult = false;
            result = instance.isHoliday(date);
            assertEquals(expResult, result);

            date.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianAnniversary, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianAnniversary instance = this._mayNinth;
        GregorianCalendar nullValue = null;
        instance.isHoliday(nullValue);
    }
}