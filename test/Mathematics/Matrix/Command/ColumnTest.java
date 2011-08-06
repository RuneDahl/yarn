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
 * of the class Mathematics.Matrix.Command.Column.
 * @author Rune Dahl Iversen
 */
public class ColumnTest<TypeOfValue> {
    public ColumnTest() {
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
     * Test of setColumn method, of class Column.
     */
    public void testSetColumn(final Column<TypeOfValue> instance, final int newColumn) {
        instance.setColumn(newColumn);
        this.testGetColumn(instance, newColumn);
    }

    /**
     * Test of getColumn method, of class Column.
     */
    public void testGetColumn(final Column<TypeOfValue> instance, final int expResult) {
        int result = instance.getColumn();
        assertEquals("Wrong value from " + instance.getClass().getName() +
                ".getColumn().", expResult, result);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
