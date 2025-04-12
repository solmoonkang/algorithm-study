package 알고리즘분류.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 통계학 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sequences = new int[N];
        for (int i = 0; i < N; i++) {
            sequences[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int average = getAverage(N, sequences);
        int middle = getMiddle(N, sequences);
        int frequency = getFrequency(N, sequences);
        int range = getRange(N, sequences);

        bufferedWriter.write(average + "\n" + middle + "\n" + frequency + "\n" + range);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getAverage(int N, int[] sequences) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += sequences[i];
        }

        return (int) Math.round((double) sum / N);
    }

    private static int getMiddle(int N, int[] sequences) {
        Arrays.sort(sequences);

        int index = N / 2;

        return sequences[index];
    }

    private static int getFrequency(int N, int[] sequences) {
        int[] counts = new int[8001];
        for (int i = 0; i < N; i++) {
            counts[sequences[i] + 4000]++;
        }

        int maxFrequency = 0;
        for (int count : counts) {
            maxFrequency = Math.max(maxFrequency, count);
        }

        List<Integer> modeCandidates = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxFrequency) {
                modeCandidates.add(i - 4000);
            }
        }

        Collections.sort(modeCandidates);
        return modeCandidates.size() > 1 ? modeCandidates.get(1) : modeCandidates.get(0);
    }

    private static int getRange(int N, int[] sequences) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, sequences[i]);
            max = Math.max(max, sequences[i]);
        }

        return Math.abs(max - min);
    }
}
