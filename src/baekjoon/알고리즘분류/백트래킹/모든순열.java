package baekjoon.알고리즘분류.백트래킹;

import java.io.*;

public class 모든순열 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N;
    private static boolean[] visited;
    private static int[] sequences;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        numbers = new int[N + 1];
        sequences = new int[N];
        for (int i = 1; i <= N; i++) numbers[i] = i;

        generatePermutationsInLexicographicOrder(0);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generatePermutationsInLexicographicOrder(int depth) {
        if (depth == N) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequences[depth] = numbers[i];
                generatePermutationsInLexicographicOrder(depth + 1);
                visited[i] = false;
            }
        }
    }
}
