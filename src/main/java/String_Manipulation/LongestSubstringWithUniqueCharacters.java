package String_Manipulation;
import java.util.*;
/**
 * Task: Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithUniqueCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<String, Integer> uniqueChars = new HashMap<>();
            //Convert string to arrays
            String[] arr = s.split("");
            int maxSubstring = 0;
            int tempSubstring = 0;
            for (int i = 0; i < s.length(); i++) {
                //check for unique characters
                if (!uniqueChars.containsKey(arr[i])) {
                    //Add char string to map with the value as it array index
                    uniqueChars.put(arr[i], i);
                    //update max length of unique substring
                    tempSubstring++;
                    maxSubstring = Math.max(maxSubstring, tempSubstring);

                } else {
                    //Get current index of the first occurrence of the duplicate char and use it as starting index
                    // for next iteration
                    i = uniqueChars.get(arr[i]);
                    //Clear map to re-use for next window
                    uniqueChars.clear();
                    //update max length of unique substring
                    maxSubstring = Math.max(maxSubstring, tempSubstring);
                    tempSubstring = 0;
                }
            }
            return maxSubstring;
        }
    }
}
