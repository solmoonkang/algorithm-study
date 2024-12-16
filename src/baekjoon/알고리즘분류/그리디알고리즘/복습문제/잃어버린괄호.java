package baekjoon.알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = bufferedReader.readLine();

        int minValue = calculateMinValueWithParentheses(expression);
        bufferedWriter.write(String.valueOf(minValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMinValueWithParentheses(String expression) {
        // 1. 선택 절차: 값을 최소로 만들기 위해 '-' 음수를 기준으로 식을 분류한다.
        String[] dividingExpression = expression.split("-");

        // 2. 적절성 검사: 분류된 값들을 각각 더한 값들을 '-' 뺄셈을 통해 식의 해답을 도출한다.
        int minValue = 0;

        for (int i = 0; i < dividingExpression.length; i++) {
            String[] numbers = dividingExpression[i].split("\\+");

            int totalValue = 0;
            for (String number : numbers) {
                totalValue += Integer.parseInt(number);
            }

            if (i == 0) minValue += totalValue;
            else minValue -= totalValue;
        }

        // 3. 해답 검사: 주어진 식의 최솟값을 반환한다.
        return minValue;
    }
}
