package baekjoon.알고리즘분류.백트래킹;

import java.io.*;

public class 신기한소수 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        generateCombinations("", N);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateCombinations(String currentNumber, int length) {
        if (currentNumber.length() == length) {
            // 현재 길이가 N일 때, 전체 숫자가 소수인지 확인한다.
            if (isPrimeNumber(Integer.parseInt(currentNumber))) {
                // 모든 접두사를 확인한다.
                boolean isCuriousPrime = true;

                for (int i = 1; i <= currentNumber.length(); i++) {
                    // 접두사를 생성한다.
                    String prefix = currentNumber.substring(0, i);
                    if (!isPrimeNumber(Integer.parseInt(prefix))) {
                        // 접두사 중 하나라도 소수가 아니면 false로 설정한다.
                        isCuriousPrime = false;
                        break;
                    }
                }

                // 신기한 소수일 경우 StringBuilder에 추가한다.
                if (isCuriousPrime) stringBuilder.append(currentNumber).append("\n");
            }
            return;
        }

        // 조합을 계속 생성하기 위한 재귀 호출을 한다.
        for (int digit = 2; digit <= 9; digit++) {
            generateCombinations(currentNumber + digit, length);
        }
    }

    // 소수 판별에서 어떤 수가 소수인지 확인하기 위해서는 그 수의 약수를 찾아야 한다. 즉, 약수의 성질을 활용해야 한다.
    // 어떤 수 N이 있을 때, N의 약수는 항상 두 개의 수의 곱으로 나타낼 수 있다. 예를 들어, N = A * B라면, A와 B는 N의 약수이다.
    // 만약, A가 N의 약수라면, B는 N / A로 계산할 수 있다. 그리고 A와 B 중에서 하나는 항상 √N보다 작거나 같고, 다른 하나는 √N보다 크거나 같다는 것을 이용한다.
    private static boolean isPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
