package 모든문제.level2;

import java.io.*;
import java.util.*;

public class K진수에서소수개수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int countPrime = countPrimeInKBase(N, K);
        bufferedWriter.write(String.valueOf(countPrime));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countPrimeInKBase(int N, int K) {
        String[] parts = Integer.toString(N, K).split("0");

        int count = 0;
        for (String part : parts) {
            if (!part.isEmpty() && !part.equals("0")) {
                long number = Long.parseLong(part);
                if (isPrime(number)) count++;
            }
        }

        return count;
    }

    private static boolean isPrime(long number) {
        if (number < 2) return false;

        for (int i = 2; (long) i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
