package String_Manipulation;

import java.util.*;
public class ShadesOfGrey {
    /**
     * Write a function that takes a number n as a parameter and return an array containing n
     * shades of grey in hexadecimal code (#aaaaaa for example).
     * The array should be sorted in ascending order starting with '#010101', '#020202', etc. (using lower case letters).
     *
     * Conditions: if n > 254, only return an array of size 254
     */
    static String[] shadesOfGrey(int num) {
        // returns n shades of grey in an array
        if (num > 254) {
            num = 254;
        }
        System.out.println(num);
        if (num <= 0) {
            return new String[0];
        }
        String[] index = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String[] result = new String[num];
        int c = 0;
        for (int i = 0, j = 0; i < num; i++) {

            if (j > 14 && c == 0) {c++; j = 0;}
            else if (j > 15) {c++; j = 0;}
            //for the 1st iteration, the 1st index starts from 0 while the 2nd pair starts from 1
            // eg. [#010101, #020202, #030303, #040404, #050505, #060606, #070707, #080808, #090909, #0a0a0a, #0b0b0b, #0c0c0c, #0d0d0d, #0e0e0e, #0f0f0f]
            if (c == 0)
                result[i] = "#"+index[c]+(index[j+1])+index[c]+(index[j+1])+index[c]+(index[j+1]);
                //for other iterations, the 1st index continues from 0 while the 2nd pair starts from 0
            else
                result[i] = "#"+index[c]+(index[j])+index[c]+(index[j])+index[c]+(index[j]);
            j++;
        }

        return result;
    }
}
