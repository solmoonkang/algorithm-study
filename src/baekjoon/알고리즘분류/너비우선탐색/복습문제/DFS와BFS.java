package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class DFS와BFS {

    // TODO: 내가 구현한 DFS, BFS에 대한 모든 것이 이 안에 담겨있는 듯 하다. 모조리 다 공부하자.

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static boolean[] visited;
    private static List<List<Integer>> arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) arrayLists.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists.get(node1).add(node2);
            arrayLists.get(node2).add(node1);
        }

        DFS(V);
        stringBuilder.append("\n");

        visited = new boolean[N + 1];
        BFS(V);
        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // DFS는 그래프의 한 정점에서 시작하여 가능한 깊게 탐색한 후, 더 이상 진행할 수 없을 때 이전 정점으로 돌아가서 다른 경로를 탐색하는 방식이다.
    private static void DFS(int start) {
        // 현재 정점을 방문했음을 표시한다.
        visited[start] = true;
        // 현재 정점을 결과에 추가한다.
        stringBuilder.append(start).append(" ");

        // 현재 정점의 이웃 정점들에 대해 반복한다.
        for (int neighbor : arrayLists.get(start)) {
            // 이웃 정점이 아직 방문되지 않았다면, 재귀적으로 DFS를 호출한다.
            if (!visited[neighbor]) DFS(neighbor);
        }
    }

    // BFS는 그래프의 한 정점에서 시작하여 인접한 모든 정점을 먼저 방문한 후, 그 정점에서 인접한 정점들을 다시 방문하는 방식이다.
    private static void BFS(int start) {
        Deque<Integer> searchDeque = new LinkedList<>();
        // 시작 정점을 덱에 추가한다.
        searchDeque.offerLast(start);
        // 시작 정점을 방문했음을 표시한다.
        visited[start] = true;
        // 시작 정점을 결과에 추가한다.
        stringBuilder.append(start).append(" ");

        // 큐가 비어있지 않을 때까지 반복한다.
        while (!searchDeque.isEmpty()) {
            // 덱의 앞에서 정점을 꺼낸다.
            int current = searchDeque.pollFirst();

            // 현재 정점의 이웃 정점들에 대해 반복한다.
            for (int neighbor : arrayLists.get(current)) {
                // 이웃 정점이 아직 방문되지 않았다면,
                if (!visited[neighbor]) {
                    // 이웃 정점을 방문 표시한다.
                    visited[neighbor] = true;
                    // 이웃 정점을 덱에 추가한다.
                    searchDeque.offerLast(neighbor);
                    // 결과에 추가한다.
                    stringBuilder.append(neighbor).append(" ");
                }
            }
        }
    }
}
