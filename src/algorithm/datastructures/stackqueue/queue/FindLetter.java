package algorithm.datastructures.stackqueue.queue;

import java.util.Deque;
import java.util.LinkedList;

public class FindLetter {

    public boolean solution(String s) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        FindLetter letter = new FindLetter();

        System.out.println("Result : " + letter.solution("babad"));
        System.out.println("Result : " + letter.solution("cbbdaaa"));
        System.out.println("Result : " + letter.solution("abcdef"));
    }
}
