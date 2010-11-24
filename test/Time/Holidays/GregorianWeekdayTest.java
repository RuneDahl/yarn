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
 * Unit-test for the class Time.Holidays.GregorianWeekday.
 * @author Rune Dahl Iversen
 */
public class GregorianWeekdayTest {
    private GregorianWeekday _saturday;
    private GregorianWeekday _sunday;

    public GregorianWeekdayTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._saturday = new GregorianWeekday(GregorianCalendar.SATURDAY);
        this._sunday = new GregorianWeekday(GregorianCalendar.SUNDAY);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWeekday method, of class GregorianWeekday.
     */
    @Test
    public void testGetWeekday() {
        System.out.println("getWeekday");
        GregorianWeekday instance = this._saturday;
        int expResult = 7;
        int result = instance.getWeekday();
        assertEquals(expResult, result);

        instance = this._sunday;
        expResult = 1;
        result = instance.getWeekday();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeekday method, of class GregorianWeekday.
     */
    @Test
    public void testSetWeekday() {
        System.out.println("setWeekday");
        GregorianWeekday instance = this._saturday;
        for (int weekday = 1; weekday < 8; weekday++) {
            instance.setWeekday(weekday);
            assertEquals(weekday, instance.getWeekday());
        }
    }

    /**
     * Test of setWeekday method, of class GregorianWeekday, for the value 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Zero() {
        System.out.println("setWeekday(0)");
        GregorianWeekday instance = this._saturday;
        instance.setWeekday(0);
        fail("No exception thrown.");
    }

    /**
     * Test of setWeekday method, of class GregorianWeekday, for the value 8.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Eight() {
        System.out.println("setWeekday(8)");
        GregorianWeekday instance = this._saturday;
        instance.setWeekday(8);
        fail("No exception thrown.");
    }

    /**
     * Test of isHoliday method, of class GregorianWeekday.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 10000; i++) {
            GregorianWeekday instance = this._saturday;
            boolean expResult = date.get(GregorianCalendar.DAY_OF_WEEK) == 7;
            boolean result = instance.isHoliday(date);
            assertEquals(expResult, result);

            instance = this._sunday;
            expResult = date.get(GregorianCalendar.DAY_OF_WEEK) == 1;
            result = instance.isHoliday(date);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianWeekday, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday");
        GregorianWeekday instance = this._saturday;
        boolean result = instance.isHoliday(null);
        fail("No exception thrown.");
    }
}