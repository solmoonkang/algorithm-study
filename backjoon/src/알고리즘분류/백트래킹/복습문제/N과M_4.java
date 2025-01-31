package 알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_4 {

    private static int N, M;
    private static int[] sequence;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        sequence = new int[M];

        generateNonDecreasingSequences(1, 0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateNonDecreasingSequences(int start, int depth) {
        if (depth == M) {
            for (int number : sequence) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            generateNonDecreasingSequences(i, depth + 1);
        }
    }
}
