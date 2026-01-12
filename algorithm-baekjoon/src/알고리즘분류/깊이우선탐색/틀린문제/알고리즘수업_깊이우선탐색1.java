package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 알고리즘수업_깊이우선탐색1 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M, R;
    private static boolean[] visited;
    private static int[] visitOrders;
    private static List<List<Integer>> undirectedGraph;
    private static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        visitOrders = new int[N + 1];
        undirectedGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) undirectedGraph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            undirectedGraph.get(U).add(V);
            undirectedGraph.get(V).add(U);
        }

        // 모든 인접 리스트를 정렬하여 DFS 탐색 시 오름차순으로 방문한다.
        for (List<Integer> neighbors : undirectedGraph) Collections.sort(neighbors);

        DFS(R);

        for (int i = 1; i <= N; i++) stringBuilder.append(visitOrders[i]).append("\n");
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        // visitOrders 배열을 사용하여 각 정점의 방문 순서를 기록한다. order 변수를 통해 현재 방문 순서를 증가시킨다.
        visitOrders[start] = order++;

        for (int neighbor : undirectedGraph.get(start)) {
            if (!visited[neighbor]) DFS(neighbor);
        }
    }
}
