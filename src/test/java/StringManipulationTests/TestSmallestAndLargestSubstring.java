package StringManipulationTests;
import org.junit.Test;
import static StringManipulation.GetSmallestAndLargest.getSmallestAndLargest;
import static org.junit.Assert.assertEquals;

public class TestSmallestAndLargestSubstring {

    @Test
    public void smallestAndLargestSubstringTest() {
        assertEquals("ava\nwel",getSmallestAndLargest("welcometojava", 3));
    }
}
