package 모든문제.level2.복습문제;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 짝지어제거하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();
        bufferedReader.close();

        int removePairs = isRemovalPossible(sentence);
        bufferedWriter.write(String.valueOf(removePairs));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int isRemovalPossible(String sentence) {
        Deque<Character> alphabetDeque = new ArrayDeque<>();

        for (char currentAlphabet : sentence.toCharArray()) {
            if (!alphabetDeque.isEmpty() && currentAlphabet == alphabetDeque.peekLast()) alphabetDeque.pollLast();
            else alphabetDeque.offerLast(currentAlphabet);
        }

        return alphabetDeque.isEmpty() ? 1 : 0;
    }
}
