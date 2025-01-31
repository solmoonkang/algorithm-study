package 알고리즘분류.구현;

import java.io.*;

public class 방번호 {

    private static final int NUMBER_RANGE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();

        int[] numbers = new int[NUMBER_RANGE];

        for (char digit : N.toCharArray()) numbers[digit - '0']++;
        int sixNineCount = numbers[6] + numbers[9];
        int setsNeeded = (sixNineCount + 1) / 2;

        for (int i = 0; i < NUMBER_RANGE; i++) {
            if (i != 6 && i != 9) setsNeeded = Math.max(setsNeeded, numbers[i]);
        }
        bufferedWriter.write(String.valueOf(setsNeeded));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
