package 알고리즘분류.두포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 수들의합_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int count = countSubarrayWithSum(sequences, M);
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countSubarrayWithSum(int[] sequences, int target) {
        int start = 0, end = 0;
        int sum = 0, count = 0;

        while (true) {
            if (sum >= target) sum -= sequences[start++];
            else if (end == sequences.length) break;
            else sum += sequences[end++];

            if (sum == target) count++;
        }

        return count;
    }
}
