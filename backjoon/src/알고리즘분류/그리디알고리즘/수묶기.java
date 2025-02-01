package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;

public class 수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sequences = new int[N];
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(bufferedReader.readLine());

        int maxSumFormSequence = getMaxSumFromGroupedSequence(sequences);
        bufferedWriter.write(String.valueOf(maxSumFormSequence));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxSumFromGroupedSequence(int[] sequences) {
        Arrays.sort(sequences);

        int maxSumFormSequence = 0;

        for (int i = sequences.length - 1; i >= 0; i--) {
            if (sequences[i] > 1) {
                if (i > 0 && sequences[i - 1] > 1) {
                    maxSumFormSequence += sequences[i] * sequences[i - 1];
                    i--;
                } else {
                    maxSumFormSequence += sequences[i];
                }
            } else if (sequences[i] == 1) {
                maxSumFormSequence += sequences[i];
            } else if (sequences[i] < 0) {
                if (i > 0 && sequences[i + 1] < 0) {
                    maxSumFormSequence += sequences[i] * sequences[i + 1];
                    i--;
                } else {
                    maxSumFormSequence += sequences[i];
                }
            }
        }

        return maxSumFormSequence;
    }
}
