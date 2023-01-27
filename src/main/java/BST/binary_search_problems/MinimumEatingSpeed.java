package BST.binary_search_problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class MinimumEatingSpeed {

    /**
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        //Find max banana tha can be contained in a pile
        int max = 0;
        for (int e : piles) {
            max = Math.max(max, e);
        }
        /**
         * This max is the highest eating speed for Koko to finish the banana in <= h.
         *
         * The goal is to search for the lowest eating speed in the range of 0 - max. In other words,
         * this is similar to finding the index of the 1st occurrence of a number within a sorted array using Binary search.
         */

        int low = 0, high = max, ans = 1;

        while (low <= high) {
            int currentSpeed = low + (high - low)/2;

            int timeToEatAllBananas = calculateTimeToEatAllBananas(piles, currentSpeed);
            if (timeToEatAllBananas <= h) { //Continue searching the lower range for the lowest speed
                ans = currentSpeed;
                high = currentSpeed - 1;
            } else {
                low = currentSpeed + 1;
            }
        }

        return ans;

    }

    public int calculateTimeToEatAllBananas(int[] arr, int speed) {
        if (speed == 0) return Integer.MAX_VALUE;
        int t = 0;
        for (int j : arr) {
            t += Math.ceilDiv(j, speed);

        }
        return t;
    }



    public static void main(String[] args) {


//        System.out.println(Math.ceil(2/4 * 1.0));
    }
}
