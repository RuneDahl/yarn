/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the abstract class Mathematics.Result.Iterative.
 * @author Rune Dahl Iversen
 */
public class IterativeTest {
    public static void getIterationsTest(final Iterative result, int expected) {
        System.out.println("iterations for " + result.getClass().getName());
        assertEquals(expected, result.getIterations());
    }

    /**
     * Dummy test to allow this class in the test setup without causing failure.
     */
    @Test
    public void BlankTest(){
    }
}