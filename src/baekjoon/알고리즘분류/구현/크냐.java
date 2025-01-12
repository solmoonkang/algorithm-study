package baekjoon.알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 크냐 {

    private static final String GREATER_THAN_MESSAGE = "Yes";
    private static final String NOT_GREATER_THAN_MESSAGE = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number1 = Integer.parseInt(stringTokenizer.nextToken());
            int number2 = Integer.parseInt(stringTokenizer.nextToken());

            if (number1 == 0 && number2 == 0) break;

            bufferedWriter.write(number1 > number2 ? GREATER_THAN_MESSAGE + "\n" : NOT_GREATER_THAN_MESSAGE + "\n");
            bufferedWriter.flush();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
