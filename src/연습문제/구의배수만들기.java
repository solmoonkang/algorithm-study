package 연습문제;

import java.io.*;

public class 구의배수만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] bruteForce = makeMultipleOfNineBruteForce(N, bufferedReader);
        for (int answer : bruteForce) bufferedWriter.write(answer + "\n");

        bufferedWriter.write("=====");
        bufferedWriter.newLine();

        int[] digitSum = getMinDigitSumMultipleOfNine(N, bufferedReader);
        for (int answer : digitSum) bufferedWriter.write(answer + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 기존 코드의 문제점:
     * - 매 숫자마다 최대 9번 반복문을 도는 불필요한 brute-force 방식으로, 문제의 핵심이 '각 자릿수의 합'인데, 숫자 자체를 나눠보고 있다.
     * - 또한 number % 9는 전체 수가 9의 배수인지만 판단할 뿐, 자릿수 합을 고려한 것이 아니다.
     * 때문에 동작은 하지만, 시간 복잡도 측면에서 비효율적이고 본질을 벗겨간 접근이다.
     */
    private static int[] makeMultipleOfNineBruteForce(int N, BufferedReader bufferedReader) throws IOException {
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(bufferedReader.readLine());
            int count = 0;

            if (number % 9 == 0) {
                numbers[i] = 9;
                continue;
            }

            for (long j = number; j <= number + 9; j++) {
                if (j % 9 == 0) break;
                else count++;
            }

            numbers[i] = count;
        }

        return numbers;
    }

    /**
     * 문제의 본질
     * - 입력된 수의 각 자릿수를 더한 값을 기준으로 판단해야 하는 문제이다.
     * - 어떤 수가 9의 배수가 되려면, 그 수의 각 자리수의 합이 9의 배수여야 한다.
     * <p>
     * 개선된 방식의 접근 방식
     * - 각 자릿수를 모두 더하고, 그 합이 9의 배수면 9를 출력하고 아니라면 9에서 (합 % 9)를 뺀 값을 출력한다.
     * - 각 자릿수 합을 이용하기 때문에 시간 복잡도 또한 O(N)이 된다.
     */
    private static int[] getMinDigitSumMultipleOfNine(int N, BufferedReader bufferedReader) throws IOException {
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            String number = bufferedReader.readLine();

            int digitSum = 0;
            for (char c : number.toCharArray()) {
                digitSum += c - '0';
            }

            if (digitSum % 9 == 0) numbers[i] = 9;
            else numbers[i] = 9 - (digitSum % 9);
        }

        return numbers;
    }
}
