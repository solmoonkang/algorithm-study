package 알고리즘분류.두포인터.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 고정길이슬라이딩윈도우 {

    /**
     * 고정 길이 슬라이딩 윈도우: 고정된 길이의 윈도우를 사용하여 배열이나 리스트를 탐색한다.
     * - 윈도우의 크기를 일정하게 유지하면서 왼쪽 포인터와 오른쪽 포인터를 이동시키며 필요한 계산을 수행한다.
     * - 이 유형은 부분 배열의 합이나 평균을 계산하는 등의 문제에 사용될 수 있다.
     */

    /**
     * 문제 유형: 길이가 K인 부분 배열의 최대합, 평균 등을 구할 때 사용된다.
     * 핵심 아이디어: 윈도우 크기를 고정한 채로, 슬라이딩하듯 좌우로 이동하며, 매 이동마다 앞에서 하나 빼고 뒤에서 하나를 더한다. O(N)
     * 예제 문제: 길이가 K인 부분 배열 중 합이 가장 큰 값을 구하라.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxSum = getMaxSumFixedWindow(sequences, K);
        bufferedWriter.write(String.valueOf(maxSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxSumFixedWindow(int[] sequences, int K) {
        // 첫 윈도우 초기 합 계산으로 0번부터 K-1번까지 첫 번째 윈도우의 합을 구해서 초기 max로 설정한다.
        int sum = 0;
        for (int i = 0; i < K; i++) sum += sequences[i];

        // 슬라이딩 윈도우를 시작하면 i는 윈도우의 끝 인덱스로 새로 들어오는 값 sequences[i]는 더하고, 빠지는 값 sequences[i - K]는 뺀다.
        // 갱신된 합과 기존 max 중 더 큰 값을 계속 유지한다.
        int max = sum;
        for (int i = K; i < sequences.length; i++) {
            sum = sum - sequences[i - K] + sequences[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
