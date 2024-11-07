package baekjoon.단계문제.그리디알고리즘;

import java.io.*;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 선택 절차: - 연산자를 기준으로 분할한다.
        String[] separateNegativeExpression = bufferedReader.readLine().split("-");

        int total = 0;
        // 2. 적절성 검사: 분할된 각 부분에 대한 값의 합을 계산한다.
        String[] firstPositiveExpression = separateNegativeExpression[0].split("\\+");
        for (String num : firstPositiveExpression) {
            total += Integer.parseInt(num);
        }

        for (int i = 1; i < separateNegativeExpression.length; i++) {
            String[] separatePositiveExpression = separateNegativeExpression[i].split("\\+");

            int sum = 0;
            for (String number : separatePositiveExpression) {
                sum += Integer.parseInt(number);
            }
            total -= sum;
        }

        // 3. 해답 검사: 첫 번째 부분의 값에 대해 나머지 부분의 값을 빼준다.
        bufferedWriter.write(String.valueOf(total));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
