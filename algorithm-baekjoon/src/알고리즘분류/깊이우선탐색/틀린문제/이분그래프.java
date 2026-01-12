package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.*;

public class 이분그래프 {

    private static boolean[] visited;
    private static int[] colors;
    private static List<Set<Integer>> bipartiteGraph;
    private static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int vertex = Integer.parseInt(stringTokenizer.nextToken());
            int edge = Integer.parseInt(stringTokenizer.nextToken());

            visited = new boolean[vertex + 1];
            // 각 정점이 어떤 집합에 속하는지를 구별하기 위해 색상으로 표현했다. 예를 들어, 색상 0은 집합 A, 색상 1은 집합 B를 의미한다.
            colors = new int[vertex + 1];
            // 초기 상태에서 어떤 색상도 할당되지 않은 상태임을 명확히 하기 위해 -1로 초기화한다.
            Arrays.fill(colors, -1);

            bipartiteGraph = new ArrayList<>();
            for (int j = 0; j <= vertex; j++) bipartiteGraph.add(new HashSet<>());

            for (int j = 0; j < edge; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int U = Integer.parseInt(stringTokenizer.nextToken());
                int V = Integer.parseInt(stringTokenizer.nextToken());

                bipartiteGraph.get(U).add(V);
                bipartiteGraph.get(V).add(U);
            }

            isBipartite = true;

            for (int j = 1; j <= vertex; j++) {
                if (!visited[j]) {
                    DFS(j, 0);
                }
            }

            bufferedWriter.write(isBipartite ? "YES\n" : "NO\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int current, int currentColor) {
        visited[current] = true;
        // 현재 정점이 어떤 집합에 속하는지를 기록한다. 이를 통해 인접한 정점과의 비교를 가능하게 한다.
        colors[current] = currentColor;

        for (int neighbor : bipartiteGraph.get(current)) {
            // 그래프 탐색 과정에서 새로운 정점을 방문하고, 해당 정점의 색상을 설정하기 위함이다.
            if (!visited[neighbor]) {
                DFS(neighbor, 1 - currentColor);
            } else {
                // 이미 방문한 인접 정점의 색상이 현재 정점의 색상과 같다면, 두 정점이 같은 집합에 속해 있다는 것을 의미한다.
                if (colors[neighbor] == currentColor) isBipartite = false;
            }
        }
    }
}
