package String_Manipulation;
import java.util.*;
/**
 * Task: Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithUniqueCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<String, Integer> uniqueChars = new HashMap<>();
            if (s.length() == 0) return 0;
            String[] arr = s.split("");
            int maxSubstring = 0;
            int lenSubstring = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!uniqueChars.containsKey(arr[i])) {
                    uniqueChars.put(arr[i], i);
                    lenSubstring++;
                    maxSubstring =(maxSubstring > lenSubstring)? maxSubstring : lenSubstring;
                } else {
                    i = uniqueChars.get(arr[i]);
                    uniqueChars.clear();
                    maxSubstring =(maxSubstring > lenSubstring)? maxSubstring : lenSubstring;
                    lenSubstring = 0;
                }
            }
            return maxSubstring;
        }
    }
}
