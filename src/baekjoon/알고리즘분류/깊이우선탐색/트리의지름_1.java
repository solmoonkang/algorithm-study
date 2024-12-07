package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1 {

    /**
     * 트리의 모든 경로 중에서 가장 긴 경로의 길이 즉, 지름을 구해야 한다.
     *
     * 1. 그래프 표현: 인접 리스트를 사용하여 트리를 표현한다. 각 노드에 대해 연결된 노드와 가중치를 저장한다.
     * 2. 두 번의 DFS를 사용하여 트리의 지름을 구한다.
     *  - 첫 번째 DFS: 임의의 노드에서 가장 먼 노드를 찾는다.
     *  - 두 번째 DFS: 첫 번째 DFS에서 찾은 가장 먼 노드로부터 다시 가장 먼 노드를 찾고, 이떄의 거리가 트리의 지름이다.
     */

    private static int N;
    private static boolean[] visited;
    private static List<int[]>[] arrayLists;

    private static int maxDistance = 0;
    private static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parent = Integer.parseInt(stringTokenizer.nextToken());
            int child = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[parent].add(new int[]{child, weight});
            arrayLists[child].add(new int[]{parent, weight});
        }

        visited = new boolean[N + 1];
        DFS(1, 0);

        visited = new boolean[N + 1];
        maxDistance = 0;
        DFS(farthestNode, 0);

        bufferedWriter.write(String.valueOf(maxDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (int[] neighbor : arrayLists[node]) {
            int nextNode = neighbor[0];
            int edgeWeight = neighbor[1];

            if (!visited[nextNode]) DFS(nextNode, distance + edgeWeight);
        }
    }
}
