package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 소음 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(bufferedReader.readLine());
        String operator = bufferedReader.readLine();
        int B = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        if (operator.equals("+")) {
            if (A > B) stringBuilder.append("1").append("0".repeat(A));
            else if (A < B) stringBuilder.append("1").append("0".repeat(B));
            else stringBuilder.append("2").append("0".repeat(A - 1));
        } else if (operator.equals("*")) {
            stringBuilder.append("1").append("0".repeat(A + B));
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
