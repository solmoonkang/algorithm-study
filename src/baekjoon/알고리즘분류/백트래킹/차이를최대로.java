package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 차이를최대로 {

    private static int N;
    private static boolean[] visited;
    private static int[] A;
    private static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N];
        A = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(stringTokenizer.nextToken());

        findMaxValue(new int[N], 0);
        bufferedWriter.write(String.valueOf(maxValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 배열의 크기 N일 경우, N!개의 조합을 생성할 수 있으므로, 이를 백트래킹을 통해 가능한 조합을 생성해낸다.
    private static void findMaxValue(int[] perm, int depth) {
        if (depth == N) {
            maxValue = Math.max(maxValue, calculateMaxValueByRearranging(perm));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = A[i];
                findMaxValue(perm, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 각 순열에 대해 주어진 식을 계산하고 최댓값을 갱신한다.
    private static int calculateMaxValueByRearranging(int[] perm) {
        int maxValue = 0;
        for (int i = 0; i < N - 1; i++) maxValue += Math.abs(perm[i] - perm[i + 1]);
        return maxValue;
    }
}
