package StringManipulationTests;

import org.junit.Test;

import static String_Manipulation.PalindromicString.stringIsAPalindrome;
import static org.junit.Assert.assertEquals;

public class TestForPalindromicStrings {

    @Test
    public void testStringForPalindrome() {
        assertEquals(true, stringIsAPalindrome("madam"));
    }
}
