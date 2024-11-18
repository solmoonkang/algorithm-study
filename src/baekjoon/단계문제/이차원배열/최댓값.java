package baekjoon.단계문제.이차원배열;

import java.io.*;
import java.util.StringTokenizer;

public class 최댓값 {

    private static final int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] numbers = new int[N][N];

        int maxNumber = Integer.MIN_VALUE;
        int row = 0;
        int column = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (numbers[i][j] > maxNumber) {
                    maxNumber = Math.max(maxNumber, numbers[i][j]);
                    row = i + 1;
                    column = j + 1;
                }
            }
        }

        bufferedWriter.write(maxNumber + "\n" + row + " " + column);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
