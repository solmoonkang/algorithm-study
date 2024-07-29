package programmers.알고리즘고득점KIT.Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

public class 올바른괄호 {

    boolean solution(String s) {

        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                open++;
            } else if (s.charAt(i) == ')') {

                close++;
            }

            if (open < close) {
                return false;
            }
        }

        if (open == close) {

            return true;
        }

        return true;
    }

    boolean solution_deque(String s) {

        Deque<String> deque = new LinkedList<>();

        // 문자열의 길이만큼 반복문을 실행하여 문자열의 각 문자를 순회
        for (int i = 0; i < s.length(); i++) {

            // 현재 문자가 여는 괄호일 경우, 덱의 마지막에 여는 괄호를 추가
            if (s.charAt(i) == '(') {

                deque.offerLast("(");
            // 현재 문자가 닫는 괄호일 경우,
            } else if (s.charAt(i) == ')') {

                // 덱이 비어있는지 확인하고, 비어있다면 false 를 반환
                if (deque.isEmpty()) {

                    return false;
                }

                // 비어있지 않다면, 마지막으로 추가된 여는 괄호와 현재 닫는 괄호가 짝을 이루어 덱의 마지막 요소를 제거
                deque.pollLast();
            }
        }

        // 반복문이 종료된 후, 덱이 비어있는지 확인하고 덱이 비어있다면, 모든 괄호들이 올바르게 열고 닫힌 것으로 true 를 반환
        return deque.isEmpty();
    }

    public static void main(String[] args) {

        올바른괄호 correct = new 올바른괄호();

        System.out.println("Result : " + correct.solution("())"));
        System.out.println("Result : " + correct.solution_deque("()()"));
    }
}
