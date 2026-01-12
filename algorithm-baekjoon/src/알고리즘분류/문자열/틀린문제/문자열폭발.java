package 알고리즘분류.문자열.틀린문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 문자열폭발 {

    private static final String NO_CHARACTERS_REMAINING = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();
        String explosionSentence = bufferedReader.readLine();

        Deque<Character> processingDeque = new LinkedList<>();
        int explosionLength = explosionSentence.length();

        for (char alphabet : sentence.toCharArray()) {
            processingDeque.offerLast(alphabet);

            if (processingDeque.size() >= explosionLength) {
                StringBuilder lastPart = new StringBuilder();
                for (int i = 0; i < explosionLength; i++)
                    lastPart.append(processingDeque.toArray()[processingDeque.size() - explosionLength + i]);

                if (lastPart.toString().equals(explosionSentence)) {
                    for (int i = 0; i < explosionLength; i++) processingDeque.removeLast();
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character alphabet : processingDeque) stringBuilder.append(alphabet);

        bufferedWriter.write(stringBuilder.isEmpty() ? NO_CHARACTERS_REMAINING : stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
