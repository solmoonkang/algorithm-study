package 알고리즘분류.자료구조;

import java.io.*;
import java.util.*;

public class 스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        List<Integer> numberList = new ArrayList<>();

        int currentNumber = 1;

        for (int i = 0; i < N; i++) {
            numberList.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int number : numberList) {
            while (currentNumber <= number) {
                deque.offerLast(currentNumber++);
                stringBuilder.append("+\n");
            }

            if (deque.isEmpty() || !Objects.equals(deque.peekLast(), number)) {
                bufferedWriter.write("NO\n");
                bufferedWriter.flush();
                return;
            }

            deque.pollLast();
            stringBuilder.append("-\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
