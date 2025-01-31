package 단계문제.반복문;

import java.io.*;

public class A더하기B_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            String[] testCases = input.split(" ");

            int A = Integer.parseInt(testCases[0]);
            int B = Integer.parseInt(testCases[1]);
            int sum = A + B;

            bufferedWriter.write(String.valueOf(sum));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
