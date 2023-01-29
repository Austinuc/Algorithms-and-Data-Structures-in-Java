package FastAndSlowPointer_Algo;

/**
 * Write an algorithm to determine if a number
 * �
 * n
 *  is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1
 *
 * Those numbers for which this process ends in 1 are happy.
 * Return TRUE if n is a happy number, and FALSE if not.
 */
public class HappyNumber {

    public static boolean isHappyNumber(int n) {

        /**
         * Initialize fast and slow pointers with slow = n  and fast = sum of digits squared of (n)
         */
        int slow = n, fast = sumOfDigitsSqr(n);

        /**
         * If fast is one, then n is a happy number.
         * If fast == slow, there is an endless loop, so n is not a happy number
         * move slow one step and fast two steps from their current values
         *
         * i.e. slow = sum of digits squared of (slow) and fast sum of digits squared of (sum of digits squared of (fast))
         */
        while(true) {

            if (fast == 1) break;
            if (slow == fast) return false;
            else {
                slow = sumOfDigitsSqr(slow);
                fast = sumOfDigitsSqr(sumOfDigitsSqr(fast));
            }
        }
        return true;
    }

    public static int sumOfDigitsSqr(int n) {
        int res = 0;

        while (n > 0) {
            res += (int) Math.pow(n % 10, 2.0);
            n /= 10;
        }
        return res;
    }
}
