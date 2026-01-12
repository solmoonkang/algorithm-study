package 알고리즘분류.깊이우선탐색.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리에서특정노드까지의거리구하기 {

    private static int nodeNumber, targetNode;
    private static boolean[] visited;
    private static List<List<Node>> tree;
    private static int targetDistance = -1;

    private record Node(int to, int weight) { }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        nodeNumber = Integer.parseInt(bufferedReader.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= nodeNumber; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < nodeNumber - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            tree.get(parentNode).add(new Node(childNode, weight));
            tree.get(childNode).add(new Node(parentNode, weight));
        }

        targetNode = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[nodeNumber + 1];
        DFS(1, 0);

        bufferedWriter.write(String.valueOf(targetDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // DFS를 이용하여 루트(1번)에서 시작해 목표 노드 X를 찾을 때까지 탐색한다.
    private static void DFS(int node, int distance) {
        if (visited[node]) return;
        // 방문한 노드를 다시 방문하지 않도록 visited 배열을 사용한다.
        visited[node] = true;

        // 목표 노드에 도달하면 현재까지 누적된 거리, distance를 저장하고 탐색을 종료한다.
        if (node == targetNode) {
            targetDistance = distance;
            return;
        }

        for (Node nextNode : tree.get(node)) {
            if (!visited[nextNode.to]) DFS(nextNode.to, distance + nextNode.weight);
        }
    }
}
