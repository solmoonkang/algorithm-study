package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class N진수게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        String numbers = numberGame(N, T, M, P);
        bufferedWriter.write(numbers);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String numberGame(int N, int T, int M, int P) {
        StringBuilder allNumbers = new StringBuilder();
        int number = 0;

        while (allNumbers.length() < T * M) {
            allNumbers.append(Integer.toString(number++, N).toUpperCase());
        }

        StringBuilder tubeAnswer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            // (P - 1): 튜브의 초기 순서 (0-based로 맞추기) / i * M: 라운드 수에 따라 얼마나 멀어졌는지
            int index = (P - 1) + i * M;
            tubeAnswer.append(allNumbers.charAt(index));
        }

        return tubeAnswer.toString();
    }
}
