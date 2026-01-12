package 단계문제.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] cards = new int[N];
        StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(numberTokenizer.nextToken());
        }

        int closestSum = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && sum > closestSum) closestSum = sum;
                }
            }
        }

        bufferedWriter.write(String.valueOf(closestSum));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
