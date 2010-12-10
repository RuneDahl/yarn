/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import java.util.GregorianCalendar;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test of the class Time.Holidays.GregorianWesternEaster.
 * @author Rune Dahl Iversen
 */
public class GregorianWesternEasterTest {
    private GregorianWesternEaster _easter;
    private HashMap<Integer, GregorianCalendar> _easters;

    public GregorianWesternEasterTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._easter = new GregorianWesternEaster();
        this._easters = new HashMap<Integer, GregorianCalendar>();
        // Dates are from Wikipedia:
        // http://en.wikipedia.org/wiki/Easter#Date_of_Easter
        this._easters.put(1982, new GregorianCalendar(1982, 3, 11));
        this._easters.put(1983, new GregorianCalendar(1983, 3, 3));
        this._easters.put(1984, new GregorianCalendar(1984, 3, 22));
        this._easters.put(1985, new GregorianCalendar(1985, 3, 7));
        this._easters.put(1986, new GregorianCalendar(1986, 2, 30));
        this._easters.put(1987, new GregorianCalendar(1987, 3, 19));
        this._easters.put(1988, new GregorianCalendar(1988, 3, 3));
        this._easters.put(1989, new GregorianCalendar(1989, 2, 26));
        this._easters.put(1990, new GregorianCalendar(1990, 3, 15));
        this._easters.put(1991, new GregorianCalendar(1991, 2, 31));
        this._easters.put(1992, new GregorianCalendar(1992, 3, 19));
        this._easters.put(1993, new GregorianCalendar(1993, 3, 11));
        this._easters.put(1994, new GregorianCalendar(1994, 3, 3));
        this._easters.put(1995, new GregorianCalendar(1995, 3, 16));
        this._easters.put(1996, new GregorianCalendar(1996, 3, 7));
        this._easters.put(1997, new GregorianCalendar(1997, 2, 30));
        this._easters.put(1998, new GregorianCalendar(1998, 3, 12));
        this._easters.put(1999, new GregorianCalendar(1999, 3, 4));
        this._easters.put(2000, new GregorianCalendar(2000, 3, 23));
        this._easters.put(2001, new GregorianCalendar(2001, 3, 15));
        this._easters.put(2002, new GregorianCalendar(2002, 2, 31));
        this._easters.put(2003, new GregorianCalendar(2003, 3, 20));
        this._easters.put(2004, new GregorianCalendar(2004, 3, 11));
        this._easters.put(2005, new GregorianCalendar(2005, 2, 27));
        this._easters.put(2006, new GregorianCalendar(2006, 3, 16));
        this._easters.put(2007, new GregorianCalendar(2007, 3, 8));
        this._easters.put(2008, new GregorianCalendar(2008, 2, 23));
        this._easters.put(2009, new GregorianCalendar(2009, 3, 12));
        this._easters.put(2010, new GregorianCalendar(2010, 3, 4));
        this._easters.put(2011, new GregorianCalendar(2011, 3, 24));
        this._easters.put(2012, new GregorianCalendar(2012, 3, 8));
        this._easters.put(2013, new GregorianCalendar(2013, 2, 31));
        this._easters.put(2014, new GregorianCalendar(2014, 3, 20));
        this._easters.put(2015, new GregorianCalendar(2015, 3, 5));
        this._easters.put(2016, new GregorianCalendar(2016, 2, 27));
        this._easters.put(2017, new GregorianCalendar(2017, 3, 16));
        this._easters.put(2018, new GregorianCalendar(2018, 3, 1));
        this._easters.put(2019, new GregorianCalendar(2019, 3, 21));
        this._easters.put(2020, new GregorianCalendar(2020, 3, 12));
        this._easters.put(2021, new GregorianCalendar(2021, 3, 4));
        this._easters.put(2022, new GregorianCalendar(2022, 3, 17));
    }

    @After
    public void tearDown() {
        this._easter = null;
        this._easters.clear();
    }

    /**
     * Test of getHoliday method, of class GregorianWesternEaster.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        GregorianWesternEaster instance = this._easter;
        for (int year = 1982; year < 2023; year++) {
            GregorianCalendar expResult = this._easters.get(year);
            GregorianCalendar result = instance.getHoliday(year);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getHoliday method, of class GregorianWesternEaster, for the value 1582.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_1582() {
        System.out.println("getHoliday(1582)");
        GregorianWesternEaster instance = this._easter;
        instance.getHoliday(1582);
        fail("No exception thrown.");
    }

    /**
     * Test of getHoliday method, of class GregorianWesternEaster, for the value 4100.
     */
    @Test (expected=NullPointerException.class)
    public void testGetHoliday_4100() {
        System.out.println("getHoliday(4100)");
        GregorianWesternEaster instance = this._easter;
        instance.getHoliday(4100);
        fail("No exception thrown.");
    }

    /**
     * Test of occurs method, of class GregorianWesternEaster.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        GregorianWesternEaster instance = this._easter;
        for (int year = 0; year < 10000; year++) {
            boolean expResult = 1582 < year && year < 4100;
            boolean result = instance.occurs(year);
            assertEquals(Integer.toString(year) + " wrong value for occurs",
                    expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianWesternEaster.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        GregorianCalendar date = new GregorianCalendar(1982, 0, 1);
        GregorianWesternEaster instance = this._easter;
        for (int i = 0; i < 10000; i++) {
            boolean expResult = this._easters.containsValue(date);
            boolean result = instance.isHoliday(date);
            assertEquals("", expResult, result);
            date.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Test of isHoliday method, of class GregorianWesternEaster.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianWesternEaster instance = this._easter;
        instance.isHoliday(null);
        fail("No exception thrown.");
    }
}