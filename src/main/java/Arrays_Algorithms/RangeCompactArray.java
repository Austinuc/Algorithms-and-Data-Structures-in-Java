package Arrays_Algorithms;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeCompactArray {
    public static String rangeCompact(ArrayList<Integer> arr) {
        System.out.println(arr);
        String ans = "";
        int count = 1;

        //[-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20]
        //-6,-3-1,3-5,7-11,14,15,17-20

        for (int j = 1, k = 0; j < arr.size(); j++) {

            if (arr.get(j) - arr.get(j-1) != 1 || j == arr.size()-1) {
                if (j == arr.size()-1 && arr.get(j)-arr.get(j-1) == 1) //checks if we're at the last element
                    count++;
                if (count < 3 ) {
                    while (k<j) //print from k to j-1
                        ans += (k==0) ? arr.get(k++) : ","+arr.get(k++);
                } else if (count>=3 && k==0) //don't add comma while printing the first element
                    ans += arr.get(k)+"-"+arr.get(j-1);
                else if (j == arr.size()-1 && arr.get(j)-arr.get(j-1) != 1) {
                    ans += ","+arr.get(k)+"-"+arr.get(j-1);
                    ans += ","+arr.get(j);
                    break;
                } else //print from k - j if you're at the last element or from k - j-1 otherwise
                    ans += (j == arr.size()-1) ? ","+arr.get(k)+"-"+arr.get(j) : ","+arr.get(k)+"-"+arr.get(j-1);

                k = j; //move you starting point to your current position
                count = 1; //reset your count and continue
                continue;
            }
            count++;
        }
        System.out.println(ans+"\n");
        return ans;
    }

    public static void main(String[] args) {
        //rangeCompact(new ArrayList<Integer>(Arrays.asList(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)));
        //rangeCompact(new ArrayList<Integer>(Arrays.asList(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20)));
        rangeCompact(new ArrayList<Integer>(Arrays.asList(-48, -45, -42, -41, -38, -36, -34, -31, -29, -28, -27, -25, -24, -21, -19, -18, -16, -14, -13, -12, -11, -10, -7)));
    }
}
