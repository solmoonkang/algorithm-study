package baekjoon.알고리즘분류.백트래킹.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 부분집합구하기 {

    /**
     * 문제 설명
     * 1부터 N까지의 자연수 중에서 M개의 수를 선택하여 가능한 모든 부분집합을 구하세요. 선택된 수들은 중복 없이 선택되어야 하며, 오름차순으로 정렬된 상태로 출력해야 합니다.
     * <p>
     * 입력
     * 첫째 줄에 자연수 N과 M이 주어집니다. (1 ≤ M ≤ N ≤ 8)
     * <p>
     * 출력
     * 조건을 만족하는 모든 부분집합을 각 한 줄에 하나씩 출력합니다. 각 부분집합은 공백으로 구분되어야 하며, 사전 순으로 출력되어야 합니다. 만약 조건을 만족하는 부분집합이 없다면, "No subset"을 출력합니다.
     */
    private static final String NO_SUBSET = "NO SUBSET";

    private static int N, M;
    private static List<Integer> sequence = new ArrayList<>();
    private static boolean found = false;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        generateSubset(1);

        bufferedWriter.write(!found ? NO_SUBSET : stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateSubset(int start) {
        if (sequence.size() == M) {
            found = true;
            for (int number : sequence) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence.add(i);
            generateSubset(i + 1);
            sequence.remove(sequence.size() - 1);
        }
    }
}
