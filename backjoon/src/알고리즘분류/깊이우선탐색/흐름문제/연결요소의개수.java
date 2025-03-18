package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    private static int N, M;
    private static boolean[] visited;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        // 만약 graph 상태를 0, 1(2, 5), 2(1, 5), 3(4), 4(3, 6), 5(1, 2), 6(4)로 구성되어 있다고 가정하자.
        // 이를 그래프로 나타내면 1 <-> 2 <-> 5, 3 <-> 4 <-> 6으로 구성된다.
        // (1, 2, 5)는 서로 연결된 하나의 그룹, (3, 4, 6)은 서로 연결된 또 다른 그룹이 된다. 따라서 연결 요소의 개수는 2개가 된다.

        // 따라서 연결 요소의 개수를 구하기 위한 변수를 선언하고, 1부터 N까지 순회하며 DFS를 재귀 호출하여 연결 요소의 개수를 구한다.
        int connectedComponents = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                connectedComponents++;
            }
        }

        bufferedWriter.write(String.valueOf(connectedComponents));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) DFS(nextNode);
        }
    }
}
