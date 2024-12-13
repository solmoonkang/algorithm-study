package baekjoon.알고리즘분류.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class 진법변환 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String N = stringTokenizer.nextToken();
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int decimalValue = convertBase36ToDecimal(N, B);

        bufferedWriter.write(String.valueOf(decimalValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int convertBase36ToDecimal(String number, int baseValue) {
        int decimalValue = 0;
        int N = number.length();

        for (int i = 0; i < N; i++) {
            char c = number.charAt(i);
            int digit;

            if (c >= '0' && c <= '9') digit = c - '0';
            else digit = c - 'A' + 10;

            decimalValue += (int) (digit * Math.pow(baseValue, N - 1 - i));
        }

        return decimalValue;
    }
}
