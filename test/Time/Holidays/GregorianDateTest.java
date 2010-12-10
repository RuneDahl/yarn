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
 * Unit-test for the class Time.Holidays.GregorianDate.
 * @author Rune Dahl Iversen
 */
public class GregorianDateTest {
    private GregorianDate _mayNinth2k;
    private GregorianDate _mayNinth2k9;
    private GregorianDate _juneFirst2k;

    public GregorianDateTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._mayNinth2k = new GregorianDate(new GregorianCalendar(2000, 4, 9));
        this._mayNinth2k9 = new GregorianDate(new GregorianCalendar(2009, 4, 9));
        this._juneFirst2k = new GregorianDate(new GregorianCalendar(2000, 5, 1));
    }

    @After
    public void tearDown() {
        this._mayNinth2k = null;
        this._mayNinth2k9 = null;
        this._juneFirst2k = null;
    }

    /**
     * Test of getDate method, of class GregorianDate.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        GregorianDate instance = this._mayNinth2k;
        GregorianCalendar expResult = new GregorianCalendar(2000, 4, 9);
        GregorianCalendar result = instance.getDate();
        assertEquals(expResult, result);

        instance = this._mayNinth2k9;
        expResult = new GregorianCalendar(2009, 4, 9);
        result = instance.getDate();
        assertEquals(expResult, result);

        instance = this._juneFirst2k;
        expResult = new GregorianCalendar(2000, 5, 1);
        result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class GregorianDate.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        GregorianCalendar date = new GregorianCalendar(2010, 1, 1, 12, 31, 45);
        GregorianDate instance = this._mayNinth2k;
        instance.setDate(date);
        GregorianCalendar expResult = new GregorianCalendar(2010, 1, 1);
        assertEquals(expResult, instance.getDate());
    }

    /**
     * Test of setDate method, of class GregorianDate, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetDate_Null() {
        System.out.println("setDate(null)");
        GregorianCalendar date = null;
        GregorianDate instance = this._mayNinth2k;
        instance.setDate(date);
        fail("No exception thrown.");
    }

    /**
     * Test of isHoliday method, of class GregorianDate.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 10000; i++) {
            GregorianDate instance = this._mayNinth2k;
            boolean expResult = date.get(GregorianCalendar.YEAR) == 2000 &&
                    date.get(GregorianCalendar.MONTH) == 4 &&
                    date.get(GregorianCalendar.DAY_OF_MONTH) == 9;
            boolean result = instance.isHoliday(date);
            assertEquals(expResult, result);

            instance = this._juneFirst2k;
            expResult = date.get(GregorianCalendar.YEAR) == 2000 &&
                    date.get(GregorianCalendar.MONTH) == 5 &&
                    date.get(GregorianCalendar.DAY_OF_MONTH) == 1;
            result = instance.isHoliday(date);
            assertEquals(expResult, result);

            instance = this._mayNinth2k9;
            expResult = date.get(GregorianCalendar.YEAR) == 2009 &&
                    date.get(GregorianCalendar.MONTH) == 4 &&
                    date.get(GregorianCalendar.DAY_OF_MONTH) == 9;
            result = instance.isHoliday(date);
            assertEquals(expResult, result);

            date.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianDate, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar date = null;
        GregorianDate instance = this._mayNinth2k;
        instance.isHoliday(date);
        fail("No exception thrown.");
    }
}