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
 * Unit-test for the class Time.Holidays.GregorianEdnDate.
 * @author Rune Dahl Iversen
 */
public class GregorianEndDateTest {
    private GregorianEndDate _valid;
    private Holiday<GregorianCalendar> _weekday;

    public GregorianEndDateTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.GregorianEndDate");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._weekday = new GregorianWeekday(GregorianCalendar.SUNDAY);
        this._valid = new GregorianEndDate(this._weekday,
                new GregorianCalendar(2010, 0, 1));
    }

    @After
    public void tearDown() {
        this._weekday = null;
        this._valid = null;
    }

    /**
     * Test of getHoliday method, of class GregorianEndDate.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        GregorianEndDate instance = this._valid;
        Holiday result = instance.getHoliday();
        assertNotNull("No holiday returned.", result);
        if (result instanceof GregorianWeekday) {
            GregorianWeekday gwd = (GregorianWeekday)result;
            assertEquals("Wrong value from returned GregorianWeekday.",
                    GregorianCalendar.SUNDAY, gwd.getWeekday());
        } else
            fail("Wrong type of holiday returned.");
    }

    /**
     * Test of getEnd method, of class GregorianEndDate.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        GregorianEndDate instance = this._valid;
        GregorianCalendar expResult = new GregorianCalendar(2010, 0, 1);
        GregorianCalendar result = instance.getEnd();
        assertEquals("Wrong end date.", expResult, result);
    }

    /**
     * Test of setHoliday method, of class GregorianEndDate.
     */
    @Test
    public void testSetHoliday() {
        System.out.println("setHoliday");
        Holiday<GregorianCalendar> holiday = new GregorianWeekday(GregorianCalendar.SATURDAY);
        GregorianEndDate instance = this._valid;

        Holiday<GregorianCalendar> result = instance.getHoliday();
        assertNotNull("Pre-condition: No holiday returned.", result);
        if (result instanceof GregorianWeekday) {
            GregorianWeekday gwd = (GregorianWeekday)result;
            assertEquals("Pre-condition: Wrong value from returned GregorianWeekday.",
                    GregorianCalendar.SUNDAY, gwd.getWeekday());
        } else
            fail("Pre-condition: Wrong type of holiday returned.");
        
        instance.setHoliday(holiday);

        result = instance.getHoliday();
        assertNotNull("No holiday returned after setHoliday.", result);
        if (result instanceof GregorianWeekday) {
            GregorianWeekday gwd = (GregorianWeekday)result;
            assertEquals("Wrong value from returned GregorianWeekday after setHoliday.",
                    GregorianCalendar.SATURDAY, gwd.getWeekday());
        } else
            fail("Wrong type of holiday returned after setHoliday.");
    }

    /**
     * Test of setHoliday method, of class GregorianEndDate, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetHolidayNull() {
        System.out.println("setHoliday(null)");
        Holiday<GregorianCalendar> holiday = null;
        GregorianEndDate instance = this._valid;

        instance.setHoliday(holiday);
        fail("No exception thrown.");
    }

    /**
     * Test of setEnd method, of class GregorianEndDate.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        GregorianCalendar end = new GregorianCalendar(2000, 4, 9);
        GregorianEndDate instance = this._valid;

        GregorianCalendar expResult = new GregorianCalendar(2010, 0, 1);
        GregorianCalendar result = instance.getEnd();
        assertEquals("Error in pre-condition.", expResult, result);

        instance.setEnd(end);

        expResult = new GregorianCalendar(2000, 4, 9);
        result = instance.getEnd();
        assertEquals("Wrong value after setEnd.", expResult, result);
    }

    /**
     * Test of setEnd method, of class GregorianEndDate, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetEndNull() {
        System.out.println("setEnd(null)");
        GregorianCalendar end = null;
        GregorianEndDate instance = this._valid;

        instance.setEnd(end);
        fail("No exception thrown.");
    }

    /**
     * Test of isHoliday method, of class GregorianEndDate.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar dateTime = new GregorianCalendar(2010, 0, 1);
        GregorianEndDate instance = this._valid;
        for (int i = 0; i < 10000; i++) {
            boolean expResult = (dateTime.get(GregorianCalendar.YEAR) < 2010) &&
                    (dateTime.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY);
            boolean result = instance.isHoliday(dateTime);
            assertEquals(expResult, result);
            dateTime.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianEndDate, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHolidayNull() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        GregorianEndDate instance = this._valid;
       instance.isHoliday(dateTime);
        fail("No exception thrown.");
    }
}