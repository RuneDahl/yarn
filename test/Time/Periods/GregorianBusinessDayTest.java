/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Periods;

import Time.BusinessDays.*;
import Time.Holidays.*;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Time.Periods.GregorianBusinessDay.
 * @author Rune Dahl Iversen
 */
public class GregorianBusinessDayTest {
    private Holiday<GregorianCalendar> _holidays;
    private BusinessDays<GregorianCalendar> _businessDays;
    private GregorianBusinessDay _period;
    private Period<GregorianCalendar> _p;

    public GregorianBusinessDayTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Periods.GregorianBusinessDay");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._p = new GregorianDay(1);
        this._holidays = Factory.DanishFinancialHolidays();
        this._businessDays = new Following<GregorianCalendar>(this._holidays, this._p);
        this._period = new GregorianBusinessDay(1, this._businessDays);
    }

    @After
    public void tearDown() {
        this._period = null;
        this._businessDays = null;
        this._holidays = null;
        this._p = null;
    }

    /**
     * Test of getBusinessDays method, of class GregorianBusinessDay.
     */
    @Test
    public void testGetBusinessDays() {
        System.out.println("getBusinessDays");
        GregorianBusinessDay instance = this._period;
        BusinessDays result = instance.getBusinessDays();
        assertTrue(result instanceof Following);
        Following<GregorianCalendar> f = (Following)result;
        assertTrue("Wrong type of period.", f.getPeriod() instanceof GregorianDay);
        GregorianDay g = (GregorianDay)f.getPeriod();
        assertEquals("Wroung count from period.", 1, g.getCount());
        assertTrue("Wrong type of holidays.", f.getHolidays() instanceof And);
        And<GregorianCalendar> a = (And)f.getHolidays();
        assertEquals("Wrong number of holidays in collection.", 9, a.size());
    }

    /**
     * Test of setBusinessDays method, of class GregorianBusinessDay.
     */
    @Test
    public void testSetBusinessDays() {
        System.out.println("setBusinessDays");
        BusinessDays<GregorianCalendar> businessDays =
                new Previous<GregorianCalendar>(this._holidays, this._p);
        GregorianBusinessDay instance = this._period;
        instance.setBusinessDays(businessDays);

    }

    /**
     * Test of setBusinessDays method, of class GregorianBusinessDay,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetBusinessDays_Null() {
        System.out.println("setBusinessDays(null)");
        BusinessDays<GregorianCalendar> businessDays = null;
        GregorianBusinessDay instance = this._period;
        instance.setBusinessDays(businessDays);
    }

    /**
     * Test of getCount method, of class GregorianBusinessDay.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        GregorianBusinessDay instance = this._period;
        int expResult = 1;
        int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBusinessDays method, of class GregorianBusinessDay.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        GregorianBusinessDay instance = this._period;
        assertEquals("Failed pre-condition to test setCount.",
                1, instance.getCount());
        instance.setCount(21);
        assertEquals("Wrong value from getCount after setCount.",
                21, instance.getCount());
    }

    /**
     * Test of shift method, of class GregorianBusinessDay.
     */
    @Test
    public void testShift() {
        System.out.println("shift");
        GregorianBusinessDay instance = this._period;
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int count = 0; count < 1000; count++) {
            GregorianCalendar result = instance.shift(date, count);
            GregorianCalendar expResult = new GregorianCalendar(2000, 0, 1);
            for (int i = 0; i < count; ) {
                i += (this._holidays.isHoliday(expResult) ? 0 : 1);
                expResult.add(GregorianCalendar.DAY_OF_YEAR, 1);
            }
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of shift method, of class GregorianBusinessDay,
     * for a null date/time value.
     */
    @Test (expected=NullPointerException.class)
    public void testShift_DateTimeNull() {
        System.out.println("shift(null, c)");
        GregorianCalendar date = null;
        int count = 2;
        GregorianBusinessDay instance = this._period;
        instance.shift(date, count);
    }
}