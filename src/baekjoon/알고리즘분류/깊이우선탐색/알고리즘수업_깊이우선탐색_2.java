package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 알고리즘수업_깊이우선탐색_2 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N, M, R;
    private static boolean[] visited;
    private static int[] visiteOrder;
    private static List<List<Integer>> undirectedGraphList;
    private static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        visiteOrder = new int[N + 1];
        undirectedGraphList = new ArrayList<>();
        for (int i = 0; i <= N; i++) undirectedGraphList.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            undirectedGraphList.get(U).add(V);
            undirectedGraphList.get(V).add(U);
        }

        for (List<Integer> neighborList : undirectedGraphList) neighborList.sort(Collections.reverseOrder());

        DFS(R);

        for (int i = 1; i <= N; i++) stringBuilder.append(visiteOrder[i]).append("\n");
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        visiteOrder[start] = order++;

        for (int neighbor : undirectedGraphList.get(start)) {
            if (!visited[neighbor]) DFS(neighbor);
        }
    }
}
