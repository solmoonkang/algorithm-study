package 연습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 괄호짝맞추기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = bufferedReader.readLine();

        boolean isValidBracketsNaive = isValidBracketsNaive(parentheses);
        bufferedWriter.write(isValidBracketsNaive + "\n");

        bufferedWriter.write("=====");
        bufferedWriter.newLine();

        boolean isValidBracketsStrict = isValidBracketsStrict(parentheses);
        bufferedWriter.write(isValidBracketsStrict + "\n");

        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 잘못된 입력에 대해 아무 처리도 하지 않는 구조
     * - peekLast()가 null인 상황 혹은 deque가 비어있을 때에도 조건만 안 맞으면 그냥 지나간다.
     * - 또한 짝이 안 맞아도 무시하고 지나간다.
     * - 결과적으로 deque.isEmpty()만 보고 판단하는 구조는 잘못된 닫는 괄호가 여러 번 섞여도 false가 안 나올 수 있다.
     */
    private static boolean isValidBracketsNaive(String parentheses) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : parentheses.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') deque.offerLast(c);
            else if (c == ')' && deque.peekLast() == '(') deque.pollLast();
            else if (c == '}' && deque.peekLast() == '{') deque.pollLast();
            else if (c == ']' && deque.peekLast() == '[') deque.pollLast();
        }

        return deque.isEmpty();
    }

    /**
     * 개선된 구조
     * - 열린 괄호 없이 닫는 괄호가 나오는 경우 바로 false를 반환한다.
     * - 짝이 맞지 않는 경우 바로 false를 반환한다.
     * - 모든 문자를 처리한 후 deque가 비어 있지 않다면 아직 닫히지 않은 괄호가 있으므로 false를 반환한다.
     */
    private static boolean isValidBracketsStrict(String parentheses) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : parentheses.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') deque.offerLast(c);
            else {
                // 닫는 괄호가 나왔지만 열려 있는 괄호가 있다면 false를 반환한다.
                if (deque.isEmpty()) return false;

                char top = deque.pollLast();
                // 짝이 안맞을 경우 false를 반환한다.
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
