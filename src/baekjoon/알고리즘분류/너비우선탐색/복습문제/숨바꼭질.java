package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    private static final int UNREACHABLE = -1;
    private static final int MAX_POSITION = 100_000;
    // 수빈이의 위치가 0부터 100_000까지 가능하기 때문에 다음과 같이 초기화한다.
    private static final boolean[] visited = new boolean[MAX_POSITION + 1];

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        int minTimeToFindBrother = BFS(N);
        bufferedWriter.write(String.valueOf(minTimeToFindBrother));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start) {
        // 수빈이의 현재 위치와 그 위치까지 걸린 시간을 함께 저장하기 위해 int[]를 사용한다.
        // int[] 배열의 첫 번째 요소는 현재 위치를 나타내고, 두 번째 요소는 그 위치에 도달하는 데 걸린 시간을 나타낸다.
        Deque<int[]> searchDeque = new LinkedList<>();
        // start는 수빈이의 시작 위치인 N이고, 0은 그 위치에 도달하는 데 걸린 시간이다. 즉, 수빈이가 처음 시작할 때는 0초가 경과한 상태이다.
        searchDeque.offerLast(new int[]{start, 0});
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            // 현재 위치와 시간을 저장하는 역할로, 한 번의 큐 작업으로 두 가지 정보를 함께 처리할 수 있다.
            int[] current = searchDeque.pollFirst();
            int position = current[0];
            int time = current[1];

            if (position == K) return time;

            int[] directions = {position - 1, position + 1, 2 * position};
            for (int neighbor : directions) {
                // 수빈이가 이동할 수 있는 위치는 음수가 될 수 없고, 수빈이가 이동할 수 있는 최대 위치를 넘기지 말아야 한다.
                if (neighbor >= 0 && neighbor <= MAX_POSITION && !visited[neighbor]) {
                    visited[neighbor] = true;
                    searchDeque.offerLast(new int[]{neighbor, time + 1});
                }
            }
        }

        return UNREACHABLE;
    }
}
