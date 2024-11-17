package baekjoon.알고리즘분류.정렬;

import java.io.*;
import java.util.Arrays;

public class 대표값_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[5];

        int average = 0;
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
            average += numbers[i] / 5;
        }

        Arrays.sort(numbers);

        bufferedWriter.write(average + "\n");
        bufferedWriter.write(String.valueOf(numbers[numbers.length / 2]));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
