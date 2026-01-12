package 알고리즘분류.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 카드_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> discardCardList = new ArrayList<>();
        Deque<Integer> currentCardSequences = new LinkedList<>();
        for (int i = 1; i <= N; i++) currentCardSequences.offerLast(i);

        while (currentCardSequences.size() > 1) {
            discardCardList.add(currentCardSequences.pollFirst());
            currentCardSequences.offerLast(currentCardSequences.pollFirst());
        }

        discardCardList.add(currentCardSequences.peekFirst());
        for (int cardNumber : discardCardList) bufferedWriter.write(cardNumber + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
