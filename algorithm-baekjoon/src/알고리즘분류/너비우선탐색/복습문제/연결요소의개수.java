package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 연결요소의개수 {

    private static int N, M;
    private static boolean[] visited;
    private static List<List<Integer>> undirectedGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        undirectedGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) undirectedGraph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            undirectedGraph.get(U).add(V);
            undirectedGraph.get(V).add(U);
        }

        int connectedComponents = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
                connectedComponents++;
            }
        }

        bufferedWriter.write(String.valueOf(connectedComponents));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int start) {
        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.offerLast(start);
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            // 연결 요소의 개수를 찾는 경우, 각 정점에 대해 BFS를 시작할 때마다 연결된 모든 노드를 방문하면 되므로 레벨 관리가 필요하지 않다.
            int current = searchDeque.pollFirst();

            for (int neighbor : undirectedGraph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    searchDeque.offerLast(neighbor);
                }
            }
        }
    }
}
