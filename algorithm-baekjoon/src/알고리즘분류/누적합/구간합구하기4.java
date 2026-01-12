package 알고리즘분류.누적합;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] prefixSumSequences = new int[N + 1];
        for (int i = 1; i <= N; i++) prefixSumSequences[i] = prefixSumSequences[i - 1] + sequences[i - 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startIndex = Integer.parseInt(stringTokenizer.nextToken());
            int endIndex = Integer.parseInt(stringTokenizer.nextToken());

            int prefixSum = prefixSumSequences[endIndex] - prefixSumSequences[startIndex - 1];
            bufferedWriter.write(prefixSum + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
