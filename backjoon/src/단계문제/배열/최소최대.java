package 단계문제.배열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소최대 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer numbersTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numbersTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        bufferedWriter.write(numbers[0] + " " + numbers[N - 1]);

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
