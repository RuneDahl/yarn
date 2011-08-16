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
 * of the class Mathematics.Matrix.Command.Columns.
 * @author Rune Dahl Iversen
 */
public class ColumnsTest<TypeOfValue> {
    public ColumnsTest() {
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
     * Test of getFirstColumn method, of class Columns.
     */
    public void testGetFirstColumn(Columns<TypeOfValue> instance, int expResult) {
        int result = instance.getFirstColumn();
        assertEquals("Wrong result from " + instance.getClass().getName() +
                ".getFirstColumn().", expResult, result);
    }

    /**
     * Test of setFirstColumn method, of class Columns.
     */
    public void testSetFirstColumn(Columns<TypeOfValue> instance, int firstColumn) {
        instance.setFirstColumn(firstColumn);
        this.testGetFirstColumn(instance, firstColumn);
    }

    /**
     * Test of getSecondColumn method, of class Columns.
     */
    public void testGetSecondColumn(Columns<TypeOfValue> instance, int expResult) {
        int result = instance.getSecondColumn();
        assertEquals("Wrong result from " + instance.getClass().getName() +
                ".getSecondColumn().", expResult, result);
    }

    /**
     * Test of setSecondColumn method, of class Columns.
     */
    public void testSetSecondColumn(Columns<TypeOfValue> instance, int secondColumn) {
        instance.setSecondColumn(secondColumn);
        this.testGetSecondColumn(instance, secondColumn);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
