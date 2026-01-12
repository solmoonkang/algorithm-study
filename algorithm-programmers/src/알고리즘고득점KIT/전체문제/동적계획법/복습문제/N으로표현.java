package 알고리즘고득점KIT.전체문제.동적계획법.복습문제;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class N으로표현 {

    private static final int LIMIT_OPERATIONS_NUMBER = 8;
    private static final int NOT_EXPRESS_OPERATIONS_NUMBER = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int number = Integer.parseInt(bufferedReader.readLine());

        int minOperationsUsedNumber = getMinOperationsUsedNumber(N, number);
        bufferedWriter.write(String.valueOf(minOperationsUsedNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getMinOperationsUsedNumber(int N, int number) {
        if (N == number) return 1;

        Set<Integer>[] dp = new HashSet[LIMIT_OPERATIONS_NUMBER + 1];
        for (int i = 1; i <= LIMIT_OPERATIONS_NUMBER; i++) dp[i] = new HashSet<>();

        for (int i = 1; i <= LIMIT_OPERATIONS_NUMBER; i++) {
            int current = 0;

            for (int j = 0; j < i; j++) current = current * 10 + N;
            dp[i].add(current);

            for (int j = 1; j < i; j++) {
                for (int number1 : dp[j]) {
                    for (int number2 : dp[i - j]) {
                        dp[i].add(number1 + number2);
                        dp[i].add(number1 - number2);
                        dp[i].add(number1 * number2);
                        if (number2 != 0) dp[i].add(number1 / number2);
                    }
                }
            }
        }

        for (int i = 1; i <= LIMIT_OPERATIONS_NUMBER; i++) {
            if (dp[i].contains(number)) return i;
        }

        return NOT_EXPRESS_OPERATIONS_NUMBER;
    }
}
