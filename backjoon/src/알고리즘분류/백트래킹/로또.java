package 알고리즘분류.백트래킹;

import java.io.*;

public class 로또 {

    private static int K;
    private static int[] S;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static final int LOTTO_NUMBER = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String number = bufferedReader.readLine();
            if (number.equals("0")) break;

            String[] numbers = number.split(" ");
            K = Integer.parseInt(numbers[0]);

            S = new int[K];
            for (int i = 1; i <= K; i++) S[i - 1] = Integer.parseInt(numbers[i]);

            stringBuilder.setLength(0);

            generateLottoCombinations(new int[LOTTO_NUMBER], 0, 0);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateLottoCombinations(int[] combination, int start, int depth) {
        if (depth == LOTTO_NUMBER) {
            for (int number : combination) stringBuilder.append(number).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            combination[depth] = S[i];
            generateLottoCombinations(combination, i + 1, depth + 1);
        }
    }
}
