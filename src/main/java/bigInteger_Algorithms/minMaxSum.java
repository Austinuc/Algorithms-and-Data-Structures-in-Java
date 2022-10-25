package bigInteger_Algorithms;
import java.util.*;
import java.math.*;

public class minMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void solution(List<Integer> arr) {
        // Write your code here
        BigInteger minVal = BigInteger.valueOf(Long.MAX_VALUE), maxVal = BigInteger.ZERO, sum = BigInteger.ZERO;
        for (Integer a : arr) {
            sum = sum.add(BigInteger.valueOf(a));
        }

        for (int i = 0; i < arr.size(); i++) {
            minVal = minVal.min(sum.subtract(BigInteger.valueOf(arr.get(i))));
            maxVal = maxVal.max(sum.subtract(BigInteger.valueOf(arr.get(i))));
        }

        System.out.printf("%d %d\n", minVal, maxVal);

    }

}
