package Recursion_Algorithms;

public class Practice {
    static String res = "";
    static boolean f = false;

    public static String backTrack(String foo, int i) {
        if (i < 0) return "";
        if (i == foo.length()-1) {
            f = true;
//            return "";
        }
        String s = foo.substring(i, i+1);

        if (!f) {
            System.out.print(s);
            backTrack(foo, i + 1);
        }
        else {
            System.out.print(s);
            backTrack(foo, i - 1);
        }

        res += s;
//        System.out.print(s);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(backTrack("abcdef", 0));
//        backTrack("abcdef", 0);
    }
}
