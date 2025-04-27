package 기출문제.프로그래머스_코드챌린지_2차_예선_2025;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 완전범죄 {

    /**
     * 초반 접근으로 그리디 알고리즘을 적용하려고 했지만, 어떤 물건 하나를 A가 훔쳤을 때 A흔적이 가장 적다고 해서 그 선택이 전체 물건을 훔칠 때도 최적이 되지 않는다.
     * 또한, A흔적을 줄이려다 보면 B흔적이 급증해서 M을 넘길 수도 있고, 반대로 B흔적을 걱정하다 보면 A흔적이 N에 근접한다.
     */

    private static final int CANNOT_ESCAPE_BOTH_THIEVES = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int row = Integer.parseInt(bufferedReader.readLine());

        int[][] info = new int[row][2];

        for (int i = 0; i < row; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            info[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            info[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int tracesNumber = getMinTracesNumber(info, N, M);
        bufferedWriter.write(String.valueOf(tracesNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getMinTracesNumber(int[][] info, int N, int M) {
        final int INF = Integer.MAX_VALUE / 2;

        // dp[a] = A흔적이 정확히 a일 때, 가능한 B흔적의 최솟값
        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        // 아무 물건도 안 훔치면 A=0, B=0
        dp[0] = 0;

        // 각 물건 i를 차례로 고려하며 상태 전이
        for (int[] traces : info) {
            int aTrace = traces[0];
            int bTrace = traces[1];

            // i번째 물건까지 고려한 다음 상태를 담을 배열
            int[] next = new int[N];
            Arrays.fill(next, INF);

            for (int a = 0; a < N; a++) {
                // 달성 불가능한 상태라면 건너뛰기
                if (dp[a] == INF) continue;

                // A가 훔치는 경우
                int na = a + aTrace;
                // B흔적은 변동 없으므로 dp[a]
                if (na < N) next[na] = Math.min(next[na], dp[a]);

                // B가 훔치는 경우
                int nb = dp[a] + bTrace;
                // A흔적은 a 그대로, B흔적만 증가
                if (nb < M) next[a] = Math.min(next[a], nb);
            }

            // 다음 물건 전이를 마친 뒤 dp 갱신
            dp = next;
        }

        // 최종적으로 dp[a] < M인 a 중 최소값이 정답
        int answer = INF;
        for (int a = 0; a < N; a++) {
            if (dp[a] < M) answer = Math.min(answer, a);
        }

        return (answer == INF) ? CANNOT_ESCAPE_BOTH_THIEVES : answer;
    }
}
