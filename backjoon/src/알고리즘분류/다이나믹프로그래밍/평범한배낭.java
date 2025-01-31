package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 평범한배낭 {

    private static int N, K;

    // TODO: 이해가 제대로 되지 않은 것 같다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxValue = getMaxValue(weights, values);
        bufferedWriter.write(String.valueOf(maxValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxValue(int[] weights, int[] values) {
        int[] dynamicArray = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int weight = weights[i];
            int value = values[i];

            for (int j = K; j >= weight; j--) {
                dynamicArray[j] = Math.max(dynamicArray[j], dynamicArray[j - weight] + value);
            }
        }

        return dynamicArray[K];
    }
}
