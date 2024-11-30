package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class DFS와BFS {

    private static int N, M, V;
    private static boolean[] visited;
    private static List<Integer>[] arrayLists;

    private static Deque<int[]> deque = new LinkedList<>();
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[node1].add(node2);
            arrayLists[node2].add(node1);
        }

        DFS(V);
        stringBuilder.append("\n");

        visited = new boolean[N + 1];
        BFS(V);

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        stringBuilder.append(start).append(" ");

        for (int neighbor : arrayLists[start]) {
            if (!visited[neighbor]) DFS(neighbor);
        }
    }

    private static void BFS(int start) {
        deque.offerLast(new int[]{start});
        visited[start] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            for (int node : current) {
                stringBuilder.append(node).append(" ");
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    deque.offerLast(new int[]{i});
                }
            }
        }
    }
}
