package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 연결요소의개수 {

    private static final Deque<Integer> deque = new LinkedList<>();

    private static boolean[] visited;
    private static List<List<Integer>> arrayLists;
    private static int linkedElement = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayLists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists.get(U).add(V);
            arrayLists.get(V).add(U);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
                linkedElement++;
            }
        }

        bufferedWriter.write(String.valueOf(linkedElement));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int start) {
        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            int currentNode = deque.pollFirst();

            for (int neighborNode : arrayLists.get(currentNode)) {
                if (!visited[neighborNode]) {
                    visited[neighborNode] = true;
                    BFS(neighborNode);
                }
            }
        }
    }
}
