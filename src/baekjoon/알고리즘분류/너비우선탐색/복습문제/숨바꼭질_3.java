package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질_3 {

    private static final int MAX_POSITION = 100_000;
    private static final int INVALID_POSITION = -1;

    private static int N, K;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        if (N == K) {
            bufferedWriter.write("0");
            return;
        }

        visited = new boolean[MAX_POSITION + 1];

        int shortestWayToFind = BFS(N);
        bufferedWriter.write(String.valueOf(shortestWayToFind));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{start, 0});
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int distance = current[0];
            int time = current[1];

            if (K == distance) return time;

            int[] directions = {distance - 1, distance + 1, 2 * distance};
            for (int direction : directions) {
                if (direction >= 0 && direction <= MAX_POSITION && !visited[direction]) {
                    visited[direction] = true;
                    // 수빈이가 걸을 경우 X - 1 OR X + 1일 경우 한 칸 이동하는 데 1초가 걸린다. 순간이동인 경우 2 * X일 경우 0초가 걸린다.
                    // direction이 2 * distance일 경우 즉, 순간이동일 경우 시간을 time 그대로 사용하고, 그렇지 않으면 즉, 걷기일 경우에는 time + 1을 사용하여 덱에 추가한다.
                    searchDeque.offerLast(new int[]{direction, direction == distance * 2 ? time : time + 1});
                }
            }
        }

        return INVALID_POSITION;
    }
}
