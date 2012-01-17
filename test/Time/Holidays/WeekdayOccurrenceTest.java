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
 * jUnit test for the class Time.Holidays.WeekdayOccurrence(T).
 * @author Rune Dahl Iversen
 */
public class WeekdayOccurrenceTest {
    private WeekdayOccurrence<GregorianCalendar> _instance;
    
    public WeekdayOccurrenceTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.WeekdayOccurrence");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new WeekdayOccurrenceImpl(3, 2);
    }
    
    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getOccurrence method, of class WeekdayOccurrence.
     */
    @Test
    public void testGetOccurrence() {
        System.out.println("getOccurrence");
        WeekdayOccurrence instance = this._instance;
        int expResult = 3;
        
        int result = instance.getOccurrence();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOccurrence method, of class WeekdayOccurrence.
     */
    @Test
    public void testSetOccurrence() {
        System.out.println("setOccurrence");
        int occurrence = 1;
        WeekdayOccurrence instance = this._instance;
        
        instance.setOccurrence(occurrence);
        int result = instance.getOccurrence();
        
        assertEquals(occurrence, result);
    }

    /**
     * Test of setOccurrence method, of class WeekdayOccurrence,
     * for the value 6.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetOccurrence_Six() {
        System.out.println("setOccurrence(6)");
        int occurrence = 6;
        WeekdayOccurrence instance = this._instance;
        
        instance.setOccurrence(occurrence);
    }

    /**
     * Test of setOccurrence method, of class WeekdayOccurrence,
     * for the value 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetOccurrence_Zero() {
        System.out.println("setOccurrence(0)");
        int occurrence = 0;
        WeekdayOccurrence instance = this._instance;
        
        instance.setOccurrence(occurrence);
    }

    /**
     * Test of getWeekday method, of class WeekdayOccurrence.
     */
    @Test
    public void testGetWeekday() {
        System.out.println("getWeekday");
        WeekdayOccurrence instance = this._instance;
        int expResult = 2;
        
        int result = instance.getWeekday();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeekday method, of class WeekdayOccurrence.
     */
    @Test
    public void testSetWeekday() {
        System.out.println("setWeekday");
        int weekday = 1;
        WeekdayOccurrence instance = this._instance;
        
        instance.setWeekday(weekday);
        int result = instance.getWeekday();
        
        assertEquals(weekday, result);
    }

    /**
     * Test of setWeekday method, of class WeekdayOccurrence,
     * for the value 8.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Eight() {
        System.out.println("setWeekday(8)");
        int weekday = 8;
        WeekdayOccurrence instance = this._instance;
        
        instance.setWeekday(weekday);
    }

    /**
     * Test of setWeekday method, of class WeekdayOccurrence,
     * for the value 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetWeekday_Zero() {
        System.out.println("setWeekday(0)");
        int weekday = 0;
        WeekdayOccurrence instance = this._instance;
        
        instance.setWeekday(weekday);
    }

    public class WeekdayOccurrenceImpl extends WeekdayOccurrence<GregorianCalendar> {
        public WeekdayOccurrenceImpl(final int occurrenc, final int weekday) {
            super(occurrenc, weekday);
        }

        @Override
        public boolean isHoliday(GregorianCalendar dateTime) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
