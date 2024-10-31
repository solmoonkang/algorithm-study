package baekjoon.단계문제.배열;

import java.io.*;

public class 최댓값 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int max = numbers[0];
        int position = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                position = i + 1;
            }
        }
        bufferedWriter.write(String.valueOf(max));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(position));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
