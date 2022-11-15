package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DequesPractice {

    public static void push() {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (Integer a : stack) {
            System.out.println(stack.peek()*10);
        }

        System.out.println(stack);

    }

    public static void add() {
        Deque<String> stack = new ArrayDeque<>();
        stack.add("a");
        stack.add("z");
        stack.add("b");
        stack.add("c");
        stack.add("d");

        for (String a : stack) {
            System.out.println(stack.peek());
        }

        System.out.println(stack);
    }

    public static void main(String[] args) {
        push();
//        Map<String, Integer> map = new HashMap<>();
//        map.getOrDefault()
    }
}
