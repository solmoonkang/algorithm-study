package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {

    private static boolean[] visited;
    private static List<List<Integer>> arrayLists;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) arrayLists.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            arrayLists.get(U).add(V);
            arrayLists.get(V).add(U);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        BFS(1);

        for (int i = 2; i <= N; i++) bufferedWriter.write(parent[i] + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int start) {
        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.add(start);
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            int currentNode = searchDeque.pollFirst();

            for (int neighborNode : arrayLists.get(currentNode)) {
                if (!visited[neighborNode]) {
                    visited[neighborNode] = true;
                    parent[neighborNode] = currentNode;
                    searchDeque.add(neighborNode);
                }
            }
        }
    }
}
