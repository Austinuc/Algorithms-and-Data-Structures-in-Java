package Arrays_Algorithms;

public class ArrayProblems {


    public String toString(int[] arr) {
        StringBuilder res = new StringBuilder("[");
        for (int i =0; i< arr.length; i++) {
            res.append((i == arr.length - 1) ? arr[i] : arr[i] + ", ");
        }

        return res+"]";
    }

    public int[] reverse(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = arr.length - 1, j = 0; i >= 0; i--) {
            res[j++] = arr[i];
        }
        return res;
    }

    public int[] rotateRight(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length -1) {
                int t = arr[i+1];
                arr[i+1] = temp;
                temp = t;
            } else {
                arr[0] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println(new ArrayProblems().toString(arr));
        System.out.println(new ArrayProblems().toString(new ArrayProblems().reverse(arr)));
        arr = new ArrayProblems().rotateRight(arr);
        System.out.println(new ArrayProblems().toString(arr));
        arr = new ArrayProblems().rotateRight(arr);
        System.out.println(new ArrayProblems().toString(arr));
    }
}
