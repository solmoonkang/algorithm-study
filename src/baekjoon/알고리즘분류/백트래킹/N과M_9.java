package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_9 {

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
        generateDistinctSequences(0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateDistinctSequences(int depth) {
        if (depth == M) {
            for (int number : sequences) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        int before = -1;
        for (int i = 0; i < N; i++) {
            // 이미 선택된 숫자이면 건너뛴다.
            if (visited[i]) continue;

            // 중복을 방지하기 위한 경우
            if (before != numbers[i]) {
                visited[i] = true;
                sequences[depth] = numbers[i];
                before = numbers[i];
                generateDistinctSequences(depth + 1);
                visited[i] = false;
            }
        }
    }
}
