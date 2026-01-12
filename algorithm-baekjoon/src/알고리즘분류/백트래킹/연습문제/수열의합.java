package 알고리즘분류.백트래킹.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수열의합 {

    /**
     * 문제 설명
     * 자연수 N과 M이 주어질 때, 1부터 N까지의 자연수 중에서 M개의 수를 선택하여 그 합이 S가 되는 모든 수열을 출력하세요. 선택된 수들은 비내림차순으로 정렬되어야 합니다.
     * <p>
     * 입력
     * 첫째 줄에 자연수 N, M, S가 주어집니다. (1 ≤ M ≤ N ≤ 8, 1 ≤ S ≤ N * (N + 1) / 2)
     * <p>
     * 출력
     * 조건을 만족하는 M개의 수열을 각 한 줄에 하나씩 출력합니다. 수열은 공백으로 구분되어야 하며, 사전 순으로 출력되어야 합니다. 만약 조건을 만족하는 수열이 없다면, "No sequence"를 출력합니다.
     */
    private static final String NO_SEQUENCE = "NO SEQUENCE";

    private static int N, M, S;
    private static List<Integer> sequence = new ArrayList<>();
    private static boolean found = false;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        generateSequence(1, 0);

        bufferedWriter.write(!found ? NO_SEQUENCE : stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSequence(int start, int currentSum) {
        if (sequence.size() == M) {
            if (currentSum == S) {
                found = true;

                for (int number : sequence) {
                    stringBuilder.append(number).append(" ");
                }
                stringBuilder.append("\n");
            }

            return;
        }

        for (int i = start; i <= N; i++) {
            sequence.add(i);
            generateSequence(i, currentSum + i);
            sequence.remove(sequence.size() - 1);
        }
    }
}
