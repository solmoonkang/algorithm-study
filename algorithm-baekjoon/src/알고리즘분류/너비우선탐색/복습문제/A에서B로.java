package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A에서B로 {

    private static final int RETURN_IMPOSSIBLE = -1;

    private static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());

        int minOperation = BFS(A);
        bufferedWriter.write(String.valueOf(minOperation));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{start, 0});

        while (!searchDeque.isEmpty()) {
            int[] currentExpression = searchDeque.pollFirst();

            int number = currentExpression[0];
            int operator = currentExpression[1];

            if (number == B) return operator + 1;

            int doubled = number * 2;
            if (doubled <= B) searchDeque.offerLast(new int[]{doubled, operator + 1});

            int appended = number * 10 + 1;
            if (appended <= B) searchDeque.offerLast(new int[]{doubled, operator + 1});
        }

        return RETURN_IMPOSSIBLE;
    }
}
