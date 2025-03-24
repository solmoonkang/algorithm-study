package 알고리즘분류.두포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int minLength = getMinLengthSubarray(sequences, S);
        bufferedWriter.write(String.valueOf(minLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinLengthSubarray(int[] sequences, int S) {
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < sequences.length; right++) {
            sum += sequences[right];

            while (sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= sequences[left++];
            }
        }

        return minLength;
    }
}
