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
public class GregorianStartDateTest {
    private GregorianStartDate _valid;
    private Holiday<GregorianCalendar> _weekday;

    public GregorianStartDateTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._weekday = new GregorianWeekday(GregorianCalendar.SUNDAY);
        this._valid = new GregorianStartDate(this._weekday,
                new GregorianCalendar(2010, 0, 1));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHoliday method, of class GregorianStartDate.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        GregorianStartDate instance = this._valid;
        Holiday result = instance.getHoliday();
        assertNotNull("No holiday returned.", result);
        if (!(result instanceof GregorianWeekday))
            fail("Wrong type of holiday returned.");
        else {
            GregorianWeekday gwd = (GregorianWeekday)result;
            assertEquals("Wrong value from returned GregorianWeekday.",
                    GregorianCalendar.SUNDAY, gwd.getWeekday());
        }
    }

    /**
     * Test of getStart method, of class GregorianStartDate.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        GregorianStartDate instance = this._valid;
        GregorianCalendar expResult = new GregorianCalendar(2010, 0, 1);
        GregorianCalendar result = instance.getStart();
        assertEquals("Wrong end date.", expResult, result);
    }

    /**
     * Test of setHoliday method, of class GregorianStartDate.
     */
    @Test
    public void testSetHoliday() {
        System.out.println("setHoliday");
        Holiday<GregorianCalendar> holiday = new GregorianWeekday(GregorianCalendar.SATURDAY);
        GregorianStartDate instance = this._valid;

        Holiday<GregorianCalendar> result = instance.getHoliday();
        assertNotNull("Pre-condition: No holiday returned.", result);
        if (!(result instanceof GregorianWeekday))
            fail("Pre-condition: Wrong type of holiday returned.");
        else {
            GregorianWeekday gwd = (GregorianWeekday)result;
            assertEquals("Pre-condition: Wrong value from returned GregorianWeekday.",
                    GregorianCalendar.SUNDAY, gwd.getWeekday());
        }

        instance.setHoliday(holiday);

        result = instance.getHoliday();
        assertNotNull("No holiday returned after setHoliday.", result);
        if (!(result instanceof GregorianWeekday))
            fail("Wrong type of holiday returned after setHoliday.");
        else {
            GregorianWeekday gwd = (GregorianWeekday)result;
            assertEquals("Wrong value from returned GregorianWeekday after setHoliday.",
                    GregorianCalendar.SATURDAY, gwd.getWeekday());
        }
    }

    /**
     * Test of setHoliday method, of class GregorianStartDate, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetHolidayNull() {
        System.out.println("setHoliday(null)");
        Holiday<GregorianCalendar> holiday = null;
        GregorianStartDate instance = this._valid;

        instance.setHoliday(holiday);
        fail("No exception thrown.");
    }

    /**
     * Test of setStart method, of class GregorianStartDate.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        GregorianCalendar end = new GregorianCalendar(2000, 4, 9);
        GregorianStartDate instance = this._valid;

        GregorianCalendar expResult = new GregorianCalendar(2010, 0, 1);
        GregorianCalendar result = instance.getStart();
        assertEquals("Error in pre-condition.", expResult, result);

        instance.setStart(end);

        expResult = new GregorianCalendar(2000, 4, 9);
        result = instance.getStart();
        assertEquals("Wrong value after setStart.", expResult, result);
    }

    /**
     * Test of setStart method, of class GregorianStartDate, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetStartNull() {
        System.out.println("setStart(null)");
        GregorianCalendar end = null;
        GregorianStartDate instance = this._valid;

        instance.setStart(end);
        fail("No exception thrown.");
    }

    /**
     * Test of isHoliday method, of class GregorianStartDate.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar dateTime = new GregorianCalendar(2000, 0, 1);
        GregorianStartDate instance = this._valid;
        for (int i = 0; i < 10000; i++) {
            boolean expResult = (2010 <= dateTime.get(GregorianCalendar.YEAR)) &&
                    (dateTime.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY);
            boolean result = instance.isHoliday(dateTime);
            assertEquals(expResult, result);
            dateTime.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianStartDate, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHolidayNull() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        GregorianStartDate instance = this._valid;
        boolean result = instance.isHoliday(dateTime);
        fail("No exception thrown.");
    }
}