package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 짝지어제거하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();

        int answer = isRemoveInPairs(sentence);
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int isRemoveInPairs(String sentence) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char alphabet : sentence.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() == alphabet) deque.pollLast();
            else deque.offerLast(alphabet);
        }

        return deque.isEmpty() ? 1 : 0;
    }
}
