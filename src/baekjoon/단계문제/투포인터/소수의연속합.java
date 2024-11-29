package baekjoon.단계문제.투포인터;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> numberList = new ArrayList<>();

        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) numberList.add(i);
        }

        int start = 0, end = 0;
        int currentSum = 0;
        int count = 0;

        while (end < numberList.size()) {
            currentSum += numberList.get(end);
            end++;

            while (currentSum >= N) {
                if (currentSum == N) count++;
                currentSum -= numberList.get(start);
                start++;
            }
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
