/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit test for implementations
 * of the class Mathematics.Matrix.Command.Rows.
 * @author Rune Dahl Iversen
 */
public class RowsTest<TypeOfValue> {
    public RowsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstRow method, of class Rows.
     */
    public void testGetFirstRow(Rows<TypeOfValue> instance, int expResult) {
        int result = instance.getFirstRow();
        assertEquals("Wrong result from " + instance.getClass().getName() +
                ".getFirstRow().", expResult, result);
    }

    /**
     * Test of setFirstRow method, of class Rows.
     */
    public void testSetFirstRow(Rows<TypeOfValue> instance, int firstRow) {
        instance.setFirstRow(firstRow);
        this.testGetFirstRow(instance, firstRow);
    }

    /**
     * Test of getSecondRow method, of class Rows.
     */
    public void testGetSecondRow(Rows<TypeOfValue> instance, int expResult) {
        int result = instance.getSecondRow();
        assertEquals("Wrong result from " + instance.getClass().getName() +
                ".getSecondRow().", expResult, result);
    }

    /**
     * Test of setSecondRow method, of class Rows.
     */
    public void testSetSecondRow(Rows<TypeOfValue> instance, int secondRow) {
        instance.setSecondRow(secondRow);
        this.testGetSecondRow(instance, secondRow);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
