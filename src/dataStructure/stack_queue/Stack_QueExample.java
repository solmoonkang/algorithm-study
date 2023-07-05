package dataStructure.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_QueExample {

    public static void main(String[] args) {

        // LIFO
        Stack<Integer> stack = new Stack<>();

        // FIFO : Queue 인터페이스는 여러 가지가 존재하지만, LinkedList 사용해서 구현
        Queue<Integer> queue = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("===== Stack =====");
        while (!stack.isEmpty()) {
            System.out.println("Stack : " + stack.pop());
        }

        System.out.println("===== Queue =====");
        while (!queue.isEmpty()) {
            System.out.println("Queue : " + queue.poll());
        }
    }
}
