package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int sequenceSize = Integer.parseInt(bufferedReader.readLine());

        int[] sequences = new int[sequenceSize];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < sequenceSize; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxSubSequenceLength = getMaxIncrementSubSequenceLength(sequences);
        bufferedWriter.write(String.valueOf(maxSubSequenceLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxIncrementSubSequenceLength(int[] sequences) {
        int N = sequences.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequences[j] < sequences[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int maxLength = 0;
        for (int length : dp) maxLength = Math.max(maxLength, length);

        return maxLength;
    }
}
