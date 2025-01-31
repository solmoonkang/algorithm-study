package 알고리즘분류.자료구조;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String command = bufferedReader.readLine();

            if (command.startsWith("push")) {
                String[] parts = command.split(" ");
                deque.offerLast(Integer.parseInt(parts[1]));
            } else if (command.equals("pop")) {
                Integer value = deque.pollFirst();
                bufferedWriter.write(value != null ? value + "\n" : "-1\n");
            } else if (command.equals("size")) {
                bufferedWriter.write(deque.size() + "\n");
            } else if (command.equals("empty")) {
                bufferedWriter.write(deque.isEmpty() ? "1\n" : "0\n");
            } else if (command.equals("front")) {
                Integer value = deque.peekFirst();
                bufferedWriter.write(value != null ? value + "\n" : "-1\n");
            } else if (command.equals("back")) {
                Integer value = deque.peekLast();
                bufferedWriter.write(value != null ? value + "\n" : "-1\n");
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
