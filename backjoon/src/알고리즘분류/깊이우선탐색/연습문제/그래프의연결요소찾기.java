package 알고리즘분류.깊이우선탐색.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 그래프의연결요소찾기 {

    /**
     * 문제:
     * 주어진 무방향 그래프에서 연결 요소의 개수를 구하는 문제
     *
     * 입력:
     * 첫 번째 줄에 정점의 개수 (N) (1 ≤ (N) ≤ 1000)과 간선의 개수 (M) (0 ≤ (M) ≤ 10000)가 주어집니다.
     * 다음 (M)줄에 각 간선의 두 정점 (u)와 (v)가 주어집니다.
     *
     * 출력:
     * 연결 요소의 개수를 출력합니다.
     */

    /**
     * 입력:
     * 5 3
     * 1 2
     * 2 3
     * 4 5
     * <p>
     * 출력:
     * 2
     */

    static int N, M;
    static boolean[] visited;
    static List<Integer>[] arrayLists;

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
            StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(numberTokenizer.nextToken());
            int V = Integer.parseInt(numberTokenizer.nextToken());

            arrayLists[U].add(V);
            arrayLists[V].add(U);
        }

        int componentNumber = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                componentNumber++;
            }
        }

        bufferedWriter.write(String.valueOf(componentNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void DFS(int start) {
        visited[start] = true;

        for (int node : arrayLists[start]) {
            if (!visited[node]) DFS(node);
        }
    }
}
