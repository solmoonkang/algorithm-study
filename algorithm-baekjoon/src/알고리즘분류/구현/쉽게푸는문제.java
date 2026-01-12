package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 쉽게푸는문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = new int[B];
        int index = 0;

        for (int i = 1; index < B; i++) {
            for (int j = 0; j < i && index < B; j++) {
                sequences[index++] = i;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += sequences[i - 1];
        }

        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
