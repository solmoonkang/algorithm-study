package 알고리즘분류.재귀.연습문제.문제풀이;

import java.io.*;

public class 팩토리얼 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int factorialNumber = generateFactorialNumber(N);
        bufferedWriter.write(String.valueOf(factorialNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateFactorialNumber(int targetNumber) {
        if (targetNumber == 0 || targetNumber == 1) return 1;
        return targetNumber * generateFactorialNumber(targetNumber - 1);
    }
}
