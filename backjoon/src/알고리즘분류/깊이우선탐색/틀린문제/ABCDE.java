package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

    private static int N, M;
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(parentNode).add(childNode);
            graph.get(childNode).add(parentNode);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (found) break;
        }

        bufferedWriter.write(found ? "1" : "0");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int node, int depth) {
        // "ABCDE" 관계를 찾으려면 5번의 연속된 친구 관계가 형성되어야 한다. 즉, DFS를 수행할 때 현재 깊이가 5인지 확인해야 한다.
        if (depth == N) {
            found = true;
            return;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                DFS(neighbor, depth + 1);
                if (found) return;
            }
        }

        // visited 배열이 전역적으로 관리되므로, DFS 탐색을 끝까지 진행한 후 이전 상태로 돌아갈 때 (백트래킹) 방문 상태가 유지된다.
        // 즉, DFS를 백트래킹할 때, visited 배열을 다시 false로 설정해야 한다.
        visited[node] = false;
    }
}
