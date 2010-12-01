/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import Time.Periods.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rune Dahl Iversen
 */
public class RelativesTest {
    private Relatives<GregorianCalendar> _relative;
    private Period<GregorianCalendar> _week;
    private Period<GregorianCalendar> _days3;
    private GregorianAnniversary _central;

    public RelativesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._week = new GregorianWeek(1);
        this._days3 = new GregorianDay(3);
        this._central = new GregorianAnniversary(4, 9);
        Collection<Period<GregorianCalendar>> periods = new ArrayList<Period<GregorianCalendar>>();
        periods.add(this._days3);
        periods.add(this._week);
        this._relative = new Relatives<GregorianCalendar>(this._central, periods);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCentralHoliday method, of class Relatives.
     */
    @Test
    public void testGetCentralHoliday() {
        System.out.println("getCentralHoliday");
        Relatives<GregorianCalendar> instance = this._relative;
        Holiday result = instance.getCentralHoliday();
        assertNotNull("No central holiday.", result);
        if (!(result instanceof GregorianAnniversary))
            fail("Wrong class of central holiday.");
        else {
            GregorianAnniversary ga = (GregorianAnniversary)result;
            assertEquals("Wrong month from central holiday.", 4, ga.getMonth());
            assertEquals("Wrong date from central holiday.", 9, ga.getDate());
        }
    }

    /**
     * Test of setCentralHoliday method, of class Relatives.
     */
    @Test
    public void testSetCentralHoliday() {
        System.out.println("setCentralHoliday");
        Relatives<GregorianCalendar> instance = this._relative;
        Holiday result = instance.getCentralHoliday();
        assertNotNull("Pre-condition: No central holiday.", result);
        if (!(result instanceof GregorianAnniversary))
            fail("Pre-condition: Wrong class of central holiday.");
        else {
            GregorianAnniversary ga = (GregorianAnniversary)result;
            assertEquals("Pre-condition: Wrong month from central holiday.", 4, ga.getMonth());
            assertEquals("Pre-condition: Wrong date from central holiday.", 9, ga.getDate());
        }
        
        instance.setCentralHoliday(new GregorianWesternEaster());

        result = instance.getCentralHoliday();
        assertNotNull("No central holiday after setCentralHoliday.", result);
        if (!(result instanceof GregorianWesternEaster))
            fail("Wrong class of central holiday after setCentralHoliday.");
    }

    /**
     * Test of setCentralHoliday method, of class Relatives, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetCentralHolidayNull() {
        System.out.println("setCentralHoliday(null)");
        Holiday<GregorianCalendar> centralHoliday = null;
        Relatives<GregorianCalendar> instance = this._relative;
        instance.setCentralHoliday(centralHoliday);
        fail("No exception thrown.");
    }

    /**
     * Test of isHoliday method, of class Relatives.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        Relatives<GregorianCalendar> instance = this._relative;
        GregorianCalendar date = new GregorianCalendar(2000, 0, 1);
        for (int i = 0; i < 10000; i++) {
            boolean expResult = this._central.isHoliday(this._days3.shift(date, -1));
            expResult |= this._central.isHoliday(this._week.shift(date, -1));
            boolean result = instance.isHoliday(date);
            assertEquals(expResult, result);
            date.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of isHoliday method, of class Relatives, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHolidayNull() {
        System.out.println("isHoliday(null)");
        GregorianCalendar date = null;
        Relatives<GregorianCalendar> instance = this._relative;
        boolean result = instance.isHoliday(date);
        fail("No exception thrown.");
    }
}