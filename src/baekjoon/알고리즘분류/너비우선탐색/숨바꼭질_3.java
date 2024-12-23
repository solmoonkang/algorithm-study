package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질_3 {

    private static final int MAX_RANGE = 100000;
    private static final int UNREACHABLE = -1;

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[MAX_RANGE + 1];
        int shortestTime = BFS(N, K);
        bufferedWriter.write(String.valueOf(shortestTime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start, int target) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{start, 0});
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            int[] currentPosition = searchDeque.pollFirst();
            int position = currentPosition[0];
            int time = currentPosition[1];

            // 수빈이가 동생 위치에 도달했을 경우, 걸린 최소 시간을 반환한다.
            if (position == target) return time;

            // 수빈이가 이동 가능한 다음 위치를 저장한다.
            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int nextPosition : nextPositions) {
                // 범위를 초과하지 않고 방문하지 않은 경우에 동작한다.
                if (nextPosition >= 0 && nextPosition <= MAX_RANGE && !visited[nextPosition]) {
                    visited[nextPosition] = true;
                    // 순간 이동은 0초, 걷기는 1초 후에 덱에 추가한다.
                    searchDeque.add(new int[]{nextPosition, nextPosition == position * 2 ? time : time + 1});
                }
            }
        }

        return UNREACHABLE;
    }
}
