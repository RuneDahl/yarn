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
 * jUnit-test for the class Time.Holidays.GregorianNthLastWeekday.
 * @author Rune Dahl Iversen
 */
public class GregorianNthLastWeekdayTest {
    private GregorianNthLastWeekday _instance;
    private ArrayList<Integer> _years;
    private ArrayList<Integer> _months;
    
    public GregorianNthLastWeekdayTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.GregorianNthLastWeekday");        
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new GregorianNthLastWeekday(1, 5);
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
     * Test of getCount method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        GregorianNthLastWeekday instance = this._instance;
        int expResult = 5;
        
        int result = instance.getOccurrence();

        assertEquals(expResult, result);
    }

    /**
     * Test of setCount method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        int count = 1;
        GregorianNthLastWeekday instance = this._instance;
        assertTrue("Failed precondition to test setCount(int).", 
                instance.getOccurrence() != count);
        
        instance.setOccurrence(count);
        int result = instance.getOccurrence();
        
        assertEquals(count, result);
    }

    /**
     * Test of setCount method, of class GregorianNthLastWeekday,
     * for the value 6 (six).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCount_Six() {
        System.out.println("setCount(6)");
        int count = 6;
        GregorianNthLastWeekday instance = this._instance;
        instance.setOccurrence(count);
    }

    /**
     * Test of setCount method, of class GregorianNthLastWeekday,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCount_Zero() {
        System.out.println("setCount(0)");
        int count = 0;
        GregorianNthLastWeekday instance = this._instance;
        instance.setOccurrence(count);
    }

    /**
     * Test of getWeekday method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testGetWeekday() {
        System.out.println("getWeekday");
        GregorianNthLastWeekday instance = this._instance;
        int expResult = 1;
        
        int result = instance.getWeekday();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeekday method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testSetWeekday() {
        System.out.println("setWeekday");
        int weekday = 2;
        GregorianNthLastWeekday instance = this._instance;
        assertTrue("Failed precondition to test setWeekday(int).", 
                instance.getWeekday() != weekday);
        
        instance.setWeekday(weekday);
        int result = instance.getWeekday();
        
        assertEquals(weekday, result);
    }

    /**
     * Test of setWeekday method, of class GregorianNthLastWeekday.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Zero() {
        System.out.println("setWeekday(0)");
        int weekday = 0;
        GregorianNthLastWeekday instance = this._instance;
        instance.setWeekday(weekday);
    }

    /**
     * Test of setWeekday method, of class GregorianNthLastWeekday.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Eight() {
        System.out.println("setWeekday(8)");
        int weekday = 8;
        GregorianNthLastWeekday instance = this._instance;
        instance.setWeekday(weekday);
    }

    /**
     * Test of getHoliday method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        int year = 2012;
        int month = 0;
        MonthlyRecurring<GregorianCalendar> instance = this._instance;
        GregorianCalendar expResult = new GregorianCalendar(year, month, 1);
        
        GregorianCalendar result = instance.getHoliday(year, month);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getHoliday method, of class GregorianNthLastWeekday.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_DoesNotExist() {
        System.out.println("getHoliday(that does not exist)");
        int year = 2012;
        int month = 1;
        MonthlyRecurring<GregorianCalendar> instance = this._instance;

        instance.getHoliday(year, month);
    }

    /**
     * Test of occurs method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        int year = 2011;
        int month = 0;
        GregorianNthLastWeekday instance = this._instance;
        for (int weekday = 1; weekday < 8; weekday++) {
            instance.setWeekday(weekday);
            boolean expResult = Gregorian.nthWeekdayOfMonthOccurs(5, weekday, year, month);
            
            boolean result = instance.occurs(year, month);
            
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianNthLastWeekday.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        Holiday<GregorianCalendar> instance = this._instance;
        for (int i = 1; i < 32; i++)
        {
            GregorianCalendar dateTime = new GregorianCalendar(2012, 0, i, i%24, i, 60-i);
            boolean expResult = (i == 1);
            boolean result = instance.isHoliday(dateTime);
            
            assertEquals(expResult, result);
        }
    }
    
    /**
     * Test of isHoliday method, of class GregorianNthLastWeekday, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        Holiday<GregorianCalendar> instance = this._instance;
        
        instance.isHoliday(dateTime);
    }
}
