/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the class Time.GregorianLongSeed.
 * @author Rune Dahl Iversen
 */
public class GregorianLongSeedTest {
    private GregorianLongSeed _instance;
    
    public GregorianLongSeedTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.GregorianLongSeed");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new GregorianLongSeed(0, 100000);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getLowerBound method, of class GregorianLongSeed.
     */
    @Test
    public void testGetLowerBound() {
        System.out.println("getLowerBound");
        GregorianLongSeed instance = this._instance;
        long expResult = 0L;
        long result = instance.getLowerBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUpperBound method, of class GregorianLongSeed.
     */
    @Test
    public void testGetUpperBound() {
        System.out.println("getUpperBound");
        GregorianLongSeed instance = this._instance;
        long expResult = 100000L;
        long result = instance.getUpperBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLowerBound method, of class GregorianLongSeed.
     */
    @Test
    public void testSetLowerBound() {
        System.out.println("setLowerBound");
        long lowerBound = 50L;
        GregorianLongSeed instance = this._instance;
        instance.setLowerBound(lowerBound);
        long result = instance.getLowerBound();
        assertEquals("Wrong value from getLowerBound after use of setLowerBound(long).",
                lowerBound, result);
    }

    /**
     * Test of setUpperBound method, of class GregorianLongSeed.
     */
    @Test
    public void testSetUpperBound() {
        System.out.println("setUpperBound");
        long upperBound = 1000L;
        GregorianLongSeed instance = this._instance;
        instance.setUpperBound(upperBound);
        long result = instance.getUpperBound();
        assertEquals("Wrong value from getUpperBound after use of setUpperBound(long).",
                upperBound, result);
    }

    /**
     * Test of getSeed method, of class GregorianLongSeed,
     * without a specified date/time.
     */
    @Test
    public void testGetSeed() {
        System.out.println("getSeed");
        GregorianLongSeed instance = this._instance;
        System.out.println(Long.toString(instance.getSeed()));
    }

    /**
     * Test of getSeed method, of class GregorianLongSeed,
     * without a specified date/time.
     */
    @Test
    public void testGetSeed_GregorianCalendar() {
        System.out.println("getSeed(GregorianCalendar)");
        GregorianLongSeed instance = this._instance;
        GregorianCalendar dateTime = Gregorian.date(new GregorianCalendar());
        System.out.println(Long.toString(instance.getSeed(dateTime)));
        dateTime.set(GregorianCalendar.HOUR_OF_DAY, 12);
        System.out.println(Long.toString(instance.getSeed(dateTime)));
    }
}
