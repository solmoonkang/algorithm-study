package 알고리즘분류.자료구조;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();

        int[] nextGreaterNumbers = findNextGreaterNumbersDeque(numbers);

        for (int number : nextGreaterNumbers) {
            stringBuilder.append(number).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 시간 초과 발생
    public static int[] findNextGreaterNumbers(int[] numbers) {
        int[] nextGreaterNumbers = new int[numbers.length];
        Arrays.fill(nextGreaterNumbers, -1);

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNumber < numbers[j]) {
                    nextGreaterNumbers[i] = numbers[j];
                    break;
                }
            }
        }

        return nextGreaterNumbers;
    }

    public static int[] findNextGreaterNumbersDeque(int[] numbers) {
        int[] nextGreaterNumbers = new int[numbers.length];

        Deque<Integer> numberDeque = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!numberDeque.isEmpty() && numbers[numberDeque.peekLast()] < numbers[i]) {
                nextGreaterNumbers[numberDeque.pollLast()] = numbers[i];
            }

            numberDeque.offerLast(i);
        }

        while (!numberDeque.isEmpty()) {
            nextGreaterNumbers[numberDeque.pollLast()] = -1;
        }

        return nextGreaterNumbers;
    }
}
