package baekjoon.알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    private static int N;
    private static int[] A;
    private static int[] operatorsCount;
    private static int minValue = Integer.MAX_VALUE;
    private static int maxValue = Integer.MIN_VALUE;

    private static final int NUM_OPERATORS = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        A = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(stringTokenizer.nextToken());

        operatorsCount = new int[NUM_OPERATORS];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < NUM_OPERATORS; i++) operatorsCount[i] = Integer.parseInt(stringTokenizer.nextToken());

        findMaxAndMinValue(0, A[0]);
        bufferedWriter.write(maxValue + "\n" + minValue);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findMaxAndMinValue(int depth, int currentValue) {
        if (depth == N - 1) {       // 모든 연산자를 사용한 경우
            maxValue = Math.max(maxValue, currentValue);
            minValue = Math.min(minValue, currentValue);
            return;
        }

        // 각 연산자를 사용하여 다음 깊이로 진행
        for (int i = 0; i < operatorsCount.length; i++) {
            if (operatorsCount[i] > 0) {        // 사용 가능한 연산자가 있는 경우
                operatorsCount[i]--;            // 연산자 사용

                int nextValue = evaluateExpression(currentValue, A[depth + 1], i);
                findMaxAndMinValue(depth + 1, nextValue);   // 다음 깊이로 진행

                operatorsCount[i]++;            // 연산자 복구
            }
        }
    }

    private static int evaluateExpression(int current, int next, int operatorIndex) {
        switch (operatorIndex) {
            case 0: return current + next;
            case 1: return current - next;
            case 2: return current * next;
            case 3:
                if (current < 0) return -(-current / next);
                else return current / next;
            default: return current;
        }

    }
}
