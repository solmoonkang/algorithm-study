package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 약수의개수와덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());

        int sum = sumByDivisorParity(L, R);
        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int sumByDivisorParity(int L, int R) {
        int sum = 0;

        for (int i = L; i <= R; i++) {
            int divisor = countDivisors(i);

            if (divisor % 2 == 0) sum += i;
            else sum -= i;
        }

        return sum;
    }

    private static int countDivisors(int L) {
        int divisor = 0;
        for (int i = 1; i <= L; i++) if (L % i == 0) divisor++;
        return divisor;
    }

    private static int anotherSolution(int L, int R) {
        int sum = 0;

        for (int i = L; i <= R; i++) {
            if (i % Math.sqrt(i) == 0) sum -= i;
            else sum += i;
        }

        return sum;
    }
}
