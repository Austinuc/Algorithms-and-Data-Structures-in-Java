package Arrays_Algorithms;

/**
 * given an array of up to four non-negative integers, each less than 256.
 *
 * Your task is to pack these integers into one number M in the following way:
 *
 * The first element of the array occupies the first 8 bits of M;
 * The second element occupies next 8 bits, and so on.
 */
public class ArrayPacking {

    public static long arrayPacking(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum |= (long) arr[i] << 8*i;
        }

        return sum;
    }

    //Second approach
    public static long arrayPacking2(int[] arr) {
        String ans = "";
        String tmp = "";
        for (int i = 0; i < arr.length; i++) {
            tmp = Integer.toBinaryString(arr[i]);
            while(tmp.length() < 8) { //fillup right most digits until digit length is 8
                tmp = "0"+tmp;
            }
            ans = tmp + ans;
        }
        return Long.valueOf(ans,2); //convert string in base 2 to a long in decimal
    }
}
