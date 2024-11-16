package baekjoon.단계문제.약수배수소수;

import java.io.*;

public class 약수들의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N = Integer.parseInt(bufferedReader.readLine());

            if (N == -1) break;

            int sumOfDivisors = 0;
            StringBuilder builder = new StringBuilder();

            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    sumOfDivisors += i;
                    builder.append(i).append(" + ");
                }
            }

            if (!builder.isEmpty()) builder.setLength(builder.length() - 3);

            bufferedWriter.write((sumOfDivisors == N) ? N + " = " + builder + "\n" : N + " is NOT perfect.\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
