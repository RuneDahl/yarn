/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the enum Mathematics.Relations.
 * @author Rune Dahl Iversen
 */
public class RelationsTest {
    public RelationsTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Relations");
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
     * Test of values method, of class Relations.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Relations[] expResult = new Relations[5];
        expResult[0] = Relations.LessThan;
        expResult[1] = Relations.LessThanOrEqualTo;
        expResult[2] = Relations.EqualTo;
        expResult[3] = Relations.GreaterThanOrEqualTo;
        expResult[4] = Relations.GreaterThan;
        Relations[] result = Relations.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Relations.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "EqualTo";
        Relations expResult = Relations.EqualTo;
        Relations result = Relations.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Relations.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Relations[] relations = Relations.values();
        for (int i = 0; i < relations.length; i++) {
            Relations instance = relations[i];
            int expResult = i - 2;
            int result = instance.getValue();
            assertEquals("Value of " + instance.toString(), expResult, result);
        }
    }
}