package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 알고리즘수업_깊이우선탐색_1 {

    private static final int NOT_VISITED = 0;

    private static boolean[] visited;
    // 각 정점의 방문 순서를 저장하는 배열
    private static int[] visitOrder;
    private static List<List<Integer>> arrayLists;
    private static int orderIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        visitOrder = new int[N + 1];
        arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) arrayLists.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists.get(U).add(V);
            arrayLists.get(V).add(U);
        }

        for (List<Integer> neighbors : arrayLists) Collections.sort(neighbors);

        // 방문할 때마다 순서를 부여한다.
        orderIndex = 1;
        DFS(R);

        for (int i = 1; i <= N; i++) {
            bufferedWriter.write(visitOrder[i] == 0 ? NOT_VISITED + "\n" : visitOrder[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        // 현재 정점을 방문했을 경우 방문 순서를 기록한다.
        visitOrder[start] = orderIndex++;

        for (int neighbor : arrayLists.get(start)) {
            if (!visited[neighbor]) DFS(neighbor);
        }
    }
}
