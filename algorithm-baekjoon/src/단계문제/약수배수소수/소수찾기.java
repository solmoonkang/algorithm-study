package 단계문제.약수배수소수;

import java.io.*;
import java.util.StringTokenizer;

public class 소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int countOfPrime = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (isPrime(number)) countOfPrime++;
        }

        bufferedWriter.write(String.valueOf(countOfPrime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
