package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_3 {

    private static int N, M;
    private static List<Integer> sequence = new ArrayList<>();
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        generateSequence(0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSequence(int depth) {
        if (depth == M) {
            for (int number : sequence) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            sequence.add(i);
            generateSequence(depth + 1);
            sequence.remove(sequence.size() - 1);
        }
    }
}
