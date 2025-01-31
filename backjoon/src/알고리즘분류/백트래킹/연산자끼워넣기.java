package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {


    private static int N;
    private static int[] numbers;
    private static int[] operations = new int[4];
    private static int maxExpressionValue = Integer.MIN_VALUE;
    private static int minExpressionValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        findExpressionValue(0, numbers[0]);
        bufferedWriter.write(maxExpressionValue + "\n" + minExpressionValue);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 현재까지 사용한 숫자의 인덱스와 현재 결과를 받아서 연산자를 조합하여 재귀적으로 호출한다.
    private static void findExpressionValue(int index, int currentValue) {
        // 모든 숫자를 사용한 경우
        if (index == N - 1) {
            maxExpressionValue = Math.max(maxExpressionValue, currentValue);
            minExpressionValue = Math.min(minExpressionValue, currentValue);
            return;
        }

        // 각 연산자에 대한 시도
        for (int i = 0; i < 4; i++) {
            // 사용할 수 있는 연산자가 있는 경우
            if (operations[i] > 0) {
                // 연산자 사용
                operations[i]--;
                int nextValue = computeExpressionValue(currentValue, numbers[index + 1], i);
                // 다음 숫자와 함께 재귀 호출
                findExpressionValue(index + 1, nextValue);
                // 연산자 복구
                operations[i]++;
            }
        }
    }

    // 주어진 연산자 인덱스에 따라 현재 결과와 다음 숫자를 계산한다.
    private static int computeExpressionValue(int currentValue, int nextNumber, int operatorIndex) {
        return switch (operatorIndex) {
            case 0 -> currentValue + nextNumber;                                                        // +
            case 1 -> currentValue - nextNumber;                                                        // -
            case 2 -> currentValue * nextNumber;                                                        // *
            case 3 -> currentValue < 0 ? -(-currentValue / nextNumber) : currentValue / nextNumber;     // /
            default -> 0;
        };
    }
}
