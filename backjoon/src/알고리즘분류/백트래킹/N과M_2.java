package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.*;

public class N과M_2 {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer> sequence;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        sequence = new ArrayList<>();

        generateCombinations(0, 1);

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void generateCombinations(int depth, int start) {
        if (depth == M) {
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

                generateCombinations(depth + 1, i + 1);

                visited[i] = false;
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
