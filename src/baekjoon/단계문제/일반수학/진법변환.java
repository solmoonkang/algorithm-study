package baekjoon.단계문제.일반수학;

import java.io.*;
import java.util.StringTokenizer;

public class 진법변환 {

    // TODO: 문자열을 통해 해당 값을 변환하는 능력이 미숙하다. 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String N = stringTokenizer.nextToken();
        int B = Integer.parseInt(stringTokenizer.nextToken());

        long decimalValue = convertBaseToDecimal(N, B);

        bufferedWriter.write(String.valueOf(decimalValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long convertBaseToDecimal(String N, int B) {
        long decimalValue = 0;
        int length = N.length();

        for (int i = 0; i < length; i++) {
            char c = N.charAt(i);
            int value;

            if (Character.isDigit(c)) value = c - '0';
            else value = c - 'A' + 10;

            decimalValue += (long) (value * Math.pow(B, length - 1 - i));
        }

        return decimalValue;
    }
}
