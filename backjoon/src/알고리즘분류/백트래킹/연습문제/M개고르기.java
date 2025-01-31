package 알고리즘분류.백트래킹.연습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M개고르기 {

    /**
     * 문제 설명
     * N개의 서로 다른 자연수 중에서 M개를 선택하여 가능한 모든 조합을 출력하세요. 선택된 수들은 중복 없이 선택되어야 하며, 비내림차순으로 정렬되어야 합니다.
     * <p>
     * 입력
     * 첫째 줄에 자연수 N과 M이 주어집니다. (1 ≤ M ≤ N ≤ 8)
     * 둘째 줄에 N개의 서로 다른 자연수가 주어집니다. (1 ≤ 각 수 ≤ 100)
     * <p>
     * 출력
     * 조건을 만족하는 모든 조합을 각 한 줄에 하나씩 출력합니다. 각 조합은 공백으로 구분되어야 하며, 사전 순으로 출력되어야 합니다. 만약 조건을 만족하는 조합이 없다면, "No combination"을 출력합니다.
     */
    private static final String NO_COMBINATION = "NO COMBINATION";

    private static int N, M;
    private static int[] numbers;
    private static int[] combination;
    private static boolean found = false;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        combination = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);

        generateCombination(0, 0);

        bufferedWriter.write(!found ? NO_COMBINATION : stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateCombination(int start, int depth) {
        if (depth == M) {
            found = true;
            for (int number : combination) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append("\n");

            return;
        }

        for (int i = start; i < N; i++) {
            combination[depth] = numbers[i];
            generateCombination(i + 1, depth + 1);
        }
    }
}
