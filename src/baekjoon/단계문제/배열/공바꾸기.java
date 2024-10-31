package baekjoon.단계문제.배열;

import java.io.*;
import java.util.StringTokenizer;

public class 공바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] buckets = new int[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(numberTokenizer.nextToken());
            int end = Integer.parseInt(numberTokenizer.nextToken());

            int temp = buckets[start - 1];
            buckets[start - 1] = buckets[end - 1];
            buckets[end - 1] = temp;
        }

        for (int number : buckets) {
            bufferedWriter.write(number + " ");
        }


        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
