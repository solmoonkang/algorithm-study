package 알고리즘분류.브루트포스알고리즘.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] cardNumbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cardNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxCardSum = getMaxSumCard(M, cardNumbers);
        bufferedWriter.write(String.valueOf(maxCardSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxSumCard(int M, int[] cardNumbers) {
        int maxValidSum = 0;

        for (int i = 0; i < cardNumbers.length; i++) {
            for (int j = i + 1; j < cardNumbers.length; j++) {
                for (int k = j + 1; k < cardNumbers.length; k++) {
                    int currentSum = cardNumbers[i] + cardNumbers[j] + cardNumbers[k];
                    if (currentSum <= M && currentSum > maxValidSum) maxValidSum = currentSum;
                }
            }
        }

        return maxValidSum;
    }
}
