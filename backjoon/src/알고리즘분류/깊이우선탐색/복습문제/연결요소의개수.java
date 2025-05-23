package 알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;
    private static int linkedElement = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[U].add(V);
            arrayLists[V].add(U);
        }

        linkedElement = 0;

        for (int i = 1; i <= M; i++) {
            if (!visited[i]) {
                DFS(i);
                linkedElement++;
            }
        }

        bufferedWriter.write(String.valueOf(linkedElement));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;

        for (int neighbor : arrayLists[start]) {
            if (!visited[neighbor]) DFS(neighbor);
        }
    }
}
