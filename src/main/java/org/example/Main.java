package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        Set<Integer> goodSub = new HashSet<>();
        int len = 0, tmp = 0, j = 0;

        for (int i = 0; (i <= nums.length); i++) {

            if (goodSub.size() == k) {
                len++; tmp = i; j++;
                while (tmp < nums.length) {
                    if (goodSub.contains(nums[tmp++])) len++;
                    else break;
                }
                goodSub.clear();
                //get sub array btw j - i
                int[] sub = Arrays.copyOfRange(nums,j,i--);
                //add sub array to set and continue
                goodSub.addAll(Arrays.stream(sub).boxed().toList());
                continue;
            }
            if (i != nums.length) goodSub.add(nums[i]);
            else {
                if (j < nums.length) {
                    goodSub.clear();
                    i = j++;
                }
            }
        }
        return len;

    }
    public static void main(String[] args) {
        Set<Integer> num = new HashSet<>();


        int[] nums = {48,18,15,17,35,33,3,22,14,52,18,32,45,33,39,7,52,2,4,22,13,41,4,29,3,7,34,31,4,49,3,8,20,42,12,11,35,42,3,21,27,29,37,21,40,50,22,7,2,32,1,1,22,33,19,52,38,34,36,48,40,28,47,8,7,46,17,7,2,21,49,6,7,50,15,31,50,52,1,27,3,15,5,6,23,26,34,50,15,22,26,39,28,25,25,21,37,28,45};
        int result = subarraysWithKDistinct(new int[] {1,2,1,2,3}, 1000);
        System.out.println(result);
    }
}