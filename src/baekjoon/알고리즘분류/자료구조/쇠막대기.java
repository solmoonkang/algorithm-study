package baekjoon.알고리즘분류.자료구조;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 쇠막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = bufferedReader.readLine();

        Deque<Character> deque = new LinkedList<>();

        int pieces = 0;

        for (int i = 0; i < parentheses.length(); i++) {
            char currentParenthesis = parentheses.charAt(i);

            if (currentParenthesis == '(') {
                deque.offerLast(currentParenthesis);
            } else {
                if (parentheses.charAt(i - 1) == '(') {
                    deque.pollLast();
                    pieces += deque.size();
                } else {
                    deque.pollLast();
                    pieces += 1;
                }
            }
        }

        bufferedWriter.write(String.valueOf(pieces));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
