package String_Manipulation;


public class TimeConversion {

    /**
     * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
     *
     * @param s: A single string  that represents a time in 12-hour clock format (i.e. hh:mm:ssAM  or hh:mm:ssPM).
     * @return: a new string representing the input time in 24-hour format.
     *
     * Examples: Sample input: 07:05:45PM. Output: 19:05:45
     */
    public static String timeConversion(String s) {

        String[] str = {"01","02","03","04","05","06","07","08","09","10","11","00",
                "12","13","14","15","16","17","18","19","20","21","22","23"
        };

        //Extract the digit part HH:MM:SS
        String[] temp = s.substring(0,(s.length() - 2)).split(":");
        String ans = null;
        if (s.charAt(s.length() - 2) == 'A') { //Check for AM
            ans = ""+str[Integer.parseInt(temp[0]) - 1]; //get the HH part
        } else {
            int index = (Integer.parseInt(temp[0]) == 12) ? 12 : 12 + Integer.parseInt(temp[0]);
            ans = ""+str[index]; //Get the HH part for PM
        }
        ans += s.substring(2, s.length() - 2); //Join the :MM:SS part only to the HH part

        return ans;

    }
}
