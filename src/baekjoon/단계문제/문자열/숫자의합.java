package baekjoon.단계문제.문자열;

import java.io.*;

public class 숫자의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        String number = bufferedReader.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }

        bufferedWriter.write(String.valueOf(sum));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
