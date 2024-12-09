package baekjoon.단계문제.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_2 {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer> sequence;

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        sequence = new ArrayList<>();

        generateSequence(1);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSequence(int start) {
        if (sequence.size() == M) {
            for (int number : sequence) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append("\n");

            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence.add(i);

                generateSequence(i + 1);

                visited[i] = false;
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
