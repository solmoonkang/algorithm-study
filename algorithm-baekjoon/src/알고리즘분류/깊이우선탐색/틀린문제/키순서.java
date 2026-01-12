package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.*;

public class 키순서 {

    /**
     * 해결 접근 방식
     * 해당 문제는 그래프 탐색 문제이며, DFS보다 플로이드 워셜 혹은 위상 정렬(BFS)이 적합한 문제이다.
     * 누가 누구보다 키가 큰지를 알 수 있는 방향 그래프의 성질을 가지고 있기 때문이다.
     * 즉, 그래프에서 모든 정점 간의 관계를 알 수 있는지를 확인하는 문제이다.
     */

    private static int N, M;

    private static boolean[][] graph;

    private static List<Integer>[] directionGraph;
    private static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new boolean[N + 1][N + 1];

        directionGraph = new List[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) directionGraph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int smallerNode = Integer.parseInt(stringTokenizer.nextToken());
            int tollerNode = Integer.parseInt(stringTokenizer.nextToken());

            graph[smallerNode][tollerNode] = true;

            // A가 B보다 키가 작다.
            directionGraph[smallerNode].add(tollerNode);
            // B로 들어오는 간선 개수가 증가한다.
            indegree[tollerNode]++;
        }

        int heightOrder = heightOrder();
        bufferedWriter.write(String.valueOf(heightOrder));

        bufferedWriter.write("\n");

        int heightOrderTopo = 0;
        for (int i = 1; i <= N; i++) {
            int knownRelations = BFS(i);
            if (knownRelations == N - 1) heightOrderTopo++;
        }

        bufferedWriter.write(String.valueOf(heightOrderTopo));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 모든 학생 간의 관계를 알아야 하므로, 모든 정점 간 최단 경로를 구하는 플로이드 워셜 알고리즘을 활용하면 모든 학생의 관계를 쉽게 알 수 있다.
    // 이를 통해 직접 비교한 적 없는 학생 간의 관계도 유추가 가능하다. 시간 복잡도는 O(N^3)을 가진다.
    private static int heightOrder() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // graph[a][b] == true이고 graph[b][c] = true이면 graph[a][c] = true이다.
                    // 즉, a -> b -> c 라면, a -> c 관계도 확정된다.
                    if (graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }

        int heightOrder = 0;

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] || graph[j][i]) count++;
            }
            // 각 학생에 대해 자신의 키 순서를 정확히 알 수 있는지 확인한다.
            // 자신보다 큰 학생 수 + 작은 학생 수 = N - 1이면 자신의 키 순위를 알 수 있다.
            if (count == N - 1) heightOrder++;
        }

        return heightOrder;
    }

    // 학생들의 키 관계를 방향 그래프로 표현할 수 있다. 즉, A < B 관계가 있을 때, A가 먼저 나와야 한다.
    // 위상 정렬을 사용하면, 키 순서를 결정할 수 있는 학생을 찾을 수 있다. 시간 복잡도는 O(N^2) 또는 O(N + M)을 가진다.
    private static int BFS(int start) {
        Deque<Integer> searchDeque = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        searchDeque.offerLast(start);
        visited[start] = true;

        int count = 0;

        while (!searchDeque.isEmpty()) {
            int current = searchDeque.pollFirst();

            for (int nextNode : directionGraph[current]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    searchDeque.offerLast(nextNode);
                    count++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && indegree[i] > 0) count++;
        }

        return count;
    }
}
