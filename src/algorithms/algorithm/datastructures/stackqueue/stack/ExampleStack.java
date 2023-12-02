package algorithms.algorithm.datastructures.stackqueue.stack;

import java.util.Stack;

public class ExampleStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        int[] arrayStack = new int[5];

        System.out.println("====== Array Stack Test =====");

        for (int i = 0; i < 5; i++) {

            stack.push(i);
        }

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
