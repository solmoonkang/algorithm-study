package baekjoon.단계문제.배열;

import java.io.*;
import java.util.StringTokenizer;

public class 평균 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int M = 0;
        for (int score : scores) {
            if (score > M) M = score;
        }

        double sum = 0;
        for (int score : scores) {
            sum += (double) score / M * 100;
        }

        bufferedWriter.write(sum / N + " ");

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
