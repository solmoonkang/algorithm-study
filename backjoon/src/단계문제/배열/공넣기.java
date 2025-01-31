package 단계문제.배열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공넣기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] buckets = new int[N];
        Arrays.fill(buckets, 0);

        for (int i = 0; i < M; i++) {
            StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(numberTokenizer.nextToken());
            int end = Integer.parseInt(numberTokenizer.nextToken());
            int ballNumber = Integer.parseInt(numberTokenizer.nextToken());

            for (int j = start; j <= end; j++) {
                buckets[j - 1] = ballNumber;
            }
        }

        for (int number : buckets) {
            bufferedWriter.write(number + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
