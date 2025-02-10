package 알고리즘분류.누적합.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기 {

    private static final int[] sequences1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] sequences2 = {1, 5, 8, 10, 24, 3, 5, 100, 99, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int[] prefixSumUsingLoop = findingSectionSumUsingLoop(A, B);
        for (int sum : prefixSumUsingLoop) bufferedWriter.write(sum + "\n");

        bufferedWriter.newLine();

        int[] prefixSumUsingPrefixSum = findingSectionSumUsingPrefixSum(A, B);
        for (int sum : prefixSumUsingPrefixSum) bufferedWriter.write(sum + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 일반적인 구간 합은 모든 구간의 값을 더해주는 방법으로 구현할 수 있다.
    // 하지만 모든 입력마다 모두 더해주면 구간 길이가 M일 경우, 매 구간 합을 구할 때 O(M)의 시간 복잡도가 나온다.
    // 즉, N개의 구간에 대해 구간의 길이가 M인 구간 합을 구하는 경우, O(NM)의 시간 복잡도가 나오게 된다.
    private static int[] findingSectionSumUsingLoop(int startIndex, int endIndex) {
        int prefixSum1 = 0, prefixSum2 = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            prefixSum1 += sequences1[i];
            prefixSum2 += sequences2[i];
        }

        return new int[]{prefixSum1, prefixSum2};
    }

    private static int[] findingSectionSumUsingPrefixSum(int startIndex, int endIndex) {
        int N = sequences1.length;
        int[] prefixSumSequences1 = new int[N + 1];
        int[] prefixSumSequences2 = new int[N + 1];

        for (int i = 1; i < N; i++) {
            prefixSumSequences1[i] += prefixSumSequences1[i - 1] + sequences1[i];
            prefixSumSequences2[i] += prefixSumSequences2[i - 1] + sequences2[i];
        }

        int prefixSum1 = prefixSumSequences1[endIndex] - prefixSumSequences1[startIndex - 1];
        int prefixSum2 = prefixSumSequences2[endIndex] - prefixSumSequences2[startIndex - 1];

        return new int[]{prefixSum1, prefixSum2};
    }
}
