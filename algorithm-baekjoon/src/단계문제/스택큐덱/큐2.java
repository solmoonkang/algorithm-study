package 단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 큐2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> queDeque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = bufferedReader.readLine();

            switch (command) {
                case "pop":
                    if (!queDeque.isEmpty()) bufferedWriter.write(queDeque.pollFirst() + "\n");
                    else bufferedWriter.write("-1\n");
                    break;
                case "size":
                    bufferedWriter.write(queDeque.size() + "\n");
                    break;
                case "empty":
                    bufferedWriter.write(queDeque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bufferedWriter.write(queDeque.isEmpty() ? "-1\n" : queDeque.peekFirst() + "\n");
                    break;
                case "back":
                    bufferedWriter.write(queDeque.isEmpty() ? "-1\n" : queDeque.peekLast() + "\n");
                    break;
                default:
                    String[] pushNumbers = command.split(" ");
                    if (pushNumbers[0].equals("push")) queDeque.offerLast(Integer.parseInt(pushNumbers[1]));
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
