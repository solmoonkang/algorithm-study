package 단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number == 0) numberStack.pollLast();
            else numberStack.offerLast(number);
        }

        int numberOfSum = 0;
        while (!numberStack.isEmpty()) {
            numberOfSum += numberStack.pollLast();
        }

        bufferedWriter.write(String.valueOf(numberOfSum));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
