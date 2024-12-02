package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    private static final int MAX_POSITION = 100000;
    private static final boolean[] visited = new boolean[MAX_POSITION + 1];
    private static final Deque<State> stateDeque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int minTime = BFS(N, K);
        bufferedWriter.write(String.valueOf(minTime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int N, int K) {
        stateDeque.offerLast(new State(N, 0));
        visited[N] = true;

        while (!stateDeque.isEmpty()) {
            State current = stateDeque.pollFirst();
            int position = current.position;
            int time = current.time;

            if (position == K) return time;

            if (position - 1 >= 0 && !visited[position - 1]) {
                visited[position - 1] = true;
                stateDeque.offerLast(new State(position - 1, time + 1));
            }

            if (position + 1 <= MAX_POSITION && !visited[position + 1]) {
                visited[position + 1] = true;
                stateDeque.offerLast(new State(position + 1, time + 1));
            }

            if (2 * position <= MAX_POSITION && !visited[2 * position]) {
                visited[2 * position] = true;
                stateDeque.offerLast(new State(2 * position, time + 1));
            }
        }

        return -1;
    }

    private static class State {
        int position;
        int time;

        public State(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}
