package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N;
    private static boolean[] visited;
    private static int[] parents;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        parents = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(parentNode).add(childNode);
            graph.get(childNode).add(parentNode);
        }

        // 루트 노트에서 시작해서 DFS를 한 번만 실행한다.
        DFS(1);

        // 각 노드의 부모를 기록한 배열을 사용하여 노드 번호를 2번 노드부터 출력한다.
        for (int i = 2; i <= N; i++) {
            stringBuilder.append(parents[i]).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                parents[nextNode] = node;
                DFS(nextNode);
            }
        }
    }
}
