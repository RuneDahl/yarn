/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to help in jUnit-testing implementations of the class
 * Mathematics.Interpolation.Interpolator.
 * @author Rune Dahl Iversen
 */
public class InterpolatorTest<TypeOfData, TypeOfInput, TypeOfOutput> {
    public InterpolatorTest() {
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
     * Test of getData method, of class Interpolator.
     */
    public void testGetData(
            final Interpolator<TypeOfData, TypeOfInput, TypeOfOutput> instance,
            final TypeOfData expResult) {
        TypeOfData result = instance.getData();
        assertEquals("Wrong data from " + instance.getClass().getName(),
                expResult, result);
    }

    /**
     * Test of setData method, of class Interpolator.
     */
    public void testSetData(
            final Interpolator<TypeOfData, TypeOfInput, TypeOfOutput> instance,
            final TypeOfData data) {
        instance.setData(data);
        this.testGetData(instance, data);
    }

    /**
     * A blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
