package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {

    private static boolean[] visited;
    private static List<List<Integer>> graphLists;
    private static int[] parentNodeSequences;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N + 1];
        graphLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) graphLists.add(new ArrayList<>());
        parentNodeSequences = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            graphLists.get(parentNode).add(childNode);
            graphLists.get(childNode).add(parentNode);
        }

        BFS();
        for (int i = 2; i < N; i++) bufferedWriter.write(parentNodeSequences[i] + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS() {
        Deque<Integer> searchDeque = new LinkedList<>();
        searchDeque.offerLast(1);
        visited[1] = true;
        parentNodeSequences[1] = -1;

        while (!searchDeque.isEmpty()) {
            int current = searchDeque.pollFirst();
            for (int neighbor : graphLists.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parentNodeSequences[neighbor] = current;
                    searchDeque.offerLast(neighbor);
                }
            }
        }
    }
}
