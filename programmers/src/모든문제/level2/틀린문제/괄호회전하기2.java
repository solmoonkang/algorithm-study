package 모든문제.level2.틀린문제;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 괄호회전하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();
        int validParenthesesCount = getReplacementsForValidParentheses(sentence);
        bufferedWriter.write(String.valueOf(validParenthesesCount));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getReplacementsForValidParentheses(String sentence) {
        // 괄호를 왼쪽으로 회전시키기 위해 Deque를 선언
        Deque<Character> parenthesesDeque = new LinkedList<>();
        for (char parenthesis : sentence.toCharArray()) {
            parenthesesDeque.offerLast(parenthesis);
        }

        // 올바른 괄호를 갖는 문자열일 경우 증가시킬 count 변수
        int validParentheses = 0;

        // 올바른 괄호를 갖는 문자열임을 확인하기 위해 sentence의 길이만큼 순회
        for (int i = 0; i < sentence.length(); i++) {
            // 올바른 문자열이라면 validParentheses를 1 증가
            if (isValidParentheses(parenthesesDeque)) validParentheses++;

            // 괄호 문자열을 왼쪽으로 한 칸씩 회전
            char currentParenthesis = parenthesesDeque.pollFirst();
            parenthesesDeque.offerLast(currentParenthesis);
        }

        return validParentheses;
    }

    private static boolean isValidParentheses(Deque<Character> parenthesesDeque) {
        Deque<Character> parenthesesPairDeque = new ArrayDeque<>();

        for (char parenthesis : parenthesesDeque) {
            // 여는 괄호 처리
            if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') parenthesesPairDeque.offerLast(parenthesis);

            // 닫는 괄호 처리
            else {
                // 닫는 괄호가 나왔는데 스택이 비어있다면, 짝이 없는 닫는 괄호이므로 즉시 false를 반환
                if (parenthesesPairDeque.isEmpty()) return false;

                // 가장 최근 괄호 확인을 위해 가장 최근에 열린 괄호를 변수에 저장
                char lastOpenParenthesis = parenthesesPairDeque.pollLast();
                // 현재 닫는 괄호와 꺼낸 여는 괄호가 정확한 짝을 이루는지 확인하며, 짝이 틀리면 즉시 false를 반환
                if (parenthesis == ')' && lastOpenParenthesis != '(') return false;
                else if (parenthesis == '}' && lastOpenParenthesis != '{') return false;
                else if (parenthesis == ']' && lastOpenParenthesis != '[') return false;
            }
        }

        return parenthesesPairDeque.isEmpty();
    }
}
