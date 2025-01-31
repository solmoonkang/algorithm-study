package 알고리즘분류.문자열;

import java.io.*;

public class A더하기B_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] numbers = bufferedReader.readLine().split(",");
            int aPlusB = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            stringBuilder.append(aPlusB).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
