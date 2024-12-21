package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 부등호 {

    private static final int NUMBER_RANGE = 10;

    private static int K;
    private static boolean[] visited;
    private static int[] sequences;
    private static String maxNumber = "";
    private static String minNumber = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(bufferedReader.readLine());

        String[] A = new String[K];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < K; i++) A[i] = stringTokenizer.nextToken();

        visited = new boolean[NUMBER_RANGE];        // 숫자 방문 여부
        sequences = new int[K + 1];                 // 숫자 조합 저장

        findMaxAndMinNumbers(A, 0);
        bufferedWriter.write(maxNumber + "\n" + minNumber);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findMaxAndMinNumbers(String[] inequalities, int depth) {
        if (depth == K + 1) {
            if (isValidInequality(sequences, inequalities)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int number : sequences) stringBuilder.append(number);

                String currentNumber = stringBuilder.toString();
                if (minNumber.isEmpty() || currentNumber.compareTo(minNumber) < 0) minNumber = currentNumber;
                if (maxNumber.isEmpty() || currentNumber.compareTo(maxNumber) > 0) maxNumber = currentNumber;
            }
            return;
        }

        for (int i = 0; i < NUMBER_RANGE; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequences[depth] = i;
                findMaxAndMinNumbers(inequalities, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isValidInequality(int[] sequences, String[] inequalities) {
        for (int i = 0; i < K; i++) {
            if (inequalities[i].equals("<")) {
                if (sequences[i] >= sequences[i + 1]) return false;
            } else {
                if (sequences[i] <= sequences[i + 1]) return false;
            }
        }

        return true;
    }
}
