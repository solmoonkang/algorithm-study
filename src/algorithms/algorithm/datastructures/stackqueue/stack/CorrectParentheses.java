package algorithms.algorithm.datastructures.stackqueue.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CorrectParentheses {

    public boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            switch (c) {

                case '(' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }


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














    public boolean solution_stack(String s) {

        Stack<String> parentheses = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 시작 괄호를 만날 때마다 스택에 추가하고,
            if (s.charAt(i) == '(') {
                parentheses.push("(");
            }

            else if (s.charAt(i) == ')') {
                // 닫는 괄호를 만날 때마다 스택의 가장 최근에 추가된 열린 괄호와 짝이 맞는지 확인
                if (parentheses.isEmpty()) {
                    return false;
                }
                parentheses.pop();
            }
        }
        // 모든 문자열 처리 후 스택이 비어있으면, 올바른 괄호 쌍이며, 그렇지 않으면, 올바르지 않은 괄호
        return parentheses.isEmpty();
    }

    public static void main(String[] args) {

        CorrectParentheses correctParentheses = new CorrectParentheses();

//        System.out.println("Result : " + correctParentheses.solution("()()"));
//        System.out.println("Result : " + correctParentheses.solution("(())()"));
//        System.out.println("Result : " + correctParentheses.solution(")()("));
//        System.out.println("Result : " + correctParentheses.solution("(()("));

        System.out.println("Result : " + correctParentheses.solution_stack("(())()"));
    }
}
