package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_2 {

    /**
     * 알고리즘 선정
     * 트리는 사이클이 없는 연결 그래프이므로, 특정 정점에서 가장 먼 노드를 찾으면 해당 지름을 구성하는 한쪽 끝점이 된다.
     * DFS / BFS를 사용하면 트리를 탐색하는 데 O(V)의 시간 복잡도를 가지므로, 이를 두 번 수행해도 O(2V) = O(V)로 효율적이다.
     */
    private static int V;
    private static boolean[] visited;
    private static List<List<int[]>> tree;
    private static int maxDistance = 0, farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node = Integer.parseInt(stringTokenizer.nextToken());

            while (true) {
                int neighbor = Integer.parseInt(stringTokenizer.nextToken());
                if (neighbor == -1) break;
                int weight = Integer.parseInt(stringTokenizer.nextToken());
                tree.get(node).add(new int[]{neighbor, weight});
            }
        }

        // 1. 첫 번째 DFS: 임의의 노드에서 가장 먼 노드를 찾는다.
        visited = new boolean[V + 1];
        DFS(1, 0);

        // 2. 두 번째 DFS: 찾은 노드에서 가장 먼 노드까지의 거리를 찾는다.
        visited = new boolean[V + 1];
        // 거리를 초기화한다.
        maxDistance = 0;
        DFS(farthestNode, 0);

        bufferedWriter.write(String.valueOf(maxDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * @param node:     현재 탐색 중인 노드로, DFS는 트리의 모든 노드를 탐색해야 하므로 현재 방문한 노드의 번호를 전달한다.
     * @param distance: 루트에서 현재 노드까지의 누적 거리로, 트리의 지름은 가장 긴 거리를 찾는 것이므로, 탐색 중 누적된 거리를 추적해야 한다.
     */
    private static void DFS(int node, int distance) {
        // 임의의 정점에서 DFS를 수행하여 가장 먼 노드 A를 찾는다.
        // 노드 A에서 다시 DFS를 수행하여 가장 먼 노드 B까지의 거리(트리의 지름)를 찾는다.

        // 현재 노드를 방문했음을 표시한다.
        visited[node] = true;

        // 현재 노드까지의 거리(distance)가 최대 거리(maxDistance)보다 크면 갱신한다.
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        // 현재 노드와 연결된 모든 노드를 탐색한다.
        for (int[] neighbor : tree.get(node)) {
            int nextNode = neighbor[0];     // 다음 노드
            int weight = neighbor[1];       // 현재 노드에서 다음 노드까지의 거리

            // 방문하지 않은 노드만 탐색하여, 누적 거리(distance + weight)로 재귀 호출한다.
            if (!visited[nextNode]) DFS(nextNode, distance + weight);
        }
    }
}
