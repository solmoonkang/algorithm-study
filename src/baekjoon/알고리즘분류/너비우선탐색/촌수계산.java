package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 촌수계산 {

    private static final int UNRELATED = -1;

    private static int N, M;
    private static boolean[] visited;
    private static List<List<Integer>> arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int relationA = Integer.parseInt(stringTokenizer.nextToken());
        int relationB = Integer.parseInt(stringTokenizer.nextToken());

        M = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayLists.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parentNode = Integer.parseInt(stringTokenizer.nextToken());
            int childNode = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists.get(parentNode).add(childNode);
            arrayLists.get(childNode).add(parentNode);
        }

        int relationCount = BFS(relationA, relationB);
        bufferedWriter.write(String.valueOf(relationCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int start, int target) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{start, 0});
        visited[start] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int currentNode = current[0];
            int currentRelation = current[1];

            if (currentNode == target) return currentRelation;

            for (int neighbor : arrayLists.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    searchDeque.add(new int[]{neighbor, currentRelation + 1});
                }
            }
        }

        return UNRELATED;
    }
}
