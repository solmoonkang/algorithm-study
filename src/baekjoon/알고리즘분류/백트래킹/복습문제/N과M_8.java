package baekjoon.알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_8 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M;
    private static int[] numbers;
    private static int[] sequences;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        sequences = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(numbers);
        generateSequences(0, 0);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSequences(int start, int depth) {
        if (depth == M) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            sequences[depth] = numbers[i];
            // i를 그대로 사용하여 비내림차순을 유지한다.
            generateSequences(i, depth + 1);
        }
    }
}
