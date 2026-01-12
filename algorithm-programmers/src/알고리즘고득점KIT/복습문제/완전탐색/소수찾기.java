package 알고리즘고득점KIT.복습문제.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소수찾기 {

    private static Set<Integer> numberSet;
    private static char[] numberPieces;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = bufferedReader.readLine();
        bufferedReader.close();

        int primeNumberCount = countPrimeNumber(numbers);
        bufferedWriter.write(String.valueOf(primeNumberCount));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int countPrimeNumber(String numbers) {
        numberSet = new HashSet<>();
        numberPieces = numbers.toCharArray();
        visited = new boolean[numberPieces.length];

        generateNumbers("", 0);

        int primeNumberCount = 0;

        List<Integer> numberList = new ArrayList<>(numberSet);
        for (int num : numberList) {
            if (isPrimeNumber(num)) primeNumberCount++;
        }

        return primeNumberCount;
    }

    private static void generateNumbers(String numbers, int depth) {
        if (!numbers.isEmpty()) numberSet.add(Integer.parseInt(numbers));

        for (int i = 0; i < numberPieces.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(numbers + numberPieces[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) return false;           // 0과 1은 소수가 아니므로 false를 반환
        if (number == 2) return true;           // 유일한 짝수 소수 2이므로 true를 반환
        if (number % 2 == 0) return false;      // 2보다 큰 짝수는 더 이상 소수가 아니므로 false를 반환

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
