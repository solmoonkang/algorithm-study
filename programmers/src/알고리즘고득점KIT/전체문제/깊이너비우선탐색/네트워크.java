package 알고리즘고득점KIT.전체문제.깊이너비우선탐색;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class 네트워크 {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N1 = 3, N2 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int connectNetwork1 = solution(N1, computers1);
        int connectNetwork2 = solution(N2, computers2);
        bufferedWriter.write(String.valueOf(connectNetwork1));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(connectNetwork2));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int connectNetwork = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, computers, n);
                connectNetwork++;
            }
        }

        return connectNetwork;
    }

    // DFS에서는 현재 탐색 중인 컴퓨터의 인덱스를 index로 관리한다. index는 재귀 호출을 통해 깊이 탐색할 때마다 업데이트된다.
    private static void DFS(int index, int[][] computers, int N) {
        visited[index] = true;

        for (int i = 0; i < N; i++) {
            // index는 현재 DFS 호출의 상태를 나타내며, computers[index][i]를 통해 현재 컴퓨터(index)와 연결된 다른 컴퓨터(i)를 확인한다.
            // 즉, 현재 위치에서 연결된 컴퓨터를 탐색하기 위해 사용된다.
            if (computers[index][i] == 1 && !visited[i]) DFS(i, computers, N);
        }
    }

    // BFS에서는 큐를 사용하여 탐색하는 방식이기 떄문에, 현재 큐에서 꺼낸 컴퓨터를 current로 명명한다.
    private static void BFS(int start, int[][] computers, int N) {
        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.offerLast(start);
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            int current = searchDeque.pollFirst();

            for (int i = 0; i < N; i++) {
                // current는 BFS에서 현재 처리 중인 컴퓨터를 나타내며, computers[current][i]를 통해 현재 컴퓨터(current)와 연결된 다른 컴퓨터(i)를 확인한다.
                // 큐에서 꺼낸 컴퓨터가 현재 탐색 중인 노드이기 때문에, current를 사용하여 연결된 모든 컴퓨터를 탐색한다.
                if (computers[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    searchDeque.offerLast(i);
                }
            }
        }
    }
}
