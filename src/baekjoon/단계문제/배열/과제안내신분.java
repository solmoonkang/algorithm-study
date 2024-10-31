package baekjoon.단계문제.배열;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 과제안내신분 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> hashMapNumbers = new HashMap<>();

        for (int i = 1; i <= 30; i++) {
            hashMapNumbers.put(i, 0);
        }

        for (int i = 0; i < 28; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            hashMapNumbers.put(number, hashMapNumbers.get(number) + 1);
        }

        for (int i = 1; i <= 30; i++) {
            if (hashMapNumbers.get(i) == 0) {
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
