package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 파도반수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());

            int padoBanSequence = generatePadoBanSequences(N);
            bufferedWriter.write(padoBanSequence + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generatePadoBanSequences(int N) {
        // 초기화: P(N): 정삼각형의 변의 길이이다.
        int[] dp = new int[N + 1];

        // 기저 상태: P(1)=1, P(2)=1, P(3)=1, P(4)=2, ..., P(10)=9 순으로 이루어지므로 P(1)부터 P(3)까지 기저 상태를 설정한다.
        for (int i = 1; i <= 3; i++) dp[i] = 1;

        // 점화식: P(N) = P(N-2) + P(N-3)으로 진행하면, 원하는 값을 얻을 수 있다.
        for (int i = 4; i <= N; i++) dp[i] = dp[i - 2] + dp[i - 3];

        return dp[N];
    }
}
