package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {

    private static int N;
    private static boolean[] visited;
    private static List<List<Node>> tree;
    private static int maxDistance = 0, farthestNode = 0;

    private record Node(int to, int weight) {}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            tree.get(parentNode).add(new Node(childNode, weight));
            tree.get(childNode).add(new Node(parentNode, weight));
        }

        // DFS를 두 번 수행하는 이유는 트리에서 가장 긴 경로를 찾기 위한 방식으로,
        // 트리는 사이클이 없는 연결 그래프이므로 임의의 노드에서 출발한다고 해서 항상 트리의 지름 끝점과 연결되지는 않는다.
        // 따라서, 두 번의 DFS를 수행해야 트리의 지름을 올바르게 찾을 수 있다.

        // 임의의 노드에서 가장 먼 노드 A를 찾는다. 이 과정에서 트리 지름의 한쪽 끝점을 찾을 가능성이 높다.
        visited = new boolean[N + 1];
        DFS(1, 0);

        // A에서 가장 먼 노드 B를 찾는다. 이렇게 하면 A와 B 사이의 거리가 트리의 지름이 된다.
        visited = new boolean[N + 1];
        maxDistance = 0;
        DFS(farthestNode, 0);

        bufferedWriter.write(String.valueOf(maxDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node, int distance) {
        if (visited[node]) return;
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node nextNode : tree.get(node)) {
            if (!visited[nextNode.to]) DFS(nextNode.to, distance + nextNode.weight);
        }
    }
}
