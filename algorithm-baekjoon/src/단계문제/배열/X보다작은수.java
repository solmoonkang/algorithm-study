package 단계문제.배열;

import java.io.*;
import java.util.StringTokenizer;

public class X보다작은수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[N];
        StringTokenizer numbersTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numbersTokenizer.nextToken());
        }

        for (int number : numbers) {
            if (number < X) bufferedWriter.write(number + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
