package 알고리즘고득점KIT.전체문제.그리디;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 큰수만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = bufferedReader.readLine();
        int K = Integer.parseInt(bufferedReader.readLine());

        String maxNumber = findLargestNumberAfterRemove(number, K);
        bufferedWriter.write(maxNumber);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String findLargestNumberAfterRemove(String number, int k) {
        Deque<Character> numberBeforeRemoveDeque = new LinkedList<>();

        for (char digit : number.toCharArray()) {
            while (!numberBeforeRemoveDeque.isEmpty() && k > 0 && numberBeforeRemoveDeque.peekLast() < digit) {
                numberBeforeRemoveDeque.pollLast();
                k--;
            }

            numberBeforeRemoveDeque.offerLast(digit);
        }

        while (k > 0) {
            numberBeforeRemoveDeque.pollLast();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char digit : numberBeforeRemoveDeque) stringBuilder.append(digit);

        return stringBuilder.toString();
    }
}
