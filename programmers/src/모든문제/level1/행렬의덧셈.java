package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 행렬의덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] numbers1 = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                numbers1[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] numbers2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                numbers2[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] matrices = addMatrices(numbers1, numbers2);
        for (int[] numbers : matrices) {
            for (int number : numbers) bufferedWriter.write(number + " ");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[][] addMatrices(int[][] numbers1, int[][] numbers2) {
        int[][] sequences = new int[numbers1.length][numbers1[0].length];

        for (int i = 0; i < numbers1.length; i++) {
            for (int j = 0; j < numbers1[0].length; j++) {
                sequences[i][j] = numbers1[i][j] + numbers2[i][j];
            }
        }

        return sequences;
    }
}
