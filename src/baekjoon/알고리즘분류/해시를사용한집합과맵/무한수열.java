package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 무한수열 {

    private static Map<Integer, Integer> sequenceMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());
        int Q = Integer.parseInt(stringTokenizer.nextToken());

        int valueTabulation = computeSequenceTabulation(N, P, Q);
        bufferedWriter.write(String.valueOf(valueTabulation));
        bufferedWriter.newLine();

        int valueMemoization = computeSequenceMemoization(N, P, Q);
        bufferedWriter.write(String.valueOf(valueMemoization));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int computeSequenceTabulation(int N, int P, int Q) {
        // 초기화: A(N)을 구하기 위해 N 크기만큼의 동적 배열을 생성한다.
        int[] dp = new int[N + 1];

        // 기저 상태: A(0) = 1이므로 dp[0] = 1로 설정한다.
        dp[0] = 1;

        // 점화식: A(N) = A(Math.floor(i/P)) + A(Math.floor(i/Q))를 통해 A(N)을 계산한다.
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[(int) Math.floor((double) i / P)] + dp[(int) Math.floor((double) i / Q)];
        }

        return dp[N];
    }

    private static int computeSequenceMemoization(int N, int P, int Q) {
        if (N == 0) return 1;
        if (sequenceMap.containsKey(N)) return sequenceMap.get(N);

        int value = computeSequenceMemoization(N / P, P, Q) + computeSequenceMemoization(N / Q, P, Q);
        sequenceMap.put(N, value);

        return value;
    }
}
