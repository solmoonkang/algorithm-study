package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class A에서B로 {

    private static final int CONVERSION_NOT_POSSIBLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int minOperations = BFS(A, B);
        bufferedWriter.write(String.valueOf(minOperations));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start, int target) {
        Deque<int[]> searchDeque = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        searchDeque.add(new int[]{start, 0});
        visited.add(start);

        while (!searchDeque.isEmpty()) {
            int[] currentOperation = searchDeque.pollFirst();
            int position = currentOperation[0];
            int value = currentOperation[1];

            if (position == target) return value + 1;

            int doublePosition = position * 2;
            if (doublePosition <= target && !visited.contains(doublePosition)) {
                visited.add(doublePosition);
                searchDeque.add(new int[]{doublePosition, value + 1});
            }

            int appendOnePosition = position * 10 + 1;
            if (appendOnePosition <= target && !visited.contains(appendOnePosition)) {
                visited.add(appendOnePosition);
                searchDeque.add(new int[]{appendOnePosition, value + 1});
            }
        }

        return CONVERSION_NOT_POSSIBLE;
    }
}
