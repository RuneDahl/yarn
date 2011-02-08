/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import Mathematics.Function.Function;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit tests for implementations of the
 * abstract class Mathematics.Graph.Tree.FunctionOfStateAndChildren.
 * @author Rune Dahl Iversen
 */
public class FunctionOfStateAndChildrenTest<TypeOfState, TypeOfValue> {
    public FunctionOfStateAndChildrenTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
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
     * Test of getFunction method, of class FunctionOfStateAndChildren.
     */
    public void testGetFunction(
            final FunctionOfStateAndChildren<TypeOfState, TypeOfValue> instance,
            final Function<TypeOfState, TypeOfValue> expResult) {
        Function result = instance.getFunction();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFunction method, of class FunctionOfStateAndChildren.
     */
    public void testSetFunction(
            final FunctionOfStateAndChildren<TypeOfState, TypeOfValue> instance,
            final Function<TypeOfState, TypeOfValue> function) {
        instance.setFunction(function);
        this.testGetFunction(instance, function);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
