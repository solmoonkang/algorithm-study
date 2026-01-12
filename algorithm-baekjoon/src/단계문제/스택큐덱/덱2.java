package 단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 덱2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            String[] parts = input.split(" ");
            int command = Integer.parseInt(parts[0]);

            switch (command) {
                case 1:
                    deque.offerFirst(Integer.parseInt(parts[1]));
                    break;
                case 2:
                    deque.offerLast(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    bufferedWriter.write(!deque.isEmpty() ? deque.pollFirst() + "\n" : "-1\n");
                    break;
                case 4:
                    bufferedWriter.write(!deque.isEmpty() ? deque.pollLast() + "\n" : "-1\n");
                    break;
                case 5:
                    bufferedWriter.write(deque.size() + "\n");
                    break;
                case 6:
                    bufferedWriter.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case 7:
                    bufferedWriter.write(!deque.isEmpty() ? deque.peekFirst() + "\n" : "-1\n");
                    break;
                case 8:
                    bufferedWriter.write(!deque.isEmpty() ? deque.peekLast() + "\n" : "-1\n");
                    break;
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
