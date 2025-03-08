package 알고리즘분류.브루트포스알고리즘.복습문제;

import java.io.*;

public class 분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int minConstructorNumber = getMinConstructorNumber(N);
        bufferedWriter.write(String.valueOf(minConstructorNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinConstructorNumber(int number) {
        // int start = Math.max(1, number - (9 * String.valueOf(number).length()));
        int start = Math.max(1, number - (int) (Math.log10(number) + 1) * 9);

        for (int i = start; i < number; i++) {
            if (getDecomposedSum(i) == number) return i;
        }

        return 0;
    }

    private static int getDecomposedSum(int number) {
        int sum = number;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
