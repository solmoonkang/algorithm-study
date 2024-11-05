package baekjoon.단계문제.문자열;

import java.io.*;

public class 다이얼 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String alphabet = bufferedReader.readLine();

        int[] timeArray = new int[26];
        for (int i = 0; i < 26; i++) {
            if (i < 3) timeArray[i] = 3;
            else if (i < 6) timeArray[i] = 4;
            else if (i < 9) timeArray[i] = 5;
            else if (i < 12) timeArray[i] = 6;
            else if (i < 15) timeArray[i] = 7;
            else if (i < 19) timeArray[i] = 8;
            else if (i < 22) timeArray[i] = 9;
            else timeArray[i] = 10;
        }

        int totalTime = 0;
        for (char word : alphabet.toCharArray()) {
            int number = word - 'A';
            totalTime += timeArray[number];
        }

        bufferedWriter.write(String.valueOf(totalTime));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
