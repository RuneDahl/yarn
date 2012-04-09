/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Time.Holidays.Factory.
 * @author Rune Dahl Iversen
 */
public class FactoryTest {
    public FactoryTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.Factory");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() { // Intentional
    }

    @After
    public void tearDown() { // Intentional
    }

    /**
     * Test of DanishFinancialHolidays method, of class Factory.
     */
    @Test
    public void testDanishFinancialHolidays() {
        System.out.println("DanishFinancialHolidays");
        Holiday result = Factory.DanishFinancialHolidays();
        assertTrue("Wrong type of result from DanishFinancialHolidays.",
                result instanceof Or);
        Or o = (Or)result;
        assertEquals("Wrong number of holidays in collection.", 9, o.size());
    }

    /**
     * Test of TARGET method, of class Factory.
     */
    @Test
    public void testTARGET() {
        System.out.println("TARGET");
        Holiday result = Factory.TARGET();
        assertTrue("Wrong type of result from TARGET.",
                result instanceof Or);
        Or o = (Or)result;
        assertEquals("Wrong number of holidays in collection.", 7, o.size());
    }

    /**
     * Test of TARGET2 method, of class Factory.
     */
    @Test
    public void testTARGET2() {
        System.out.println("TARGET2");
        Holiday result = Factory.TARGET2();
        assertTrue("Wrong type of result from TARGET2.",
                result instanceof Or);
        Or o = (Or)result;
        assertEquals("Wrong number of holidays in collection.", 7, o.size());
    }

    /**
     * Test of UsNyseHolidays method, of class Factory.
     */
    @Test
    public void testUsNyseHolidays() {
        System.out.println("UsNyseHolidays");
        Holiday result = Factory.UsNyseHolidays();
        assertTrue("Wrong type of result from UsNyseHolidays.",
                result instanceof Or);
        Or o = (Or)result;
        assertEquals("Wrong number of holidays in collection.", 11, o.size());
    }
}
