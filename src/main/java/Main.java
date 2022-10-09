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

    public static void main(String[] args) {
        printArrayInReverse(new char[] {'A','B','C','D','E','F','G'});
        System.out.println();
        fibonacci(8);
    }
}
