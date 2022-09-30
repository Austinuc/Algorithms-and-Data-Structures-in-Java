package StringManipulationTests;
import org.junit.Test;
import static String_Manipulation.GetSmallestAndLargest.getSmallestAndLargest;
import static org.junit.Assert.assertEquals;

public class TestSmallestAndLargestSubstring {

    @Test
    public void smallestAndLargestSubstringTest() {
        assertEquals("ava\nwel",getSmallestAndLargest("welcometojava", 3));
    }
}
