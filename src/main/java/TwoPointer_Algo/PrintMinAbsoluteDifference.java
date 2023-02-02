package TwoPointer_Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintMinAbsoluteDifference {

    /*
     * given an array of distinct integers , determine the minimum absolute difference between any two elements. print all
     * element pairs with that difference in ascending order.
     * Example
     * numbers = [6,2,4,10]
     * The minimum absolute difference is 2 and the pairs with that difference are (2,4) and (4,6),
     * when printing element pairs (i,j), they should be ordered ascending first by i and they by j.
     * */

    public static void printMin(ArrayList<Integer> numbers) {
        int min = Integer.MAX_VALUE;

        Collections.sort(numbers);

        List<String> ans = new ArrayList<>();

        for (int i = 0, j = 1; j < numbers.size(); i++, j++) {

            if ((numbers.get(j) - numbers.get(i)) < min) {
                min = numbers.get(j) - numbers.get(i);
                ans.clear();
                ans.add(numbers.get(i) +" "+ numbers.get(j));
            } else if (numbers.get(j) - numbers.get(i) == min)
                ans.add(numbers.get(i) +" "+ numbers.get(j));
        }

        for (String s : ans)
            System.out.println(s);
    }
}
