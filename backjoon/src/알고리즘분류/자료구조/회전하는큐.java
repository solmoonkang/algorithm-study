package 알고리즘분류.자료구조;

import java.io.*;
import java.util.*;

public class 회전하는큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> positions = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            positions.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int minOperationDeque = minimumOperationsUsingDeque(N, positions);
        bufferedWriter.write(String.valueOf(minOperationDeque));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int minimumOperationsUsingDeque(int N, List<Integer> positions) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        // 원소를 뽑기 위해 수행한 총 이동 횟수를 누적
        int operationsNumber = 0;

        for (int position : positions) {
            int index = 0;

            for (int number : deque) {
                if (number == position) break;
                index++;
            }

            int leftMoves = index;
            int rightMoves = deque.size() - index;

            operationsNumber += Math.min(leftMoves, rightMoves);

            if (leftMoves <= rightMoves) {
                for (int i = 0; i < leftMoves; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < rightMoves; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }

            deque.pollFirst();
        }

        return operationsNumber;
    }
}
