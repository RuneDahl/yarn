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
 * of the class Mathematics.Matrix.Command.Row.
 * @author Rune Dahl Iversen
 */
public class RowTest<TypeOfValue> {
    public RowTest() {
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
     * Test of setRow method, of class Row.
     */
    public void testSetRow(final Row<TypeOfValue> instance, final int newRow) {
        instance.setRow(newRow);
        this.testGetRow(instance, newRow);
    }

    /**
     * Test of getRow method, of class Row.
     */
    public void testGetRow(final Row<TypeOfValue> instance, final int expResult) {
        int result = instance.getRow();
        assertEquals("Wrong value from " + instance.getClass().getName() +
                ".getRow().", expResult, result);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}