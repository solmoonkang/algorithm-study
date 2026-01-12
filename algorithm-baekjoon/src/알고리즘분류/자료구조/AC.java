package 알고리즘분류.자료구조;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String commandSequence = bufferedReader.readLine();
            int N = Integer.parseInt(bufferedReader.readLine());

            String[] numberStrings = bufferedReader.readLine().replaceAll("[\\[\\] ]", "").split(",");

            Deque<Integer> numbersDeque = new ArrayDeque<>();
            for (String number : numberStrings) {
                if (!number.isEmpty()) numbersDeque.offerLast(Integer.parseInt(number));
            }

            String result = executeCommandsOnDeque(commandSequence, numbersDeque);
            bufferedWriter.write(result + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static String executeCommandsOnDeque(String commandSequence, Deque<Integer> numberDeque) {
        boolean isReversed = false;

        for (char command : commandSequence.toCharArray()) {
            if (command == 'R') {
                isReversed = !isReversed;
            } else if (command == 'D') {
                if (numberDeque.isEmpty()) return "error";

                if (isReversed) numberDeque.pollLast();
                else numberDeque.pollFirst();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        if (isReversed) {
            while (!numberDeque.isEmpty()) {
                stringBuilder.append(numberDeque.pollLast());
                if (!numberDeque.isEmpty()) stringBuilder.append(",");
            }
        } else {
            while (!numberDeque.isEmpty()) {
                stringBuilder.append(numberDeque.pollFirst());
                if (!numberDeque.isEmpty()) stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
