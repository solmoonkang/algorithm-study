package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class 행렬의곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] numbers1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] numbers2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] multiplyMatrices = getMultiplyMatrix(numbers1, numbers2);
        for (int[] number : multiplyMatrices) {
            for (int multiply : number) bufferedWriter.write(multiply + " ");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 행렬 곱셈 정의: A(M x K) * B(K x N) -> C(M x N)
     * - 행렬의 각 원소 C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][k-1]*B[k-1][j]
     */
    private static int[][] getMultiplyMatrix(int[][] numbers1, int[][] numbers2) {
        int N = Math.max(numbers1.length, numbers2.length);
        int M = numbers1[0].length;

        int[][] multiplyMatrices = new int[N][M];

        for (int i = 0; i < numbers1.length; i++) {
            for (int j = 0; j < numbers2[0].length; j++) {
                for (int k = 0; k < numbers1[0].length; k++) {
                    multiplyMatrices[i][j] += numbers1[i][k] * numbers2[k][j];
                }
            }
        }

        return multiplyMatrices;
    }
}
