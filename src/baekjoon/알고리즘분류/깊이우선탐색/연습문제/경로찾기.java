package baekjoon.알고리즘분류.깊이우선탐색.연습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 경로찾기 {

    /**
     * 문제:
     * 주어진 두 정점 (s)와 (t)가 연결되어 있는지 확인하고, 연결되어 있다면 그 경로를 출력하는 문제입니다.
     *
     * 입력:
     * 첫 번째 줄에 정점의 개수 (N) (1 ≤ (N) ≤ 1000)과 간선의 개수 (M) (0 ≤ (M) ≤ 10000)가 주어집니다.
     * 다음 (M)줄에 각 간선의 두 정점 (u)와 (v)가 주어집니다.
     * 마지막 줄에 시작 정점 (s)와 도착 정점 (t)가 주어집니다.
     *
     * 출력:
     * (s)에서 (t)까지의 경로를 출력합니다. 경로가 없다면 "없음"이라고 출력합니다.
     */

    /**
     * 입력:
     * 4 4
     * 1 2
     * 2 3
     * 3 4
     * 1 4
     * <p>
     * 출력:
     * 1 -> 2 -> 3 -> 4
     */

    static int N, M;
    static boolean[] visited;
    static List<Integer>[] arrayList;
    static List<Integer> path;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer1.nextToken());
        M = Integer.parseInt(stringTokenizer1.nextToken());

        visited = new boolean[N + 1];
        arrayList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M - 1; i++) {
            StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(numberTokenizer.nextToken());
            int V = Integer.parseInt(numberTokenizer.nextToken());

            arrayList[U].add(V);
            arrayList[V].add(U);
        }

        StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        int S = Integer.parseInt(stringTokenizer2.nextToken());
        int T = Integer.parseInt(stringTokenizer2.nextToken());

        path = new ArrayList<>();
        found = false;

        DFS(S, T);

        if (found) {
            for (int i = 0; i < path.size(); i++) {
                bufferedWriter.write(path.get(i) + ((i < path.size() - 1 ? " -> " : "")));
            }
        } else {
            bufferedWriter.write("없음");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void DFS(int current, int target) {
        visited[current] = true;
        path.add(current);

        if (current == target) {
            found = true;
            return;
        }

        for (int node : arrayList[current]) {
            if (!visited[node]) {
                DFS(node, target);
                if (found) return;
            }
        }

        path.remove(path.size() - 1);
    }
}
