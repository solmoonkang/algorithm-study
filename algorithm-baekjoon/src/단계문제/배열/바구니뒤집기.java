package 단계문제.배열;

import java.io.*;
import java.util.StringTokenizer;

public class 바구니뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] buckets = new int[N];
        for (int i = 1; i <= N; i++) {
            buckets[i - 1] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(numberTokenizer.nextToken()) - 1;
            int end = Integer.parseInt(numberTokenizer.nextToken()) - 1;

            for (int j = start; j <= end; j++) {
                int temp = buckets[start];
                buckets[start] = buckets[end];
                buckets[end] = temp;

                start++;
                end--;
            }
        }

        for (int bucket : buckets) {
            bufferedWriter.write(bucket + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
