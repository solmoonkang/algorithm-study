package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class 땅따먹기 {

    /**
     * N개의 행을 순서대로 밟아야 한다.
     * 각 행에서는 4개의 열 중 하나를 선택해야 한다.
     * 이전 행에서 선택한 열은 다음 행에서 선택이 불가하다.
     * 각 위치의 점수는 정해져 있고, 최대 점수 합을 찾아야 한다.
     * 즉, 이전 선택이 다름 선택에 영향을 주는 결정 문제이다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] land = new int[N][4];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 4; j++) {
                land[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxLandScore = getMaxLandScore(land);
        bufferedWriter.write(String.valueOf(maxLandScore));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxLandScore(int[][] land) {
        int N = land.length;
        int[][] DP = new int[N][4];

        for (int j = 0; j < 4; j++) DP[0][j] = land[0][j];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (k != j) max = Math.max(max, DP[i - 1][k]);
                }
                DP[i][j] = land[i][j] + max;
            }
        }

        int maxLandScore = 0;
        for (int j = 0; j < 4; j++) maxLandScore = Math.max(maxLandScore, DP[N - 1][j]);

        return maxLandScore;
    }
}
