package Stack;
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * For a given chemical formula represented by a string, count the number of atoms of each element contained in the molecule and return an object
 * (associative array in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).
 */
public class MoleculeOfAtoms {

    public static Map<String,Integer> getAtoms(String formula) {

        Map<String, String> inverseBraces = new HashMap<>();
        inverseBraces.put("(", ")");
        inverseBraces.put("[", "]");
        inverseBraces.put("{", "}");

        Map<String, Integer> result = new HashMap<String,Integer>();

        Deque<Integer> multipliers = new ArrayDeque<>();
        multipliers.push(1); //initialize to 1

        Deque<String> braces = new ArrayDeque<>();


        Integer singleElemCount = 1, totalElemCount = 0;
        String element = "";


        for (int i = formula.length()-1; i >=0; i--) {
            //Add opening braces to the brace STACK
            if (formula.charAt(i) == ']' || formula.charAt(i) == ')' || formula.charAt(i) == '}') {
                braces.push(formula.charAt(i)+"");
                continue;
            }
            if (formula.charAt(i) > '0' && formula.charAt(i) <= '9') {
                //check if next symbol is another number or element instead of an opening brace, eg. H'2'O, CH'12'Cl, Mg'3'O'2'
                //ie. check for multipliers that is only applied to one element instead of a group of elements
                if (!(formula.charAt(i-1) == ']' || formula.charAt(i-1) == '}' || formula.charAt(i-1) == ')')) {
                    //check if multiplier has single or more digits
                    singleElemCount = (singleElemCount != 1) ? (formula.charAt(i) - 48) * 10 + singleElemCount : formula.charAt(i) - 48;
                }
                //if a brace is following, then add multiplier to the multiplier STACK
                else multipliers.push(multipliers.peek()*(formula.charAt(i) - 48));

                continue;
            }
            //check if we have reached a closed brace
            else if (formula.charAt(i) == '[' || formula.charAt(i) == '(' || formula.charAt(i) == '{') {

                //check for incorrect syntax
                if (braces.isEmpty() || !braces.pop().equals(inverseBraces.get(formula.charAt(i)+""))) throw new IllegalArgumentException();

                //removes the multiplier for the current closing brace for the STACK
                if (multipliers.peek() != 1) multipliers.pop();

                continue;

            }
            //if it's a small letter, then add to element name
            else if (formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
                element = formula.charAt(i) + element;
                continue;
            }
            //get the name of the current element
            else element = formula.charAt(i) + element;

            //get the total count of the element
            totalElemCount = multipliers.peek() * singleElemCount;

            //add it to result map, updating repeated entries
            result.put(element, result.getOrDefault(element, 0) + totalElemCount);

            //reset values to default and continue
            element = "";
            singleElemCount = 1;
        }

        //Validates syntax
        if (result.isEmpty() || !braces.isEmpty())
            throw new IllegalArgumentException();


        return result;
    }
}
