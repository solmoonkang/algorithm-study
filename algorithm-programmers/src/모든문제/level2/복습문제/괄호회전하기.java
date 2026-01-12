package 모든문제.level2.복습문제;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호회전하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String parentheses = bufferedReader.readLine();
        bufferedReader.close();

        int correctParenthesesNumber = getNumberCorrectRotatedParentheses(parentheses);
        bufferedWriter.write(String.valueOf(correctParenthesesNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getNumberCorrectRotatedParentheses(String parentheses) {
        // 주어진 괄호 문자열을 덱에 넣고, 왼쪽으로 회전(가장 맨 처음 괄호 문자를 빼고, 가장 마지막으로 넣는다.)한다.
        // 그렇게 한 문자열이 완성되었을 때 해당 문자열이 올바른 문자열임을 검증하는 로직을 거치고, 올바르다면 count++ 해준다.
        if (parentheses.length() % 2 != 0) return 0;

        Deque<Character> rotatedParentheses = new ArrayDeque<>();
        for (char parenthesis : parentheses.toCharArray()) rotatedParentheses.offerLast(parenthesis);

        int correctParenthesesNumber = 0;
        for (int index = 0; index < parentheses.length(); index++) {
            if (isCorrectParentheses(rotatedParentheses)) correctParenthesesNumber++;
            char currentParenthesis = rotatedParentheses.pollFirst();
            rotatedParentheses.offerLast(currentParenthesis);
        }

        return correctParenthesesNumber;
    }

    private static boolean isCorrectParentheses(Deque<Character> rotatedParentheses) {
        // 괄호 문자열의 원본을 파괴하지 않기 위한 복사본으로 tempParentheses를 선언한다.
        // 올바른 괄호 문자열 검증으로 저장할 스택 역할을 위해 validParentheses를 선언한다.
        Deque<Character> tempParentheses = new ArrayDeque<>(rotatedParentheses);
        Deque<Character> validParentheses = new ArrayDeque<>();

        while (!tempParentheses.isEmpty()) {
            char currentParenthesis = tempParentheses.pollFirst();

            if (currentParenthesis == '(' || currentParenthesis == '{' || currentParenthesis == '[') {
                validParentheses.offerLast(currentParenthesis);
            // 닫는 괄호(currentParenthesis)가 나왔을 때, validParentheses에서 꺼낸 여는 괄호(latestParenthesis)와 종류가 일치하는지 확인한다.
            } else {
                if (validParentheses.isEmpty()) return false;

                char latestParenthesis = validParentheses.pollLast();
                if ((currentParenthesis == ')' && latestParenthesis != '(')
                        || (currentParenthesis == '}' && latestParenthesis != '{')
                        || (currentParenthesis == ']' && latestParenthesis != '['))
                    return false;
            }
        }

        return validParentheses.isEmpty();
    }
}
