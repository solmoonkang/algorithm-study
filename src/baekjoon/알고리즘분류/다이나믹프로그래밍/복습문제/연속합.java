package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 연속합 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        int[] sequence = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxSubarraySum = generateMaxSubarraySum(sequence);
        bufferedWriter.write(String.valueOf(maxSubarraySum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 기존 방안의 문제점: 정렬을 통해 원래 배열의 순서를 유지해야 하는데, 원래 수열의 연속적인 부분을 고려할 수 없게 되었다.
    // 때문에 현재 요소를 시작으로 새로운 서브배열을 만들 떄의 합과 이전 요소까지의 최대 합에 현재 요소를 추가했을 때의 합 중 최대값을 dp 배열에 저장해야 한다.
    private static int generateMaxSubarraySum(int[] sequence) {
        // 초기화: 정수 N이 1부터 시작을 하므로, sequence 배열의 크기 + 1만큼의 크기를 갖는 동적계획 배열을 초기화한다.
        int[] dp = new int[N + 1];
        int maxSubarraySum = sequence[0];

        // 기저 상태: dp[0]이면, sequence 배열의 가장 첫 번째 즉, 가장 작은 값이 된다.
        dp[0] = sequence[0];

        // 점화식:
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(sequence[i], dp[i - 1] + sequence[i]);
            maxSubarraySum = Math.max(maxSubarraySum, dp[i]);
        }

        return maxSubarraySum;
    }
}
