package 알고리즘분류.구현;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String stringOfParentheses = bufferedReader.readLine();
        Deque<Character> searchDeque = new LinkedList<>();

        int result = 0;
        int temp = 1;
        boolean isValid = true;

        for (int i = 0; i < stringOfParentheses.length(); i++) {
            char parenthesis = stringOfParentheses.charAt(i);

            // case 1: 여는 괄호를 만났을 경우
            if (parenthesis == '(') {
                searchDeque.offerLast(parenthesis);
                temp *= 2;      // '(' 안에 있는 값들은 2배로 곱해질 거니까 미리 설정한다.
            } else if (parenthesis == '[') {
                searchDeque.offerLast(parenthesis);
                temp *= 3;      // '[' 안에 있는 값들은 3배로 곱해질 거니까 미리 설정한다.
            }

            // case 2: 닫는 괄호를 만났을 경우
            else if (parenthesis == ')') {
                // 덱이 비어있거나, 맨 위가 '('가 아니면, 잘못된 괄호열이므로 break해서 중단한다.
                if (searchDeque.isEmpty() || searchDeque.peekLast() != '(') {
                    isValid = false;
                    break;
                }

                // 바로 직전이 '('라면 단순 '( )'이므로 안에 내용 없이 곱하기만 적용되므로 현재 temp 값을 result에 더해준다.
                if (stringOfParentheses.charAt(i - 1) == '(') {
                    result += temp;
                }

                // 닫았으니까 덱에서 '('를 추출하며, 닫았으므로 temp 배수도 다시 원래대로 돌려야 한다.
                searchDeque.pollLast();
                temp /= 2;
            } else if (parenthesis == ']') {
                // 덱이 비어있거나, 맨 위가 '['가 아니면, 잘못된 괄호열이므로 break해서 중단한다.
                if (searchDeque.isEmpty() || searchDeque.peekLast() != '[') {
                    isValid = false;
                    break;
                }

                // 바로 직전이 '['라면 단순 '[ ]'이므로 안에 내용 없이 곱하기만 적용되므로 현재 temp 값을 result에 더해준다.
                if (stringOfParentheses.charAt(i - 1) == '[') {
                    result += temp;
                }

                // 닫았으니까 덱에서 '['를 추출하며, 닫았으므로 temp 배수도 다시 원래대로 돌려야 한다.
                searchDeque.pollLast();
                temp /= 3;
            }
        }

        bufferedWriter.write(!isValid || !searchDeque.isEmpty() ? "0" : String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
