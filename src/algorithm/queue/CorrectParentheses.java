package algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

public class CorrectParentheses {

    boolean solution_deque(String s) {

        Deque<String> deque = new LinkedList<>();

        // 문자열 s 를 Deque 에 삽입
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                deque.offerLast("(");

            } else if (s.charAt(i) == ')') {

                if (deque.isEmpty()) {

                    return false;
                }

                deque.pollLast();
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {

        CorrectParentheses correctParentheses = new CorrectParentheses();

        System.out.println("Result : " + correctParentheses.solution_deque("()()"));
        System.out.println("Result : " + correctParentheses.solution_deque("())"));
        System.out.println("Result : " + correctParentheses.solution_deque("()()(())()((()"));
    }
}
