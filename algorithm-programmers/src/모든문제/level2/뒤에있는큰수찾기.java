package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 뒤에있는큰수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] nextNumbers = getNextGreaterNumbers(numbers);
        for (int number : nextNumbers) bufferedWriter.write(number + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getNextGreaterNumbers(int[] numbers) {
        int[] nextNumbers = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]) {
                int index = deque.pollLast();
                nextNumbers[index] = numbers[i];
            }

            deque.offerLast(i);
        }

        while (!deque.isEmpty()) {
            nextNumbers[deque.pollLast()] = -1;
        }

        return nextNumbers;
    }

    private static int[] getNextGreaterNumbersBruteForce(int[] numbers) {
        int[] nextNumbers = new int[numbers.length];

        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            boolean found = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNumber < numbers[j]) {
                    maxNumber = numbers[j];
                    found = true;
                    break;
                }
            }

            nextNumbers[i] = maxNumber;
            if (!found) nextNumbers[i] = -1;
        }

        return nextNumbers;
    }
}
