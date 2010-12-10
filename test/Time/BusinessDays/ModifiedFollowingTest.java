/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.BusinessDays;

import Time.Holidays.*;
import Time.Periods.*;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for the class Time.BusinessDays.ModifiedFollowing.
 * @author Rune Dahl Iversen
 */
public class ModifiedFollowingTest {
    private ModifiedFollowing<GregorianCalendar> _modPrevious;
    private Holiday<GregorianCalendar> _holidays;
    private Period<GregorianCalendar> _day;

    public ModifiedFollowingTest() {
        System.out.println("Time.BusinessDays.ModifiedFollowing");
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._day = new GregorianDay(1);
        this._holidays = new GregorianWeekday(GregorianCalendar.SUNDAY);
        this._modPrevious = new ModifiedFollowing<GregorianCalendar>(this._holidays, this._day);
    }

    @After
    public void tearDown() {
        this._day = null;
        this._holidays = null;
        this._modPrevious = null;
    }

    /**
     * Test of getHolidays method, of class ModifiedFollowing.
     */
    @Test
    public void testGetHolidays() {
        System.out.println("getHolidays");
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        Holiday<GregorianCalendar> holiday = instance.getHolidays();
        assertNotNull(holiday);
        if (holiday instanceof GregorianWeekday) {
            GregorianWeekday gwd = (GregorianWeekday)holiday;
            assertEquals("Wrong weekday from returned holidays.",
                    GregorianCalendar.SUNDAY, gwd.getWeekday());
        } else
            fail("Wrong class of holidays returned.");
    }

    /**
     * Test of setHolidays method, of class ModifiedFollowing.
     */
    @Test
    public void testSetHolidays() {
        System.out.println("setHolidays");
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        Holiday<GregorianCalendar> holiday = instance.getHolidays();
        assertNotNull(holiday);
        if (holiday instanceof GregorianWeekday) {
            GregorianWeekday gwd = (GregorianWeekday)holiday;
            assertEquals("Pre-condition: Wrong weekday from returned holidays.",
                    GregorianCalendar.SUNDAY, gwd.getWeekday());
        } else
            fail("Pre-condition: Wrong class of holidays returned.");
        

        instance.setHolidays(new GregorianWesternEaster());

        holiday = instance.getHolidays();
        assertNotNull(holiday);
        if (!(holiday instanceof GregorianWesternEaster))
            fail("Wrong class of holidays returned after setHolidays.");
    }

    /**
     * Test of setHolidays method, of class ModifiedFollowing, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetHolidaysNull() {
        System.out.println("setHolidays(null)");
        this._modPrevious.setHolidays(null);
        fail("No exception thrown.");
    }

    /**
     * Test of getPeriod method, of class ModifiedFollowing.
     */
    @Test
    public void testGetPeriod() {
        System.out.println("getPeriod");
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        Period<GregorianCalendar> period = instance.getPeriod();
        assertNotNull(period);
        if (period instanceof GregorianDay) {
            GregorianDay gd = (GregorianDay)period;
            assertEquals("Wrong count from returned period.", 1, gd.getCount());
        } else
            fail("Wrong class of period returned.");
    }

    /**
     * Test of setPeriod method, of class ModifiedFollowing.
     */
    @Test
    public void testSetPeriod() {
        System.out.println("setPeriod");
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        Period<GregorianCalendar> period = instance.getPeriod();
        assertNotNull(period);
        if (period instanceof GregorianDay) {
            GregorianDay gd = (GregorianDay)period;
            assertEquals("Precondition: Wrong count from returned period.", 1, gd.getCount());
        } else
            fail("Pre-condition: Wrong class of period returned.");

        instance.setPeriod(new GregorianWeek(2));

        period = instance.getPeriod();
        assertNotNull(period);
        if (period instanceof GregorianWeek) {
            GregorianWeek gd = (GregorianWeek)period;
            assertEquals("Wrong count from returned period after setPeriod.",
                    2, gd.getCount());
        } else
            fail("Wrong class of period returned after setPeriod.");
    }

    /**
     * Test of setPeriod method, of class ModifiedFollowing, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testGetPeriodNull() {
        System.out.println("setPeriod(null)");
        this._modPrevious.setPeriod(null);
        fail("No exception thrown.");
    }

    /**
     * Test of Adjust method, of class ModifiedFollowing.
     */
    @Test
    public void testAdjust() {
        System.out.println("adjust");
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        GregorianCalendar dateTime = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 1500; i++) {
            GregorianCalendar expResult = (GregorianCalendar)dateTime.clone();
            if (expResult.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY)
                expResult.add(GregorianCalendar.DAY_OF_YEAR, 1);
            if (expResult.get(GregorianCalendar.MONTH) !=
                    dateTime.get(GregorianCalendar.MONTH)) {
                expResult = (GregorianCalendar)dateTime.clone();
                expResult.add(GregorianCalendar.DAY_OF_YEAR, -1);
            }
            GregorianCalendar result = instance.adjust(dateTime);
            assertEquals(expResult, result);
            dateTime.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of Adjust method, of class ModifiedFollowing, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testAdjustNull() {
        System.out.println("adjust(null)");
        GregorianCalendar dateTime = null;
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        instance.adjust(dateTime);
        fail("No exception thrown.");
    }

    /**
     * Test of Shift method, of class ModifiedFollowing.
     */
    @Test
    public void testShift() {
        System.out.println("shift");
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        GregorianCalendar dateTime = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 100; i++) {
            for (int count = -12; count < 14; count++) {
                GregorianCalendar expResult = (GregorianCalendar)dateTime.clone();
                for (int j = 0; j < Math.abs(count); j++) {
                    expResult.add(GregorianCalendar.DAY_OF_YEAR, (int)Math.signum(count));
                    if (expResult.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY)
                        expResult.add(GregorianCalendar.DAY_OF_YEAR, (int)Math.signum(count));
                }
                GregorianCalendar result = instance.shift(dateTime, count);
                assertEquals(expResult, result);
            }
            dateTime.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of Shift method, of class ModifiedFollowing, for a null date/time value.
     */
    @Test (expected=NullPointerException.class)
    public void testShiftNull() {
        System.out.println("shift(null, x)");
        GregorianCalendar dateTime = null;
        int count = 2;
        ModifiedFollowing<GregorianCalendar> instance = this._modPrevious;
        instance.shift(dateTime, count);
        fail("No exception thrown.");
    }
}