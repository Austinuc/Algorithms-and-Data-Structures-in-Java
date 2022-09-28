package StringManipulationTests;

import org.junit.Test;

import java.util.Arrays;

import static StringManipulation.SplitStrings.splitStrings;
import static org.junit.Assert.*;

public class SplitStringsTest {

    @Test
    public void testString1() {

        assertEquals("[ab, c_]", Arrays.toString(splitStrings("abc")));
    }
    @Test
    public void testString2() {
        assertEquals("[He, ll, oW, or, ld]", Arrays.toString(splitStrings("HelloWorld")));
    }
    @Test
    public void testString3() {
        assertEquals("[ab, cd, ef]", Arrays.toString(splitStrings("abcdef")));
    }
}
