/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.Holidays;

import Time.Gregorian;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Time.Holidays.GregorianNthWeekday.
 * @author Rune Dahl Iversen
 */
public class GregorianNthWeekdayTest {
    private GregorianNthWeekday _instance;
    private ArrayList<Integer> _years;
    private ArrayList<Integer> _months;
    
    public GregorianNthWeekdayTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.GregorianNthWeekday");        
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new GregorianNthWeekday(1, 5);
        this._months = new ArrayList<Integer>(12);
        for (int month = 0; month < 12; month++)
            this._months.add(month);
        this._years = new ArrayList<Integer>();
        for (int year = 2000; year < 2012; year++)
            this._years.add(year);
    }
    
    @After
    public void tearDown() {
        this._instance = null;
        this._months = null;
        this._years = null;
    }

    /**
     * Test of getCount method, of class GregorianNthWeekday.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        GregorianNthWeekday instance = this._instance;
        int expResult = 5;
        
        int result = instance.getCount();

        assertEquals(expResult, result);
    }

    /**
     * Test of setCount method, of class GregorianNthWeekday.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        int count = 1;
        GregorianNthWeekday instance = this._instance;
        assertTrue("Failed precondition to test setCount(int).", 
                instance.getCount() != count);
        
        instance.setCount(count);
        int result = instance.getCount();
        
        assertEquals(count, result);
    }

    /**
     * Test of setCount method, of class GregorianNthWeekday,
     * for the value 6 (six).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCount_Six() {
        System.out.println("setCount(6)");
        int count = 6;
        GregorianNthWeekday instance = this._instance;
        instance.setCount(count);
    }

    /**
     * Test of setCount method, of class GregorianNthWeekday,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCount_Zero() {
        System.out.println("setCount(0)");
        int count = 0;
        GregorianNthWeekday instance = this._instance;
        instance.setCount(count);
    }

    /**
     * Test of getWeekday method, of class GregorianNthWeekday.
     */
    @Test
    public void testGetWeekday() {
        System.out.println("getWeekday");
        GregorianNthWeekday instance = this._instance;
        int expResult = 1;
        
        int result = instance.getWeekday();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeekday method, of class GregorianNthWeekday.
     */
    @Test
    public void testSetWeekday() {
        System.out.println("setWeekday");
        int weekday = 2;
        GregorianNthWeekday instance = this._instance;
        assertTrue("Failed precondition to test setWeekday(int).", 
                instance.getWeekday() != weekday);
        
        instance.setWeekday(weekday);
        int result = instance.getWeekday();
        
        assertEquals(weekday, result);
    }

    /**
     * Test of setWeekday method, of class GregorianNthWeekday.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Zero() {
        System.out.println("setWeekday(0)");
        int weekday = 0;
        GregorianNthWeekday instance = this._instance;
        instance.setWeekday(weekday);
    }

    /**
     * Test of setWeekday method, of class GregorianNthWeekday.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Eight() {
        System.out.println("setWeekday(8)");
        int weekday = 8;
        GregorianNthWeekday instance = this._instance;
        instance.setWeekday(weekday);
    }

    /**
     * Test of getHoliday method, of class GregorianNthWeekday.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        int year = 2012;
        int month = 0;
        GregorianNthWeekday instance = this._instance;
        GregorianCalendar expResult = new GregorianCalendar(year, month, 29);
        GregorianCalendar result = instance.getHoliday(year, month);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHoliday method, of class GregorianNthWeekday.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_DoesNotExist() {
        System.out.println("getHoliday(that does not exist)");
        int year = 2012;
        int month = 1;
        GregorianNthWeekday instance = this._instance;

        instance.getHoliday(year, month);
    }

    /**
     * Test of occurs method, of class GregorianNthWeekday.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        int year = 2011;
        int month = 0;
        GregorianNthWeekday instance = this._instance;
        for (int weekday = 1; weekday < 8; weekday++) {
            instance.setWeekday(weekday);
            boolean expResult = Gregorian.nthWeekdayOfMonthOccurs(5, weekday, year, month);
            
            boolean result = instance.occurs(year, month);
            
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianNthWeekday.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianNthWeekday instance = this._instance;
        for (int i = 1; i < 32; i++)
        {
            GregorianCalendar dateTime = new GregorianCalendar(2012, 0, i, i%24, i, 60-i);
            boolean expResult = (i == 29);
            boolean result = instance.isHoliday(dateTime);
            
            assertEquals(expResult, result);
        }
    }
    
    /**
     * Test of isHoliday method, of class GregorianNthWeekday, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        GregorianNthWeekday instance = this._instance;
        
        instance.isHoliday(dateTime);
    }
}
