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
 * jUnit-test for the class Time.Holidays.GregorianNthWeekdayOfMonth.
 * @author Rune Dahl Iversen
 */
public class GregorianNthWeekdayOfMonthTest {
    private GregorianNthWeekdayOfMonth _instance;
    private ArrayList<Integer> _years;
    private ArrayList<Integer> _months;
    
    public GregorianNthWeekdayOfMonthTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.GregorianNthWeekdayOfMonth");        
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new GregorianNthWeekdayOfMonth(0, 1, 5);
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
     * Test of getMonth method, of class GregorianNthLastWeekdayOfMonth.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        GregorianNthWeekdayOfMonth instance = this._instance;
        int expResult = 0;
        
        int result = instance.getMonth();

        assertEquals(expResult, result);
    }
    
    /**
     * Test of setMonth method, of class GregorianNthLastWeekdayOfMonth.
     */
    @Test
    public void testSetMonth() {
        System.out.println("setMonth");
        int month = 3;
        GregorianNthWeekdayOfMonth instance = this._instance;
        assertTrue("Failed precondition to test setMonth(int).", 
                instance.getMonth() != month);
        
        instance.setMonth(month);
        int result = instance.getMonth();
        
        assertEquals(month, result);
    }

    /**
     * Test of setMonth method, of class GregorianNthLastWeekdayOfMonth,
     * for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMonth_NegativeOne() {
        System.out.println("setMonth(-1)");
        int month = -1;
        GregorianNthWeekdayOfMonth instance = this._instance;

        instance.setMonth(month);
    }

    /**
     * Test of setMonth method, of class GregorianNthLastWeekdayOfMonth,
     * for the value 12.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMonth_Twelve() {
        System.out.println("setMonth(12)");
        int month = 12;
        GregorianNthWeekdayOfMonth instance = this._instance;

        instance.setMonth(month);
    }

    /**
     * Test of getOccurrence method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testGetOccurrence() {
        System.out.println("getOccurrence");
        GregorianNthWeekdayOfMonth instance = this._instance;
        int expResult = 5;
        
        int result = instance.getOccurrence();

        assertEquals(expResult, result);
    }

    /**
     * Test of setOccurrence method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testSetOccurrence() {
        System.out.println("setOccurrence");
        int occurrence = 1;
        GregorianNthWeekdayOfMonth instance = this._instance;
        assertTrue("Failed precondition to test setOccurrence(int).", 
                instance.getOccurrence() != occurrence);
        
        instance.setOccurrence(occurrence);
        int result = instance.getOccurrence();
        
        assertEquals(occurrence, result);
    }

    /**
     * Test of setOccurrence method, of class GregorianNthWeekdayOfMonth,
     * for the value 6 (six).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetOccurrence_Six() {
        System.out.println("setOccurrence(6)");
        int occurrence = 6;
        GregorianNthWeekdayOfMonth instance = this._instance;
        instance.setOccurrence(occurrence);
    }

    /**
     * Test of setOccurrence method, of class GregorianNthWeekdayOfMonth,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetOccurrence_Zero() {
        System.out.println("setOccurrence(0)");
        int occurrence = 0;
        GregorianNthWeekdayOfMonth instance = this._instance;
        instance.setOccurrence(occurrence);
    }

    /**
     * Test of getWeekday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testGetWeekday() {
        System.out.println("getWeekday");
        WeekdayOccurrence<GregorianCalendar> instance = this._instance;
        int expResult = 1;
        
        int result = instance.getWeekday();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeekday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testSetWeekday() {
        System.out.println("setWeekday");
        int weekday = 2;
        WeekdayOccurrence<GregorianCalendar> instance = this._instance;
        assertTrue("Failed precondition to test setWeekday(int).", 
                instance.getWeekday() != weekday);
        
        instance.setWeekday(weekday);
        int result = instance.getWeekday();
        
        assertEquals(weekday, result);
    }

    /**
     * Test of setWeekday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Zero() {
        System.out.println("setWeekday(0)");
        int weekday = 0;
        WeekdayOccurrence<GregorianCalendar> instance = this._instance;
        instance.setWeekday(weekday);
    }

    /**
     * Test of setWeekday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Eight() {
        System.out.println("setWeekday(8)");
        int weekday = 8;
        WeekdayOccurrence<GregorianCalendar> instance = this._instance;
        instance.setWeekday(weekday);
    }

    /**
     * Test of getHoliday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        int year = 2012;
        int month = 0;
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;
        GregorianCalendar expResult = new GregorianCalendar(year, month, 29);
        GregorianCalendar result = instance.getHoliday(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHoliday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_DoesNotExist() {
        System.out.println("getHoliday(that does not exist)");
        int year = 2009;
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;

        instance.getHoliday(year);
    }

    /**
     * Test of occurs method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        int year = 2011;
        int month = 0;
        GregorianNthWeekdayOfMonth instance = this._instance;
        for (int weekday = 1; weekday < 8; weekday++) {
            instance.setWeekday(weekday);
            boolean expResult = Gregorian.nthWeekdayOfMonthOccurs(5, weekday, year, month);
            
            boolean result = instance.occurs(year);
            
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianNthWeekdayOfMonth.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        Holiday<GregorianCalendar> instance = this._instance;
        for (int i = 1; i < 32; i++)
        {
            GregorianCalendar dateTime = new GregorianCalendar(2012, 0, i, i%24, i, 60-i);
            boolean expResult = (i == 29);
            boolean result = instance.isHoliday(dateTime);
            
            assertEquals(expResult, result);
            
            dateTime = new GregorianCalendar(2012, 3, i, i%24, i, 60-i);
            expResult = false;
            
            result = instance.isHoliday(dateTime);
            assertEquals(expResult, result);
        }
    }
    
    /**
     * Test of isHoliday method, of class GregorianNthWeekdayOfMonth, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        Holiday<GregorianCalendar> instance = this._instance;
        
        instance.isHoliday(dateTime);
    }
}
