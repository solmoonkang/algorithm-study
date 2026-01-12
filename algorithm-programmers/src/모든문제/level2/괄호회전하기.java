package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호회전하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = bufferedReader.readLine();

        int validBracketRotationCount = getValidBracketRotationCount(parentheses);
        bufferedWriter.write(String.valueOf(validBracketRotationCount));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 괄호 문자열을 Deque에 담아서 순환하도록 한다.
     * for문으로 전체 문자열 길이만큼 반복하면서:
     *  - 현재 상태가 올바른 괄호인지 검사 -> isCorrectParenthesis(...)
     *  - 회전을 위해 앞의 문자를 빼서 뒤에 붙임 -> pollFirst() + offerLast()
     */
    private static int getValidBracketRotationCount(String parentheses) {
        Deque<Character> circulateDeque = new ArrayDeque<>();
        for (char parenthesis : parentheses.toCharArray()) circulateDeque.offerLast(parenthesis);

        int count = 0;
        for (int i = 0; i < parentheses.length(); i++) {
            if (isCorrectParenthesis(circulateDeque)) count++;

            char first = circulateDeque.pollFirst();
            circulateDeque.offerLast(first);
        }

        return count;
    }

    /**
     * 괄호 유효성을 검사하는 메서드로, 내부에서 스택처럼 동작하는 Deque를 하나 생성한다.
     * 문자를 하나씩 보면서:
     *  - 여는 괄호 -> 스택에 넣는다.
     *  - 닫는 괄호 -> 스택에서 꺼낸 값과 짝이 맞는지 확인한다.
     * 모든 문자를 다 검사했을 때 스택이 비어 있으면 -> 유효한 괄호
     */
    private static boolean isCorrectParenthesis(Deque<Character> circulateDeque) {
        Deque<Character> parenthesesDeque = new ArrayDeque<>();

        for (char parenthesis : circulateDeque) {
            if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
                parenthesesDeque.offerLast(parenthesis);
            } else {
                if (parenthesesDeque.isEmpty()) return false;
                char top = parenthesesDeque.pollLast();
                if (!isMatching(top, parenthesis)) return false;
            }
        }

        return parenthesesDeque.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
