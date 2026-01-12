package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 키순서 {

    private static int N, M;
    private static List<Integer>[] tallerList, shorterList;
    private static int[] smallerCount, largerCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        tallerList = new ArrayList[N + 1];
        shorterList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tallerList[i] = new ArrayList<>();
            shorterList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            // A번 학생보다 키가 큰 학생들의 목록을 저장한다.
            tallerList[A].add(B);
            // B번 학생보다 키가 작은 학생들의 목록을 저장한다.
            shorterList[B].add(A);
        }

        // i번 학생보다 작은 학생의 수를 저장한다.
        smallerCount = new int[N + 1];
        // i번 학생보다 큰 학생의 수를 저장한다.
        largerCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            DFS(i, i, visited, tallerList);
            DFS(i, i, visited, shorterList);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            // 만약 어떤 학생이 자신보다 작은 학생 수 + 자신보다 큰 학생 수 = N - 1을 만족하면, 그 학생은 자신의 키 순서를 정확히 알 수 있다.
            if (smallerCount[i] + largerCount[i] == N - 1) count++;
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     *
     * @param start: 탐색을 시작한 학생 번호
     * @param node: 현재 탐색 중인 학생 번호
     * @param visited: 방문한 학생을 기록하는 배열
     * @param graph: 탐색할 그래프 (tallerList 또는 shorterList)
     */
    private static void DFS(int start, int node, boolean[] visited, List<Integer>[] graph) {
        visited[node] = true;

        // 자기 자신이 아닐 경우
        if (start != node) {
            // 현재 학생보다 큰 학생의 수를 증가시킨다.
            if (graph == tallerList) largerCount[start]++;
            // 현재 학생보다 작은 학생의 수를 증가시킨다.
            else smallerCount[start]++;
        }

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                DFS(start, neighbor, visited, graph);
            }
        }
    }
}
