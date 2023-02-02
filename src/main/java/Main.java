import Sorting_Algorithms.MergeSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int index = 0;
    public static void printArrayInReverse(char[] s) {
        /**
         * setting our terminating condition
         */
        if (index == s.length - 1) {
            return;
        }
        /**
         * First Phase(before the recursive function call).
         * We want to store each character in the stack, so we can access them in reverse
         * order during the Second Phase of the function call
         */
        char character = s[index];
        index++;
        /**
         * Time to make our recursive call
         */
        printArrayInReverse(s);

        /**
         * Second Phase: we print out the characters as they're popped from the STACK
         */
        System.out.print(character);
    }


    static int n0 = 0, n1 = 1;
    public static void fibonacci(int N) {

        int n3;
        if (N > 1) {
            n3 = n1 + n0;
            n0 = n1;
            n1 = n3;
//            System.out.print(n3+",");
            fibonacci(N - 1);
            System.out.print(n3+",");
        }
    }

    public static int powers0f2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
//            int prev = powers0f2(n / 2);
            int curr = powers0f2(n / 2) * 2;
            System.out.println(curr);
            return curr;
            }
    }


    public static void main(String[] args) {
        double s = 12373/9.0;
        System.out.println(s);

        Pattern p = Pattern.compile("e", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("ADCT9REODG");
        System.out.println(m.find());

//        printArrayInReverse(new char[] {'A','B','C','D','E','F','G'});
//        System.out.println();
//        fibonacci(8);
//        powers0f2(13);
//        System.out.println(isPil("cdecd", List.of(0,0,0,0), List.of(0,1,2,3), List.of(0,1,1,0)));
//        System.out.println(Arrays.toString(MergeSort.mSort(new Integer[]{6, 3, 2, 10, 1, 8, 0, -1}, 0, 8)));

//        System.out.println(tri(5,6,4,2,7,5,7,5,4,2));
    }


}
