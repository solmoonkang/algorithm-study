package 알고리즘고득점KIT.동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class 등굣길 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] floodedArea = new int[K][2];
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            floodedArea[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            floodedArea[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int shortestPath = getShortestPath(M, N, floodedArea);
        bufferedWriter.write(String.valueOf(shortestPath));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getShortestPath(int M, int N, int[][] puddles) {
        // 시작점 (1, 1)에서 도착점 (i, j)까지 갈 수 있는 모든 경로의 수를 저장한다.
        int[][] dp = new int[M + 1][N + 1];

        // 물구덩이를 -1로 초기화한다.
        for (int[] puddle : puddles) dp[puddle[0]][puddle[1]] = -1;

        // 시작점인 (1, 1)에서 출발할 수 있는 유일한 경로가 하나이므로, 1로 초기화한다.
        dp[1][1] = 1;

        // 오른쪽과 아래쪽으로만 움직일 수 있다. -> 오른쪽은 dp[][j + 1], 아래쪽은 dp[i + 1][] 이 되지 않을까?
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                // 현재 위치가 물구덩이라면, 경로를 0으로 설정하고 다음 반복으로 넘어간다.
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                // i가 1일 때 dp[0][j]를 참조하지 않고, 위쪽에서 오는 경로가 물구덩이가 아니라면, 경로의 수를 더한다.
                if (i > 1 && dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j];
                // j가 1일 때 dp[i][0]을 참조하지 않고, 왼쪽에서 오는 경로가 물구덩이가 아니라면, 경로의 수를 더한다.
                if (j > 1 && dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }

        // 도달할 수 없는 경우 0을 반환하고, 아니라면 최단 경로를 반환한다.
        return Math.max(dp[M][N], 0);
    }
}
