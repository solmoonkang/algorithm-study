package 알고리즘분류.백트래킹.복습문제;

import java.io.*;

public class 로또 {

    private static final int LOTTO_NUMBERS = 6;
    private static final int[] combinations = new int[LOTTO_NUMBERS];
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int K;
    private static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] testCase = bufferedReader.readLine().split(" ");
            if (testCase[0].equals("0")) break;

            K = Integer.parseInt(testCase[0]);
            S = new int[K];
            for (int i = 1; i <= K; i++) S[i - 1] = Integer.parseInt(testCase[i]);

            findAllCombinations(0, 0);
            stringBuilder.append("\n");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findAllCombinations(int start, int depth) {
        if (depth == LOTTO_NUMBERS) {
            for (int i = 0; i < LOTTO_NUMBERS; i++) stringBuilder.append(combinations[i]).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            combinations[depth] = S[i];
            findAllCombinations(i + 1, depth + 1);
        }
    }
}
