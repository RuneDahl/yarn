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
 * jUnit test for the class Time.Holidays.And.
 * @author Rune Dahl Iversen
 */
public class AndTest {
    private And<GregorianCalendar> _empty;
    private And<GregorianCalendar> _and;

    public AndTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.And<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._empty = new And<GregorianCalendar>();
        this._and = new And<GregorianCalendar>(
                (Or<GregorianCalendar>)Factory.DanishFinancialHolidays());
    }

    @After
    public void tearDown() {
        this._empty = null;
        this._and = null;
    }

    /**
     * Test of the empty constructor, of class And.
     */
    @Test
    public void testCtor_Empty() {
        System.out.println("And()");
        And<GregorianCalendar> instance = this._empty;

        assertNotNull("Null value.", instance);
        assertEquals("Wrong size.", 0, instance.size());

        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 1000; i++) {
            assertTrue(Time.Gregorian.toString(date), instance.isHoliday(date));
            date.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of the ellipsis constructor, of class And.
     */
    @Test
    public void testCtor_Ellipsis() {
        System.out.println("And(...)");
        Holiday<GregorianCalendar> h1 = null;
        Holiday<GregorianCalendar> h2 = new GregorianAnniversary(4, 9);

        And<GregorianCalendar> instance = new And<GregorianCalendar>(h1, h2);

        assertNotNull("Null value.", instance);
        assertEquals("Wrong size.", 2, instance.size());
    }

    /**
     * Test of the Collection constructor, of class And.
     */
    @Test
    public void testCtor_Collection() {
        System.out.println("And(Collection)");
        Holiday<GregorianCalendar> h1 = null;
        Holiday<GregorianCalendar> h2 = new GregorianAnniversary(4, 9);
        And<GregorianCalendar> and = new And<GregorianCalendar>(h1, h2);

        Or<GregorianCalendar> instance = new Or<GregorianCalendar>(and);

        assertNotNull("Null value.", instance);
        assertEquals("Wrong size.", 2, instance.size());
    }

    /**
     * Test of isHoliday method, of class And.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        And<GregorianCalendar> instance = this._and;
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 1000; i++) {
            boolean expResult = false;
            for (Holiday<GregorianCalendar> h : instance)
                expResult &= h.isHoliday(date);
            boolean result = instance.isHoliday(date);
            assertEquals(Time.Gregorian.toString(date), expResult, result);
            date.add(GregorianCalendar.DATE, 1);
        }
    }

    /**
     * Test of isHoliday method, of class And, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        Object date = null;
        And instance = this._and;
        instance.isHoliday(date);
    }
}