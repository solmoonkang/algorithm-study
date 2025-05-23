package 모든문제.level2.틀린문제;

import java.io.*;
import java.util.*;

public class 괄호회전하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = bufferedReader.readLine();

        int rotatedNumber = getCorrectStringsRotatedNumber(parentheses);
        bufferedWriter.write(String.valueOf(rotatedNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getCorrectStringsRotatedNumber(String parentheses) {
        Deque<Character> rotatedParentheses = new ArrayDeque<>();

        for (char parenthesis : parentheses.toCharArray()) rotatedParentheses.offerLast(parenthesis);

        int rotatedNumber = 0;

        for (char parenthesis : parentheses.toCharArray()) {
            if (isCorrectParentheses(rotatedParentheses)) rotatedNumber++;

            char current = rotatedParentheses.pollFirst();
            rotatedParentheses.offerLast(current);
        }


        return rotatedNumber;
    }

    private static boolean isCorrectParentheses(Deque<Character> rotatedParentheses) {
        Deque<Character> temporaryDeque = new ArrayDeque<>();

        for (char parenthesis : rotatedParentheses) {
            if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
                temporaryDeque.offerLast(parenthesis);
            } else {
                if (temporaryDeque.isEmpty()) return false;

                char open = temporaryDeque.pollLast();
                if (!isMatching(open, parenthesis)) return false;
            }
        }

        return temporaryDeque.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
