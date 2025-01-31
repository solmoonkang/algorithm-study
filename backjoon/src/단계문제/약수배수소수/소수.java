package 단계문제.약수배수소수;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bufferedReader.readLine());
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> primeList = new ArrayList<>();

        int sumOfPrime = 0;
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                primeList.add(i);
                sumOfPrime += i;
            }
        }

        bufferedWriter.write((primeList.isEmpty()) ? "-1\n" : sumOfPrime + "\n" + primeList.get(0));
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
