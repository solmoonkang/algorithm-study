package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_6 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M;
    private static boolean[] visited;
    private static int[] sequences;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(numbers);
        visited = new boolean[N];
        sequences = new int[M];
        generateDistinctSequences(0, 0);

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateDistinctSequences(int start, int depth) {
        if (depth == M) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            // 비내림차순을 유지하기 위해, 이전 숫자와 같을 경우 건너뛴다.
            if (depth > 0 && sequences[depth - 1] > numbers[i]) continue;

            if (!visited[i]) {
                visited[i] = true;
                sequences[depth] = numbers[i];
                generateDistinctSequences(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
