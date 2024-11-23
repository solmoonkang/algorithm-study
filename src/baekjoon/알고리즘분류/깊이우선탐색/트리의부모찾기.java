package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    private static int N;
    private static boolean[] visited;
    private static List<Integer>[] arrayList;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        arrayList = new List[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            arrayList[U].add(V);
            arrayList[V].add(U);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            bufferedWriter.write(parent[i] + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;

        for (int neighbor : arrayList[start]) {
            if (!visited[neighbor]) {
                parent[neighbor] = start;
                DFS(neighbor);
            }
        }
    }
}
