package 모든문제.level2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 올바른괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = bufferedReader.readLine();

        boolean isCorrectParentheses = isCorrectParentheses(parentheses);
        bufferedWriter.write(String.valueOf(isCorrectParentheses));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isCorrectParentheses(String parentheses) {
        Deque<Character> deque = new LinkedList<>();

        for (char parenthesis : parentheses.toCharArray()) {
            if (parenthesis == '(') {
                deque.offerLast(parenthesis);
            } else if (parenthesis == ')') {
                if (deque.isEmpty()) return false;
                deque.pollLast();
            }
        }

        return deque.isEmpty();
    }

    private static boolean isCorrectParenthesesWithCounter(String parentheses) {
        int count = 0;

        for (char parenthesis : parentheses.toCharArray()) {
            if (parenthesis == '(') count++;
            if (parenthesis == ')') count--;
            if (count < 0) break;
        }

        return count == 0;
    }
}
