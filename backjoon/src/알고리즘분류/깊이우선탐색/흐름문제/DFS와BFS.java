package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.*;

public class DFS와BFS {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M, V;
    private static boolean[] visited;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int relationA = Integer.parseInt(stringTokenizer.nextToken());
            int relationB = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(relationA).add(relationB);
            graph.get(relationB).add(relationA);
        }

        // 방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문해야 하지만, graph에 추가할 때 정점 번호 순서를 보장하지 않는다.
        // 때문에 작은 번호부터 방문할 수 있도록 보장하도록 해줘야 한다.
        for (int i = 1; i <= N; i++) Collections.sort(graph.get(i));

        DFS(V);

        stringBuilder.append("\n");

        Arrays.fill(visited, false);
        BFS(V);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        stringBuilder.append(start).append(" ");

        for (int next : graph.get(start)) {
            if (!visited[next]) DFS(next);
        }
    }

    private static void BFS(int start) {
        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.offerLast(start);
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            int current = searchDeque.pollFirst();
            stringBuilder.append(current).append(" ");

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    searchDeque.offerLast(next);
                }
            }
        }
    }
}
