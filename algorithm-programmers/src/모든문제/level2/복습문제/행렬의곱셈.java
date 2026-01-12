package 모든문제.level2.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 행렬의곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row1 = Integer.parseInt(stringTokenizer.nextToken());
        int row2 = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());

        int[][] numbers1 = new int[row1][col];
        for (int i = 0; i < row1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                numbers1[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] numbers2 = new int[row2][col];
        for (int i = 0; i < row2; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                numbers2[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        bufferedReader.close();

        int[][] multiplyMatrices = getMultiplyMatrices(numbers1, numbers2);
        String matrices = Arrays.stream(multiplyMatrices)
                .flatMapToInt(Arrays::stream)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        bufferedWriter.write(matrices);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int[][] getMultiplyMatrices(int[][] numbers1, int[][] numbers2) {
        int N = numbers1.length;        // 결과 행렬의 행 개수 (첫 번째 행렬 numbers1의 행 개수)
        int M = numbers2[0].length;     // 결과 행렬의 열 개수 (두 번째 행렬 numbers2의 열 개수)
        int K = numbers1[0].length;     // 내적에 필요한 횟수 (첫 번째 행렬의 열 개수 = 두 번째 행렬의 행 개수)

        int[][] multiplyMatrices = new int[N][M];

        // 가장 바깥쪽 두 루프는 결과 행렬의 어디를 채울지 위치를 저장한다. 코드는 결과 행렬 multiplyMatrices[row][col]의 모든 칸을 한 번씩 방문하게 된다.
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                int sum = 0;
                for (int index = 0; index < K; index++) sum += numbers1[row][index] * numbers2[index][col];
                multiplyMatrices[row][col] = sum;
            }
        }

        return multiplyMatrices;
    }
}
