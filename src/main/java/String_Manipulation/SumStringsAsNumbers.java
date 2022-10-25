package String_Manipulation;

public class SumStringsAsNumbers {
    public static String sumStrings(String a, String b) {

        int lenA = a.length(), lenB = b.length(), valA = 0, valB = 0, carry = 0;
        int len = (lenA-- >= lenB--) ? lenA : lenB;

        String result = "";

        for (int i = len; i >= 0; i--) {
            valA = (lenA < 0) ? 0 : a.charAt(lenA--)-48;
            valB = (lenB < 0) ? 0 : b.charAt(lenB--)-48;

            int tmp = valA + valB + carry;
            result = tmp%10 + result;
            carry = tmp/10;
        }

        if (carry != 0)
            result = carry + result;

        while (result.charAt(0) == '0')
            result = result.substring(1,result.length());

        return result;

    }
}
