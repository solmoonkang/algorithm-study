package 모든문제.level1;

import java.io.*;

public class 약수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int sumOfDivisors = getSumOfDivisors(N);
        bufferedWriter.write(String.valueOf(sumOfDivisors));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getSumOfDivisors(int N) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) sum += i;
        }

        return sum;
    }
}
