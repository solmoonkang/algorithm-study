package baekjoon.단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String PS = bufferedReader.readLine();

            if (isValidParenthesis(PS)) bufferedWriter.write("YES\n");
            else bufferedWriter.write("NO\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isValidParenthesis(String PS) {
        Deque<Character> parenthesisDeque = new ArrayDeque<>();

        for (char parenthesis : PS.toCharArray()) {
            if (parenthesis == '(') parenthesisDeque.offerLast(parenthesis);
            else if (parenthesis == ')') {
                if (parenthesisDeque.isEmpty()) return false;
                parenthesisDeque.pollLast();
            }
        }

        return parenthesisDeque.isEmpty();
    }
}
