package 단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String validString = bufferedReader.readLine();
            if (validString.equals(".")) break;

            if (isValidString(validString)) bufferedWriter.write("yes\n");
            else bufferedWriter.write("no\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isValidString(String validString) {
        Deque<Character> validDeque = new ArrayDeque<>();

        for (char ch : validString.toCharArray()) {
            if (ch == '(' || ch == '[') validDeque.offerLast(ch);
            else if (ch == ')') {
                if (validDeque.isEmpty() || validDeque.pollLast() != '(') return false;
            } else if (ch == ']') {
                if (validDeque.isEmpty() || validDeque.pollLast() != '[') return false;
            }
        }

        return validDeque.isEmpty();
    }
}
