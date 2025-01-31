package 단계문제.재귀;

import java.io.*;

public class 피보나치수_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        long result = fibonacci(N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
