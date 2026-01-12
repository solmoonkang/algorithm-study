package 알고리즘분류.브루트포스알고리즘;

import java.io.*;

public class 분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int decompositionSum = 0;
        for (int M = 1; M < N; M++) {
            if (M + getDecompositionSum(M) == N) {
                decompositionSum = M;
                break;
            }
        }

        bufferedWriter.write(String.valueOf(decompositionSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getDecompositionSum(int number) {
        int sumOfDigits = 0;

        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits;
    }
}
