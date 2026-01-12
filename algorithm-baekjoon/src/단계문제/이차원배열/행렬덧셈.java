package 단계문제.이차원배열;

import java.io.*;
import java.util.StringTokenizer;

public class 행렬덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] matrix = new int[N][M];

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer numberTokenizerA = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = Integer.parseInt(numberTokenizerA.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer numberTokenizerB = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = Integer.parseInt(numberTokenizerB.nextToken());
                matrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bufferedWriter.write(matrix[i][j] + " ");
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
