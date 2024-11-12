package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS와BFS {

    static int N, M, V;
    static boolean[] visited;
    static int[][] arrayLists;

    static StringBuilder builder = new StringBuilder();
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(numberTokenizer.nextToken());
            int B = Integer.parseInt(numberTokenizer.nextToken());

            arrayLists[A][B] = arrayLists[B][A] = 1;
        }

        DFS(V);
        builder.append("\n");

        visited = new boolean[N + 1];
        BFS(V);

        bufferedWriter.write(builder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void DFS(int start) {
        visited[start] = true;
        builder.append(start).append(" ");

        for (int i = 0; i <= N; i++) {
            if (arrayLists[start][i] == 1 && !visited[i]) DFS(i);
        }
    }

    public static void BFS(int start) {
        deque.offerLast(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            start = deque.pollFirst();
            builder.append(start).append(" ");

            for (int i = 1; i <= N; i++) {
                if (arrayLists[start][i] == 1 && !visited[i]) {
                    deque.offerLast(i);
                    visited[i] = true;
                }
            }
        }
    }
}
