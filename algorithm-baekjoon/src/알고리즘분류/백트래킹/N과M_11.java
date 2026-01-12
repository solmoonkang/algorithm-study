package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_11 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M;
    private static boolean[] visited;
    private static int[] numbers;
    private static int[] sequences;

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

        generateSequences(0);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSequences(int depth) {
        if (depth == M) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            sequences[depth] = numbers[i];
            generateSequences(depth + 1);
            visited[i] = false;
        }
    }
}

