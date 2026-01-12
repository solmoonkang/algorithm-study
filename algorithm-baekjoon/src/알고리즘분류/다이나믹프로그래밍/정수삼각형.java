package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int result = maxPathSum(triangle, N);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int maxPathSum(int[][] triangle, int N) {
        int[][] dynamicArray = new int[N][N];
        dynamicArray[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dynamicArray[i][j] = dynamicArray[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dynamicArray[i][j] = dynamicArray[i - 1][j - 1] + triangle[i][j];
                } else {
                    dynamicArray[i][j] = Math.max(dynamicArray[i - 1][j - 1], dynamicArray[i - 1][j]) + triangle[i][j];
                }
            }
        }

        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dynamicArray[N - 1][i]);
        }

        return maxSum;
    }
}
